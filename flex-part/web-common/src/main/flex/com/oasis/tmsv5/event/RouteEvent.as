package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class RouteEvent extends Event
	{
		public function RouteEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const ROUTE_LIST_EVENT:String = "reloadRouteList";
	}
}