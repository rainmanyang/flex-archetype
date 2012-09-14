package com.oasis.wolfburg.common.vo.system;

import java.io.Serializable;

public class Mail implements Serializable {
    private static final long serialVersionUID = 6532431982950455417L;

    private String mailAdrr;

    private String phoneCode;

    public String getMailAdrr() {
        return mailAdrr;
    }

    public void setMailAdrr(String mailAdrr) {
        this.mailAdrr = mailAdrr;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

}
