package com.oasis.tmsv5.vo.naturalZone
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.zone.NaturalZoneVO")]
	public class NaturalZone extends com.oasis.tmsv5.vo.BaseVO
	{
		public function NaturalZone(){}
		
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