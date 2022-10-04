import { WebPlugin } from '@capacitor/core';

import type { DocumentReaderPlugin } from './definitions';

export class DocumentReaderWeb extends WebPlugin implements DocumentReaderPlugin {
  async initializeReaderAutomatically(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getAvailableScenarios(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async parseCoreResults(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getAPIVersion(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getCoreVersion(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getCoreMode(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDatabaseID(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDatabaseVersion(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDatabaseDate(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDatabaseDescription(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDatabaseCountriesNumber(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDatabaseDocumentsNumber(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async isAuthenticatorAvailableForUse(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getConfig(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getRfidScenario(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async selectedScenario(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getScenario(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getLicenseExpiryDate(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getLicenseCountryFilter(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async licenseIsRfidAvailable(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDocumentReaderIsReady(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getDocumentReaderStatus(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async isRFIDAvailableForUse(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async getSessionLogFolder(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async setTCCParams(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async initializeReader(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async deinitializeReader(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async startNewSession(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async startNewPage(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async recognizeImageWithOpts(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async recognizeData(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async recognizeImages(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async recognizeImagesWithImageInputs(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async removeDatabase(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async cancelDBUpdate(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async resetConfiguration(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async setEnableCoreLogs(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async addPKDCertificates(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async clearPKDCertificates(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async recognizeVideoFrame(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async showScannerWithCameraID(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async showScanner(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async showScannerWithCameraIDAndOpts(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async stopScanner(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async startRFIDReader(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async stopRFIDReader(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async prepareDatabase(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async runAutoUpdate(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async setRfidScenario(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async setConfig(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async readRFID(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async providePACertificates(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async provideTACertificates(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async provideTASignature(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }

  async setRfidDelegate(): Promise<any> {
    this.unimplemented('Not implemented on web.')
  }
}
