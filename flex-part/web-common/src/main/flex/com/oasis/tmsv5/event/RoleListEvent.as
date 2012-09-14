package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class RoleListEvent extends Event
	{
		public function RoleListEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const ROLE_LIST_EVENT:String = "reloadRoleList";
	}
}