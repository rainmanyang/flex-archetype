package com.oasis.wolfburg.common.service.qzSchedule;

import com.oasis.tmsv5.common.enums.type.JobCommand;

public interface ScheduleService {

    void processCommand(JobCommand command);

   

}
