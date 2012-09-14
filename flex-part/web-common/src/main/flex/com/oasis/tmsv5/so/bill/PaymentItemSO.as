package com.oasis.tmsv5.so.bill
{
	import com.oasis.component.page.BasePageSO;
	import com.oasis.utils.DateFormatterUtil;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.bill.PaymentItemSO")]
	public class PaymentItemSO extends BasePageSO
	{
		public function PaymentItemSO()
		{
		}
		public var licensePlate:String;
		public var trsJobCode:String;
		public var itemType:String;
		public var itemTypeName:String;
		public var billDateBegin:Date;
		public var billDateEnd:Date;
		public var requestUrl:String;
		public var carrierName:String;
		public var minMoney:String;
		public var maxMoney:String;
		public var flag:String;
		public var routeId:Number;
		public var routeName:String;
		public var isManualStr:String;
		
		public function get billDateBeginStr():String{
			return DateFormatterUtil.format2(billDateBegin);
		}
		public function get billDateEndStr():String{
			return DateFormatterUtil.format2(billDateEnd);
		}
		public function get flagStr():String{
			if(flag == "0"){
				return "未关账";
			} else if(flag == "1"){
				return "已关账";
			} else {
				return null;
			}
		}
	}
}

