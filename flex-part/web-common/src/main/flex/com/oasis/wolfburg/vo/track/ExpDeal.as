package com.oasis.wolfburg.vo.track
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.track.ExpDealVO")]
	public class ExpDeal extends BaseVO
	{
		public function ExpDeal(){
			super();
		}
		
		public var expDealContent:String;
		public var expDealer:String;
		public var expTrackId:Number;
	}
}