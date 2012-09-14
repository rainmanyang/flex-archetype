package com.oasis.wolfburg.common.vo.trackRecord;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.type.EventPhase;

public class TrackRecordVO extends BaseVO {
    
    private static final long serialVersionUID = 2586970954113115179L;
    
    private Long truckRsJobId;
    
    private Date eventTime;
    
    private String description;
    
    private EventPhase eventPhase;

    public EventPhase getEventPhase() {
		return eventPhase;
	}

	public void setEventPhase(EventPhase eventPhase) {
		this.eventPhase = eventPhase;
	}

	public Long getTruckRsJobId() {
        return truckRsJobId;
    }

    public void setTruckRsJobId(Long truckRsJobId) {
        this.truckRsJobId = truckRsJobId;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
