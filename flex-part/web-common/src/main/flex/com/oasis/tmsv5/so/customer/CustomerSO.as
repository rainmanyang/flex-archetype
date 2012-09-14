package com.oasis.tmsv5.so.customer
{
	import com.oasis.component.page.BasePageSO;
	
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.so.customer.CustomerSO")]
	public class CustomerSO extends BasePageSO
	{
		public function CustomerSO(){}
		
		public var codeName:String;
		
		public var parentCodeName:String;
		
		public var  shortName:String;
		
		public var  shortCode:String;
		
		public var  paymentMethod:String;
		
		public var  contracted:Boolean;
		
		public var  code:String;
		
		public var  name:String;
	}
}