package com.oasis.wolfburg.model.track;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.status.ExpDealStatus;
import com.oasis.wolfburg.common.enums.status.ExpGrade;
import com.oasis.wolfburg.common.enums.status.ExpType;
import com.oasis.wolfburg.common.enums.status.RSJobStatus;
@Table(name = "wl_exp_track")
@SequenceGenerator(name = "wl_exp_track_seq")
public class ExpTrack extends BaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "license_plate")
	private String licensePlate;
	
    /**
     * 关联任务单号
     */
	@Column(name = "RS_JOB_code")
	private String rssJobCode;
	
	/**
     * 关联任务单ID
     */
    @Column(name = "RS_JOB_ID")
    private Long rsJobId;
    
    @Column(name = "RS_JOB_STATUS")
    private RSJobStatus rsJobStatus;
    
    /**
     * 关联班次
     */
	@Column(name = "RS_SCHEDULE_name")
	private String rsScheduleName;
	
	/**
     * 关联班次ID
     */
    @Column(name = "RS_SCHEDULE_ID")
    private Long rsScheduleId;
    
    /**
     * 运营线路
     */
    @Column(name = "route_name")
    private String routeName;
    
    /**
     * 异常类型
     */
    @Column(name = "exp_type")
    private ExpType expType;
    
    /**
     * 异常级别
     */
    @Column(name = "exp_grade")
    private ExpGrade expGrade;
    
    /**
     * 异常内容
     */
    @Column(name = "exp_content")
    private String expContent;
    
    /**
     * 预计延误时间(分钟)
     */
    @Column(name = "delay_time")
    private String delayTime;
    
    /**
     * 报告人
     */
    private String reporter;
    
    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;
    
    /**
     * 处理状态
     */
    private ExpDealStatus status;
    
    /**
     * 异常处理人员
     */
    @Column(name = "exp_dealer")
    private String expDealer;
    
    /**
     * 异常处理时间
     */
    @Column(name = "exp_deal_time")
    private Date expDealTime;
    
    /**
     * 异常处理内容
     */
    @Column(name = "exp_deal_content")
    private String expDealContent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getRssJobCode() {
		return rssJobCode;
	}

	public void setRssJobCode(String rssJobCode) {
		this.rssJobCode = rssJobCode;
	}

	public Long getRsJobId() {
		return rsJobId;
	}

	public void setRsJobId(Long rsJobId) {
		this.rsJobId = rsJobId;
	}

	public String getRsScheduleName() {
		return rsScheduleName;
	}

	public void setRsScheduleName(String rsScheduleName) {
		this.rsScheduleName = rsScheduleName;
	}

	public Long getRsScheduleId() {
		return rsScheduleId;
	}

	public void setRsScheduleId(Long rsScheduleId) {
		this.rsScheduleId = rsScheduleId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public ExpType getExpType() {
		return expType;
	}

	public void setExpType(ExpType expType) {
		this.expType = expType;
	}

	public ExpGrade getExpGrade() {
		return expGrade;
	}

	public void setExpGrade(ExpGrade expGrade) {
		this.expGrade = expGrade;
	}

	public String getExpContent() {
		return expContent;
	}

	public void setExpContent(String expContent) {
		this.expContent = expContent;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public ExpDealStatus getStatus() {
		return status;
	}

	public void setStatus(ExpDealStatus status) {
		this.status = status;
	}

	public String getExpDealer() {
		return expDealer;
	}

	public void setExpDealer(String expDealer) {
		this.expDealer = expDealer;
	}

	public Date getExpDealTime() {
		return expDealTime;
	}

	public void setExpDealTime(Date expDealTime) {
		this.expDealTime = expDealTime;
	}

	public String getExpDealContent() {
		return expDealContent;
	}

	public void setExpDealContent(String expDealContent) {
		this.expDealContent = expDealContent;
	}

	public String getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(String delayTime) {
		this.delayTime = delayTime;
	}

	public RSJobStatus getRsJobStatus() {
		return rsJobStatus;
	}

	public void setRsJobStatus(RSJobStatus rsJobStatus) {
		this.rsJobStatus = rsJobStatus;
	}
}
