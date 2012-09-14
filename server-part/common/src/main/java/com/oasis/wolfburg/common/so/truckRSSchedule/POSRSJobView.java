package com.oasis.wolfburg.common.so.truckRSSchedule;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class POSRSJobView implements Serializable {

    private static final long serialVersionUID = -993646994322404661L;

    /**
     * 任务单号
     */
    private String code;

    /**
     * 计划进站时间
     */
    @Column(name = "PLAN_INBOUND_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planInboundTime;

    /**
     * 计划离站时间
     */
    @Column(name = "plan_Outbound_Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planOutboundTime;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone1")
    private String contactPhone1;

    /**
     * 车牌号
     */
    @Column(name = "LICENSE_PLATE")
    private String licensePlate;
    /**
     * 司机
     */
    private String driver;

    /**
     * 线路
     */
    @Column(name = "ROUTE_NAME")
    private String routeName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPlanInboundTime() {
        return planInboundTime;
    }

    public void setPlanInboundTime(Date planInboundTime) {
        this.planInboundTime = planInboundTime;
    }

    public Date getPlanOutboundTime() {
        return planOutboundTime;
    }

    public void setPlanOutboundTime(Date planOutboundTime) {
        this.planOutboundTime = planOutboundTime;
    }

    public String getContactPhone1() {
        return contactPhone1;
    }

    public void setContactPhone1(String contactPhone1) {
        this.contactPhone1 = contactPhone1;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

}
