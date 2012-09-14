package com.oasis.tmsv5.vo.security
{

	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.RoleVO")]
	public class Role 
	{
		public var id:Number;
		
		public var name:String;
		
		public var description:String;
		
		public var netAuthority:String;
		
		public function Role(){}
		
		
	}
}