package com.oasis.tmsv5.layout
{
	
	import com.oasis.tmsv5.view.base.DownloadInfoList;
	import com.oasis.tmsv5.view.bill.FeeItemList;
	import com.oasis.tmsv5.view.bill.FeeItemList4Settlement;
	import com.oasis.tmsv5.view.carrier.CarrierList;
	import com.oasis.tmsv5.view.dispatchDock.DispatchDock;
	import com.oasis.tmsv5.view.dispatchDock.ExceptionalJobDock;
	import com.oasis.tmsv5.view.dispatchDock.TodayPlanedTruckRsJobList;
	import com.oasis.tmsv5.view.dispatchDock.TruckRsJobList;
	import com.oasis.tmsv5.view.dispatchDock.UnPlanedJobDock;
	import com.oasis.tmsv5.view.driver.DriverList;
	import com.oasis.tmsv5.view.mail.MailManageView;
	import com.oasis.tmsv5.view.message.JMSMessageTest;
	import com.oasis.tmsv5.view.message.MessageTest;
	import com.oasis.tmsv5.view.pos.POSList;
	import com.oasis.tmsv5.view.preArrangeRS.PreArrangeRS;
	import com.oasis.tmsv5.view.price.PriceList;
	import com.oasis.tmsv5.view.report.FeeItemReport;
	import com.oasis.tmsv5.view.report.FeeReport;
	import com.oasis.tmsv5.view.report.OperationStateReport;
	import com.oasis.tmsv5.view.report.OperationTimeManage;
	import com.oasis.tmsv5.view.report.OperationTimeReport;
	import com.oasis.tmsv5.view.report.ReportDownLoadList;
	import com.oasis.tmsv5.view.route.RouteList;
	import com.oasis.tmsv5.view.security.AccountCreateView;
	import com.oasis.tmsv5.view.security.AccountManageView;
	import com.oasis.tmsv5.view.security.MenuItemManage;
	import com.oasis.tmsv5.view.security.OrganizationManageView;
	import com.oasis.tmsv5.view.security.PasswordEdit;
	import com.oasis.tmsv5.view.security.RolePremissionCreateView;
	import com.oasis.tmsv5.view.security.RolePremissionManageView;
	import com.oasis.tmsv5.view.track.ExpTrackList;
	import com.oasis.tmsv5.view.truck.TruckExpirationList;
	import com.oasis.tmsv5.view.truck.TruckList;
	import com.oasis.tmsv5.view.truck.TruckRouteRelationList;
	import com.oasis.tmsv5.view.truck.TruckStatusList;
	import com.oasis.tmsv5.view.truckAttence.TruckAttenceManageView;
	import com.oasis.tmsv5.view.truckRSSchedule.ClientBarcodeRecordList;
	import com.oasis.tmsv5.view.truckRSSchedule.StopRSJobList;
	import com.oasis.tmsv5.view.truckRSSchedule.TruckRSScheduleList;
	
	import flash.utils.Dictionary;
	
	/**
	 * 菜单对应的module
	 */
	public class ModuleClass
	{

		private static const allModuleClass:Dictionary = new Dictionary();
		
		
		/**
		 * 账号和权限管理
		 */		
		allModuleClass["RolePremissionCreateView"] = RolePremissionCreateView;//  创建角色
		allModuleClass["RolePremissionManageView"] = RolePremissionManageView;	//	维护角色
	    allModuleClass["AccountCreateView"] = AccountCreateView;		//	创建用户
	    allModuleClass["AccountManageView"] = AccountManageView;		//	用户管理
	    allModuleClass["OrganizationManageView"] = OrganizationManageView;		//	组织管理
		allModuleClass["MessageTest"] = MessageTest;		//	flex 消息测试
		allModuleClass["JMSMessageTest"] = JMSMessageTest; // jms 消息测试
		allModuleClass["PasswordEdit"] = PasswordEdit; // jms 消息测试
		allModuleClass["MenuItemManage"] = MenuItemManage;
		allModuleClass["MailManageView"] = MailManageView;//邮件管理
		/**
		 * 基础数据管理
		 */ 
		allModuleClass["DriverList"] = DriverList;
		allModuleClass["POSList"] = POSList;
		allModuleClass["PriceList"] = PriceList;
		allModuleClass["RouteList"] = RouteList;
		allModuleClass["CarrierList"] = CarrierList;
		allModuleClass["TruckList"] = TruckList;
		allModuleClass["TruckRSScheduleList"] = TruckRSScheduleList;
		
		allModuleClass["DispatchDock"] = DispatchDock;
		
		allModuleClass["UnPlanedJobDock"] = UnPlanedJobDock;
		
		allModuleClass["DeductFeeList"] = FeeItemList;
		
		allModuleClass["FeeItemList4Settlement"] = FeeItemList4Settlement;
		
		allModuleClass["ExpTrackList"] = ExpTrackList;
		
		allModuleClass["ClientBarcodeRecordList"] = ClientBarcodeRecordList;
		allModuleClass["TruckExpirationList"] = TruckExpirationList;
		allModuleClass["TruckRouteRelationList"] = TruckRouteRelationList;
		
		allModuleClass["StopRSJobList"] = StopRSJobList ;
		
		/**
		 * 报表
		 */
		allModuleClass["OperationTimeReport"] = OperationTimeReport;//运营时效报表
		allModuleClass["OperationTimeManage"] = OperationTimeManage;//运营时效管理
		allModuleClass["FeeReport"] = FeeReport;//费用报表
		
		allModuleClass["DownloadInfoList"] = DownloadInfoList;//费用报表
		
		allModuleClass["FeeItemReport"] = FeeItemReport;
		allModuleClass["TruckAttenceManageView"] = TruckAttenceManageView;//日考核报表
		
		allModuleClass["ReportDownLoadList"] = ReportDownLoadList;//日报表下载
		
		allModuleClass["OperateStatsReport"] = OperationStateReport;//网络班车情况运营表
		
		/**
		 * 调度台
		 */ 
		allModuleClass["PreArrangeRS"] = PreArrangeRS;
		allModuleClass["TruckStatusList"] = TruckStatusList;
		allModuleClass["TruckRsJobList"] = TruckRsJobList;
		allModuleClass["TodayPlanedTruckRsJobList"] = TodayPlanedTruckRsJobList;
		allModuleClass["ExceptionalJobDock"] = ExceptionalJobDock;
		
		public static function getModuleClass(roleName:String):Class{
			return allModuleClass[roleName];
		}
		
		public function ModuleClass()
		{
		}
	}
}