package com.oasis.tmsv5.service.message;

import java.io.Serializable;

public interface MessageSender<T extends Serializable> {

    public final static String JMS_MSG_ID = "jmsMsgId";

    void send(T target);

    void delaySend(final T target, long timeMillis);
}
