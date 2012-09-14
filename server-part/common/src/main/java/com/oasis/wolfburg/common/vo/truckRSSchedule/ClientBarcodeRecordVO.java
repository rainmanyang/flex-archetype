package com.oasis.wolfburg.common.vo.truckRSSchedule;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;
public class ClientBarcodeRecordVO extends BaseVO {

    private static final long serialVersionUID = 4901713984202052939L;

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

    private boolean processed = Boolean.FALSE;
    
    private String posName;
    
    private boolean online = true;

    /**
     * 离线上传客户端时间
     */
    private Date offlineUploadTime;

    /**
     * 离线上传服务器时间
     */
    private Date serverTime;

    /**
     * 离线上传服务器时间
     */
    private Date processedTime;

    /**
     * 处理结果
     */
    private String precessedResult;

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

	public Date getServerTime() {
		return serverTime;
	}

	public void setServerTime(Date serverTime) {
		this.serverTime = serverTime;
	}

	public Date getProcessedTime() {
		return processedTime;
	}

	public void setProcessedTime(Date processedTime) {
		this.processedTime = processedTime;
	}

	public String getPrecessedResult() {
		return precessedResult;
	}

	public void setPrecessedResult(String precessedResult) {
		this.precessedResult = precessedResult;
	}

    

}
