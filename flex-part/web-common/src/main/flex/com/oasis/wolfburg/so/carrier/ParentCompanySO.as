package com.oasis.wolfburg.so.carrier
{
	import com.oasis.component.page.BasePageSO;
	
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.carrier.ParentCompanySO")]
	public class ParentCompanySO extends BasePageSO
	{
		public function ParentCompanySO()
		{
		}
		public var companyName:String;
		
	}
}

