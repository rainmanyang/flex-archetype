package com.oasis.tmsv5.facade.interceptor;

import flex.messaging.messages.Message;
import flex.messaging.services.remoting.adapters.JavaAdapter;

public class V5JavaAdapter extends JavaAdapter {

    @Override
    public Object invoke(Message msg) { 
        Object result = super.invoke(msg);    
         return result;
    }

}
