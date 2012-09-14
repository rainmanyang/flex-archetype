package com.oasis.wolfburg.so.carrier
{
	import com.oasis.component.page.BasePageSO;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.carrier.CarrierSO")]
	public class CarrierSO extends BasePageSO
	{
		public function CarrierSO()
		{
		}
		public var carrierName:String;
		public var carrierCode:String;
		public var carrierType:String;
		public var status:String;
	}
}

