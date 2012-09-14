package com.oasis.wolfburg.model.truckRSSchedule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.oasis.tmsv5.model.BaseModel;
import com.oasis.wolfburg.common.enums.type.BarcodeScanType;
import com.oasis.wolfburg.common.enums.type.EventPhase;

@Table(name = "WL_TRSJOB_TIME_RECORD")
@SequenceGenerator(name = "WL_TRSJOB_TIME_RECORD_SEQ")
public class TruckRSJobTimeRecord extends BaseModel {

    private static final long serialVersionUID = -6317729076572764973L;

    @Id
    private Long id;

    /**
     * 具体任务ID
     */
    @Column(name = "TRS_JOB_ID")
    private Long trsJobId;

    @Column(name = "STOP_ID")
    private Long stopId;

    /**
     * 网点ID
     */
    @Column(name = "POS_ID")
    private Long posId;

    /**
     * 计划时间
     */
    @Column(name = "PLAN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planTime;

    /**
     * 扫描时间
     */
    @Column(name = "SCANED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scanedTime;

    /**
     * 扫描人
     */
    private String scanner;

    /**
     * 进站铅封
     */
    @Column(name = "STRIP_SEAL")
    private String stripSeal;

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

    @Column(name = "STOP_SEQ")
    private String stopSeq;

    /**
     * 0,进;1,出
     */
    @Column(name = "SCAN_TYPE")
    private int scanType = EventPhase.INBOUND.value();

    /**
     * 0,扫描;1,手工
     */
    @Column(name = "INPUT_TYPE")
    private int inputType = BarcodeScanType.SCAN.value();

    public Date getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    public int getInputType() {
        return inputType;
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
    }

    public Date getScanedTime() {
        return scanedTime;
    }

    public void setScanedTime(Date scanedTime) {
        this.scanedTime = scanedTime;
    }

    public int getScanType() {
        return scanType;
    }

    public void setScanType(int scanType) {
        this.scanType = scanType;
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

    public String getStopSeq() {
        return stopSeq;
    }

    public void setStopSeq(String stopSeq) {
        this.stopSeq = stopSeq;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getStripSeal() {
        return stripSeal;
    }

    public void setStripSeal(String stripSeal) {
        this.stripSeal = stripSeal;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public Long getTrsJobId() {
        return trsJobId;
    }

    public void setTrsJobId(Long trsJobId) {
        this.trsJobId = trsJobId;
    }

    public Long getStopId() {
        return stopId;
    }

    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
