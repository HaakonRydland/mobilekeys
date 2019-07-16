package cordova.plugin.mobilekeys;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.assaabloy.mobilekeys.api.ApiConfiguration;
import com.assaabloy.mobilekeys.api.MobileKeys;
import com.assaabloy.mobilekeys.api.MobileKeysApi;
import com.assaabloy.mobilekeys.api.ReaderConnectionController;
import com.assaabloy.mobilekeys.api.ble.*;
import com.assaabloy.mobilekeys.api.hce.NfcConfiguration;

/**
 * This class echoes a string called from JavaScript.
 */
public class MobileKeys extends CordovaPlugin {
    private MobileKeysImplementation mobileKey = new MobileKeysImplementation();

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        } else if (action.equals("externalClassMethod")) {
            this.externalClassMethod(callbackContext);
            return true;
        } else if (action.equals("echoMethod")) {
            String arguments = args.getString(0);
            boolean outputChanger = Boolean.valueOf(arguments);
            this.echoMethod(callbackContext, outputChanger);
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
        if (mobileKey.GotContact()) {
            callbackContext.success("That worked");
        }
        callbackContext.error("That did not go as planned");
    }

    private void echoMethod(CallbackContext callbackContext, boolean outputchanger) {
        mobileKey.echoMethod(callbackContext, outputchanger);
    }
}
