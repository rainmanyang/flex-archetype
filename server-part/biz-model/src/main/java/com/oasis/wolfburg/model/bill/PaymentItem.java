package com.oasis.wolfburg.model.bill;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.oasis.tmsv5.model.BaseModel;

@Table(name = "WL_PAYMENT_ITEM")
@SequenceGenerator(name = "WL_PAYMENT_ITEM_SEQ")
public class PaymentItem extends BaseModel {

    private static final long serialVersionUID = -8454168986042312487L;

    /**
     * 车牌号
     */
    @Column(name = "LICENSE_PLATE")
    private String licensePlate;

    /**
     * 车ID
     */
    @Column(name = "TRUCK_ID")
    private Long truckId;

    /**
     * 费用发生日期
     */
    @Column(name = "BILL_DATE")
    private Date billDate;

    /**
     * 车主编号
     */
    @Column(name = "CARRIER_CODE")
    private String carrierCode;

    /**
     * 车主名字
     */
    @Column(name = "CARRIER_NAME")
    private String carrierName;

    /**
     * 费用项目编号，对于predefinedcode.code
     */
    @Column(name = "ITEM_TYPE")
    private String itemType;

    /**
     * 费用金额
     */
    private String amount;

    /**
     * 任务单编号
     */
    @Column(name = "TRSJOB_CODE")
    private String trsJobCode;
    
    /**
     * 费率本编号
     */
    @Column(name = "PRICE_CODE")
    private String priceCode;
    
    private String reason;
    
    /**
     * 标识是否关帐过
     */
    @Column(name = "flag")
    private String flag = new String("0");

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
        this.amount = amount;
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



	@Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
