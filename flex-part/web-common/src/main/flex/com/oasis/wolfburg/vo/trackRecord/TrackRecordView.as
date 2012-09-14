package com.oasis.wolfburg.vo.trackRecord
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.trackRecord.TrackRecordViewVO")]
	public class TrackRecordView extends BaseVO
	{    
	    public var truckRsJobId:Number;
	    public var eventTime:Date;
	    public var description:String;
		public var truckRsJobName:String;
		public var opName:String;
		
		public function TrackRecordView()
		{
		}
	}
}
