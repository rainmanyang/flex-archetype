package com.oasis.wolfburg.common.vo.bill;

import java.util.Date;

import com.oasis.tmsv5.common.vo.BaseVO;

public class PaymentItemVO extends BaseVO{

    private static final long serialVersionUID = -8454168986042312487L;

    /**
     * 车牌号
     */
    private String licensePlate;

    /**
     * 车ID
     */
    private Long truckId;

    /**
     * 费用发生日期
     */
    private Date billDate;

    /**
     * 车主编号
     */
    private String carrierCode;

    /**
     * 车主名字
     */
    private String carrierName;

    /**
     * 费用项目编号，对于predefinedcode.code
     */
    private String itemType;

    /**
     * 费用金额
     */
    private String amount;

    /**
     * 任务单编号
     */
    private String trsJobCode;
    
    /**
     * 费率本编号
     */
    private String priceCode;
    
    private String reason;
    
    private String flag;
    
    
    /*********仅用于页面显示********/
    private String itemTypeCN;
    
    private String strStatus;

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode;
    }

    public String getTrsJobCode() {
        return trsJobCode;
    }

    public void setTrsJobCode(String trsJobCode) {
        this.trsJobCode = trsJobCode;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
    	String res = "";
    	int dex = amount.indexOf(".");
		if(dex==-1){
			res = amount+".00";
		}else{
			String decimal = amount.substring(dex+1);
			if(decimal.length() == 0){
				res = amount+"00";
			}else if(decimal.length() == 1){
				res = amount+"0";
			}else{
				res = amount;
			}
		}
		
        this.amount = res;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}


	private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getItemTypeCN() {
		return itemTypeCN;
	}

	public void setItemTypeCN(String itemTypeCN) {
		this.itemTypeCN = itemTypeCN;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
    
    
}
