package com.oasis.wolfburg.common.so.truck;

import java.util.List;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.enums.type.TruckResourceType;
import com.oasis.wolfburg.common.enums.type.TruckType;

public class TruckSO extends BasePageSO {
	
	private static final long serialVersionUID = 1L;
	
	private String licensePlate;
	
	private Long truckId;
	
	private List<Long> truckIdList;
	
	private Long carrierId;
	
	private String carrierName;
	
	private String driverName;
	
	private TruckType truckType;
	
	private TruckStatus status;
	
	private TruckResourceType truckResourceType;
	
	private Long routeId;
	
	private Long notInRouteId;
	
	public TruckStatus getStatus() {
		return status;
	}

	public void setStatus(TruckStatus status) {
		this.status = status;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public TruckType getTruckType() {
		return truckType;
	}

	public void setTruckType(TruckType truckType) {
		this.truckType = truckType;
	}

	public Long getTruckId() {
		return truckId;
	}

	public void setTruckId(Long truckId) {
		this.truckId = truckId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public List<Long> getTruckIdList() {
		return truckIdList;
	}

	public void setTruckIdList(List<Long> truckIdList) {
		this.truckIdList = truckIdList;
	}

	public TruckResourceType getTruckResourceType() {
		return truckResourceType;
	}

	public void setTruckResourceType(TruckResourceType truckResourceType) {
		this.truckResourceType = truckResourceType;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Long getNotInRouteId() {
		return notInRouteId;
	}

	public void setNotInRouteId(Long notInRouteId) {
		this.notInRouteId = notInRouteId;
	}

	public Long getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}
	
}
