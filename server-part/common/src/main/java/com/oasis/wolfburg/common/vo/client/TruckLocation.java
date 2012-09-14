package com.oasis.wolfburg.common.vo.client;

import java.io.Serializable;
import java.util.Date;

public class TruckLocation implements Serializable {

    private static final long serialVersionUID = 6725383610823465017L;
    /**
     * 车牌
     */
    private String truckCode;

    private Date updatedTime;

    private String location;
    
    private String city;
    
    private int execFlag=0;
    
    private String message;

    public int getExecFlag() {
        return execFlag;
    }

    public void setExecFlag(int execFlag) {
        this.execFlag = execFlag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTruckCode() {
        return truckCode;
    }

    public void setTruckCode(String truckCode) {
        this.truckCode = truckCode;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
