package com.oasis.wolfburg.vo.bill
{
	import com.oasis.tmsv5.vo.BaseVO;
	import com.oasis.utils.DateFormatterUtil;
	
	import mx.resources.ResourceManager;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.bill.PaymentItemVO")]
	public class PaymentItem extends BaseVO
	{
		public function PaymentItem()
		{
		}
		public var licensePlate:String;
		public var truckId:Number;
		public var billDate:Date;
		public var cardCode:String;
		public var carrierName:String;
		public var itemType:String;
		public var itemTypeCN:String;
		public var amount:String;
		public var trsJobCode:String;
		public var priceCode:String;
		public var reason:String;
		public var flag:String;
		public var payType:String;
		public var rsJobType:String;
		public var truckType:String;
		public var routeName:String;
		public var isReCost:String;
		public var closeTime:Date;
		public var reportId:Number;
		public var jobStartTime:Date;
		public var jobEndTime:Date;
		public var rsJobId:Number;
		public var actualStartTime:Date;
		/**
		 * 实际线路
		 */
		public var realRouteId:Number;
		
		/**
		 * 实际线路
		 */
		public var realRouteName:String;
		
		/**
		 * 计费线路
		 */
		public var payRouteId:Number;
		
		/**
		 * 计费线路
		 */
		public var payRouteName:String;
		
		/**
		 * 实际费率本编号
		 */
		public var realPriceCode:String;
		
		/**
		 * 计划费费率本编号
		 */
		public var payPriceCode:String;
		
		/**
		 * 实际费用金额
		 */
		public var realAmount:String;
		
		/**
		 * 计费费用金额
		 */
		public var payAmount:String;
		
		
		/**
		 * 实际结束时间
		 */
		public var actualEndTime:Date;
		/**
		 * 手工调整标志
		 */
		public var isManual:Number;
		public function truckTypeStr():String{
			return ResourceManager.getInstance().getString('normalResource',truckType);
		}
		
		public function get billDateStr():String{
			return DateFormatterUtil.format2(billDate);
		}
		public function get jobStartTimeStr():String{
			return DateFormatterUtil.format2(jobStartTime);
		}
		public function get actualStartTimeStr():String{
			return DateFormatterUtil.format2(actualStartTime);
		}
		public function get jobEndTimeStr():String{
			return DateFormatterUtil.format2(jobEndTime);
		}
		public function get closeTimeStr():String{
			return DateFormatterUtil.format2(closeTime);
		}
		public function get isManualStr():String{
			if(isManual == 1){
				return "手工结算";
			} else if(isManual == 0){
				return "自动结算";
			} else {
				return "";
			}
		}
	}
}

