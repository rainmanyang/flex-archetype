package com.oasis.tmsv5.so.security
{
	import com.oasis.component.page.BasePageSO;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.so.security.RolePremissionSO")]
	public class RolePremissionSO extends BasePageSO
	{
		public var name:String;
		public var description:String;
		
		public function RolePremissionSO()
		{
		}

	}
}