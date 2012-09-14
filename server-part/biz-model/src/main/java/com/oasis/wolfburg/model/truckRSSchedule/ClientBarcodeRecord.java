package com.oasis.wolfburg.model.truckRSSchedule;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.oasis.tmsv5.model.BaseModel;

@Table(name = "WL_CLIENT_BARCODE_RECORD")
@SequenceGenerator(name = "WL_CLIENT_BARCODE_RECORD_SEQ")
public class ClientBarcodeRecord extends BaseModel {

    private static final long serialVersionUID = 4901713984202052939L;

    @Id
    private Long id;

    @Column(name = "POS_ID")
    private Long posId;

    private String barcode;

    /**
     * 0,扫描;1,手工
     */
    @Column(name = "INPUT_TYPE")
    private int inputType = 0;

    private String scanner;

    @Column(name = "SCAN_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scanTime;

    /**
     * 0,进;1,出
     */
    @Column(name = "SCAN_TYPE")
    private int scanType = 0;

    private boolean processed = Boolean.FALSE;

    /**
     * 是否连网提交
     */
    @Column(name = "ON_LINE")
    private boolean online = true;

    /**
     * 离线上传客户端时间
     */
    @Column(name = "OFFLINE_UPLOAD_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date offlineUploadTime;

    /**
     * 离线上传服务器时间
     */
    @Column(name = "SERVER_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serverTime;

    /**
     * 离线上传服务器时间
     */
    @Column(name = "PROCESSED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processedTime;

    /**
     * 处理结果
     */
    @Column(name = "PRECESSED_RESULT")
    private String precessedResult;
    
    //仅用于显示
    private String posName; 

    public boolean isOnline() {
        return online;
    }

    public String getPrecessedResult() {
        return precessedResult;
    }

    public void setPrecessedResult(String precessedResult) {
        this.precessedResult = precessedResult;
    }

    public Date getProcessedTime() {
        return processedTime;
    }

    public void setProcessedTime(Date processedTime) {
        this.processedTime = processedTime;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Date getOfflineUploadTime() {
        return offlineUploadTime;
    }

    public void setOfflineUploadTime(Date offlineUploadTime) {
        this.offlineUploadTime = offlineUploadTime;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getInputType() {
        return inputType;
    }

    public void setInputType(int inputType) {
        this.inputType = inputType;
    }

    public String getScanner() {
        return scanner;
    }

    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public int getScanType() {
        return scanType;
    }

    public void setScanType(int scanType) {
        this.scanType = scanType;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

	public String getPosName() {
		return posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}
    
}
