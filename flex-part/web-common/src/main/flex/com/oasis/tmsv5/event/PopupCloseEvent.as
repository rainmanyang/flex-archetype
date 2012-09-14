package com.oasis.tmsv5.event
{
	import flash.events.Event;
	
	public class PopupCloseEvent extends Event
	{
		public function PopupCloseEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static const ORG_POPUP_CLOSE:String = "org_pupup_close";
		
		/**
		 * 弹窗中选中的对象
		 */ 
		private var _dto:Object = new Object();
		
		public function get dto():Object
		{
			return _dto;
		}
		
		public function set dto(value:Object):void
		{
			_dto = value;
		}
	}
}