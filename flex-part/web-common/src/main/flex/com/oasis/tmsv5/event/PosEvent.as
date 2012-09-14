package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class PosEvent extends Event
	{
		public function PosEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const POS_LIST_EVENT:String = "reloadPosList";
	}
}