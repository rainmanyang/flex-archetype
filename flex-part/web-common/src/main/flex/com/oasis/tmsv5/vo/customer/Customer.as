package com.oasis.tmsv5.vo.customer
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.customer.CustomerVO")]
	public class Customer extends BaseVO
	{
		public function Customer(){}
		
		public var  code:String;
		
		public var  name:String;
		
		public var  status:String;
		
		public var  parentId:Number;
		
		public var  addressId:Number;
		
		public var  contactPersonName:String;
		
		public var  contactPhone:String;
		
		public var  byDefault:Boolean;
		
		public var  insured:Boolean;
		
		public var  insuredRate:Number;
		
		public var  transType:Number;
		
		public var  shortName:String;
		
		public var  shortCode:String;
		
		public var  profileId:Number;
		
		public var  brevityCode:String;

		public var  paymentMethod:String;
		
		public var  paymentCurrency:String;
		
		public var  quotationType:String;
		
		public var  accountAmount:Number;
		
		public var  accountUnitId:Number;
		
		public var  apAmount:Number;
		
		public var  apUnitId:Number;
		
		public var  contracted:Boolean;
	}
}