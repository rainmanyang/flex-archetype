package com.oasis.wolfburg.service.mail;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.enums.type.MailMessageType;
import com.oasis.tmsv5.util.tools.LogMessageUtil;
import com.oasis.wolfburg.common.vo.system.Mail;
import com.oasis.wolfburg.common.vo.system.NotifyMail;

@Component
public class MailHelper {
//    @Autowired
//    @Qualifier("mailSender")
//    private MailSender mailSender;
//
//    @Autowired
//    @Qualifier("phoneTextSender")
////    private MailSender phoneTextSender;
//
//    private static final Log logger = LogFactory.getLog(MailHelper.class);
//
//    private Resource resource;
//
//    public static Properties mailConfig = new Properties();
//
//    public static final String MAIL_SWITCH_ON = "mail.switch.on";
//
//    public static final String MAIL_HOST = "mail.host";
//
//    public static final String MAIL_TO = "mail.to";
//
//    public static final String MAIL_FROM = "mail.from";
//
//    public static final String MAIL_SUBJECT = "mail.subject";
//
//    public static final String SUPPORT_MAIL_TO = "mail.support.to";
//
//    public static final String SUPPORT_MAIL_FROM = "mail.support.from";
//
//    public static final String SUPPORT_MAIL_SUBJECT = "mail.support.subject";
//
//    public static final String MESSAGE_FROM = "message.from";
//
//    public static final String MESSAGE_HOST = "messsage.host";
//
//    public static final String COMMENT_MAIL_TO = "mail.comment.to";
//
//    public static final String COMMENT_MAIL_FROM = "mail.comment.from";
//
//    public static final String COMMENT_MAIL_SUBJECT = "mail.comment.subject";
//
//    public static final String JOB_MAIL_SUBJECT = "mail.job.subject";
//
//    public static final String MAIL_SPLITOR = "@";
//
//    public void setResource(Resource resource) {
//        this.resource = resource;
//        getMailConfig();
//    }
//
//    public void send(SimpleMailMessage msg) {
//        try {
//            mailSender.send(msg);
//        } catch (MailException me) {
//            logger.error("Mail sending failed");
//            logger.error(me);
//        }
//    }
//
//    public void send(String message, MailMessageType messageType) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        Properties properties = getMailConfig();
//        if (!Boolean.parseBoolean(properties.getProperty(MAIL_SWITCH_ON))) {
//            logger.trace("Mail sending disabled.");
//            return;
//        }
//        switch (messageType) {
//        case SUPPORT:
//            msg.setFrom(properties.getProperty(SUPPORT_MAIL_FROM));
//            msg.setTo(properties.getProperty(SUPPORT_MAIL_TO));
//            msg.setSubject(properties.getProperty(SUPPORT_MAIL_SUBJECT));
//            break;
//        case USERCOMMENT:
//            msg.setFrom(properties.getProperty(COMMENT_MAIL_FROM));
//            msg.setTo(properties.getProperty(COMMENT_MAIL_TO));
//            msg.setSubject(properties.getProperty(COMMENT_MAIL_SUBJECT));
//            break;
//        default:
//            msg.setFrom(properties.getProperty(MAIL_FROM));
//            msg.setTo(properties.getProperty(MAIL_TO));
//            msg.setSubject(properties.getProperty(MAIL_SUBJECT));
//        }
//        msg.setText(message);
//        msg.setSentDate(new Date(System.currentTimeMillis()));
//        send(msg);
//    }
//
//    public void sendPoneText(SimpleMailMessage msg) {
//        try {
//            phoneTextSender.send(msg);
//        } catch (MailException me) {
//            logger.error("Mail sending failed");
//            logger.error(me);
//        }
//    }
//
//    public NotifyMail getPhoneNotifyMail(Set<Mail> mailList, String notifyTitle, String sendingMessage) {
//        if (mailList == null || mailList.size() == 0) {
//            return null;
//        }
//        String phoneCodes[] = new String[mailList.size()];
//        int i = 0;
//        for (Mail mail : mailList) {            
//            phoneCodes[i] = mail.getPhoneCode()+ MAIL_SPLITOR + MailHelper.mailConfig.getProperty(MailHelper.MESSAGE_HOST);
//            i++;
//        }
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(MailHelper.mailConfig.getProperty(MailHelper.MESSAGE_FROM));
//        msg.setText(sendingMessage);
//        msg.setTo(phoneCodes);
//        msg.setSubject(notifyTitle);
//
//        NotifyMail notifyMail = new NotifyMail();
//        notifyMail.setMail(msg);
//        notifyMail.setMailType(MailMessageType.NOTITYPHONETEXT);
//        return notifyMail;
//    }
//
//    private Properties getMailConfig() {
//        if (!mailConfig.isEmpty()) {
//            return mailConfig;
//        }
//        try {
//            mailConfig.load(resource.getInputStream());
//        } catch (IOException e) {
//            logger.error("can't find mail configuration property");
//            logger.error(LogMessageUtil.printStack(e));
//        }
//        return mailConfig;
//    }
}
