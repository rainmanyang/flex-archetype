package com.oasis.wolfburg.vo.truckRSSchedule
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobVO")]
	public class TruckRSJob extends com.oasis.tmsv5.vo.BaseVO
	{

	public var formatSDate:String;
	
	public var weekDay:String;
	
    /**
     * 关联时刻表ID
     */
    public var  rsScheduleId: Number;
	
	/**
	 * 时刻表名称
	 */ 
	public var  rsScheduleName:String;

	public var  code:String ;

    public var  startDate: Date;

    public var  licensePlate: String;

    public var  driver: String;

    /**
     * 车辆标示卡
     */
    public var  identityCard: String;
	
	public var truckId:Number;

    /**
     * 任务单打印唯一码
     */
    public var  pinCode: String;

    /**
     * 任务单扫描唯一码
     */
    public var  scanCode: String;

    /**
     * 铅封号
     */

    public var  sealCode: String;
	
    public var  status: String;

    public var  routeId: Number;

    public var  routeName:String ;

    /**
     * 合同费用
     */
    public var  contrackPrice: String;

    /**
     * 空驶费用
     */
    public var  emptyPrice: String;

    /**
     * 加班费用
     */
    public var  overTimePrice:String ;
	
	/**
	 * 付款方式
	 */ 
	public var  payMethod:String;
	
    /**
     * 费率本编号
     */
    public var  priceCode: String;
	
	public var asco_RsJobId:Number;
	
	public var rsJobType:String;
	
	public var editFlag:Boolean;
	
	public var remark:String;
	
	/**
	 * 实际线路
	 */
	public var realRouteId:Number;
	
	/**
	 * 实际线路
	 */
	public var realRouteName:String;
	
	/**
	 * 计费线路
	 */
	public var payRouteId:Number;
	
	/**
	 * 计费线路
	 */
	public var payRouteName:String;
	
	/**
	 * 实际线路与计划线路不一致
	 */
	public var exceptional:Boolean;
	
	/**
	 * 实际线路与计划线路不一致
	 */
	public var exceptionalRemark:String;
	
	public var planPOS:String;
	
	public var realPOS:String;
	
	public var realPOSName:String;
	
	public var endDate:Date;
	
	public var isDisposed : Boolean;

	public function get isDisposedStr():String{
		if(isDisposed){
			return "已处理";
		} else {
			return "未处理";
		}
	}
	
	public function TruckRSJob()
	{
	}
	}
}
