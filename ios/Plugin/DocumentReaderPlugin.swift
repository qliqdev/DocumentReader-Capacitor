import Foundation
import Capacitor

import UIKit;

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(DocumentReaderPlugin)
public class DocumentReaderPlugin: CAPPlugin {
    private let implementation = DocumentReader()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }

    @objc func initializeReaderAutomatically(_ call: CAPPluginCall) {
        implementation.initializeReaderAutomatically(call)
    }

    @objc func getAPIVersion(_ call: CAPPluginCall) {
        call.resolve([
            "value": implementation.getAPIVersion()
        ])
    }
    
    @objc func getAvailableScenarios(_ call: CAPPluginCall) {
        call.resolve([
            "value": implementation.getAvailableScenarios()
        ])
    }
}
