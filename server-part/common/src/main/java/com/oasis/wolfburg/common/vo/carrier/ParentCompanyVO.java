package com.oasis.wolfburg.common.vo.carrier;

import com.oasis.tmsv5.common.vo.BaseVO;

public class ParentCompanyVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 公司名
	 */
	private String companyName;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
