package com.oasis.tmsv5.vo.address
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.address.AddressVO")]
	public class Address extends BaseVO
	{
		public function Address(){}
		
		public var naturalZoneId:Number;
		
		public var postCode:String;
		
		public var street:String;
		
		public var area:String;
		
	}
}