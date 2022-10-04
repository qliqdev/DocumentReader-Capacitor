import Foundation
import Capacitor
import DocumentReader

@objc public class DocumentReader: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
    
    @objc public func initializeReaderAutomatically(_ call: CAPPluginCall) {
        call.resolve()
    }
    
    @objc public func getAPIVersion() -> String {
        return DocReader.shared.version?.api ?? ""
    }
    
    @objc public func getAvailableScenarios() -> Array<Any> {
        return DocReader.shared.availableScenarios
    }
}
