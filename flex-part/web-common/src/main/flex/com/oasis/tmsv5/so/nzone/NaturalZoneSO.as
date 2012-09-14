package com.oasis.tmsv5.so.nzone
{
	import com.oasis.component.page.BasePageSO;
	
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.so.zone.NaturalZoneSO")]
	public class NaturalZoneSO extends BasePageSO
	{
		public function NaturalZoneSO(){}
		
		public var postCode:String;
		
		public var parent:Number;
		
		public var treePath:String;
		
		public var namePath:String;
		
		public var status:String;
		
		public var code:String;
		
		public var desc:String;
		
		public var name:String;

	}
}