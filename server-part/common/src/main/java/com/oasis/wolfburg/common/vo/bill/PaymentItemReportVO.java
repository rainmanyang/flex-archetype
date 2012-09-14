package com.oasis.wolfburg.common.vo.bill;

import java.text.DecimalFormat;

import com.oasis.tmsv5.common.vo.BaseVO;

public class PaymentItemReportVO extends BaseVO{

    private static final long serialVersionUID = -8454168986042312487L;
    
    private DecimalFormat df = new DecimalFormat("#.00");

    /**
     * 车牌号
     */
    private String licensePlate;

    /**
     * 车ID
     */
    private Long truckId;


    /**
     * 车主编号
     */
    private String carrierCode;

    /**
     * 车主名字
     */
    private String carrierName;
    
    /**
     * 总部应付主线费用
     */
    private Float prd011;
    
    private String prd011Str;
    
    /**
     * 主线扣税
     */
    private Float mainLineTax;
    
    private String mainLineTaxStr;
    
    /**
     * 扣税点
     */
    private Float prd001;
    
    private String prd001Str;
    
    /**
     * 总部应付加班费用
     */
    private Float prd012;
    
    private String prd012Str;
    
    /**
     * 加班税
     * 
     */
    private Float overtimeTax;
    
    private String overtimeTaxStr;
    
    /**
     * 应付班车费
     */
    private Float truckFee;
    
    private String truckFeeStr;
    
    /**
     * 应付加班费
     */
    private Float overtimeFee;
    
    private String overtimeFeeStr;
    
    /**
     * 付款小计
     */
    private Float totalPayFee;
    
    private String totalPayFeeStr;
    
    
    
    /**
     * 收班车罚款
     */
    private Float prd002;
    
    private String prd002Str;
    
    /**
     * 扣GPS费
     */
    private Float prd003;
    
    private String prd003Str;
    
    /**
     * 收班车押金
     */
    private Float prd004;
    
    private String prd004Str;
    
    /**
     * 收班车管理费
     */
    private Float prd005;
    
    private String prd005Str;
    
    /**
     * 收扫描卡费
     */
    private Float prd006;
    
    private String prd006Str;
    
    /**
     * 财务帐面欠款
     */
    private Float prd007;
    
    private String prd007Str;
    
    /**
     * 预留1
     */
    private Float prd008;
    
    private String prd008Str;
    
    /**
     * 预留2
     */
    private Float prd009;
    
    private String prd009Str;
    
    /**
     * 预留3
     */
    private Float prd010;
    
    private String prd010Str;
    
    private Float toatalReceiveFee;
    
    private String toatalReceiveFeeStr;
    
    private Float totalFee;
    
    private String totalFeeStr;
    
    /**
     * 临时用于空值的
     */
    private String temp;
    
    
    public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public Float getTotalFee() {
		if(totalPayFee == null){
			totalPayFee = 0F;
		}
		if(toatalReceiveFee == null){
			toatalReceiveFee = 0F;
		}
		return getTotalPayFee() - getToatalReceiveFee();
	}

	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}

	public Float getToatalReceiveFee() {
		return prd002+prd003+prd004+prd005+prd006+prd007+prd008+prd009+prd010;
	}

	public void setToatalReceiveFee(Float toatalReceiveFee) {
		this.toatalReceiveFee = toatalReceiveFee;
	}

	public Float getTruckFee() {
		if(prd011 == null){
			prd011 = 0F;
		}
		return prd011 - getMainLineTax();
	}

	public void setTruckFee(Float truckFee) {
		this.truckFee = truckFee;
	}

	public Float getOvertimeFee() {
		if(prd012 == null){
			prd012 = 0F;
		}
		return prd012 - getOvertimeTax();
	}

	public void setOvertimeFee(Float overtimeFee) {
		this.overtimeFee = overtimeFee;
	}

	public Float getTotalPayFee() {
		return getTruckFee()+getOvertimeFee();
	}

	public void setTotalPayFee(Float totalPayFee) {
		this.totalPayFee = totalPayFee;
	}

	public Float getOvertimeTax() {
		return prd012*prd001;
	}

	public void setOvertimeTax(Float overtimeTax) {
		this.overtimeTax = overtimeTax;
	}

	public Float getMainLineTax() {
		return prd011*prd001;
	}

	public void setMainLineTax(Float mainLineTax) {
		this.mainLineTax = mainLineTax;
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



    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


	public Float getPrd011() {
		return prd011;
	}

	public void setPrd011(Float prd011) {
		this.prd011 = prd011;
	}

	public Float getPrd001() {
		return prd001;
	}

	public void setPrd001(Float prd001) {
		this.prd001 = prd001;
	}

	public Float getPrd012() {
		return prd012;
	}

	public void setPrd012(Float prd012) {
		this.prd012 = prd012;
	}

	public Float getPrd002() {
		return prd002;
	}

	public void setPrd002(Float prd002) {
		this.prd002 = prd002;
	}

	public Float getPrd003() {
		return prd003;
	}

	public void setPrd003(Float prd003) {
		this.prd003 = prd003;
	}

	public Float getPrd004() {
		return prd004;
	}

	public void setPrd004(Float prd004) {
		this.prd004 = prd004;
	}

	public Float getPrd005() {
		return prd005;
	}

	public void setPrd005(Float prd005) {
		this.prd005 = prd005;
	}

	public Float getPrd006() {
		return prd006;
	}

	public void setPrd006(Float prd006) {
		this.prd006 = prd006;
	}

	public Float getPrd007() {
		return prd007;
	}

	public void setPrd007(Float prd007) {
		this.prd007 = prd007;
	}

	public Float getPrd008() {
		return prd008;
	}

	public void setPrd008(Float prd008) {
		this.prd008 = prd008;
	}

	public Float getPrd009() {
		return prd009;
	}

	public void setPrd009(Float prd009) {
		this.prd009 = prd009;
	}

	public Float getPrd010() {
		return prd010;
	}

	public void setPrd010(Float prd010) {
		this.prd010 = prd010;
	}

	public String getPrd011Str() {
		if(getPrd011() == 0){
			return "0";
		}
		return df.format(getPrd011());
	}

	public void setPrd011Str(String prd011Str) {
		this.prd011Str = prd011Str;
	}

	public String getMainLineTaxStr() {
		if(getMainLineTax() == 0){
			return "0";
		}
		return df.format(getMainLineTax());
	}

	public void setMainLineTaxStr(String mainLineTaxStr) {
		this.mainLineTaxStr = mainLineTaxStr;
	}

	public String getPrd001Str() {
		if(getPrd001() == 0){
			return "0";
		}
		return df.format(getPrd001());
	}

	public void setPrd001Str(String prd001Str) {
		this.prd001Str = prd001Str;
	}

	public String getPrd012Str() {
		if(getPrd012() == 0){
			return "0";
		}
		return  df.format(getPrd012());
	}

	public void setPrd012Str(String prd012Str) {
		this.prd012Str = prd012Str;
	}

	public String getOvertimeTaxStr() {
		if(getOvertimeTax() == 0){
			return "0";
		}
		return  df.format(getOvertimeTax());
	}

	public void setOvertimeTaxStr(String overtimeTaxStr) {
		this.overtimeTaxStr = overtimeTaxStr;
	}

	public String getTruckFeeStr() {
		if(getTruckFee() == 0){
			return "0";
		}
		return  df.format(getTruckFee());
	}

	public void setTruckFeeStr(String truckFeeStr) {
		this.truckFeeStr = truckFeeStr;
	}

	public String getOvertimeFeeStr() {
		if(getOvertimeFee() == 0){
			return "0";
		}
		return  df.format(getOvertimeFee());
	}

	public void setOvertimeFeeStr(String overtimeFeeStr) {
		this.overtimeFeeStr = overtimeFeeStr;
	}

	public String getTotalPayFeeStr() {
		if(getTotalPayFee() == 0){
			return "0";
		}
		return  df.format(getTotalPayFee());
	}

	public void setTotalPayFeeStr(String totalPayFeeStr) {
		this.totalPayFeeStr = totalPayFeeStr;
	}

	public String getPrd002Str() {
		if(getPrd002() == 0){
			return "0";
		}
		return  df.format(getPrd002());
	}

	public void setPrd002Str(String prd002Str) {
		this.prd002Str = prd002Str;
	}

	public String getPrd003Str() {
		if(getPrd003() == 0){
			return "0";
		}
		return  df.format(getPrd003());
	}

	public void setPrd003Str(String prd003Str) {
		this.prd003Str = prd003Str;
	}

	public String getPrd004Str() {
		if(getPrd004() == 0){
			return "0";
		}
		return  df.format(getPrd004());
	}

	public void setPrd004Str(String prd004Str) {
		this.prd004Str = prd004Str;
	}

	public String getPrd005Str() {
		if(getPrd005() == 0){
			return "0";
		}
		return  df.format(getPrd005());
	}

	public void setPrd005Str(String prd005Str) {
		this.prd005Str = prd005Str;
	}

	public String getPrd006Str() {
		if(getPrd006() == 0){
			return "0";
		}
		return  df.format(getPrd006());
	}

	public void setPrd006Str(String prd006Str) {
		this.prd006Str = prd006Str;
	}

	public String getPrd007Str() {
		if(getPrd007() == 0){
			return "0";
		}
		return  df.format(getPrd007());
	}

	public void setPrd007Str(String prd007Str) {
		this.prd007Str = prd007Str;
	}

	public String getPrd008Str() {
		if(getPrd008() == 0){
			return "0";
		}
		return  df.format(getPrd008());
	}

	public void setPrd008Str(String prd008Str) {
		this.prd008Str = prd008Str;
	}

	public String getPrd009Str() {
		if(getPrd009() == 0){
			return "0";
		}
		return  df.format(getPrd009());
	}

	public void setPrd009Str(String prd009Str) {
		this.prd009Str = prd009Str;
	}

	public String getPrd010Str() {
		if(getPrd010() == 0){
			return "0";
		}
		return  df.format(getPrd010());
	}

	public void setPrd010Str(String prd010Str) {
		this.prd010Str = prd010Str;
	}

	public String getToatalReceiveFeeStr() {
		if(getToatalReceiveFee() == 0){
			return "0";
		}
		return  df.format(getToatalReceiveFee());
	}

	public void setToatalReceiveFeeStr(String toatalReceiveFeeStr) {
		this.toatalReceiveFeeStr = toatalReceiveFeeStr;
	}

	public String getTotalFeeStr() {
		if(getTotalFee() == 0){
			return "0";
		}
		return  df.format(getTotalFee());
	}

	public void setTotalFeeStr(String totalFeeStr) {
		this.totalFeeStr = totalFeeStr;
	}
    
    
}
