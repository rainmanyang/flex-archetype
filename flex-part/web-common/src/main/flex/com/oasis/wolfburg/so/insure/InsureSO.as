package com.oasis.wolfburg.so.insure
{
	import com.oasis.component.page.BasePageSO;
	
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.insure.InsureSO")]
	public class InsureSO extends BasePageSO
	{
		public function InsureSO()
		{
		}
		public var insurer:String;
		public var insureCode:String;
		
	}
}

