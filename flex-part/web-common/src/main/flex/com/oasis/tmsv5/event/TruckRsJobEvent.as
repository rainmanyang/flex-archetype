package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class TruckRsJobEvent extends Event
	{
		public function TruckRsJobEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const RSJOB_LIST_EVENT:String = "reloadTruckRsJobList";
	}
}