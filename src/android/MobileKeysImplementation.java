package cordova.plugin.mobilekeys;
import org.apache.cordova.CallbackContext;

public class MobileKeysImplementation {
    public MobileKeysImplementation() { }

    public boolean GotContact() {
        return true;
    }

    public void echoMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}