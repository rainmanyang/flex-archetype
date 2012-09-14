package com.oasis.tmsv5.so.security
{
	
	import com.oasis.component.page.BasePageSO;
	
	import org.hamcrest.mxml.object.Null;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.so.security.AccountSO")]
	public class AccountSO extends BasePageSO
	{
		public var disabled:Boolean;
		
		public var locked:Number;
		
		public var expiredDate:Date;
		
		public var passwordExpiredDate:Date;
		
		public var loginName:String;
		
		public var nameCN:String;
		
		public var email:String;
		
		public var phoneCode:String;
		
		public var orgName:String;
		
		public var orgTreePath:String;
		
		public function AccountSO()
		{
		}

	}
}