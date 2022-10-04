package com.getcapacitor.plugin.documentreader;

import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONException;

@CapacitorPlugin(name = "DocumentReader")
public class DocumentReaderPlugin extends Plugin {

    private DocumentReader implementation;

    @Override
    public void load() {
        implementation = new DocumentReader(this.bridge);
    }

    @Override
    public void handleOnResume() {
        implementation.handleOnResume();
    }

    @Override
    public void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);
        implementation.handleOnNewIntent(intent);
    }

    @PluginMethod
    private void initializeReaderAutomatically(PluginCall call) {
        implementation.initializeReaderAutomatically(call);
    }

    @PluginMethod
    private void getAvailableScenarios(PluginCall call) throws JSONException {
        implementation.getAvailableScenarios(call);
    }

    @PluginMethod
    private void parseCoreResults(PluginCall call) {
        implementation.parseCoreResults(call);
    }

    @PluginMethod
    private void getAPIVersion(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getAPIVersion());
        call.resolve(ret);
    }

    @PluginMethod
    private void getCoreVersion(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getCoreVersion());
        call.resolve(ret);
    }

    @PluginMethod
    private void getCoreMode(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getCoreMode());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDatabaseID(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDatabaseID());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDatabaseVersion(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDatabaseVersion());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDatabaseDate(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDatabaseDate());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDatabaseDescription(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDatabaseDescription());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDatabaseCountriesNumber(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDatabaseCountriesNumber());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDatabaseDocumentsNumber(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDatabaseDocumentsNumber());
        call.resolve(ret);
    }

    @PluginMethod
    private void isAuthenticatorAvailableForUse(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.isAuthenticatorAvailableForUse());
        call.resolve(ret);
    }

    @PluginMethod
    private void getConfig(PluginCall call) throws JSONException {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getConfig());
        call.resolve(ret);
    }

    @PluginMethod
    private void getRfidScenario(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getRfidScenario());
        call.resolve(ret);
    }

    @PluginMethod
    private void selectedScenario(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.selectedScenario());
        call.resolve(ret);
    }

    @PluginMethod
    private void getScenario(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getScenario(call));
        call.resolve(ret);
    }


    @PluginMethod
    private void getLicenseExpiryDate(PluginCall call) {
        implementation.getLicenseExpiryDate(call);
    }

    @PluginMethod
    private void getLicenseCountryFilter(PluginCall call) {
        implementation.getLicenseCountryFilter(call);
    }

    private void licenseIsRfidAvailable(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.licenseIsRfidAvailable());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDocumentReaderIsReady(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDocumentReaderIsReady());
        call.resolve(ret);
    }

    @PluginMethod
    private void getDocumentReaderStatus(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getDocumentReaderStatus());
        call.resolve(ret);
    }

    @PluginMethod
    private void isRFIDAvailableForUse(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.isRFIDAvailableForUse());
        call.resolve(ret);
    }

    @PluginMethod
    private void getSessionLogFolder(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getSessionLogFolder());
        call.resolve(ret);
    }

    @PluginMethod
    private void setTCCParams(PluginCall call) {
        implementation.setTCCParams(call);
    }

    @PluginMethod
    private void initializeReader(PluginCall call) {
        implementation.initializeReader(call);
    }

    @PluginMethod
    private void deinitializeReader(PluginCall call) {
        implementation.deinitializeReader(call);
    }

    @PluginMethod
    private void startNewSession(PluginCall call) {
        implementation.startNewSession();
        call.resolve();
    }

    @PluginMethod
    private void startNewPage(PluginCall call) {
        implementation.startNewPage();
        call.resolve();
    }

    @PluginMethod
    private void recognizeImageWithOpts(PluginCall call) throws JSONException {
        implementation.recognizeImageWithOpts(call);
    }

    @PluginMethod
    private void recognizeData(PluginCall call) {
        implementation.recognizeData(call);
    }

    @PluginMethod
    private void recognizeImages(PluginCall call) throws JSONException {
        implementation.recognizeImages(call);
    }

    @PluginMethod
    private void recognizeImagesWithImageInputs(PluginCall call) throws JSONException {
        implementation.recognizeImagesWithImageInputs(call);
    }

    @PluginMethod
    private void removeDatabase(PluginCall call) {
        implementation.removeDatabase();
        call.resolve();
    }

    @PluginMethod
    private void cancelDBUpdate(PluginCall call) {
        implementation.cancelDBUpdate();
        call.resolve();
    }

    @PluginMethod
    private void resetConfiguration(PluginCall call) {
        implementation.resetConfiguration();
        call.resolve();
    }

    @PluginMethod
    private void setEnableCoreLogs(PluginCall call) {
        implementation.setEnableCoreLogs(call);
        call.resolve();
    }

    @PluginMethod
    private void addPKDCertificates(PluginCall call) throws JSONException {
        implementation.addPKDCertificates(call);
    }

    @PluginMethod
    private void clearPKDCertificates(PluginCall call) {
        implementation.clearPKDCertificates();
        call.resolve();
    }

    @PluginMethod
    private void recognizeVideoFrame(PluginCall call) throws JSONException {
        implementation.recognizeVideoFrame(call);
    }

    @PluginMethod
    private void showScannerWithCameraID(PluginCall call) {
        implementation.showScannerWithCameraID(call);
    }

    @PluginMethod
    private void showScanner(PluginCall call) {
        showScannerWithCameraID(call);
    }

    @PluginMethod
    private void showScannerWithCameraIDAndOpts(PluginCall call) throws JSONException {
        implementation.showScannerWithCameraIDAndOpts(call);
    }

    @PluginMethod
    private void stopScanner(PluginCall call) {
        implementation.stopScanner();
        call.resolve();
    }

    @PluginMethod
    private void startRFIDReader(PluginCall call) {
        implementation.startRFIDReader(call);
    }

    @PluginMethod
    private void stopRFIDReader(PluginCall call) {
        implementation.stopRFIDReader(call);
    }

    @PluginMethod
    private void prepareDatabase(PluginCall call) {
        implementation.prepareDatabase(call);
    }

    @PluginMethod
    private void runAutoUpdate(PluginCall call) {
        implementation.runAutoUpdate(call);
    }

    @PluginMethod
    private void setRfidScenario(PluginCall call) throws JSONException {
        implementation.setRfidScenario(call);
    }

    @PluginMethod
    private void setConfig(PluginCall call) throws JSONException {
        implementation.setConfig(call);
    }

    @PluginMethod
    private void readRFID(PluginCall call) {
        implementation.readRFID();
        call.resolve();
    }

    @PluginMethod
    private void providePACertificates(PluginCall call) throws JSONException {
        implementation.providePACertificates(call);
    }

    @PluginMethod
    private void provideTACertificates(PluginCall call) throws JSONException {
        implementation.provideTACertificates(call);
    }

    @PluginMethod
    private void provideTASignature(PluginCall call) {
        implementation.provideTASignature(call);
    }

    @PluginMethod
    private void setRfidDelegate(PluginCall call) {
        implementation.setRfidDelegate(call);
    }
}
