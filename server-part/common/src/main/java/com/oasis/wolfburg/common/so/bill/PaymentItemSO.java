package com.oasis.wolfburg.common.so.bill;

import java.util.Date;

import com.oasis.tmsv5.common.util.page.BasePageSO;

public class PaymentItemSO extends BasePageSO {
	
	private static final long serialVersionUID = 1L;
	
	private String licensePlate;
	
	private String trsJobCode;
	
	private Date billDateBegin;
	
	private Date billDateEnd;
	
	private String itemType;
	
	private String requestUrl;
	
	private String carrierName;
	

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getTrsJobCode() {
		return trsJobCode;
	}

	public void setTrsJobCode(String trsJobCode) {
		this.trsJobCode = trsJobCode;
	}

	
	

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public Date getBillDateBegin() {
		return billDateBegin;
	}

	public void setBillDateBegin(Date billDateBegin) {
		this.billDateBegin = billDateBegin;
	}

	public Date getBillDateEnd() {
		return billDateEnd;
	}

	public void setBillDateEnd(Date billDateEnd) {
		this.billDateEnd = billDateEnd;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	

	
	
}
