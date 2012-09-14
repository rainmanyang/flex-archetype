package com.oasis.wolfburg.service.qzSchedule.handler;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oasis.tmsv5.common.base.Constants;
import com.oasis.tmsv5.service.helper.ResourceDispHelper;
import com.oasis.tmsv5.service.message.DefaultMessageSender;
import com.oasis.tmsv5.service.message.MailMessageSender;
import com.oasis.tmsv5.util.tools.DateGen;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.vo.system.Mail;
import com.oasis.wolfburg.common.vo.system.NotifyMail;
import com.oasis.wolfburg.common.vo.system.NotifyMessage;
import com.oasis.wolfburg.dao.truck.TruckDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobDAO;
import com.oasis.wolfburg.dao.truckRSSchedule.TruckRSJobTimeRecordDAO;
import com.oasis.wolfburg.model.track.ExpTrack;
import com.oasis.wolfburg.model.truck.Truck;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJob;
import com.oasis.wolfburg.model.truckRSSchedule.TruckRSJobTimeRecord;
import com.oasis.wolfburg.service.mail.MailHelper;

@Component
public class RsJobNotificationHandler {
    @Autowired
    private TruckRSJobDAO truckRSJobDAO;

    @Autowired
    private TruckDAO truckDAO;

    @Autowired
    private MailHelper mailHelper;

    @Autowired(required=false)
    private MailMessageSender mailSender;

    @Autowired
    private TruckRSJobTimeRecordDAO truckRSJobTimeRecordDAO;
   
    @Autowired(required=false)
    private DefaultMessageSender<NotifyMessage> jmsSender;

    public void handle() {      

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24);
        Date notifyDate = cal.getTime();
        List<TruckRSJob> jobList = truckRSJobDAO.getNotificationJobs(notifyDate);
        if (jobList.size() > 0) {
            notify(jobList);
        }

    }

    private void notify(List<TruckRSJob> jobList) {
        for (TruckRSJob job : jobList) {
            Truck truck = truckDAO.find(job.getTruckId());
            if (truck == null) {
                continue;
            }
            String contact = truck.getLicensePlate();
            String phone = truck.getContactPhone1();
            if (StringUtils.isEmpty(phone)) {
                continue;
            }
            /**
             * whom to send
             */
            Set<Mail> mailSet = new HashSet<Mail>();
            Mail mail = new Mail();
            mail.setPhoneCode(phone);
            mailSet.add(mail);
            /**
             * tile is
             */
            String notifyTitle = contact;
            /**
             * what content is
             */
            TruckRSJobTimeRecord truckRSJobTimeRecord = truckRSJobTimeRecordDAO.getFirstStopTruckRSJobTimeRecordByJob(job.getId());
            String content = ResourceDispHelper.getInstance().getValue("RSJOBNOTIFY_MESSAGE");
            Object[] objs = {DateGen.getStringDateByFormat(truckRSJobTimeRecord.getPlanTime(), "MM-dd hh"),
            		job.getRouteName(),
            		job.getCode()};
            content = MessageFormat.format(content, objs);

//            NotifyMail notifyMail = mailHelper.getPhoneNotifyMail(mailSet, notifyTitle, content);
//            mailSender.send(notifyMail);
            /**
             * at last ,to update job status to be DISPATCHED
             */
            job.setStatus(RSJobStatus.DISPATCHED);
            truckRSJobDAO.update(job);
        }
    }
    
    public void handleExpTrack(ExpTrack expTrack){
    	 NotifyMessage notifyMessage = new NotifyMessage();
         notifyMessage.setTopic(expTrack.getLicensePlate()+ ResourceDispHelper.getInstance().getValue("EXCEPTION"));
         notifyMessage.setContent(expTrack.getId()+ Constants.COLON +expTrack.getRsJobId()+ Constants.COLON +expTrack.getRsScheduleId());
         jmsSender.send(notifyMessage);
    }

}
