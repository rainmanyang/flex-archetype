package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class FeeItemEvent extends Event
	{
		public function FeeItemEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const FEE_ITEM_LIST_EVENT:String = "reloadFeeItemList";
		
		public static const FEE_REPORT_LIST_EVENT:String = "feeReportList";
	}
}