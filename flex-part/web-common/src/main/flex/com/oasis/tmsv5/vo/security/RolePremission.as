package com.oasis.tmsv5.vo.security
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.RolePremissionVO")]
	public class RolePremission extends com.oasis.tmsv5.vo.BaseVO
	{
		public function RolePremission(){}
		
		public var code:String;
		
		public var name:String;
		
		public var roleType:String;
		
		public var  dataLevel:String;
		
		public var description:String;
		
		public var domainCode:String;
		
		public var netAuthority:String;
		
		public var  premission:ArrayCollection = new ArrayCollection();
		
		public var configurePages:ArrayCollection = new ArrayCollection();
		
	}
}