package com.oasis.tmsv5.facade.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import flex.messaging.FlexSession;
import flex.messaging.FlexSessionListener;

public class FlexSessionInterceptor implements FlexSessionListener {
    
    private static final Log logger = LogFactory.getLog(FlexSessionInterceptor.class);

    @Override
    public void sessionCreated(FlexSession flexSession) {
        logger.info("session "+flexSession.getId()+" created.");
        
    }

    @Override
    public void sessionDestroyed(FlexSession flexSession) {
        logger.info("session "+flexSession.getId()+" destroyed.");
        
    }

    

}
