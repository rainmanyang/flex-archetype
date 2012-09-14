package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class ExpTrackEvent extends Event{
		public function ExpTrackEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false){
			super(type, bubbles, cancelable);
		}
		
		public static const EXPTRACK_LIST_EVENT:String = "reloadExpTrackList";
	}
}