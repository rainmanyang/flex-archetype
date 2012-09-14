package com.oasis.tmsv5.so.base
{
	import com.oasis.component.page.BasePageSO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.so.base.DownloadInfoSO")]
	public class DownloadInfoSO extends BasePageSO
	{
		public function DownloadInfoSO()
		{
		}
		public var operator:String;
		public var trsJobCode:String;
		public var fileType:String;
		public var fileTypes:ArrayCollection;
		public var beginTime:Date;
		public var endTime:Date;
		public var code:String;
		
		
		
	}
}

