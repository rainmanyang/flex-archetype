package com.oasis.wolfburg.common.enums.status;

import java.util.ArrayList;
import java.util.List;

public enum RSJobStatus {
    /**
     * 新建
     */
    NEW, 
    /**
     * 已计划
     */
    PLANED, 
    /**
     * 已派车
     */
    DISPATCHED, 
    /**
     * 在途
     */
    ENROUTE, 
    /**
     * 到达
     */
    ARRIEVED, 
    /**
     * 已取消
     */
    CANCLED, 
    /**
     * 已终止
     */
    TERMINATED;
    
    public static RSJobStatus string2Status(String value) {
		if (DISPATCHED.name().equals(value)){
			return DISPATCHED;
		} 
		if (PLANED.name().equals(value)) {
			return PLANED;
		}
		if (ENROUTE.name().equals(value)) {
			return ENROUTE;
		}
		if (ARRIEVED.name().equals(value)) {
			return ARRIEVED;
		}
		return null;
	}
    
    public static List<RSJobStatus> getCalendarStatus() {
    	List<RSJobStatus> statusList = new ArrayList<RSJobStatus>();
    	statusList.add(RSJobStatus.NEW);
        statusList.add(RSJobStatus.PLANED);
        statusList.add(RSJobStatus.DISPATCHED);
        statusList.add(RSJobStatus.ENROUTE);
        statusList.add(RSJobStatus.TERMINATED);
		return statusList;
	}

}
