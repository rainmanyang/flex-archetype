package com.oasis.tmsv5.vo.security
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.AccountVO")]
	public class Account extends com.oasis.tmsv5.vo.BaseVO
	{
		public function Account(){}
		
		public var disabled:Boolean;
		
		public var locked:Boolean;
		
		public var expiredDate:Date;
		
		public var passwordExpiredDate:Date;
		
		public var loginName:String;
		
		public var  password:String;
		
		public var nameCN:String;
		
		public var nameEn:String;
		
		public var email:String;
		
		public var phoneCode:String;
		
		public var orgName:String;
		
		public var orgTreePath:String;
		
		public var createTime:Date;
		
		public var lastUpdate:Date;
		
		public var roles:ArrayCollection;
		
		public var orgs:ArrayCollection;
		
		public var netAuthority:String;
		
	}
}