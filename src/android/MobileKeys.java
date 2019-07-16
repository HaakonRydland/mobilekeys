package cordova.plugin.mobilekeys;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MobileKeys extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        } else if (action.equals("externalClassMethod")) {
            this.externalClassMethod(callbackContext);
            return true;
        } else if (action.equals("echoMethod)")) {
            String message = args.getString(0);
            this.privateEchoMethod(message, callbackContext);
            return true;
        }

        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void externalClassMethod(CallbackContext callbackContext) {
        MobileKeysImplementation mobileKey = new MobileKeysImplementation();
        if (mobileKey.GotContact()) {
            callbackContext.success("That worked");
        }
        callbackContext.error("That did not go as planned");
    }
}
