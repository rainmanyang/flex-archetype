package com.oasis.wolfburg.model.truck;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.enums.type.TruckResourceType;

@Table(name = "wl_truck_status_record")
@SequenceGenerator(name = "wl_truck_status_record_seq")
public class TruckStatusRecord extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "license_plate")
	private String licensePlate;

	@Column(name = "execute_date")
	private Date executeDate;

	@Column(name = "update_person")
	private String updatePerson;

	@Column(name = "truck_status")
	private TruckStatus truckStatus;
	
	@Column(name = "running_status")
	private TruckRunningStatus runningStatus;
	
	/**
	 * 资源类型
	 */
	@Column(name = "resource_type")
	private TruckResourceType resourceType;

	@Column(name = "reason")
	private String reason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Date getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(Date executeDate) {
		this.executeDate = executeDate;
	}

	public TruckStatus getTruckStatus() {
		return truckStatus;
	}

	public void setTruckStatus(TruckStatus truckStatus) {
		this.truckStatus = truckStatus;
	}

	public TruckRunningStatus getRunningStatus() {
		return runningStatus;
	}

	public void setRunningStatus(TruckRunningStatus runningStatus) {
		this.runningStatus = runningStatus;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public TruckResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(TruckResourceType resourceType) {
		this.resourceType = resourceType;
	}

}
