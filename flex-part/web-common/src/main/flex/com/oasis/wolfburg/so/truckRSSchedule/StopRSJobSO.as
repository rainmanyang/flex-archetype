package com.oasis.wolfburg.so.truckRSSchedule
{
	import com.oasis.component.page.BasePageSO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truckRSSchedule.StopRSJobSO")]
	public class StopRSJobSO extends BasePageSO
	{
		public  var code:String;
		
		public  var toDate:Date;
		
		public  var fromDate:Date;
		
		public  var routeId:Number;
		
		public  var routeName:String;
		
		public  var statusList:ArrayCollection = new ArrayCollection();
		
		public  var inOut:Boolean = true;
		
		public var idCard: String;
		
		public var licensePlate: String;
		
		public var posId:Number;
		
		public var posName:String;
		
		public function StopRSJobSO()
		{
		}
	}
}
