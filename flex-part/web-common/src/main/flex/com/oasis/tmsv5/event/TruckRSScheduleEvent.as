package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class TruckRSScheduleEvent extends Event
	{
		public function TruckRSScheduleEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const TRUCK_RS_SCHEDULE_LIST_EVENT:String = "reloadTruckRSScheduleList";
	}
}