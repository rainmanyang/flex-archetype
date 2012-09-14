package com.oasis.wolfburg.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.oasis.wolfburg.common.vo.system.NotifyMail;

@Component
public class MailComponent {
    @Autowired
    private MailHelper mailHelper;

//    public void process(NotifyMail mail) {
//        switch (mail.getMailType()) {
//        case NOTIFYMAIL:
//            mailHelper.send((SimpleMailMessage) mail.getMail());
//            break;
//        case NOTITYPHONETEXT:
//            mailHelper.sendPoneText((SimpleMailMessage) mail.getMail());
//            break;
//        }

//    }
}
