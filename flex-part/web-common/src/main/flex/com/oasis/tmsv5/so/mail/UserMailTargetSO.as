package com.oasis.tmsv5.so.mail
{
	import com.oasis.component.page.BasePageSO;
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.mail.UserMailTargetSO")]
	public class UserMailTargetSO extends BasePageSO
	{
		public function UserMailTargetSO()
		{
			super();
		}
		
		public var reportType:String;
	}
}