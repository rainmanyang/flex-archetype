package com.oasis.wolfburg.vo.track
{
	import com.oasis.tmsv5.vo.BaseVO;
	import com.oasis.utils.DateFormatterUtil;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.track.ExpTrackVO")]
	public class ExpTrack extends BaseVO{
		public function ExpTrack(){
			super();
		}
		
		public var licensePlate:String;
		public var rssJobCode:String;
		public var rsScheduleName:String;
		public var routeName:String;
		public var expType:String;
		public var expGrade:String;
		public var expContent:String;
		public var delayTime:String;
		public var reporter:String;
		public var reportTime:Date;
		public var contactPhone:String;
		public var status:String;
		public var expDealer:String;
		public var expDealTime:String;
		public var expDealContent:String;
		
		public var rsJobId:Number;
		public var rsScheduleId:Number;
		
		public var createdTime:Date;
		
		public var rsJobStatus:String;
		public var feedBackFlag:Boolean;
		
		public var suggestList:ArrayCollection = new ArrayCollection();
		
		public function get operation():Boolean {
			return status == "UNPROCESSED";
		}
	}
}