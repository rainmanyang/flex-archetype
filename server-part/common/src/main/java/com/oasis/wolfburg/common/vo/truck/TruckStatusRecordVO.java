package com.oasis.wolfburg.common.vo.truck;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.enums.type.TruckResourceType;

public class TruckStatusRecordVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;

	private String licensePlate;

	private Date executeDate;

	private String updatePerson;

	private TruckStatus truckStatus;
	
	private TruckRunningStatus runningStatus;
	
	private TruckResourceType resourceType;

	private String reason;

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
