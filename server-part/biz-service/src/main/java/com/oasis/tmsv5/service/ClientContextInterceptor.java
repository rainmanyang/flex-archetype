package com.oasis.tmsv5.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.security.ClientContextHolder;

public class ClientContextInterceptor implements MethodInterceptor {

    
    public Object invoke(MethodInvocation mi) throws Throwable {
        try {
            Object[] paras = mi.getArguments();
            if(paras.length>0){
            	if(paras[0] instanceof ClientContext){
            		ClientContext cc = (ClientContext)paras[0];
            		ClientContextHolder.setContext(cc);
            	}
            }
           return mi.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } 
    }
}
