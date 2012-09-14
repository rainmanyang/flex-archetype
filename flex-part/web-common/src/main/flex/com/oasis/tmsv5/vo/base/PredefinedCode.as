package com.oasis.tmsv5.vo.base
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.base.PredefinedCodeVO")]
	public class PredefinedCode extends BaseVO
	{
		public function PredefinedCode(){}
		
		public var  code:String;
		
		public var  value:String;
		
		public var  description:String;
		
		public var  type:String;
	}
}