package com.oasis.tmsv5.service.message;

import java.io.Serializable;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.oasis.tmsv5.common.base.Constants;

public class DefaultMessageSender<T extends Serializable> implements MessageSender<T> {

    protected JmsTemplate jmsTemplate;

    protected Destination destination;
    
    protected Destination topicDestination;

    
    public void setTopicDestination(Destination topicDestination) {
        this.topicDestination = topicDestination;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void delaySend(final T target, long timeMillis) {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new TimerTask() {
            public void run() {
                doSending(target,destination);
                this.cancel();
                executorService.shutdown();
            }
        }, timeMillis, TimeUnit.MILLISECONDS);
    }

    public void send(final T target) {
        doSending(target,destination);

    }
    
    public void sendToTopic(final T target) {
        doSending(target,topicDestination);

    }

    private void doSending(final T target,Destination msgDest) {
      
        final String jmsMessageId = getMessageId(target);
        jmsTemplate.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        jmsTemplate.setSessionTransacted(false);
        jmsTemplate.send(msgDest, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message msg = session.createObjectMessage(target);
                msg.setStringProperty(JMS_MSG_ID, jmsMessageId);
                return msg;
            }
        });

    }

    public T logMessage(T message) {
        return message;
    }

    protected boolean bePassed(T target) {
        if (target == null) {
            return false;
        }
        return true;
    }

    protected String getMessageId(final T target) {
        return System.currentTimeMillis() + Constants.UNDERLINE + UUID.randomUUID();
    }

}
