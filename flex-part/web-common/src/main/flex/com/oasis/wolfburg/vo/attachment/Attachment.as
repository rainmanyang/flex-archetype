package com.oasis.wolfburg.vo.attachment
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	import flash.utils.ByteArray;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.attachment.AttachmentVO")]
	public class Attachment extends BaseVO
	{
		public function Attachment(){
			super();
		}
		
		public var type:String;
		
		public var fileUrl:String;
		
		public var fileType:String;
		
		public var fileBytes:ByteArray;
		
		//不对应只做校验的字段
		public var time:Number;
		public var size:uint;
	}
}