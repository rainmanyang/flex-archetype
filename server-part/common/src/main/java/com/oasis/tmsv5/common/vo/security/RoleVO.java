package com.oasis.tmsv5.common.vo.security;

import java.io.Serializable;

public class RoleVO implements Serializable {
	
    private static final long serialVersionUID = 1L;

	private Long id;
	
	private String name;
	
	private String description;
	
	private String netAuthority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNetAuthority() {
		return netAuthority;
	}

	public void setNetAuthority(String netAuthority) {
		this.netAuthority = netAuthority;
	}
	
	
}
