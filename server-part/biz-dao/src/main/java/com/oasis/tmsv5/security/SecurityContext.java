package com.oasis.tmsv5.security;

import java.io.Serializable;
import java.util.List;

import com.oasis.tmsv5.common.vo.security.RolePremissionVO;
import com.oasis.tmsv5.model.security.Account;
import com.oasis.tmsv5.model.security.Role;

public class SecurityContext implements Serializable {

    private static final long serialVersionUID = 8231934071238310850L;

    private Account account;
    
    private Role preRole;

    private List<RolePremissionVO> role;
    
    private String ip;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<RolePremissionVO> getRole() {
        return role;
    }

    public void setRole(List<RolePremissionVO> role) {
        this.role = role;
    }

	public Role getPreRole() {
		return preRole;
	}

	public void setPreRole(Role preRole) {
		this.preRole = preRole;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
    
}
