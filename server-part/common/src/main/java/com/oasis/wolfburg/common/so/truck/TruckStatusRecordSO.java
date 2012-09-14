package com.oasis.wolfburg.common.so.truck;

import java.util.Date;

import com.oasis.tmsv5.common.util.page.BasePageSO;

public class TruckStatusRecordSO  extends BasePageSO {
	
	private static final long serialVersionUID = 1L;
	
	private String licensePlate;
	
	private String updatePerson;
	
	private Date executeDateFrom;
	
	private Date executeDateTo;

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	public Date getExecuteDateFrom() {
		return executeDateFrom;
	}

	public void setExecuteDateFrom(Date executeDateFrom) {
		this.executeDateFrom = executeDateFrom;
	}

	public Date getExecuteDateTo() {
		return executeDateTo;
	}

	public void setExecuteDateTo(Date executeDateTo) {
		this.executeDateTo = executeDateTo;
	}

}
