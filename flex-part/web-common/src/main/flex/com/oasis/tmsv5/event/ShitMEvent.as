package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class ShitMEvent extends Event
	{
		public function ShitMEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const MENU_ITEM_REFRESH:String = "reloadMenuItem";
	}
}