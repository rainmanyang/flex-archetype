package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class AccountEvent extends Event
	{
		public function AccountEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const ACCOUNT_LIST_EVENT:String = "reloadAccountList";
	}
}