package com.oasis.wolfburg.so.truckRSSchedule
{
	import com.oasis.component.page.BasePageSO;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSJobTimeRecordSO")]
	public class TruckRSJobTimeRecordSO extends BasePageSO
	{
		public function TruckRSJobTimeRecordSO()
		{
		}
		
		public var truckRSJobName:String;
		/**
		 * 车牌号
		 */
		public var licensePlate:String;
		
		
		public var stopName:String;
		
		public var routeName:String;
		
		
		public var requestUrl:String;
		
		public var beginDate:Date;
		public var endDate:Date;
		
		public var jobStatus:String;
		
	}
}

