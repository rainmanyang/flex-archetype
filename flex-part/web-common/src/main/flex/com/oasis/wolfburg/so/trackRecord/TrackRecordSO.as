package com.oasis.wolfburg.so.trackRecord
{
	import com.oasis.component.page.BasePageSO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.trackRecord.TrackRecordSO")]
	public class TrackRecordSO extends BasePageSO
	{    
	    public var truckRsJobId:Number;
	    public var eventTime:Date;
	    public var description:String;
		
		public function TrackRecordSO()
		{
		}
	}
}
