package com.oasis.wolfburg.so.truck
{
	import com.oasis.component.page.BasePageSO;
	
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truck.TruckSO")]
	public class TruckSO extends BasePageSO
	{
		public function TruckSO()
		{
		}
		public var licensePlate:String;
		public var truckId:Number;
		public var carrierName:String;
		public var driverName:String;
		public var truckType:String;
		public var status:String;
		public var truckResourceType:String;
		public var routeId:Number;
		public var notInRouteId:Number;
		public var carrierId:Number;
		public var expirationCount:Number=30;
		public var expiration:String;
		public var filterDate:Date;
		public var cardCode:String;	
		public var truckPro;
		public var requestUrl:String;
	}
}

