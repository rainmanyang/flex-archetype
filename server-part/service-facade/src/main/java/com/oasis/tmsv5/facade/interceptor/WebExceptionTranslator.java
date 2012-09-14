package com.oasis.tmsv5.facade.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.flex.core.ExceptionTranslator;

import com.google.gson.Gson;
import com.oasis.tmsv5.util.exception.GLException;

import flex.messaging.MessageException;

public class WebExceptionTranslator implements ExceptionTranslator {

    private static final Log logger = LogFactory.getLog(WebExceptionTranslator.class);

    @Override
    public boolean handles(Class<?> arg0) {
        // 默认处理所有的抛出异常
        return true;
    }

    @Override
    public MessageException translate(Throwable ex) {
        logger.error(ex.getCause());
        MessageException me = new MessageException();
        if (ex.getCause() instanceof GLException) {
            GLException gle = (GLException) ex.getCause();
            me.setMessage(gle.getMessage());
            if (gle.getErrorMap().entrySet().size() > 0) {
                Map<String, String> errors = gle.getErrorMap();
                Gson gson = new Gson();
                String gson_str = gson.toJson(errors);
                me.setMessage(gson_str);
            }
        }
        me.setRootCause(ex);
        return me;
    }
}
