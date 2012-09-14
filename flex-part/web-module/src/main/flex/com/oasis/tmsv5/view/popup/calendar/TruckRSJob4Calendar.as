package com.oasis.tmsv5.view.popup.calendar
{
	
	[Bindable]
	public class TruckRSJob4Calendar
	{

	public var  code:String ;

    public var  startDate: Date;

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

    public var  routeName:String;
	
	public var calendar:Calendar;

	public function TruckRSJob4Calendar()
	{
	}
	}
}
