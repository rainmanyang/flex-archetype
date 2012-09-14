package com.oasis.security
{
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.ClientContext")]
	public class ClientContext
	{
		public function ClientContext(){}
		
		public var loginName:String;
		
		public var accountId:Number;
		
		public var password:String;
		
		public var loginToken:String;
		
		public var nameCn:String;
		
		public var ip:String;
		
		public var netAuthority:String;
	}
}