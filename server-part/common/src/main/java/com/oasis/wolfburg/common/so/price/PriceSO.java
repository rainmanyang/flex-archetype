package com.oasis.wolfburg.common.so.price;

import java.util.Date;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.PriceStatus;

public class PriceSO extends BasePageSO {

	private static final long serialVersionUID = 1L;

	private String routeName;

	private PriceStatus status;

	private Date periodStart;

	private Date periodEnd;
	
	private Long routeId;

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

	public PriceStatus getStatus() {
		return status;
	}

	public void setStatus(PriceStatus status) {
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
