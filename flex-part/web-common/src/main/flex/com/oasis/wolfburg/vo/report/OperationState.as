package com.oasis.wolfburg.vo.report
{
	import com.oasis.tmsv5.vo.BaseVO;
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.report.OperationStateVO")]
	public class OperationState extends BaseVO
	{
		public function OperationState()
		{
			super();
		}
		/**
		 * 任务单名称
		 */
		public var code:String;
		
		/**
		 * 任务日期
		 */
		public var startDate:String;
		
		/**
		 * 状态
		 */
		public var status:String;
		
		/**
		 * 车牌
		 */
		public var licensePlate:String;
		
		/**
		 * 线路
		 */
		public var routeName:String;
		
		/**
		 * 计划始发时间
		 */
		public var planStartTime:String;
		
		/**
		 * 计划到达时间
		 */
		public var planEndTime:String;
		
		/**
		 * 出发站
		 */
		public var startStop:String;
		
		/**
		 * 到达站
		 */
		public var endStop:String;
		
		/**
		 * 出发时间
		 */
		public var actualStartTime:String;
		
		/**
		 * 到达时间
		 */
		public var actualEndTime:String;
		
		/**
		 * 出发方数
		 */
		public var startVolume:String;
		
		/**
		 * 出发吨位
		 */
		public var startWeight:String;
		
		/**
		 * 出发封签
		 */
		public var startSealSort:String;
		
		/**
		 * 到达方数
		 */
		public var endVolume:String;
		
		/**
		 * 到达吨位
		 */
		public var endWeight:String;
		
		/**
		 * 到达封签
		 */
		public var endSealSort:String;
		
		/**
		 * 出发封签检查
		 */
		public var startSealSortCheck:String;
		
		/**
		 * 到达封签检查
		 */
		public var endSealSortCheck:String;
		
		/**
		 * 封签检查
		 */
		public var sealSortCheck:String;
		
		/**
		 * 出发备注
		 */
		public var startRemark:String;
		
		/**
		 * 到达备注
		 */
		public var endRemark:String;
		
		/**
		 * 出发考勤类型
		 */
		public var startScanType:String;
		
		/**
		 * 到达考勤类型
		 */
		public var endScanType:String;
		
		/**
		 * 可装容积
		 */
		public var loadVolume:String;

	}
}