# document-reader

Regula Document Reader SDK allows you to read various kinds of identification documents, passports, driving licenses, ID cards, etc. All processing is performed completely offline on your device. No any data leaving your device.You can use native camera to scan the documents or image from gallery for extract all data from it.This repository contains the source code of the Document Reader API, and the sample application that demonstrates the API calls you can use to interact with the Document Reader library.

## Install

```bash
npm install document-reader
npx cap sync
```

## API

<docgen-index>

* [`initializeReaderAutomatically()`](#initializereaderautomatically)
* [`getAvailableScenarios()`](#getavailablescenarios)
* [`parseCoreResults(...)`](#parsecoreresults)
* [`getAPIVersion()`](#getapiversion)
* [`getCoreVersion()`](#getcoreversion)
* [`getCoreMode()`](#getcoremode)
* [`getDatabaseID()`](#getdatabaseid)
* [`getDatabaseVersion()`](#getdatabaseversion)
* [`getDatabaseDate()`](#getdatabasedate)
* [`getDatabaseDescription()`](#getdatabasedescription)
* [`getDatabaseCountriesNumber()`](#getdatabasecountriesnumber)
* [`getDatabaseDocumentsNumber()`](#getdatabasedocumentsnumber)
* [`isAuthenticatorAvailableForUse()`](#isauthenticatoravailableforuse)
* [`getConfig()`](#getconfig)
* [`getRfidScenario()`](#getrfidscenario)
* [`selectedScenario()`](#selectedscenario)
* [`getScenario(...)`](#getscenario)
* [`getLicenseExpiryDate()`](#getlicenseexpirydate)
* [`getLicenseCountryFilter()`](#getlicensecountryfilter)
* [`licenseIsRfidAvailable()`](#licenseisrfidavailable)
* [`getDocumentReaderIsReady()`](#getdocumentreaderisready)
* [`getDocumentReaderStatus()`](#getdocumentreaderstatus)
* [`isRFIDAvailableForUse()`](#isrfidavailableforuse)
* [`getSessionLogFolder()`](#getsessionlogfolder)
* [`setTCCParams(...)`](#settccparams)
* [`initializeReader()`](#initializereader)
* [`deinitializeReader()`](#deinitializereader)
* [`startNewSession()`](#startnewsession)
* [`startNewPage()`](#startnewpage)
* [`recognizeImageWithOpts(...)`](#recognizeimagewithopts)
* [`recognizeData(...)`](#recognizedata)
* [`recognizeImages(...)`](#recognizeimages)
* [`recognizeImagesWithImageInputs(...)`](#recognizeimageswithimageinputs)
* [`removeDatabase()`](#removedatabase)
* [`cancelDBUpdate()`](#canceldbupdate)
* [`resetConfiguration()`](#resetconfiguration)
* [`setEnableCoreLogs(...)`](#setenablecorelogs)
* [`addPKDCertificates(...)`](#addpkdcertificates)
* [`clearPKDCertificates()`](#clearpkdcertificates)
* [`recognizeVideoFrame(...)`](#recognizevideoframe)
* [`showScannerWithCameraID(...)`](#showscannerwithcameraid)
* [`showScanner(...)`](#showscanner)
* [`showScannerWithCameraIDAndOpts(...)`](#showscannerwithcameraidandopts)
* [`stopScanner()`](#stopscanner)
* [`startRFIDReader()`](#startrfidreader)
* [`stopRFIDReader()`](#stoprfidreader)
* [`prepareDatabase(...)`](#preparedatabase)
* [`runAutoUpdate(...)`](#runautoupdate)
* [`setRfidScenario(...)`](#setrfidscenario)
* [`setConfig(...)`](#setconfig)
* [`readRFID()`](#readrfid)
* [`providePACertificates(...)`](#providepacertificates)
* [`provideTACertificates(...)`](#providetacertificates)
* [`provideTASignature(...)`](#providetasignature)
* [`setRfidDelegate(...)`](#setrfiddelegate)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### initializeReaderAutomatically()

```typescript
initializeReaderAutomatically() => any
```

**Returns:** <code>any</code>

--------------------


### getAvailableScenarios()

```typescript
getAvailableScenarios() => any
```

**Returns:** <code>any</code>

--------------------


### parseCoreResults(...)

```typescript
parseCoreResults(options: { json: string; }) => any
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ json: string; }</code> |

**Returns:** <code>any</code>

--------------------


### getAPIVersion()

```typescript
getAPIVersion() => any
```

**Returns:** <code>any</code>

--------------------


### getCoreVersion()

```typescript
getCoreVersion() => any
```

**Returns:** <code>any</code>

--------------------


### getCoreMode()

```typescript
getCoreMode() => any
```

**Returns:** <code>any</code>

--------------------


### getDatabaseID()

```typescript
getDatabaseID() => any
```

**Returns:** <code>any</code>

--------------------


### getDatabaseVersion()

```typescript
getDatabaseVersion() => any
```

**Returns:** <code>any</code>

--------------------


### getDatabaseDate()

```typescript
getDatabaseDate() => any
```

**Returns:** <code>any</code>

--------------------


### getDatabaseDescription()

```typescript
getDatabaseDescription() => any
```

**Returns:** <code>any</code>

--------------------


### getDatabaseCountriesNumber()

```typescript
getDatabaseCountriesNumber() => any
```

**Returns:** <code>any</code>

--------------------


### getDatabaseDocumentsNumber()

```typescript
getDatabaseDocumentsNumber() => any
```

**Returns:** <code>any</code>

--------------------


### isAuthenticatorAvailableForUse()

```typescript
isAuthenticatorAvailableForUse() => any
```

**Returns:** <code>any</code>

--------------------


### getConfig()

```typescript
getConfig() => any
```

**Returns:** <code>any</code>

--------------------


### getRfidScenario()

```typescript
getRfidScenario() => any
```

**Returns:** <code>any</code>

--------------------


### selectedScenario()

```typescript
selectedScenario() => any
```

**Returns:** <code>any</code>

--------------------


### getScenario(...)

```typescript
getScenario(options: { scenario: string; }) => any
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ scenario: string; }</code> |

**Returns:** <code>any</code>

--------------------


### getLicenseExpiryDate()

```typescript
getLicenseExpiryDate() => any
```

**Returns:** <code>any</code>

--------------------


### getLicenseCountryFilter()

```typescript
getLicenseCountryFilter() => any
```

**Returns:** <code>any</code>

--------------------


### licenseIsRfidAvailable()

```typescript
licenseIsRfidAvailable() => any
```

**Returns:** <code>any</code>

--------------------


### getDocumentReaderIsReady()

```typescript
getDocumentReaderIsReady() => any
```

**Returns:** <code>any</code>

--------------------


### getDocumentReaderStatus()

```typescript
getDocumentReaderStatus() => any
```

**Returns:** <code>any</code>

--------------------


### isRFIDAvailableForUse()

```typescript
isRFIDAvailableForUse() => any
```

**Returns:** <code>any</code>

--------------------


### getSessionLogFolder()

```typescript
getSessionLogFolder() => any
```

**Returns:** <code>any</code>

--------------------


### setTCCParams(...)

```typescript
setTCCParams(options: { params: any; }) => any
```

| Param         | Type                          |
| ------------- | ----------------------------- |
| **`options`** | <code>{ params: any; }</code> |

**Returns:** <code>any</code>

--------------------


### initializeReader()

```typescript
initializeReader() => any
```

**Returns:** <code>any</code>

--------------------


### deinitializeReader()

```typescript
deinitializeReader() => any
```

**Returns:** <code>any</code>

--------------------


### startNewSession()

```typescript
startNewSession() => any
```

**Returns:** <code>any</code>

--------------------


### startNewPage()

```typescript
startNewPage() => any
```

**Returns:** <code>any</code>

--------------------


### recognizeImageWithOpts(...)

```typescript
recognizeImageWithOpts(options: { opts: any; base64Image: string; }) => any
```

| Param         | Type                                             |
| ------------- | ------------------------------------------------ |
| **`options`** | <code>{ opts: any; base64Image: string; }</code> |

**Returns:** <code>any</code>

--------------------


### recognizeData(...)

```typescript
recognizeData(options: { data: any; }) => any
```

| Param         | Type                        |
| ------------- | --------------------------- |
| **`options`** | <code>{ data: any; }</code> |

**Returns:** <code>any</code>

--------------------


### recognizeImages(...)

```typescript
recognizeImages(options: { base64Images: string[]; }) => any
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ base64Images: {}; }</code> |

**Returns:** <code>any</code>

--------------------


### recognizeImagesWithImageInputs(...)

```typescript
recognizeImagesWithImageInputs(options: { base64Images: string[]; }) => any
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ base64Images: {}; }</code> |

**Returns:** <code>any</code>

--------------------


### removeDatabase()

```typescript
removeDatabase() => any
```

**Returns:** <code>any</code>

--------------------


### cancelDBUpdate()

```typescript
cancelDBUpdate() => any
```

**Returns:** <code>any</code>

--------------------


### resetConfiguration()

```typescript
resetConfiguration() => any
```

**Returns:** <code>any</code>

--------------------


### setEnableCoreLogs(...)

```typescript
setEnableCoreLogs(options: { enableLogs: boolean; }) => any
```

| Param         | Type                                  |
| ------------- | ------------------------------------- |
| **`options`** | <code>{ enableLogs: boolean; }</code> |

**Returns:** <code>any</code>

--------------------


### addPKDCertificates(...)

```typescript
addPKDCertificates(options: { certificatesJSON: PKDCertificate[]; }) => any
```

| Param         | Type                                   |
| ------------- | -------------------------------------- |
| **`options`** | <code>{ certificatesJSON: {}; }</code> |

**Returns:** <code>any</code>

--------------------


### clearPKDCertificates()

```typescript
clearPKDCertificates() => any
```

**Returns:** <code>any</code>

--------------------


### recognizeVideoFrame(...)

```typescript
recognizeVideoFrame(options: { opts: any; byteString: string; }) => any
```

| Param         | Type                                            |
| ------------- | ----------------------------------------------- |
| **`options`** | <code>{ opts: any; byteString: string; }</code> |

**Returns:** <code>any</code>

--------------------


### showScannerWithCameraID(...)

```typescript
showScannerWithCameraID(options: { cameraID: number; }) => any
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ cameraID: number; }</code> |

**Returns:** <code>any</code>

--------------------


### showScanner(...)

```typescript
showScanner(options: { cameraID: -1; }) => any
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ cameraID: -1; }</code> |

**Returns:** <code>any</code>

--------------------


### showScannerWithCameraIDAndOpts(...)

```typescript
showScannerWithCameraIDAndOpts(options: { opts: any; cameraID: number; }) => any
```

| Param         | Type                                          |
| ------------- | --------------------------------------------- |
| **`options`** | <code>{ opts: any; cameraID: number; }</code> |

**Returns:** <code>any</code>

--------------------


### stopScanner()

```typescript
stopScanner() => any
```

**Returns:** <code>any</code>

--------------------


### startRFIDReader()

```typescript
startRFIDReader() => any
```

**Returns:** <code>any</code>

--------------------


### stopRFIDReader()

```typescript
stopRFIDReader() => any
```

**Returns:** <code>any</code>

--------------------


### prepareDatabase(...)

```typescript
prepareDatabase(options: { dbID: string; }) => any
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ dbID: string; }</code> |

**Returns:** <code>any</code>

--------------------


### runAutoUpdate(...)

```typescript
runAutoUpdate(options: { dbID: string; }) => any
```

| Param         | Type                           |
| ------------- | ------------------------------ |
| **`options`** | <code>{ dbID: string; }</code> |

**Returns:** <code>any</code>

--------------------


### setRfidScenario(...)

```typescript
setRfidScenario(options: { opts: RfidScenario; }) => any
```

| Param         | Type                                                             |
| ------------- | ---------------------------------------------------------------- |
| **`options`** | <code>{ opts: <a href="#rfidscenario">RfidScenario</a>; }</code> |

**Returns:** <code>any</code>

--------------------


### setConfig(...)

```typescript
setConfig(options: { opts: RegulaConfig; }) => any
```

| Param         | Type                                                             |
| ------------- | ---------------------------------------------------------------- |
| **`options`** | <code>{ opts: <a href="#regulaconfig">RegulaConfig</a>; }</code> |

**Returns:** <code>any</code>

--------------------


### readRFID()

```typescript
readRFID() => any
```

**Returns:** <code>any</code>

--------------------


### providePACertificates(...)

```typescript
providePACertificates(options: { certificatesJSON: PKDCertificate[]; }) => any
```

| Param         | Type                                   |
| ------------- | -------------------------------------- |
| **`options`** | <code>{ certificatesJSON: {}; }</code> |

**Returns:** <code>any</code>

--------------------


### provideTACertificates(...)

```typescript
provideTACertificates(options: { certificatesJSON: PKDCertificate[]; }) => any
```

| Param         | Type                                   |
| ------------- | -------------------------------------- |
| **`options`** | <code>{ certificatesJSON: {}; }</code> |

**Returns:** <code>any</code>

--------------------


### provideTASignature(...)

```typescript
provideTASignature(options: { signature: any; }) => any
```

| Param         | Type                             |
| ------------- | -------------------------------- |
| **`options`** | <code>{ signature: any; }</code> |

**Returns:** <code>any</code>

--------------------


### setRfidDelegate(...)

```typescript
setRfidDelegate(options: { delegate: number; }) => any
```

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ delegate: number; }</code> |

**Returns:** <code>any</code>

--------------------


### Interfaces


#### PKDCertificate

| Prop               | Type                |
| ------------------ | ------------------- |
| **`binaryData`**   | <code>string</code> |
| **`resourceType`** | <code>number</code> |
| **`privateKey`**   | <code>string</code> |


#### RfidScenario

| Prop                                     | Type                 |
| ---------------------------------------- | -------------------- |
| **`paceStaticBinding`**                  | <code>boolean</code> |
| **`signManagementAction`**               | <code>number</code>  |
| **`readingBuffer`**                      | <code>number</code>  |
| **`onlineTAToSignDataType`**             | <code>number</code>  |
| **`onlineTA`**                           | <code>boolean</code> |
| **`writeEid`**                           | <code>boolean</code> |
| **`profilerType`**                       | <code>number</code>  |
| **`authProcType`**                       | <code>number</code>  |
| **`baseSMProcedure`**                    | <code>number</code>  |
| **`pacePasswordType`**                   | <code>number</code>  |
| **`terminalType`**                       | <code>number</code>  |
| **`universalAccessRights`**              | <code>boolean</code> |
| **`authorizedRestrictedIdentification`** | <code>boolean</code> |
| **`auxVerificationCommunityID`**         | <code>boolean</code> |
| **`auxVerificationDateOfBirth`**         | <code>boolean</code> |
| **`skipAA`**                             | <code>boolean</code> |
| **`strictProcessing`**                   | <code>boolean</code> |
| **`pkdDSCertPriority`**                  | <code>boolean</code> |
| **`pkdUseExternalCSCA`**                 | <code>boolean</code> |
| **`trustedPKD`**                         | <code>boolean</code> |
| **`passiveAuth`**                        | <code>boolean</code> |
| **`password`**                           | <code>string</code>  |
| **`useSFI`**                             | <code>boolean</code> |
| **`pkdPA`**                              | <code>string</code>  |
| **`pkdEAC`**                             | <code>string</code>  |
| **`readEPassport`**                      | <code>boolean</code> |
| **`readEID`**                            | <code>boolean</code> |
| **`readEDL`**                            | <code>boolean</code> |
| **`mrz`**                                | <code>string</code>  |
| **`eSignPINDefault`**                    | <code>string</code>  |
| **`eSignPINNewValue`**                   | <code>string</code>  |
| **`authorizedSTSignature`**              | <code>boolean</code> |
| **`authorizedSTQSignature`**             | <code>boolean</code> |
| **`authorizedWriteDG17`**                | <code>boolean</code> |
| **`authorizedWriteDG18`**                | <code>boolean</code> |
| **`authorizedWriteDG19`**                | <code>boolean</code> |
| **`authorizedWriteDG20`**                | <code>boolean</code> |
| **`authorizedWriteDG21`**                | <code>boolean</code> |
| **`authorizedVerifyAge`**                | <code>boolean</code> |
| **`authorizedVerifyCommunityID`**        | <code>boolean</code> |
| **`authorizedPrivilegedTerminal`**       | <code>boolean</code> |
| **`authorizedCANAllowed`**               | <code>boolean</code> |
| **`authorizedPINManagement`**            | <code>boolean</code> |
| **`authorizedInstallCert`**              | <code>boolean</code> |
| **`authorizedInstallQCert`**             | <code>boolean</code> |
| **`applyAmendments`**                    | <code>boolean</code> |
| **`autoSettings`**                       | <code>boolean</code> |
| **`ePassportDataGroups`**                | <code>any</code>     |
| **`eIDDataGroups`**                      | <code>any</code>     |
| **`eDLDataGroups`**                      | <code>any</code>     |
| **`reprocessParams`**                    | <code>any</code>     |
| **`defaultReadingBufferSize`**           | <code>number</code>  |


#### RegulaConfig

| Prop                | Type                                                    |
| ------------------- | ------------------------------------------------------- |
| **`customization`** | <code><a href="#customization">Customization</a></code> |
| **`functionality`** | <code><a href="#functionality">Functionality</a></code> |
| **`processParams`** | <code><a href="#processparams">ProcessParams</a></code> |


#### Customization

| Prop                                        | Type                 |
| ------------------------------------------- | -------------------- |
| **`status`**                                | <code>string</code>  |
| **`resultStatus`**                          | <code>string</code>  |
| **`cameraFrameDefaultColor`**               | <code>string</code>  |
| **`cameraFrameActiveColor`**                | <code>string</code>  |
| **`statusTextColor`**                       | <code>string</code>  |
| **`resultStatusTextColor`**                 | <code>string</code>  |
| **`resultStatusBackgroundColor`**           | <code>string</code>  |
| **`multipageButtonBackgroundColor`**        | <code>string</code>  |
| **`tintColor`**                             | <code>string</code>  |
| **`activityIndicatorColor`**                | <code>string</code>  |
| **`showStatusMessages`**                    | <code>boolean</code> |
| **`showResultStatusMessages`**              | <code>boolean</code> |
| **`showHelpAnimation`**                     | <code>boolean</code> |
| **`showNextPageAnimation`**                 | <code>boolean</code> |
| **`showBackgroundMask`**                    | <code>boolean</code> |
| **`cameraFrameBorderWidth`**                | <code>number</code>  |
| **`statusTextSize`**                        | <code>number</code>  |
| **`cameraFrameLineLength`**                 | <code>number</code>  |
| **`cameraFrameShapeType`**                  | <code>number</code>  |
| **`resultStatusTextSize`**                  | <code>number</code>  |
| **`cameraFrameOffsetWidth`**                | <code>number</code>  |
| **`customLabelStatus`**                     | <code>string</code>  |
| **`multipageAnimationFrontImage`**          | <code>string</code>  |
| **`multipageAnimationBackImage`**           | <code>string</code>  |
| **`borderBackgroundImage`**                 | <code>string</code>  |
| **`helpAnimationImage`**                    | <code>string</code>  |
| **`statusPositionMultiplier`**              | <code>string</code>  |
| **`resultStatusPositionMultiplier`**        | <code>number</code>  |
| **`backgroundMaskAlpha`**                   | <code>number</code>  |
| **`statusTextFont`**                        | <code>string</code>  |
| **`statusTextFontStyle`**                   | <code>number</code>  |
| **`resultStatusTextFont`**                  | <code>string</code>  |
| **`resultStatusTextFontStyle`**             | <code>number</code>  |
| **`helpAnimationImageScaleType`**           | <code>string</code>  |
| **`multipageAnimationFrontImageScaleType`** | <code>string</code>  |
| **`multipageAnimationBackImageScaleType`**  | <code>string</code>  |
| **`helpAnimationImageMatrix`**              | <code>any</code>     |
| **`multipageAnimationFrontImageMatrix`**    | <code>any</code>     |
| **`multipageAnimationBackImageMatrix`**     | <code>any</code>     |
| **`customStatusPositionMultiplier`**        | <code>number</code>  |
| **`cameraFrameVerticalPositionMultiplier`** | <code>number</code>  |
| **`cameraFrameLandscapeAspectRatio`**       | <code>number</code>  |
| **`cameraFramePortraitAspectRatio`**        | <code>number</code>  |
| **`cameraFrameCornerRadius`**               | <code>number</code>  |
| **`cameraFrameLineCap`**                    | <code>number</code>  |
| **`closeButtonImage`**                      | <code>string</code>  |
| **`captureButtonImage`**                    | <code>string</code>  |
| **`changeFrameCollapseButtonImage`**        | <code>string</code>  |
| **`changeFrameExpandButtonImage`**          | <code>string</code>  |
| **`cameraSwitchButtonImage`**               | <code>string</code>  |
| **`torchButtonOnImage`**                    | <code>string</code>  |
| **`torchButtonOffImage`**                   | <code>string</code>  |
| **`changeFrameButtonExpandImage`**          | <code>string</code>  |
| **`changeFrameButtonCollapseImage`**        | <code>string</code>  |
| **`toolbarSize`**                           | <code>number</code>  |
| **`statusBackgroundColor`**                 | <code>string</code>  |
| **`hologramAnimationImage`**                | <code>string</code>  |
| **`hologramAnimationPositionMultiplier`**   | <code>number</code>  |
| **`hologramAnimationImageMatrix`**          | <code>any</code>     |
| **`hologramAnimationImageScaleType`**       | <code>string</code>  |
| **`uiCustomizationLayer`**                  | <code>any</code>     |


#### Functionality

| Prop                                   | Type                                            |
| -------------------------------------- | ----------------------------------------------- |
| **`pictureOnBoundsReady`**             | <code>boolean</code>                            |
| **`showTorchButton`**                  | <code>boolean</code>                            |
| **`showCloseButton`**                  | <code>boolean</code>                            |
| **`videoCaptureMotionControl`**        | <code>boolean</code>                            |
| **`showCaptureButton`**                | <code>boolean</code>                            |
| **`showChangeFrameButton`**            | <code>boolean</code>                            |
| **`showCaptureButtonDelayFromDetect`** | <code>number</code>                             |
| **`showCaptureButtonDelayFromStart`**  | <code>number</code>                             |
| **`databaseAutoupdate`**               | <code>boolean</code>                            |
| **`showSkipNextPageButton`**           | <code>boolean</code>                            |
| **`useAuthenticator`**                 | <code>boolean</code>                            |
| **`skipFocusingFrames`**               | <code>boolean</code>                            |
| **`showCameraSwitchButton`**           | <code>boolean</code>                            |
| **`cameraFrame`**                      | <code>string</code>                             |
| **`btDeviceName`**                     | <code>string</code>                             |
| **`orientation`**                      | <code>number</code>                             |
| **`startDocReaderForResult`**          | <code>boolean</code>                            |
| **`captureMode`**                      | <code>number</code>                             |
| **`displayMetadata`**                  | <code>boolean</code>                            |
| **`cameraSize`**                       | <code>{ width: number; height: number; }</code> |
| **`cameraMode`**                       | <code>number</code>                             |
| **`excludedCamera2Models`**            | <code>any</code>                                |
| **`isZoomEnabled`**                    | <code>boolean</code>                            |
| **`zoomFactor`**                       | <code>number</code>                             |
| **`isCameraTorchCheckDisabled`**       | <code>boolean</code>                            |
| **`recordScanningProcess`**            | <code>boolean</code>                            |
| **`manualMultipageMode`**              | <code>boolean</code>                            |
| **`exposure`**                         | <code>number</code>                             |
| **`rfidTimeout`**                      | <code>number</code>                             |
| **`onlineProcessingConfiguration`**    | <code>any</code>                                |


#### ProcessParams

| Prop                                | Type                 |
| ----------------------------------- | -------------------- |
| **`multipageProcessing`**           | <code>boolean</code> |
| **`dateFormat`**                    | <code>string</code>  |
| **`logs`**                          | <code>boolean</code> |
| **`debugSaveImages`**               | <code>boolean</code> |
| **`debugSaveLogs`**                 | <code>boolean</code> |
| **`returnUncroppedImage`**          | <code>boolean</code> |
| **`customParams`**                  | <code>any</code>     |
| **`uvTorchEnabled`**                | <code>boolean</code> |
| **`debugSaveCroppedImages`**        | <code>boolean</code> |
| **`scenario`**                      | <code>string</code>  |
| **`measureSystem`**                 | <code>number</code>  |
| **`captureButtonScenario`**         | <code>string</code>  |
| **`disableFocusingCheck`**          | <code>boolean</code> |
| **`debugSaveRFIDSession`**          | <code>boolean</code> |
| **`doublePageSpread`**              | <code>boolean</code> |
| **`barcodeParserType`**             | <code>number</code>  |
| **`documentIDList`**                | <code>any</code>     |
| **`fieldTypesFilter`**              | <code>any</code>     |
| **`barcodeTypes`**                  | <code>any</code>     |
| **`faceMetaData`**                  | <code>any</code>     |
| **`timeout`**                       | <code>number</code>  |
| **`timeoutFromFirstDetect`**        | <code>number</code>  |
| **`timeoutFromFirstDocType`**       | <code>number</code>  |
| **`manualCrop`**                    | <code>boolean</code> |
| **`perspectiveAngle`**              | <code>number</code>  |
| **`integralImage`**                 | <code>boolean</code> |
| **`minDPI`**                        | <code>number</code>  |
| **`returnCroppedBarcode`**          | <code>boolean</code> |
| **`checkHologram`**                 | <code>boolean</code> |
| **`checkRequiredTextFields`**       | <code>boolean</code> |
| **`depersonalizeLog`**              | <code>boolean</code> |
| **`resultTypeOutput`**              | <code>any</code>     |
| **`generateDoublePageSpreadImage`** | <code>boolean</code> |
| **`imageDpiOutMax`**                | <code>number</code>  |
| **`alreadyCropped`**                | <code>boolean</code> |
| **`forceDocID`**                    | <code>number</code>  |
| **`matchTextFieldMask`**            | <code>boolean</code> |
| **`fastDocDetect`**                 | <code>boolean</code> |
| **`updateOCRValidityByGlare`**      | <code>boolean</code> |
| **`imageQA`**                       | <code>any</code>     |

</docgen-api>
