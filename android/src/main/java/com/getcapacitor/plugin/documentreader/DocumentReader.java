package com.getcapacitor.plugin.documentreader;

import static com.regula.documentreader.api.DocumentReader.Instance;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.os.Bundle;
import android.util.Base64;

import androidx.annotation.NonNull;

import com.getcapacitor.Bridge;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;
import com.regula.documentreader.api.completions.IDocumentReaderCompletion;
import com.regula.documentreader.api.completions.IDocumentReaderInitCompletion;
import com.regula.documentreader.api.completions.IDocumentReaderPrepareCompletion;
import com.regula.documentreader.api.completions.IRfidPKDCertificateCompletion;
import com.regula.documentreader.api.completions.IRfidReaderRequest;
import com.regula.documentreader.api.completions.IRfidTASignatureCompletion;
import com.regula.documentreader.api.completions.ITccParamsCompletion;
import com.regula.documentreader.api.enums.DocReaderAction;
import com.regula.documentreader.api.errors.DocumentReaderException;
import com.regula.documentreader.api.internal.core.CoreScenarioUtil;
import com.regula.documentreader.api.internal.params.ImageInputParam;
import com.regula.documentreader.api.internal.parser.DocReaderResultsJsonParser;
import com.regula.documentreader.api.params.DocReaderConfig;
import com.regula.documentreader.api.params.ImageInputData;
import com.regula.documentreader.api.params.rfid.PKDCertificate;
import com.regula.documentreader.api.params.rfid.authorization.PAResourcesIssuer;
import com.regula.documentreader.api.params.rfid.authorization.TAChallenge;
import com.regula.documentreader.api.results.DocumentReaderResults;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class DocumentReader {
    private final Bridge bridge;
    private final Activity activity;
    public String callBackId;
    private boolean backgroundRFIDEnabled = false;

    private IRfidPKDCertificateCompletion paCertificateCompletion;
    private IRfidPKDCertificateCompletion taCertificateCompletion;
    private IRfidTASignatureCompletion taSignatureCompletion;
    private final static String rfidNotificationCompletionEvent = "rfidNotificationCompletionEvent";
    private final static String paCertificateCompletionEvent = "paCertificateCompletionEvent";
    private final static String taCertificateCompletionEvent = "taCertificateCompletionEvent";
    private final static String taSignatureCompletionEvent = "taSignatureCompletionEvent";
    private static int databaseDownloadProgress = 0;

    public DocumentReader(@NonNull Bridge bridge) {
        this.bridge = bridge;
        activity = bridge.getActivity();
    }

    private Context getContext() {
        return activity;
    }

    private Activity getActivity() {
        return activity;
    }

    void handleOnResume() {
        if (backgroundRFIDEnabled)
            startForegroundDispatch(getActivity());
    }

    void handleOnNewIntent(Intent intent) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        if (intent.getAction() != null && intent.getAction().equals(NfcAdapter.ACTION_TECH_DISCOVERED) && backgroundRFIDEnabled)
            Instance().readRFID(IsoDep.get(intent.getParcelableExtra(NfcAdapter.EXTRA_TAG)), getCompletion(call));
    }

    void initializeReaderAutomatically(PluginCall call) {
        JSObject ret = new JSObject();

        if (!Instance().isReady())
            try {
                InputStream is = getContext().getAssets().open("regula.license");
                byte[] license = new byte[is.available()];
                //noinspection ResultOfMethodCallIgnored
                is.read(license);
                Instance().initializeReader(getContext(), new DocReaderConfig(license), getInitCompletion(call));
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                call.reject("problem reading license(see logs)");
            }
        else
            ret.put("message", "already initialized");
        call.resolve(ret);
    }

    void getAvailableScenarios(PluginCall call) throws JSONException {
        JSObject ret = new JSObject();
        ret.put("value", JSONConstructor.generateList(Instance().availableScenarios, JSONConstructor::generateDocumentReaderScenario).toString());
        call.resolve(ret);
    }

    void parseCoreResults(PluginCall call) {
        String json = call.getString("json");
        assert json != null;

        DocumentReaderResults results = (DocumentReaderResults) DocReaderResultsJsonParser.parseCoreResults(json).get("docReaderResults");
        JSObject ret = new JSObject();
        ret.put("value", JSONConstructor.generateDocumentReaderResults(results, getContext()).toString());
        call.resolve(ret);
    }

    String getAPIVersion() {
        return Objects.requireNonNull(Instance().version).api;
    }

    String getCoreVersion() {
        return Objects.requireNonNull(Instance().version).core;
    }

    String getCoreMode() {
        return Objects.requireNonNull(Instance().version).coreMode;
    }

    String getDatabaseID() {
        return Objects.requireNonNull(Objects.requireNonNull(Instance().version).database).databaseID;
    }

    String getDatabaseVersion() {
        return Objects.requireNonNull(Objects.requireNonNull(Instance().version).database).version;
    }

    String getDatabaseDate() {
        return Objects.requireNonNull(Objects.requireNonNull(Instance().version).database).date;
    }

    String getDatabaseDescription() {
        return Objects.requireNonNull(Objects.requireNonNull(Instance().version).database).databaseDescription;
    }

    Integer getDatabaseCountriesNumber() {
        return Objects.requireNonNull(Objects.requireNonNull(Instance().version).database).countriesNumber;
    }

    Integer getDatabaseDocumentsNumber() {
        return Objects.requireNonNull(Objects.requireNonNull(Instance().version).database).documentsNumber;
    }

    boolean isAuthenticatorAvailableForUse() {
        return Instance().isAuthenticatorAvailableForUse();
    }

    String getConfig() throws JSONException {
        return RegulaConfig.getConfig(Instance()).toString();
    }

    String getRfidScenario() {
        return Instance().rfidScenario().toJson();
    }

    String selectedScenario() {
        return JSONConstructor.generateCoreDetailedScenario(CoreScenarioUtil.getScenario(Instance().processParams().getScenario())).toString();
    }

    String getScenario(PluginCall call) {
        String scenario = call.getString("scenario");
        return JSONConstructor.generateCoreDetailedScenario(CoreScenarioUtil.getScenario(scenario)).toString();
    }

    boolean licenseIsRfidAvailable() {
        return Instance().license().isRfidAvailable();
    }

    boolean getDocumentReaderIsReady() {
        return Instance().isReady();
    }

    boolean getDocumentReaderStatus() {
        return Instance().isReady();
    }

    boolean isRFIDAvailableForUse() {
        return Instance().isRFIDAvailableForUse();
    }

    String getSessionLogFolder() {
        return Instance().processParams().sessionLogFolder;
    }

    void setTCCParams(PluginCall call) {
        JSONObject params = call.getObject("params");
        Instance().setTccParams(JSONConstructor.TCCParamsFromJSON(params), getTCCParamsCompletion(call));
    }

    void getLicenseExpiryDate(PluginCall call) {
        JSObject ret = new JSObject();
        Date expiryDate = Instance().license().getExpiryDate();
        if (expiryDate == null)
            call.reject("null");
        else
            ret.put("value", expiryDate.toString());
        call.resolve(ret);
    }

    void getLicenseCountryFilter(PluginCall call) {
        JSObject ret = new JSObject();
        List<String> countryFilter = Instance().license().getCountryFilter();
        if (countryFilter == null)
            call.reject("null");
        else
            ret.put("value", JSONConstructor.generateList(Instance().license().getCountryFilter()).toString());
        call.resolve(ret);
    }

    void initializeReader(PluginCall call) {
        JSONObject config = call.getObject("config");
        if (!Instance().isReady())
            Instance().initializeReader(getContext(), JSONConstructor.DocReaderConfigFromJSON(config), getInitCompletion(call));
        else
            call.resolve();
    }

    void deinitializeReader(PluginCall call) {
        Instance().deinitializeReader();
        call.resolve();
    }

    void startNewSession() {
        Instance().startNewSession();
    }

    void startNewPage() {
        Instance().startNewPage();
    }

    void recognizeImageWithOpts(PluginCall call) throws JSONException {
        JSONObject opts = call.getObject("opts");
        String base64Image = call.getString("base64Image");
        RegulaConfig.setConfig(Instance(), opts, getContext());
        recognizeImage(call, base64Image);
    }

    void recognizeData(PluginCall call) {
        JSONObject data = call.getObject("data");
        stopBackgroundRFID();
        Instance().recognizeImage(Base64.decode(data.toString(), Base64.DEFAULT), getCompletion(call));
    }

    void recognizeImages(PluginCall call) throws JSONException {
        JSONArray base64Images = call.getArray("base64Images");
        stopBackgroundRFID();
        Bitmap[] images = new Bitmap[base64Images.length()];
        for (int i = 0; i < images.length; i++)
            images[i] = Helpers.bitmapFromBase64(base64Images.getString(i));
        Instance().recognizeImages(images, getCompletion(call));
    }

    void recognizeImagesWithImageInputs(PluginCall call) throws JSONException {
        JSONArray base64Images = call.getArray("base64Images");
        stopBackgroundRFID();
        ImageInputData[] images = new ImageInputData[base64Images.length()];
        for (int i = 0; i < images.length; i++)
            images[i] = JSONConstructor.ImageInputDataFromJSON(base64Images.getJSONObject(i));
        Instance().recognizeImages(images, getCompletion(call));
    }

    void removeDatabase() {
        Instance().removeDatabase(getContext());
    }

    void cancelDBUpdate() {
        Instance().cancelDBUpdate();
    }

    void resetConfiguration() {
        Instance().resetConfiguration();
    }

    void setEnableCoreLogs(PluginCall call) {
        boolean enableLogs = Boolean.TRUE.equals(call.getBoolean("enableLogs"));
        Instance().setEnableCoreLogs(enableLogs);
    }

    void addPKDCertificates(PluginCall call) throws JSONException {
        JSONArray certificatesJSON = call.getArray("certificatesJSON");
        List<PKDCertificate> certificates = new ArrayList<>();
        for (int i = 0; i < certificatesJSON.length(); i++) {
            JSONObject certificate = certificatesJSON.getJSONObject(i);
            certificates.add(new PKDCertificate(Base64.decode(certificate.get("binaryData").toString(), Base64.DEFAULT), certificate.getInt("resourceType"), certificate.has("privateKey") ? Base64.decode(certificate.get("privateKey").toString(), Base64.DEFAULT) : null));
        }
        Instance().addPKDCertificates(certificates);
    }

    void clearPKDCertificates() {
        Instance().clearPKDCertificates();
    }

    void recognizeVideoFrame(PluginCall call) throws JSONException {
        String byteString = call.getString("byteString");
        if (byteString == null) {
            call.reject("byteString is null");
            return;
        }
        JSONObject opts = call.getObject("opts");
        stopBackgroundRFID();
        Instance().recognizeVideoFrame(
                byteString.getBytes(),
                new ImageInputParam(opts.getInt("width"),
                        opts.getInt("height"),
                        opts.getInt("type")),
                getCompletion(call)
        );

    }

    void showScannerWithCameraID(PluginCall call) {
        Integer cameraID = call.getInt("cameraID");
        if (cameraID == null) {
            call.reject("No cameraID");
            return;
        }
        stopBackgroundRFID();
        Instance().showScanner(getContext(), cameraID, getCompletion(call));
    }

    void showScannerWithCameraIDAndOpts(PluginCall call) throws JSONException {
        Integer cameraID = call.getInt("cameraID");
        JSONObject opts = call.getObject("opts");
        if (cameraID == null) {
            call.reject("No cameraID");
            return;
        }
        stopBackgroundRFID();
        RegulaConfig.setConfig(Instance(), opts, getContext());
        Instance().showScanner(getContext(), cameraID, getCompletion(call));
    }

    void stopScanner() {
        Instance().stopScanner(getContext());
    }

    void startRFIDReader(PluginCall call) {
        stopBackgroundRFID();
        IRfidReaderRequest delegate = null;
        if (rfidDelegate == RFIDDelegate.NO_PA)
            delegate = getIRfidReaderRequestNoPA();
        if (rfidDelegate == RFIDDelegate.FULL)
            delegate = getIRfidReaderRequest();
        Instance().startRFIDReader(getContext(), getCompletion(call), delegate, this::sendIRfidNotificationCompletion);
    }

    void stopRFIDReader(PluginCall call) {
        Instance().stopRFIDReader(getContext());
        stopBackgroundRFID();
        call.resolve();
    }

    void prepareDatabase(PluginCall call) {
        String dbID = call.getString("dbID");
        if (dbID == null) {
            call.reject("No dbID");
            return;
        }
        Instance().prepareDatabase(getContext(), dbID, getPrepareCompletion(call));
    }

    void runAutoUpdate(PluginCall call) {
        String dbID = call.getString("dbID");
        if (dbID == null) {
            call.reject("No dbID");
            return;
        }
        Instance().runAutoUpdate(getContext(), dbID, getPrepareCompletion(call));
    }

    void setRfidScenario(PluginCall call) throws JSONException {
        JSONObject opts = call.getObject("opts");
        RegulaConfig.setRfidScenario(opts);
    }

    void setConfig(PluginCall call) throws JSONException {
        JSONObject opts = call.getObject("opts");
        RegulaConfig.setConfig(Instance(), opts, getContext());
        call.resolve();
    }

    void readRFID() {
        backgroundRFIDEnabled = true;
        startForegroundDispatch(getActivity());
    }

    void providePACertificates(PluginCall call) throws JSONException {
        JSONArray certificatesJSON = call.getArray("certificatesJSON");
        if (paCertificateCompletion == null) {
            call.reject("paCertificateCompletion is null");
            return;
        }
        PKDCertificate[] certificates = new PKDCertificate[certificatesJSON.length()];
        for (int i = 0; i < certificatesJSON.length(); i++) {
            JSONObject certificate = certificatesJSON.getJSONObject(i);
            certificates[i] = new PKDCertificate(Base64.decode(certificate.get("binaryData").toString(), Base64.DEFAULT), certificate.getInt("resourceType"), certificate.has("privateKey") ? Base64.decode(certificate.get("privateKey").toString(), Base64.DEFAULT) : null);
        }
        paCertificateCompletion.onCertificatesReceived(certificates);
        call.resolve();
    }

    void provideTACertificates(PluginCall call) throws JSONException {
        JSONArray certificatesJSON = call.getArray("certificatesJSON");
        if (taCertificateCompletion == null) {
            call.reject("taCertificateCompletion is null");
            return;
        }
        PKDCertificate[] certificates = new PKDCertificate[certificatesJSON.length()];
        for (int i = 0; i < certificatesJSON.length(); i++) {
            JSONObject certificate = certificatesJSON.getJSONObject(i);
            certificates[i] = new PKDCertificate(Base64.decode(certificate.get("binaryData").toString(), Base64.DEFAULT), certificate.getInt("resourceType"), certificate.has("privateKey") ? Base64.decode(certificate.get("privateKey").toString(), Base64.DEFAULT) : null);
        }
        taCertificateCompletion.onCertificatesReceived(certificates);
        call.resolve();
    }

    void provideTASignature(PluginCall call) {
        JSONObject signature = call.getObject("signature");
        if (taSignatureCompletion == null) {
            call.reject("taSignatureCompletion is null");
            return;
        }
        taSignatureCompletion.onSignatureReceived(Base64.decode(signature.toString(), Base64.DEFAULT));
        call.resolve();
    }

    void setRfidDelegate(PluginCall call) {
        Integer delegate = call.getInt("delegate");
        if (delegate == null) {
            call.reject("delegate is null");
            return;
        }
        rfidDelegate = delegate;
        call.resolve();
    }

    private void recognizeImage(PluginCall call, String base64Image) {
        stopBackgroundRFID();
        Instance().recognizeImage(Helpers.bitmapFromBase64(base64Image), getCompletion(call));
    }

    private void sendVideoEncoderCompletion(String sessionId, File file) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        JSObject ret = new JSObject();
        ret.put("value", JSONConstructor.generateVideoEncoderCompletion(sessionId, file).toString());
        call.resolve(ret);
    }

    private void sendProgress(int progress) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        JSObject ret = new JSObject();
        ret.put("value", progress);
        call.resolve(ret);
    }

    private void sendCompletion(int action, DocumentReaderResults results, DocumentReaderException error) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        JSObject ret = new JSObject();
        ret.put("value", JSONConstructor.generateCompletion(action, results, error, getContext()).toString());
        call.resolve(ret);
    }

    private void sendIRfidNotificationCompletion(int notification, Bundle value) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        JSObject ret = new JSObject();
        ret.put("value", rfidNotificationCompletionEvent + JSONConstructor.generateRfidNotificationCompletion(notification, value));
        call.resolve(ret);
    }


    private void sendPACertificateCompletion(byte[] serialNumber, PAResourcesIssuer issuer) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        JSObject ret = new JSObject();
        ret.put("value", paCertificateCompletionEvent + JSONConstructor.generatePACertificateCompletion(serialNumber, issuer));
        call.resolve(ret);
    }

    private void sendTACertificateCompletion(String keyCAR) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        JSObject ret = new JSObject();
        ret.put("value", taCertificateCompletionEvent + keyCAR);
        call.resolve(ret);
    }

    private void sendTASignatureCompletion(TAChallenge challenge) {
        PluginCall call = this.bridge.getSavedCall(callBackId);

        JSObject ret = new JSObject();
        ret.put("value", taSignatureCompletionEvent + JSONConstructor.generateTAChallenge(challenge));
        call.resolve(ret);
    }

    private void startForegroundDispatch(final Activity activity) {
        IntentFilter[] filters = new IntentFilter[1];
        filters[0] = new IntentFilter();
        filters[0].addAction(NfcAdapter.ACTION_TECH_DISCOVERED);
        filters[0].addCategory(Intent.CATEGORY_DEFAULT);
        String[][] techList = new String[][]{
                new String[]{"android.nfc.tech.IsoDep"}
        };
        Intent intent = new Intent(activity.getApplicationContext(), activity.getClass());
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        @SuppressLint("UnspecifiedImmutableFlag")
        PendingIntent pendingIntent = PendingIntent.getActivity(activity.getApplicationContext(), 0, intent, 0);
        NfcAdapter.getDefaultAdapter(activity).enableForegroundDispatch(activity, pendingIntent, filters, techList);
    }

    private void stopBackgroundRFID() {
        if (!backgroundRFIDEnabled)
            return;
        NfcAdapter.getDefaultAdapter(getActivity()).disableForegroundDispatch(activity);
        backgroundRFIDEnabled = false;
    }

    private ITccParamsCompletion getTCCParamsCompletion(PluginCall call) {
        return (success, error) -> {
            if (success)
                call.resolve();
            else {
                if (error != null)
                    call.reject("failed: " + error.getMessage());
                else
                    call.reject("failed: ");


            }
        };
    }

    private IDocumentReaderInitCompletion getInitCompletion(PluginCall call) {
        return (success, error) -> {
            if (success) {
                this.bridge.saveCall(call);
                this.callBackId = call.getCallbackId();
                Instance().setVideoEncoderCompletion(this::sendVideoEncoderCompletion);
            } else
                call.reject("Init failed:" + error);
        };
    }

    private IDocumentReaderCompletion getCompletion(PluginCall call) {
        return (action, results, error) -> {
            this.bridge.saveCall(call);
            this.callBackId = call.getCallbackId();
            sendCompletion(action, results, error);
            if (action == DocReaderAction.ERROR || action == DocReaderAction.CANCEL || (action == DocReaderAction.COMPLETE && results != null && results.rfidResult == 1))
                stopBackgroundRFID();
        };
    }

    private IDocumentReaderPrepareCompletion getPrepareCompletion(PluginCall call) {
        return new IDocumentReaderPrepareCompletion() {
            @Override
            public void onPrepareProgressChanged(int progress) {
                if (progress != databaseDownloadProgress) {
                    sendProgress(progress);
                    databaseDownloadProgress = progress;
                }
            }

            @Override
            public void onPrepareCompleted(boolean status, DocumentReaderException error) {
                if (status)
                    call.resolve();
                else
                    call.reject("database preparation failed: " + error.toString());
            }
        };
    }

    private IRfidReaderRequest getIRfidReaderRequest() {
        return new IRfidReaderRequest() {
            @Override
            public void onRequestPACertificates(byte[] serialNumber, PAResourcesIssuer issuer, @NonNull IRfidPKDCertificateCompletion completion) {
                paCertificateCompletion = completion;
                completion.onCertificatesReceived(new PKDCertificate[0]);
                sendPACertificateCompletion(serialNumber, issuer);
            }

            @Override
            public void onRequestTACertificates(String keyCAR, @NonNull IRfidPKDCertificateCompletion completion) {
                taCertificateCompletion = completion;
                sendTACertificateCompletion(keyCAR);
            }

            @Override
            public void onRequestTASignature(TAChallenge challenge, @NonNull IRfidTASignatureCompletion completion) {
                taSignatureCompletion = completion;
                sendTASignatureCompletion(challenge);
            }
        };
    }

    private IRfidReaderRequest getIRfidReaderRequestNoPA() {
        return new IRfidReaderRequest() {
            @Override
            public void onRequestPACertificates(byte[] serialNumber, PAResourcesIssuer issuer, @NonNull IRfidPKDCertificateCompletion completion) {
                paCertificateCompletion = null;
                completion.onCertificatesReceived(new PKDCertificate[0]);
            }

            @Override
            public void onRequestTACertificates(String keyCAR, @NonNull IRfidPKDCertificateCompletion completion) {
                taCertificateCompletion = completion;
                sendTACertificateCompletion(keyCAR);
            }

            @Override
            public void onRequestTASignature(TAChallenge challenge, @NonNull IRfidTASignatureCompletion completion) {
                taSignatureCompletion = completion;
                sendTASignatureCompletion(challenge);
            }
        };
    }

    private static int rfidDelegate = RFIDDelegate.NULL;

    private static class RFIDDelegate {
        public static final int NULL = 0;
        public static final int NO_PA = 1;
        public static final int FULL = 2;
    }
}
