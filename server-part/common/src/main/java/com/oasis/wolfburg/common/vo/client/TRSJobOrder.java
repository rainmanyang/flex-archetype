package com.oasis.wolfburg.common.vo.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oasis.wolfburg.common.enums.status.RSJobStatus;

public class TRSJobOrder implements Serializable {

    private static final long serialVersionUID = 8622144577679013206L;

    private Long id;

    /**
     * 任务单编号
     */
    private String code;

    /**
     * 时刻表编号
     */
    private String trsCode;

    /**
     * 发班日期
     */
    private Date startDate;

    /**
     * 车牌
     */
    private String licence;

    /**
     * 司机
     */
    private String driver;

    /**
     * 车辆标示卡
     */
    private String identityCard;

    /**
     * 任务单打印唯一码
     */
    private String pinCode;

    /**
     * 任务单扫描唯一码
     */
    private String scanCode;

    /**
     * 铅封号
     */
    private String sealCode;

    /**
     * 任务单状态
     */
    private RSJobStatus status;

    /**
     * 线路名称
     */
    private String routeName;

    /**
     * 途径站点
     */
    private List<TRSStop> stops = new ArrayList<TRSStop>();

    private boolean defaultOrder = false;
    
    private String truckType;
    
    private String jobType;

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    private int printCount = 0;

    public boolean isDefaultOrder() {
        return defaultOrder;
    }

    public void setDefaultOrder(boolean defaultOrder) {
        this.defaultOrder = defaultOrder;
    }

    public int getPrintCount() {
        return printCount;
    }

    public void setPrintCount(int printCount) {
        this.printCount = printCount;
    }

    public Long getId() {
        return id;
    }

    public void addStop(TRSStop stop) {
        this.stops.add(stop);
    }

    public List<TRSStop> getStops() {
        return stops;
    }

    public void setStops(List<TRSStop> stops) {
        this.stops = stops;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTrsCode() {
        return trsCode;
    }

    public void setTrsCode(String trsCode) {
        this.trsCode = trsCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getScanCode() {
        return scanCode;
    }

    public void setScanCode(String scanCode) {
        this.scanCode = scanCode;
    }

    public String getSealCode() {
        return sealCode;
    }

    public void setSealCode(String sealCode) {
        this.sealCode = sealCode;
    }

    public RSJobStatus getStatus() {
        return status;
    }

    public void setStatus(RSJobStatus status) {
        this.status = status;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

}
