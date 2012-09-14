package com.oasis.wolfburg.common.vo.client;

import java.io.Serializable;
import java.util.Date;

public class ScanBarcode implements Serializable {

    private static final long serialVersionUID = -546515044605240990L;

    private Long posId;

    private String barcode;

    /**
     * 0,扫描;1,手工
     */
    private int inputType = 0;

    private String scanner;

    private Date scanTime;

    /**
     * 0,进;1,出
     */
    private int scanType = 0;

    /**
     * 是否连网提交
     */
    private boolean online = true;

    /**
     * 离线上传时间
     */
    private Date offlineUploadTime;

    public boolean isOnline() {
        return online;
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

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public int getScanType() {
        return scanType;
    }

    public void setScanType(int scanType) {
        this.scanType = scanType;
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

}
