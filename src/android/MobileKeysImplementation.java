package cordova.plugin.mobilekeys;
import org.apache.cordova.CallbackContext;

public class MobileKeysImplementation {
    public MobileKeysImplementation() { }

    public boolean GotContact() {
        return true;
    }

    public void echoMethod(CallbackContext callbackContext, boolean outputchanger) {
        if (outputchanger) {
            callbackContext.success("Got contact with external method: " + outputchanger);
        } else {
            callbackContext.error("Didn't get contact with external method: " + outputchanger);
        }
    }
}