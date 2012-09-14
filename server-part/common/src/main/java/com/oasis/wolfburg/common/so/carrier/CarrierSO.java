package com.oasis.wolfburg.common.so.carrier;

import java.util.List;

import com.oasis.tmsv5.common.util.page.BasePageSO;
import com.oasis.wolfburg.common.enums.status.CarrierStatus;
import com.oasis.wolfburg.common.enums.type.CarrierType;

public class CarrierSO extends BasePageSO {
	
	private static final long serialVersionUID = 1L;
	
	private String carrierName;
	
	private String carrierCode;
	
	private List<Long> carrierIdList;
	
	private CarrierStatus status;
	
	private CarrierType carrierType;

	public String getCarrierName() {
		return carrierName == null ? carrierName:carrierName.trim();
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierCode() {
		return carrierCode == null ? carrierCode : carrierCode.trim();
	}

	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}

	public List<Long> getCarrierIdList() {
		return carrierIdList;
	}

	public void setCarrierIdList(List<Long> carrierIdList) {
		this.carrierIdList = carrierIdList;
	}

	public CarrierStatus getStatus() {
		return status;
	}

	public void setStatus(CarrierStatus status) {
		this.status = status;
	}

	public CarrierType getCarrierType() {
		return carrierType;
	}

	public void setCarrierType(CarrierType carrierType) {
		this.carrierType = carrierType;
	}
	
}
