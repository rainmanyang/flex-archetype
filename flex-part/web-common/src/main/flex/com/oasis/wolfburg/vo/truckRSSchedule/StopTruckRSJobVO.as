package com.oasis.wolfburg.vo.truckRSSchedule
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.truckRSSchedule.StopTruckRSJobView")]
	public class StopTruckRSJobVO extends com.oasis.tmsv5.vo.BaseVO
	{
	
		public var name:String;
		
		public var code:String;
		
		public var licensePlate:String;
		
		public var routeName:String;
		
		public var truckType:String;
		
		public var driver1Name:String;
		
		public var contactPhone1:String;
		
		public var status:String;
		
		public var delayTime:String;
		
		public var inPlanTime:Date;
		
		public var outPlanTime:Date;
		
		public var outStop:String;
		
		public var inStop:String;
		
		public var idCard:String;
		
		public var thisStop:String;
		
		public var jobType:String;
		
		public var loadVolume:String;
		
		public var outScanTime:Date;
		
		public var inScanTime:Date;
		
		public var outVolume:String;
		
		public var inVolume:String;
		
		public var outScanner:String;
		
		public var inScanner:String;
		
		public var outWeight:String;
		
		public var inWeight:String;
		
		public var outSeal:String;
		
		public var inSeal:String;
		
		public var outRemark:String;
		
		public var inRemark:String;
		
		public function StopTruckRSJobVO()
		{
		}
	}
}
