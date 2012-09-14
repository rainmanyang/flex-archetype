package com.oasis.wolfburg.so.truckRSSchedule
{
	import com.oasis.component.page.BasePageSO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobSO")]
	public class TruckRSJobSO extends BasePageSO
	{

	public var formatSDate:String;
	
	public var weekDay:String;

    /**
     * 关联时刻表ID
     */
    public var  rsScheduleId: Number;
	
	public var reScheduleName:String;

    public var  code:String;

    public var  startDate:Date;
	
	public var  endDate:Date;
	
	public var  endStartDate:Date;
	
	public var  endEndDate:Date;
	
    public var  licensePlate: String;

    public var  driver: String;

    /**
     * 车辆标示卡
     */
    public var  identityCard: String;

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
     * 费率本编号
     */
    public var  priceCode: String;
	
	/**
	 * 精确车牌号
	 */
	public var exactLicensePlate: String;
	
	/**
	 * 出发网点
	 */ 
	public var startPos:Number;
	
	/**
	 * 到达网点
	 */ 
	public var endPos:Number;
	
	public var  rsJobType: String;
	
	public var statuses:ArrayCollection = new ArrayCollection();
	
	public var types:ArrayCollection = new ArrayCollection();
	
	public var exceptional:Boolean;
	
	public var  realRouteId: Number;
	
	public var  realRouteName:String ;

	public var  isDisposed:String ;
	
	public function TruckRSJobSO()
	{
	}
	}
}
