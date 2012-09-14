package com.oasis.wolfburg.common.vo.truckRSSchedule;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;

public class TruckRSJobTimeRecordVO extends BaseVO {

    private static final long serialVersionUID = -6317729076572764973L;

    /**
     * 具体任务ID
     */
    private Long trsJobId;

    private Long stopId;

    /**
     * 网点ID
     */
    private Long posId;

    /**
     * 计划进站时间
     */
    private Date planInboundTime;

    /**
     * 计划离站时间
     */
    private Date planOutboundTime;

    /**
     * 扫描进站时间
     */
    private Date scanedInboundTime;

    /**
     * 扫描离站时间
     */
    private Date scanedOutboundTime;

    /**
     * GPS进站时间
     */
    private Date gpsInboundTime;

    /**
     * GPS离站时间
     */
    private Date gpsOutboundTime;

    /**
     * 手动进站时间
     */
    private Date manulInboundTime;

    /**
     * 手动离站时间
     */
    private Date manulOutboundTime;

    /**
     * 扫描人
     */
    private String scanner;

    /**
     * 进站铅封
     */
    private String inboundStripSeal;

    /**
     * 离站铅封
     */
    private String outboundStripSeal;

    /**
     * 任务单打印唯一码
     */
    private String pinCode;

    /**
     * 任务单扫描唯一码
     */
    private String scanCode;
    
  //以下字段临时使用的，没有对应的数据库列
    private String truckRSJobName;
    /**
     * 车牌号
     */
    private String licensePlate;
    
    
    private String stopName;
    
    private String routeName;
    
    
   private String n1StopName;
    
    private Date n1PlanInboundTime;
    
    private Date n1PlanOutboundTime;
    
    private Date n1ScanedInboundTime;
    
    private Date  n1ScanedOutboundTime;
    
    private Date n1ManulInboundTime;
    
    private Date  n1ManulOutboundTime;
    
    private String n1Scanner;
    
    private String n2StopName;
    
    private Date n2PlanInboundTime;
    
    private Date n2PlanOutboundTime;
    
    private Date n2ScanedInboundTime;
    
    private Date  n2ScanedOutboundTime;
    
    private Date n2ManulInboundTime;
    
    private Date  n2ManulOutboundTime;
    
    private String n2Scanner;
    
    private String n3StopName;
    
    private Date n3PlanInboundTime;
    
    private Date n3PlanOutboundTime;
    
    private Date n3ScanedInboundTime;
    
    private Date  n3ScanedOutboundTime;
    
    private Date n3ManulInboundTime;
    
    private Date  n3ManulOutboundTime;
    
    private String n3Scanner;
    
    /**
     * 任务单的开始时间
     */
    private Date startDate;

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

    private String stopSeq;

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getInboundStripSeal() {
        return inboundStripSeal;
    }

    public void setInboundStripSeal(String inboundStripSeal) {
        this.inboundStripSeal = inboundStripSeal;
    }

    public String getOutboundStripSeal() {
        return outboundStripSeal;
    }

    public void setOutboundStripSeal(String outboundStripSeal) {
        this.outboundStripSeal = outboundStripSeal;
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

    public Date getScanedInboundTime() {
        return scanedInboundTime;
    }

    public void setScanedInboundTime(Date scanedInboundTime) {
        this.scanedInboundTime = scanedInboundTime;
    }

    public Date getScanedOutboundTime() {
        return scanedOutboundTime;
    }

    public void setScanedOutboundTime(Date scanedOutboundTime) {
        this.scanedOutboundTime = scanedOutboundTime;
    }

    public Date getGpsInboundTime() {
        return gpsInboundTime;
    }

    public void setGpsInboundTime(Date gpsInboundTime) {
        this.gpsInboundTime = gpsInboundTime;
    }

    public Date getGpsOutboundTime() {
        return gpsOutboundTime;
    }

    public void setGpsOutboundTime(Date gpsOutboundTime) {
        this.gpsOutboundTime = gpsOutboundTime;
    }

    public Date getManulInboundTime() {
        return manulInboundTime;
    }

    public void setManulInboundTime(Date manulInboundTime) {
        this.manulInboundTime = manulInboundTime;
    }

    public Date getManulOutboundTime() {
        return manulOutboundTime;
    }

    public void setManulOutboundTime(Date manulOutboundTime) {
        this.manulOutboundTime = manulOutboundTime;
    }

	public String getTruckRSJobName() {
		return truckRSJobName;
	}

	public void setTruckRSJobName(String truckRSJobName) {
		this.truckRSJobName = truckRSJobName;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getN1StopName() {
		return n1StopName;
	}

	public void setN1StopName(String n1StopName) {
		this.n1StopName = n1StopName;
	}

	public Date getN1PlanInboundTime() {
		return n1PlanInboundTime;
	}

	public void setN1PlanInboundTime(Date n1PlanInboundTime) {
		this.n1PlanInboundTime = n1PlanInboundTime;
	}

	public Date getN1PlanOutboundTime() {
		return n1PlanOutboundTime;
	}

	public void setN1PlanOutboundTime(Date n1PlanOutboundTime) {
		this.n1PlanOutboundTime = n1PlanOutboundTime;
	}

	public Date getN1ScanedInboundTime() {
		return n1ScanedInboundTime;
	}

	public void setN1ScanedInboundTime(Date n1ScanedInboundTime) {
		this.n1ScanedInboundTime = n1ScanedInboundTime;
	}

	public Date getN1ScanedOutboundTime() {
		return n1ScanedOutboundTime;
	}

	public void setN1ScanedOutboundTime(Date n1ScanedOutboundTime) {
		this.n1ScanedOutboundTime = n1ScanedOutboundTime;
	}

	public Date getN1ManulInboundTime() {
		return n1ManulInboundTime;
	}

	public void setN1ManulInboundTime(Date n1ManulInboundTime) {
		this.n1ManulInboundTime = n1ManulInboundTime;
	}

	public Date getN1ManulOutboundTime() {
		return n1ManulOutboundTime;
	}

	public void setN1ManulOutboundTime(Date n1ManulOutboundTime) {
		this.n1ManulOutboundTime = n1ManulOutboundTime;
	}

	public String getN1Scanner() {
		return n1Scanner;
	}

	public void setN1Scanner(String n1Scanner) {
		this.n1Scanner = n1Scanner;
	}

	public String getN2StopName() {
		return n2StopName;
	}

	public void setN2StopName(String n2StopName) {
		this.n2StopName = n2StopName;
	}

	public Date getN2PlanInboundTime() {
		return n2PlanInboundTime;
	}

	public void setN2PlanInboundTime(Date n2PlanInboundTime) {
		this.n2PlanInboundTime = n2PlanInboundTime;
	}

	public Date getN2PlanOutboundTime() {
		return n2PlanOutboundTime;
	}

	public void setN2PlanOutboundTime(Date n2PlanOutboundTime) {
		this.n2PlanOutboundTime = n2PlanOutboundTime;
	}

	public Date getN2ScanedInboundTime() {
		return n2ScanedInboundTime;
	}

	public void setN2ScanedInboundTime(Date n2ScanedInboundTime) {
		this.n2ScanedInboundTime = n2ScanedInboundTime;
	}

	public Date getN2ScanedOutboundTime() {
		return n2ScanedOutboundTime;
	}

	public void setN2ScanedOutboundTime(Date n2ScanedOutboundTime) {
		this.n2ScanedOutboundTime = n2ScanedOutboundTime;
	}

	public Date getN2ManulInboundTime() {
		return n2ManulInboundTime;
	}

	public void setN2ManulInboundTime(Date n2ManulInboundTime) {
		this.n2ManulInboundTime = n2ManulInboundTime;
	}

	public Date getN2ManulOutboundTime() {
		return n2ManulOutboundTime;
	}

	public void setN2ManulOutboundTime(Date n2ManulOutboundTime) {
		this.n2ManulOutboundTime = n2ManulOutboundTime;
	}

	public String getN2Scanner() {
		return n2Scanner;
	}

	public void setN2Scanner(String n2Scanner) {
		this.n2Scanner = n2Scanner;
	}

	public String getN3StopName() {
		return n3StopName;
	}

	public void setN3StopName(String n3StopName) {
		this.n3StopName = n3StopName;
	}

	public Date getN3PlanInboundTime() {
		return n3PlanInboundTime;
	}

	public void setN3PlanInboundTime(Date n3PlanInboundTime) {
		this.n3PlanInboundTime = n3PlanInboundTime;
	}

	public Date getN3PlanOutboundTime() {
		return n3PlanOutboundTime;
	}

	public void setN3PlanOutboundTime(Date n3PlanOutboundTime) {
		this.n3PlanOutboundTime = n3PlanOutboundTime;
	}

	public Date getN3ScanedInboundTime() {
		return n3ScanedInboundTime;
	}

	public void setN3ScanedInboundTime(Date n3ScanedInboundTime) {
		this.n3ScanedInboundTime = n3ScanedInboundTime;
	}

	public Date getN3ScanedOutboundTime() {
		return n3ScanedOutboundTime;
	}

	public void setN3ScanedOutboundTime(Date n3ScanedOutboundTime) {
		this.n3ScanedOutboundTime = n3ScanedOutboundTime;
	}

	public Date getN3ManulInboundTime() {
		return n3ManulInboundTime;
	}

	public void setN3ManulInboundTime(Date n3ManulInboundTime) {
		this.n3ManulInboundTime = n3ManulInboundTime;
	}

	public Date getN3ManulOutboundTime() {
		return n3ManulOutboundTime;
	}

	public void setN3ManulOutboundTime(Date n3ManulOutboundTime) {
		this.n3ManulOutboundTime = n3ManulOutboundTime;
	}

	public String getN3Scanner() {
		return n3Scanner;
	}

	public void setN3Scanner(String n3Scanner) {
		this.n3Scanner = n3Scanner;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    
    

}
