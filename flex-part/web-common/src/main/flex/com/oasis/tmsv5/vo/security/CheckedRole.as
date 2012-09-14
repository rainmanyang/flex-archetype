package com.oasis.tmsv5.vo.security
{
	import mx.collections.ArrayCollection;
	
	[Bindable]          
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.CheckedRoleVO")]
	public class CheckedRole
	{
		public function CheckedRole(){}
		
		public var allRoles:ArrayCollection = new ArrayCollection;
		
		public var role:Role;
		
		public var checkedRoles:ArrayCollection = new ArrayCollection;
		
	}
}