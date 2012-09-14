package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class DriverEvent extends Event
	{
		public function DriverEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const DRIVER_LIST_EVENT:String = "reloadDriverList";
	}
}