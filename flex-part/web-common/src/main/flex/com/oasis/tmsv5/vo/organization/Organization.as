package com.oasis.tmsv5.vo.organization
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.orgnization.OrganizationVO")]
	public class Organization extends com.oasis.tmsv5.vo.BaseVO
	{
		public function Organization(){}
		
		public var treePath:String;
		
		public var namePath:String;
		
		public var status:String;
		
		public var code:String;
		
		public var desc:String;
		
		public var name:String;
		
		public var contactPersonName:String;
		
		public var contactPhone:String;
		
		public var parentId:Number;
		
		public var customers:ArrayCollection;
		
	}
}