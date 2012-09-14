package com.oasis.wolfburg.service.qzSchedule;

import com.oasis.tmsv5.common.enums.type.JobCommand;

public class CancelExpiredShiftScheduleJob extends AbstractStatefulJob {

	@Override
	protected JobCommand getCommand() {
		return JobCommand.CANCEL_EXPIRED_SHIFT_SCHEDULE;
	}

}
