package com.oasis.wolfburg.so.truckRSSchedule
{
	import com.oasis.component.page.BasePageSO;
	
	import mx.collections.ArrayCollection;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truckRSSchedule.TruckRSScheduleSO")]
	public class TruckRSScheduleSO extends BasePageSO
	{
		public function TruckRSScheduleSO()
		{
		}
		public var name:String;
		public var status:String;
		public var routeName:String;
		public var routeId:Number;
		public var statuses:ArrayCollection;
		public var requestUrl:String;
	}
}

