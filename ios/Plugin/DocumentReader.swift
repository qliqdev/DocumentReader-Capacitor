import Foundation

@objc public class DocumentReader: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
