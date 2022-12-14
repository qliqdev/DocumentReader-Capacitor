export interface PKDCertificate {
  binaryData: string;
  resourceType: number;
  privateKey: string;
}

export interface RfidScenario {
  paceStaticBinding?: boolean;
  signManagementAction?: number;
  readingBuffer?: number;
  onlineTAToSignDataType?: number;
  onlineTA?: boolean;
  writeEid?: boolean;
  profilerType?: number;
  authProcType?: number;
  baseSMProcedure?: number;
  pacePasswordType?: number;
  terminalType?: number;
  universalAccessRights?: boolean;
  authorizedRestrictedIdentification?: boolean;
  auxVerificationCommunityID?: boolean;
  auxVerificationDateOfBirth?: boolean;
  skipAA?: boolean;
  strictProcessing?: boolean;
  pkdDSCertPriority?: boolean;
  pkdUseExternalCSCA?: boolean;
  trustedPKD?: boolean;
  passiveAuth?: boolean;
  password?: string;
  useSFI?: boolean;
  pkdPA?: string;
  pkdEAC?: string;
  readEPassport?: boolean;
  readEID?: boolean;
  readEDL?: boolean;
  mrz?: string;
  eSignPINDefault?: string;
  eSignPINNewValue?: string;
  authorizedSTSignature?: boolean;
  authorizedSTQSignature?: boolean;
  authorizedWriteDG17?: boolean;
  authorizedWriteDG18?: boolean;
  authorizedWriteDG19?: boolean;
  authorizedWriteDG20?: boolean;
  authorizedWriteDG21?: boolean;
  authorizedVerifyAge?: boolean;
  authorizedVerifyCommunityID?: boolean;
  authorizedPrivilegedTerminal?: boolean;
  authorizedCANAllowed?: boolean;
  authorizedPINManagement?: boolean;
  authorizedInstallCert?: boolean;
  authorizedInstallQCert?: boolean;
  applyAmendments?: boolean;
  autoSettings?: boolean;
  ePassportDataGroups?: any;
  eIDDataGroups?: any;
  eDLDataGroups?: any;
  reprocessParams?: any;
  defaultReadingBufferSize?: number;
}

export interface RegulaConfig {
  customization?: Customization;
  functionality?: Functionality;
  processParams?: ProcessParams;
}

interface Customization {
  status?: string;
  resultStatus?: string;
  cameraFrameDefaultColor?: string;
  cameraFrameActiveColor?: string;
  statusTextColor?: string;
  resultStatusTextColor?: string;
  resultStatusBackgroundColor?: string;
  multipageButtonBackgroundColor?: string;
  tintColor?: string;
  activityIndicatorColor?: string;
  showStatusMessages?: boolean
  showResultStatusMessages?: boolean;
  showHelpAnimation?: boolean;
  showNextPageAnimation?: boolean;
  showBackgroundMask?: boolean;
  cameraFrameBorderWidth?: number;
  statusTextSize?: number;
  cameraFrameLineLength?: number;
  cameraFrameShapeType?: number;
  resultStatusTextSize?: number;
  cameraFrameOffsetWidth?: number;
  customLabelStatus?: string;
  multipageAnimationFrontImage?: string;
  multipageAnimationBackImage?: string;
  borderBackgroundImage?: string;
  helpAnimationImage?: string;
  statusPositionMultiplier?: string;
  resultStatusPositionMultiplier?: number;
  backgroundMaskAlpha?: number;
  statusTextFont?: string;
  statusTextFontStyle?: number
  resultStatusTextFont?: string;
  resultStatusTextFontStyle?: number;
  helpAnimationImageScaleType?: string;
  multipageAnimationFrontImageScaleType?: string;
  multipageAnimationBackImageScaleType?: string;
  helpAnimationImageMatrix?: any;
  multipageAnimationFrontImageMatrix?: any;
  multipageAnimationBackImageMatrix?: any;
  customStatusPositionMultiplier?: number;
  cameraFrameVerticalPositionMultiplier?: number;
  cameraFrameLandscapeAspectRatio?: number;
  cameraFramePortraitAspectRatio?: number;
  cameraFrameCornerRadius?: number;
  cameraFrameLineCap?: number;
  closeButtonImage?: string;
  captureButtonImage?: string;
  changeFrameCollapseButtonImage?: string;
  changeFrameExpandButtonImage?: string;
  cameraSwitchButtonImage?: string;
  torchButtonOnImage?: string;
  torchButtonOffImage?: string;
  changeFrameButtonExpandImage?: string;
  changeFrameButtonCollapseImage?: string;
  toolbarSize?: number;
  statusBackgroundColor?: string;
  hologramAnimationImage?: string;
  hologramAnimationPositionMultiplier?: number;
  hologramAnimationImageMatrix?: any;
  hologramAnimationImageScaleType?: string;
  uiCustomizationLayer?: any;
}

interface Functionality {
  pictureOnBoundsReady?: boolean;
  showTorchButton?: boolean;
  showCloseButton?: boolean;
  videoCaptureMotionControl?: boolean;
  showCaptureButton?: boolean;
  showChangeFrameButton?: boolean;
  showCaptureButtonDelayFromDetect?: number;
  showCaptureButtonDelayFromStart?: number;
  databaseAutoupdate?: boolean;
  showSkipNextPageButton?: boolean;
  useAuthenticator?: boolean;
  skipFocusingFrames?: boolean;
  showCameraSwitchButton?: boolean;
  cameraFrame?: string;
  btDeviceName?: string;
  orientation?: number;
  startDocReaderForResult?: boolean;
  captureMode?: number;
  displayMetadata?: boolean;
  cameraSize?: {width: number; height: number;}
  cameraMode?: number;
  excludedCamera2Models?: any;
  isZoomEnabled?: boolean;
  zoomFactor?: number;
  isCameraTorchCheckDisabled?: boolean;
  recordScanningProcess?: boolean;
  manualMultipageMode?: boolean;
  exposure?: number;
  rfidTimeout?: number;
  onlineProcessingConfiguration?: any;
}

interface ProcessParams {
  multipageProcessing?: boolean;
  dateFormat?: string;
  logs?: boolean;
  debugSaveImages?: boolean;
  debugSaveLogs?: boolean;
  returnUncroppedImage?: boolean;
  customParams?: any;
  uvTorchEnabled?: boolean;
  debugSaveCroppedImages?: boolean;
  scenario?: string;
  measureSystem?: number;
  captureButtonScenario?: string;
  disableFocusingCheck?: boolean;
  debugSaveRFIDSession?: boolean;
  doublePageSpread?: boolean;
  barcodeParserType?: number;
  documentIDList?: any;
  fieldTypesFilter?: any;
  barcodeTypes?: any;
  faceMetaData?: any;
  timeout?: number;
  timeoutFromFirstDetect?: number;
  timeoutFromFirstDocType?: number;
  manualCrop?: boolean;
  perspectiveAngle?: number;
  integralImage?: boolean;
  minDPI?: number;
  returnCroppedBarcode?: boolean;
  checkHologram?: boolean;
  checkRequiredTextFields?: boolean;
  depersonalizeLog?: boolean;
  resultTypeOutput?: any;
  generateDoublePageSpreadImage?: boolean;
  imageDpiOutMax?: number;
  alreadyCropped?: boolean;
  forceDocID?: number;
  matchTextFieldMask?: boolean;
  fastDocDetect?: boolean;
  updateOCRValidityByGlare?: boolean;
  imageQA?: any;
}

export interface DocumentReaderPlugin {
  initializeReaderAutomatically(): Promise<any>;
  getAvailableScenarios(): Promise<{value: any}>;
  parseCoreResults(options: { json: string }): Promise<{value: any}>;
  getAPIVersion(): Promise<{value: any}>;
  getCoreVersion(): Promise<{value: any}>;
  getCoreMode(): Promise<{value: any}>;
  getDatabaseID(): Promise<{value: any}>;
  getDatabaseVersion(): Promise<{value: any}>;
  getDatabaseDate(): Promise<{value: any}>;
  getDatabaseDescription(): Promise<{value: any}>;
  getDatabaseCountriesNumber(): Promise<{value: any}>;
  getDatabaseDocumentsNumber(): Promise<{value: any}>;
  isAuthenticatorAvailableForUse(): Promise<{value: any}>;
  getConfig(): Promise<{value: any}>;
  getRfidScenario(): Promise<{value: any}>;
  selectedScenario(): Promise<{value: any}>;
  getScenario(options: { scenario: string }): Promise<{value: any}>;
  getLicenseExpiryDate(): Promise<{value: any}>;
  getLicenseCountryFilter(): Promise<{value: any}>;
  licenseIsRfidAvailable(): Promise<{value: any}>;
  getDocumentReaderIsReady(): Promise<{value: any}>;
  getDocumentReaderStatus(): Promise<{value: any}>;
  isRFIDAvailableForUse(): Promise<{value: any}>;
  getSessionLogFolder(): Promise<{value: any}>;
  setTCCParams(options: { params: any }): Promise<any>;
  initializeReader(): Promise<any>;
  deinitializeReader(): Promise<any>;
  startNewSession(): Promise<any>;
  startNewPage(): Promise<any>;
  recognizeImageWithOpts(options: { opts: any, base64Image: string }): Promise<any>;
  recognizeData(options: { data: any }): Promise<any>;
  recognizeImages(options: { base64Images: string[] }): Promise<any>;
  recognizeImagesWithImageInputs(options: { base64Images: string[] }): Promise<any>;
  removeDatabase(): Promise<any>;
  cancelDBUpdate(): Promise<any>;
  resetConfiguration(): Promise<any>;
  setEnableCoreLogs(options: { enableLogs: boolean }): Promise<{value: any}>;
  addPKDCertificates(options: {certificatesJSON: PKDCertificate[]}): Promise<{value: any}>;
  clearPKDCertificates(): Promise<any>;
  recognizeVideoFrame(options: { opts: any, byteString: string }): Promise<any>;
  showScannerWithCameraID(options: { cameraID: number }): Promise<{value: any}>;
  showScanner(options: { cameraID: -1 }): Promise<any>;
  showScannerWithCameraIDAndOpts(options: { opts: any, cameraID: number }): Promise<{value: any}>;
  stopScanner(): Promise<any>;
  startRFIDReader(): Promise<any>;
  stopRFIDReader(): Promise<any>;
  prepareDatabase(options: { dbID: string }): Promise<any>;
  runAutoUpdate(options: { dbID: string }): Promise<any>;
  setRfidScenario(options: { opts: RfidScenario }): Promise<{value: any}>;
  setConfig(options: { opts: RegulaConfig }): Promise<{value: any}>;
  readRFID(): Promise<any>;
  providePACertificates(options: { certificatesJSON: PKDCertificate[] }): Promise<{value: any}>;
  provideTACertificates(options: { certificatesJSON: PKDCertificate[] }): Promise<{value: any}>;
  provideTASignature(options: {signature: any}): Promise<{value: any}>;
  setRfidDelegate(options: {delegate: number}): Promise<{value: any}>;
}
