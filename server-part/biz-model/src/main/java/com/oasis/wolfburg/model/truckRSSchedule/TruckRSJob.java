package com.oasis.wolfburg.model.truckRSSchedule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
import com.oasis.wolfburg.common.enums.type.RSJobType;

@Table(name = "WL_TRUCKRS_JOB")
@SequenceGenerator(name = "WL_TRUCKRS_JOB_SEQ")
public class TruckRSJob extends BaseModel {

    private static final long serialVersionUID = 2800136123549821225L;

    @Id
    private Long id;

    /**
     * 关联时刻表ID
     */
    @Column(name = "RS_SCHEDULE_ID")
    private Long rsScheduleId;

    private String code;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "LICENSE_PLATE")
    private String licensePlate;

    private String driver;

    /**
     * 车辆标示卡
     */
    @Column(name = "IDENTITY_CARD")
    private String identityCard;
    
    @Column(name = "TRUCK_ID")
    private Long truckId;

    /**
     * 任务单打印唯一码
     */
    @Column(name = "PIN_CODE")
    private String pinCode;

    /**
     * 任务单扫描唯一码
     */
    @Column(name = "SCAN_CODE")
    private String scanCode;

    /**
     * 铅封号
     */
    @Column(name = "SEAL_CODE")
    private String sealCode;

    private RSJobStatus status = RSJobStatus.NEW;

    @Column(name = "ROUTE_ID")
    private Long routeId;

    @Column(name = "ROUTE_NAME")
    private String routeName;

    /**
     * 合同费用
     */
    @Column(name = "CONTRACK_PRICE")
    private String contrackPrice;

    /**
     * 空驶费用
     */
    @Column(name = "EMPTY_PRICE")
    private String emptyPrice;

    /**
     * 加班费用
     */
    @Column(name = "OVERTIME_PRICE")
    private String overTimePrice;

    /**
     * 费率本编号
     */
    @Column(name = "PRICE_CODE")
    private String priceCode;
    
    /**
     * 班车类型
     */
    @Column(name = "RSJOB_TYPE")
    private RSJobType rsJobType;

    @Column(name = "PRINT_COUNT")
    private int printCount = 0;
    
    /**
     * 关联任务单号
     */
    @Column(name="ASCO_RSJOBID")
    private int asco_RsJobId;

    public int getPrintCount() {
        return printCount;
    }

    public void setPrintCount(int printCount) {
        this.printCount = printCount;
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public String getCode() {
        return code;
    }

    public Long getRsScheduleId() {
        return rsScheduleId;
    }

    public void setRsScheduleId(Long rsScheduleId) {
        this.rsScheduleId = rsScheduleId;
    }

    public String getSealCode() {
        return sealCode;
    }

    public void setSealCode(String sealCode) {
        this.sealCode = sealCode;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getContrackPrice() {
        return contrackPrice;
    }

    public void setContrackPrice(String contrackPrice) {
        this.contrackPrice = contrackPrice;
    }

    public String getEmptyPrice() {
        return emptyPrice;
    }

    public void setEmptyPrice(String emptyPrice) {
        this.emptyPrice = emptyPrice;
    }

    public String getOverTimePrice() {
        return overTimePrice;
    }

    public void setOverTimePrice(String overTimePrice) {
        this.overTimePrice = overTimePrice;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public RSJobStatus getStatus() {
        return status;
    }

    public void setStatus(RSJobStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public RSJobType getRsJobType() {
		return rsJobType;
	}

	public void setRsJobType(RSJobType rsJobType) {
		this.rsJobType = rsJobType;
	}

    public int getAsco_RsJobId() {
        return asco_RsJobId;
    }

    public void setAsco_RsJobId(int ascoRsJobId) {
        asco_RsJobId = ascoRsJobId;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }
    
}
