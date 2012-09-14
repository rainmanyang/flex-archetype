package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class TruckEvent extends Event
	{
		public function TruckEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const TRUCK_LIST_EVENT:String = "reloadTruckList";
		public static const TRUCK_STATUS_LIST_EVENT:String = "reloadTruckStatusList";
	}
}