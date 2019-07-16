// setup information
var exec = require('cordova/exec');

function MobileKeys() {}

MobileKeys.prototype.PluginName = "MobileKeys";

MobileKeys.prototype.pInvoke = function(method, data, callbackOk, callbackError) {
    console.log('Inside pInvoke');

    if (data == null || data == undefined) {
        data = [];
    } else if (!Array.isArray(data)) {
        data = [data];
    }
    exec(callbackOk, function(err) {
        callback(method + ' returned an error');
    }, this.PluginName, method, data);
}

MobileKeys.install = function() {
    console.log('Inside install');

    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.MobileKeys = new MobileKeys();

    return window.plugins.MobileKeys;
};

cordova.addConstructor(MobileKeys.install);

// Method calls to native code
MobileKeys.prototype.coolMethod = function (arg0, success, error) {
    this.pInvoke("coolMethod", arg0, success, error);
};

// External class Java
MobileKeys.prototype.externalClassMethod = function (arg0, success, error) {
    this.pInvoke("externalClassMethod", arg0, success, error);
};

MobileKeys.prototype.echoMethod = function (arg0, success, error) {
    this.pInvoke("echoMethod", arg0, success, error);
};