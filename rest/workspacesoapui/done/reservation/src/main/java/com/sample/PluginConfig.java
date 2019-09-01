package com.sample;

import com.eviware.soapui.plugins.PluginAdapter;
import com.eviware.soapui.plugins.PluginConfiguration;

@PluginConfiguration(groupId = "com.sample.plugins", name = "reservation SoapUI Action", version = "0.1",
        autoDetect = true, description = "reservation SoapUI Action",
        infoUrl = "" )
public class PluginConfig extends PluginAdapter {
}
