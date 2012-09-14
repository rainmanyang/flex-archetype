package com.oasis.wolfburg.common.so.truckRSSchedule;

import java.util.Date;

import com.oasis.tmsv5.common.util.page.BasePageSO;

public class ClientBarcodeRecordSO extends BasePageSO {
	
	private static final long serialVersionUID = 1L;
	
	private String posName;
	
	private Date scanTimeBegin;
	
	private Date scanTimeEnd;
	
	private String barcode;

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}

	public Date getScanTimeBegin() {
		return scanTimeBegin;
	}

	public void setScanTimeBegin(Date scanTimeBegin) {
		this.scanTimeBegin = scanTimeBegin;
	}

	public Date getScanTimeEnd() {
		return scanTimeEnd;
	}

	public void setScanTimeEnd(Date scanTimeEnd) {
		this.scanTimeEnd = scanTimeEnd;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	
	
	
}
