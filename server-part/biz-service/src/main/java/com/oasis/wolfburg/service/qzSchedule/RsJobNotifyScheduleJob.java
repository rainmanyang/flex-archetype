package com.oasis.wolfburg.service.qzSchedule;

import com.oasis.tmsv5.common.enums.type.JobCommand;

public class RsJobNotifyScheduleJob extends AbstractStatefulJob {

    @Override
    protected JobCommand getCommand() {       
        return JobCommand.RSJOB_NOTIFY;
    }

}
