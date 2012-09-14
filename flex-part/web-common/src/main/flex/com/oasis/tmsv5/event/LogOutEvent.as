package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class LogOutEvent extends Event
	{
		public function LogOutEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const LOG_OUT:String = "logout";
	}
}