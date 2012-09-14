package com.oasis.tmsv5.vo.base
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.base.DownloadInfoVO")]
	public class DownloadInfo extends BaseVO
	{
		public function DownloadInfo(){}
		
		public var operator:String;
		public var trsJobCode:String;
		public var fileType:String;
		public var time:Date;
		public var path:String;
		public var startTime:Date;
		public var endTime:Date;
		public var opened:Boolean;
		public var remark:String;
	}
}