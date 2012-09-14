package com.oasis.wolfburg.vo.truck
{
	import com.oasis.tmsv5.vo.BaseVO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.truck.ContractRouteVO")]
	public class ContractRoute extends com.oasis.tmsv5.vo.BaseVO
	{
		
		public function ContractRoute(){}
		public var truckId:Number;
		public var routeId:Number;
	}
}