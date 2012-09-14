package com.oasis.wolfburg.common.so.insure;

import com.oasis.tmsv5.common.util.page.BasePageSO;

public class InsureSO extends BasePageSO {
	
	private static final long serialVersionUID = 1L;
	
	private String insurer;

	private String insureCode;
	
	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}
	

	public String getInsureCode() {
		return insureCode;
	}

	public void setInsureCode(String insureCode) {
		this.insureCode = insureCode;
	}
	
	
	
}
