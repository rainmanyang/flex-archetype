package com.oasis.wolfburg.common.so.driver;

import java.util.Date;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.DriverStatus;

public class DriverSO extends BasePageSO {
	private static final long serialVersionUID = 1L;

	private String code;

	private String name;

	private String license;

	private DriverStatus status;

	private Date periodStart;

	private Date periodEnd;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public DriverStatus getStatus() {
		return status;
	}

	public void setStatus(DriverStatus status) {
		this.status = status;
	}

	public Date getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}
}
