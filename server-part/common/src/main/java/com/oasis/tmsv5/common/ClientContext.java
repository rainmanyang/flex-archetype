package com.oasis.tmsv5.common;

import java.io.Serializable;

public class ClientContext implements Serializable {

    private static final long serialVersionUID = -8640973141424812325L;

    private String loginName;

    private Long accountId;

    private String password;

    private String loginToken;

    private String nameCn;
    
    private String ip;
    
    private String netAuthority;

    public String getNameCn() {
        return nameCn;
    }

    public String getNetAuthority() {
        return netAuthority;
    }

    public void setNetAuthority(String netAuthority) {
        this.netAuthority = netAuthority;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
