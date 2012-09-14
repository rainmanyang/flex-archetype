package com.oasis.wolfburg.common.vo.trackRecord;

import java.util.Date;

import javax.persistence.Column;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.type.EventPhase;

public class TrackRecordViewVO extends BaseVO {
    
    private static final long serialVersionUID = 2586970954113115179L;
    
    @Column(name="truck_rsjob_id")
    private Long truckRsJobId;
    
    @Column(name="event_time")
    private Date eventTime;
    
    @Column(name="description")
    private String description;
    
    @Column(name="event_phase")
    private EventPhase eventPhase;
    
    private String truckRsJobName;
    
    private String opName;

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

    public String getTruckRsJobName() {
        return truckRsJobName;
    }

    public void setTruckRsJobName(String truckRsJobName) {
        this.truckRsJobName = truckRsJobName;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }
    
}
