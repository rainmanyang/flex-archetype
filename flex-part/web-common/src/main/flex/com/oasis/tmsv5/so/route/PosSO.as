package com.oasis.tmsv5.so.route
{
	import com.oasis.component.page.BasePageSO;
	
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.route.PosSO")]
	public class PosSO extends BasePageSO
	{
		public function PosSO()
		{
		}
		public var name:String;
		public var code:String;
		public var shortName:String;
		public var type:String;
		public var roadMap:String;
		public var privince:String;
		public var city:String;
		public var district:String;
		public var organizationId:Number;
		public var organizationTreePath:String;
		public var address:String;
		public var contactPerson:String;
		public var contactPhone:String;
		public var chargePerson:String;
		public var chargePhone:String;
		
	}
}

