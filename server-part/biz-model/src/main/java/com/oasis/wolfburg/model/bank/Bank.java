package com.oasis.wolfburg.model.bank;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;

@Table(name = "wl_bank")
@SequenceGenerator(name = "wl_bank_seq")
@Cache
public class Bank extends BaseModel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@Id
	private Long id;
	
	/**
	 * 银行
	 */
	@Column(name = "bank_name")
	private String bankName;
	
	/**
	 * 开户行
	 */
	@Column(name = "branch_name")
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
