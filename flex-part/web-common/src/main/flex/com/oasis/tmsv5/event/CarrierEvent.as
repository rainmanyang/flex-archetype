package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class CarrierEvent extends Event
	{
		public function CarrierEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const CARRIER_LIST_EVENT:String = "reloadCarrierList";
	}
}