package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class PaymentItemEvent extends Event
	{
		public function PaymentItemEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const PAYMENT_ITEM_LIST_EVENT:String = "reloadPaymentItemList";
		
		public static const FEE_REPORT_LIST_EVENT:String = "feeReportList";
	}
}