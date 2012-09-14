package com.oasis.wolfburg.service.qzSchedule;

import com.oasis.tmsv5.common.enums.type.JobCommand;

public class GeneratorShiftScheduleJob extends AbstractStatefulJob {
    @Override
    protected JobCommand getCommand() {
        return JobCommand.GENERATOR_SHIFT_SCHEDULE;
    }
}
