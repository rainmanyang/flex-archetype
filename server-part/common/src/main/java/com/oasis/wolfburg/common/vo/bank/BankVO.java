package com.oasis.wolfburg.common.vo.bank;

import com.oasis.tmsv5.common.vo.BaseVO;

public class BankVO extends BaseVO {
	
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private Long id;
	
	/**
	 * 银行
	 */
	private String bankName;
	
	/**
	 * 开户行
	 */
	private String branchName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
