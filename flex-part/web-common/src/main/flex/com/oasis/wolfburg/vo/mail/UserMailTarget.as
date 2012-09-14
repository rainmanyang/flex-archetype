package com.oasis.wolfburg.vo.mail
{
	import com.oasis.tmsv5.vo.BaseVO;
	import com.oasis.tmsv5.vo.security.Account;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.mail.UserMailTargetVO")]
	public class UserMailTarget extends BaseVO
	{
		public function UserMailTarget()
		{
			super();
		}
		public var accountId:Number;
		public var extraEmail:String;
		public var reportType:String;
		
		public var account:Account;
	}
}