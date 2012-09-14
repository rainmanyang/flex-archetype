package com.oasis.tmsv5.so.truckAttence
{
	import com.oasis.component.page.BasePageSO;
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truckAttence.TruckAttenceSO")]
	public class TruckAttenceSO extends BasePageSO {

		public function TruckAttenceSO(){
			super();
		}
		
		public var requestUrl:String;
	}
}