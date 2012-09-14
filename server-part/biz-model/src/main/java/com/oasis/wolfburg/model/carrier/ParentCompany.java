package com.oasis.wolfburg.model.carrier;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.tmsv5.util.query.Cache;

@Table(name = "wl_parent_company")
@SequenceGenerator(name = "wl_parent_company_seq")
@Cache
public class ParentCompany extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	@Id
	private Long id;
	
	/**
	 * 公司名
	 */
	@Column(name = "company_name")
	private String companyName;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
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
