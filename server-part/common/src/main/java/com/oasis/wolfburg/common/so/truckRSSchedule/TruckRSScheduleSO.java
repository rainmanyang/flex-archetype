package com.oasis.wolfburg.common.so.truckRSSchedule;

import java.util.List;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.TruckScheduleStatus;

public class TruckRSScheduleSO extends BasePageSO {

    private static final long serialVersionUID = -7012848245686479326L;
    
    
    /**
     * 时刻表名称
     */
    private String name;
    
    private TruckScheduleStatus status;
    
    private String routeName;
    
    private Long routeId;
    
    private List<TruckScheduleStatus> statuses;
    
	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TruckScheduleStatus getStatus() {
		return status;
	}

	public void setStatus(TruckScheduleStatus status) {
		this.status = status;
	}

    public List<TruckScheduleStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<TruckScheduleStatus> statuses) {
        this.statuses = statuses;
    }
	
	
}
