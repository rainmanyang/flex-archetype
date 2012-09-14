package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class OrgReloadEvent extends Event
	{
		public function OrgReloadEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const REOLAD_ORG_EVENT:String = "reloadOrgEvent";
	}
}