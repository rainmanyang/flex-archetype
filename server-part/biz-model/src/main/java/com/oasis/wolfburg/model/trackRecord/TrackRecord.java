package com.oasis.wolfburg.model.trackRecord;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.type.EventPhase;

@Table(name = "WL_TRACKRECORD")
@SequenceGenerator(name = "WL_TRACKRECORD_SEQ")
public class TrackRecord extends BaseModel {
    
	private static final long serialVersionUID = 2586970954113115179L;

    @Id
    private Long id;
    
    @Column(name="truck_rsjob_id")
    private Long truckRsJobId;
    
    @Column(name="event_time")
    private Date eventTime;
    
    @Column(name="description")
    private String description;
    
    @Column(name="event_phase")
    private EventPhase eventPhase;

	public EventPhase getEventPhase() {
		return eventPhase;
	}

	public void setEventPhase(EventPhase eventPhase) {
		this.eventPhase = eventPhase;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
