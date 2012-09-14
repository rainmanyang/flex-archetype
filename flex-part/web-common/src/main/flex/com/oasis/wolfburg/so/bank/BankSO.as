package com.oasis.wolfburg.so.bank
{
	import com.oasis.component.page.BasePageSO;
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.bank.BankSO")]
	public class BankSO extends BasePageSO
	{
		public function BankSO()
		{
		}
		public var bankName:String;
		public var branchName:String;
		
	}
}

