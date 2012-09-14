package com.oasis.tmsv5.vo.security
{
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.AuthenticationVO")]
	public class Authentication
	{
		public var username:String;
		public var password:String;
		public var domian:String;
		
		public function Authentication()
		{
		}
		
	}
}