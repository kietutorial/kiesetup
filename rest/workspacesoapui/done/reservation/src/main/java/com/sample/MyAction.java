package com.sample;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.plugins.ActionConfiguration;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import javax.swing.*;

@ActionConfiguration(actionGroup = ActionGroups.OPEN_PROJECT_ACTIONS)
public class MyAction extends AbstractSoapUIAction<WsdlProject> {

    public MyAction() {
        super("My Action", "A plugin action at the project level");
    }

    @Override
    public void perform(WsdlProject wsdlProject, Object o) {
        UISupport.showInfoMessage("Hello from [" + wsdlProject.getName() + "]!");
    }
}
