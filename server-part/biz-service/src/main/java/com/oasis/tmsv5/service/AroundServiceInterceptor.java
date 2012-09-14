package com.oasis.tmsv5.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.oasis.tmsv5.dao.SqlSessionHolder;

public class AroundServiceInterceptor implements MethodInterceptor {

    
    public Object invoke(MethodInvocation mi) throws Throwable {
        try {
            Object ret = mi.proceed();
            SqlSessionHolder.clearSession();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            SqlSessionHolder.clearSession();
        }

    }
}
