package com.oasis.wolfburg.common.vo.truck;

import com.oasis.tmsv5.common.vo.BaseVO;

public class ContractRouteVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;
	
	private Long truckId;
	
	private Long routeId;

	public Long getTruckId() {
		return truckId;
	}

	public void setTruckId(Long truckId) {
		this.truckId = truckId;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	
}
