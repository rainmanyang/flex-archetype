package com.oasis.wolfburg.model.truck;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "wl_contract_route")
@SequenceGenerator(name = "wl_contract_route_seq")
public class ContractRoute implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "truck_id")
	private Long truckId;
	
	@Column(name = "route_id")
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
