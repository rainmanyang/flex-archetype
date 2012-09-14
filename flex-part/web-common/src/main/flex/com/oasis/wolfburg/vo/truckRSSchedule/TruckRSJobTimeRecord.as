package com.oasis.wolfburg.vo.truckRSSchedule
{

	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSJobTimeRecordView")]
	public class TruckRSJobTimeRecord extends com.oasis.tmsv5.vo.BaseVO
	{
	
	    /**
	     * 具体任务ID
	     */
	    public var trsJobId:Number;
	    public var stopId:Number;
	
	    /**
	     * 网点ID
	     */
	    public var posId:Number;
	    /**
	     * 计划进站时间
	     */
	    public var  planInboundTime:Date;
	    /**
	     * 计划离站时间
	     */
	    public var  planOutboundTime:Date;
	    /**
	     * 扫描进站时间
	     */
	    public var  scanedInboundTime:Date;
	
	    /**
	     * 扫描离站时间
	     */
	    public var scanedOutboundTime:Date;
	
	    /**
	     * GPS进站时间
	     */
	    public var gpsInboundTime:Date;
	
	    /**
	     * GPS离站时间
	     */
	    public var gpsOutboundTime:Date;
	
	    /**
	     * 手动进站时间
	     */
	    public var manulInboundTime:Date;
	
	    /**
	     * 手动离站时间
	     */
	    public var manulOutboundTime:Date;
	
	    /**
	     * 扫描人
	     */
	    public var scanner:String;
	
	    /**
	     * 进站铅封
	     */
	    public var inboundStripSeal:String;
	
	    /**
	     * 离站铅封
	     */
	    public var outboundStripSeal:String;
	
	    /**
	     * 任务单打印唯一码
	     */
	    public var pinCode:String;
	
	    /**
	     * 任务单扫描唯一码
	     */
	    public var scanCode:String;
		
		
		//以下字段临时使用的，没有对应的数据库列
		public var truckRSJobName:String;
		/**
		 * 车牌号
		 */
		public var licensePlate:String;
		
		
		public var stopName:String;
		
		public var routeName:String;
		
		public var routeCode:String;
		
		public var n1StopName:String;
		
		public var n1PlanInboundTime:Date;
		
		public var n1PlanOutboundTime:Date;
		
		public var n1ScanedInboundTime:Date;
		
		public var  n1ScanedOutboundTime:Date;
		
		public var n1ManulInboundTime:Date;
		
		public var  n1ManulOutboundTime:Date;
		
		public var n1Scanner:String;
		
		public var n2StopName:String;
		
		public var n2PlanInboundTime:Date;
		
		public var n2PlanOutboundTime:Date;
		
		public var n2ScanedInboundTime:Date;
		
		public var  n2ScanedOutboundTime:Date;
		
		public var n2ManulInboundTime:Date;
		
		public var  n2ManulOutboundTime:Date;
		
		public var n2Scanner:String;
		
		public var n3StopName:String;
		
		public var n3PlanInboundTime:Date;
		
		public var n3PlanOutboundTime:Date;
		
		public var n3ScanedInboundTime:Date;
		
		public var  n3ScanedOutboundTime:Date;
		
		public var n3ManulInboundTime:Date;
		
		public var  n3ManulOutboundTime:Date;
		
		public var n3Scanner:String;
		
		public var n4StopName:String;
		
		public var n4PlanInboundTime:Date;
		
		public var n4PlanOutboundTime:Date;
		
		public var n4ScanedInboundTime:Date;
		
		public var  n4ScanedOutboundTime:Date;
		
		public var n4ManulInboundTime:Date;
		
		public var  n4ManulOutboundTime:Date;
		
		public var n4Scanner:String;
		
		public var startDate:Date;
		
		public var jobStatus:String;
		
		public var expJobId:Number;
		
		public var hasExp:Boolean;
		
		public var scanType:Number;
		public var scanedTime:Date;
		
		
		public var delayOutMinutes:String;
		
		public var n1DelayOutMinutes:String; 
		
		public var n2DelayOutMinutes:String; 
		
		public var n3DelayOutMinutes:String; 
		
		public var n1DelayInMinutes:String; 
		
		public var n2DelayInMinutes:String; 
		
		public var n3DelayInMinutes:String; 
		
		public var delayAllMinutes:String;
		
		public var n1PlanEnrouteMinute:String;
		
		public var n1ActualEnrouteMinute:String;
		
		public var n2PlanEnrouteMinute:String;
		
		public var n2ActualEnrouteMinute:String;
		
		public var n3PlanEnrouteMinute:String;
		
		public var n3ActualEnrouteMinute:String;
		
		public var n4PlanEnrouteMinute:String;
		
		public var n4ActualEnrouteMinute:String;
		
		public var n4DelayInMinutes:String; 
		
		public function TruckRSJobTimeRecord()
		{
		}
	
	}
}
