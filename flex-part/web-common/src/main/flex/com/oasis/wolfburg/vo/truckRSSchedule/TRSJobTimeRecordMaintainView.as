package com.oasis.wolfburg.vo.truckRSSchedule
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.truckRSSchedule.TRSJobTimeRecordMaintainView")]
	public class TRSJobTimeRecordMaintainView extends com.oasis.tmsv5.vo.BaseVO
	{
	
		public var code:String;
		
		public var licensePlate:String;
		
		public var routeName:String;
		
		public var truckType:String;
		
		public var driver1Name:String;
		
		public var contactPhone1:String;
		
		public var status:String;
		
		public var planTime:Date;
		
		public var scanedTime:Date;
		
		public var thisStop:String;
		
		public var startDate:Date;
		
		public var idCard:String;
		
		public var jobType:String;
		
		public var remark:String;
		
		public var stopSeq:Number;
		
		public var jobId:Number;
		
		public var timeId:Number;
		
		public var truckId:Number;
		
		public var scanedType:String;
		
		public function TRSJobTimeRecordMaintainView()
		{
		}
	}
}
