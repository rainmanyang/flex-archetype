package com.oasis.tmsv5.so.price
{
	import com.oasis.component.page.BasePageSO;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.price.PriceSO")]
	public class PriceSO extends BasePageSO{
		public function PriceSO(){
		}
		
		public var routeName:String;
		public var status:String;
		public var periodStart:Date;
		public var periodEnd:Date;
		public var routeId:Number;
		public var truckType:String;
		public var requestUrl:String;
	}
}