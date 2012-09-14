package com.oasis.wolfburg.so.route
{
	import com.oasis.component.page.BasePageSO;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.route.RouteSO")]
	public class RouteSO extends BasePageSO
	{
		public function RouteSO()
		{
		}
		public var name:String;
		public var status:String;
		public var passStop:String;
		
	}
}

