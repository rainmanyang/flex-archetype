package com.oasis.tmsv5.so.track
{
	import com.oasis.component.page.BasePageSO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.track.ExpTrackSO")]
	public class ExpTrackSO extends BasePageSO{
		public function ExpTrackSO(){
			super();
		}
		
		public var licensePlate:String;
		public var expType:String;
		public var expGrade:String;
		public var timeStart:Date;
		public var timeEnd:Date;
		
		public var code:String;
	}
}