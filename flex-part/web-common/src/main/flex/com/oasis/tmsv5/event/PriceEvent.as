package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class PriceEvent extends Event
	{
		public function PriceEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const PRICE_LIST_EVENT:String = "reloadPriceList";
	}
}