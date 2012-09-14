package com.oasis.wolfburg.common.so.track;

import java.util.Date;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.ExpGrade;
import com.oasis.wolfburg.common.enums.status.ExpType;

public class ExpTrackSO extends BasePageSO {
	private static final long serialVersionUID = 1L;

	private String licensePlate;
	
	private ExpType expType;
	
	private ExpGrade expGrade;
	
	private Date timeStart;
	
	private Date timeEnd;

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public ExpType getExpType() {
		return expType;
	}

	public void setExpType(ExpType expType) {
		this.expType = expType;
	}

	public ExpGrade getExpGrade() {
		return expGrade;
	}

	public void setExpGrade(ExpGrade expGrade) {
		this.expGrade = expGrade;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}
}
