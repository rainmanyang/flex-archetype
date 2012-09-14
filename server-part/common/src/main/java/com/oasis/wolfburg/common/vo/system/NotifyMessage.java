package com.oasis.wolfburg.common.vo.system;

import java.io.Serializable;

public class NotifyMessage implements Serializable {

    private static final long serialVersionUID = 7685405935452944317L;

    private String topic;

    private String content;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
