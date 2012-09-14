package com.oasis.wolfburg.vo.route
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.route.PosViewVO")]
	public class PosView extends BaseVO
	{
		public function PosView()
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
		public var privinceId:Number;
		public var cityId:Number;
		public var districtId:Number;
		public var organizationId:Number;
		public var organizationName:String;
		public var organizationTreePath:String;
		public var address:String;
		public var contactPerson:String;
		public var contactPhone:String;
		public var chargePerson:String;
		public var chargePhone:String;
		public var gps:String;
		
	}
}

