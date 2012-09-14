package com.oasis.wolfburg.service.qzSchedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.oasis.tmsv5.common.enums.type.JobCommand;
import com.oasis.tmsv5.security.ClientContextHolder;
import com.oasis.wolfburg.common.service.qzSchedule.ScheduleService;

public abstract class AbstractJob extends QuartzJobBean {

    private static final Log logger = LogFactory.getLog(AbstractJob.class);

    private boolean fire;

    private ScheduleService scheduleServiceSessionBean;

	private boolean transactional;
	
	 public void setScheduleServiceSessionBean(
				ScheduleService scheduleServiceSessionBean) {
			this.scheduleServiceSessionBean = scheduleServiceSessionBean;
		}

    public void setTransactional(boolean transactional) {
        this.transactional = transactional;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {

        logger.debug("is fire:" + fire);
        logger.debug("is transactional:" + transactional);
        if (!fire) {
            return;
        }
        logger.info("GROUP " + jobContext.getJobDetail().getGroup() + " JOB " + jobContext.getJobDetail().getFullName()
                + ", transactional:" + transactional + ", starts...");
        logger.debug("The command is:" + getCommand().name());
        try {
            if (transactional) {
            	ClientContextHolder.buildSystemContext();
                scheduleServiceSessionBean.processCommand(getCommand());
            }

        } catch (Exception e) {
            String errorMsg = "Job Handle= " + jobContext.getJobDetail().getJobClass().getSimpleName() + ", GROUP "
                    + jobContext.getJobDetail().getGroup() + ", JOB " + jobContext.getJobDetail().getFullName() + " failed.";
            logger.error(errorMsg);
            e.printStackTrace();
        }

    }

    protected abstract JobCommand getCommand();

}
