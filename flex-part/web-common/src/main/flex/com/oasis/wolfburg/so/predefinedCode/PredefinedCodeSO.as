package com.oasis.wolfburg.so.predefinedCode
{
	import com.oasis.component.page.BasePageSO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.predefinedCode.PredefinedCodeSO")]
	public class PredefinedCodeSO extends BasePageSO
	{
		public function PredefinedCodeSO()
		{
			super();
		}
		
		public var value:String;
		
		public var type:String;
		
		public var description:String;
	}
}