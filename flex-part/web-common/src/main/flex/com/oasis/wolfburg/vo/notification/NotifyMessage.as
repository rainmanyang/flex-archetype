package com.oasis.wolfburg.vo.notification
{ 
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.system.NotifyMessage")]
	public class NotifyMessage
	{
		public function NotifyMessage()
		{
		}		
		public var topic:String;
		public var content:String;
	}
}