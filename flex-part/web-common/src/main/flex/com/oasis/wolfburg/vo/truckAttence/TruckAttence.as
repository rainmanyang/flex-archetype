package com.oasis.wolfburg.vo.truckAttence
{
	import com.oasis.tmsv5.vo.BaseVO;
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.truckAttence.TruckAttenceVO")]
	public class TruckAttence extends BaseVO
	{
		public function TruckAttence()
		{
			super();
		}
		/**
		 * 线路名称
		 */
		public var routeName:String;
		
		/**
		 * 车牌
		 */
		public var licensePlate:String;
		
		/**
		 * 分区
		 */
		public var area:String;
		
		/**
		 * 调度分区
		 */
		public var dispatchArea:String;
		
		/**
		 * 班车日历
		 */
		public var startDate:String;
		
		/**
		 * 新线
		 */
		public var newLine:String;
		
		/**
		 * 里程
		 */
		public var distance:String;
		
		/**
		 * 线段
		 */
		public var routeLine:String;
		
		/**
		 * 出发站
		 */
		public var startStop:String;
		
		/**
		 * 到站
		 */
		public var endStop:String;
		
		/**
		 * 规定发车时间
		 */
		public var startPlanTime:Date;
		
		/**
		 * 实际发车时间
		 */
		public var startActualTime:Date;
		
		/**
		 * 规定到车时间
		 */
		public var endPlanTime:Date;
		
		/**
		 * 实际到车时间
		 */
		public var endActualTime:Date;
		
		/**
		 * 到车延误
		 */
		public var arrvialDelay:String;
		
		/**
		 * 行驶延误 
		 */
		public var enrouteDelay:String;
		
		/**
		 * 封签 
		 */
		public var sealSort:String;
		
		/**
		 * 方数
		 */
		public var volume:String;
		
		/**
		 * 重量
		 */
		public var weight:String;
		
		/**
		 * 件数
		 */
		public var amount:String;
		
	}
}