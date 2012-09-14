package com.oasis.wolfburg.common.vo.system;


import java.io.Serializable;

import com.oasis.tmsv5.common.enums.type.MailMessageType;

public class NotifyMail implements Serializable {

    private static final long serialVersionUID = 5693552449294309381L;

    private MailMessageType mailType;

    private Serializable mail;

    public MailMessageType getMailType() {
        return mailType;
    }

    public void setMailType(MailMessageType mailType) {
        this.mailType = mailType;
    }

    public Serializable getMail() {
        return mail;
    }

    public void setMail(Serializable mail) {
        this.mail = mail;
    }

}
