package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class CloseCalendarEvent extends Event
	{
		public function CloseCalendarEvent(type:String, id:Number, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			rsId = id;
		}
		
		public static const CALENDAR_CLOSE_EVENT:String = "close_calendar";
		
		public var rsId:Number;
	}
}