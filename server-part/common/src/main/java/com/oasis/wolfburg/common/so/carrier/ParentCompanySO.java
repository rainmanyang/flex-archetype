package com.oasis.wolfburg.common.so.carrier;

import com.oasis.tmsv5.common.util.page.BasePageSO;

public class ParentCompanySO extends BasePageSO {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 公司名
	 */
	private String companyName;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
