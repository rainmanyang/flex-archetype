package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class PopExceptionWinEvent extends Event
	{
		
		public function PopExceptionWinEvent(type:String,stackTrace:String, bubbles:Boolean=false,cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			error = stackTrace;
		}
		
		public static const POP_EXCEPTION_WIN:String = "pop_exception_win";
		
		public var error:String;
	}
}