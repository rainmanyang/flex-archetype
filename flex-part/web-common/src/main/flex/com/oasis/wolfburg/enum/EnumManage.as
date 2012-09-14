package com.oasis.wolfburg.enum
{
	import mx.collections.ArrayCollection;
	
	public class EnumManage
	{
		public function EnumManage(){
		}
		public static var base:Object = {label:"--请选择--", data:''};
		public static var baseNum:Object = {label:"--请选择--", data:NaN};
		
		public static var yesType:Object = {label:"是", data:'true'};
		public static var noType:Object = {label:"否", data:'false'};
		
		public static var booleanYesType:Object = {label:"是", data:true};
		public static var booleanNoType:Object = {label:"否", data:false};
		
		public static var booleanOutType:Object = {label:"出港 ", data:true};
		public static var booleanInType:Object = {label:"进港", data:false};
		
		public static var certType1:Object = {label:"驾驶证", data:'1'};
		public static var certType2:Object = {label:"驾驶证副页", data:'2'};
		public static var certType3:Object = {label:"身份证", data:'3'};
		public static var certType4:Object = {label:"其它", data:'4'};
		
		public static var allowedTruck1:Object = {label:"A", data:'A'};
		public static var allowedTruck2:Object = {label:"B", data:'B'};
		public static var allowedTruck3:Object = {label:"C", data:'C'};
		
		public static var driverStatus1:Object = {label:"正常", data:'NORMAL'};
		public static var driverStatus2:Object = {label:"冻结", data:'FROZEN'};
		
		public static var priceStatus1:Object = {label:"有效", data:'EFFECTIVE'};
		public static var priceStatus2:Object = {label:"停用", data:'FAILURE'};
		public static var priceStatus3:Object = {label:"历史", data:'HISTORY'};
		
		public static var truckLevel1:Object = {label:"豪华", data:'HIGH'};
		public static var truckLevel2:Object = {label:"中等", data:'NORMAL'};
		public static var truckLevel3:Object = {label:"普通", data:'LOW'};
		
		public static var truckType1:Object = {label:"9.6米", data:'T9_6M'};
		public static var truckType2:Object = {label:"9.2米", data:'T9_2M'};
		public static var truckType3:Object = {label:"8.6米", data:'T8_6M'};
		public static var truckType4:Object = {label:"7.6米", data:'T7_6M'};
		public static var truckType5:Object = {label:"7.2米", data:'T7_2M'};
		public static var truckType6:Object = {label:"7.1米", data:'T7_1M'};
		public static var truckType7:Object = {label:"6.8米", data:'T6_8M'};
		public static var truckType8:Object = {label:"6.2米", data:'T6_2M'};
		public static var truckType9:Object = {label:"4.2米", data:'T4_2M'};
		
		public static var truckPro1:Object = {label:"干线", data:"TRUNK"};
		public static var truckPro2:Object = {label:"市内", data:"CITY"};
		public static var truckPro3:Object = {label:"站点", data:"STATION"};
		
		public static var POSType1:Object = {label:"一级分拨", data:'F'};
		public static var POSType2:Object = {label:"二级分拨", data:'S'};
		public static var POSType3:Object = {label:"网点", data:'N'};
		
		public static var routeStatus1:Object = {label:"新建", data:'NEW'};
		public static var routeStatus2:Object = {label:"启用", data:'ACTIVE'};
		public static var routeStatus3:Object = {label:"停用", data:'FROZEN'};
		
		public static var truckRunningStatus1:Object = {label:"空闲", data:'FREE'};
		public static var truckRunningStatus2:Object = {label:"预排班", data:'PLANED'};
		public static var truckRunningStatus3:Object = {label:"准备", data:'READY'};
		public static var truckRunningStatus4:Object = {label:"在途", data:'ENROUTE'};
		public static var truckRunningStatus5:Object = {label:"到达", data:'ARRIVAL'};
		
		public static var truckStatus1:Object = {label:"可用", data:'ENABLE'};
		public static var truckStatus2:Object = {label:"禁闭", data:'PONISHED'};
		public static var truckStatus3:Object = {label:"故障", data:'BREAK_DOWN'};
		public static var truckStatus4:Object = {label:"下线", data:'CLOSED'};
		public static var truckStatus5:Object = {label:"退网", data:'DISABLED'};
		
		public static var truckResourceType1:Object = {label:"正式", data:'REGULAR'};
		public static var truckResourceType2:Object = {label:"试用", data:'TEMP'};
		public static var truckResourceType3:Object = {label:"临时", data:'OUT'};
		
		public static var carrierStatus1:Object = {label:"新建", data:'NEW'};
		public static var carrierStatus2:Object = {label:"激活", data:'ACTIVED'};
		public static var carrierStatus3:Object = {label:"退网", data:'DISABLED'};
		public static var carrierStatus4:Object = {label:"冻结", data:'FROZEN'};
		
		public static var carrierType1:Object = {label:"公司", data:'COMPANY'};
		public static var carrierType2:Object = {label:"个人", data:'PERSON'};
		
		public static var payWay1:Object = {label:"现金", data:'CASH'};
		public static var payWay2:Object = {label:"支票", data:'CHECK'};
		public static var payWay3:Object = {label:"转账", data:'TRANSFER'};
		
		public static var RSJobStatus1:Object = {label:"待派", data:'NEW'};
		public static var RSJobStatus2:Object = {label:"已计划", data:'PLANED'};
		public static var RSJobStatus3:Object = {label:"已派", data:'DISPATCHED'};
		public static var RSJobStatus4:Object = {label:"途中", data:'ENROUTE'};
		public static var RSJobStatus5:Object = {label:"到达", data:'ARRIEVED'};
		public static var RSJobStatus6:Object = {label:"取消", data:'CANCLED'};
		public static var RSJobStatus7:Object = {label:"终止", data:'TERMINATED'};
		
		public static var OperateStateStatus1:Object = {label:"计划", data:'PLANED'};
		public static var OperateStateStatus2:Object = {label:"未考勤", data:'DISPATCHED'};
		public static var OperateStateStatus3:Object = {label:"在途", data:'ENROUTE'};
		public static var OperateStateStatus4:Object = {label:"到达", data:'ARRIEVED'};
		
		public static var RSScheduleStatus1:Object = {label:"新建", data:'NEW'};
		public static var RSScheduleStatus2:Object = {label:"发布", data:'PUBLISH'};
		public static var RSScheduleStatus3:Object = {label:"关闭", data:'CLOSED'};
		
		public static var carrierCertType1:Object = {label:"运输合同", data:'1'};
		public static var carrierCertType2:Object = {label:"驾驶证副页", data:'2'};
		public static var carrierCertType3:Object = {label:"身份证", data:'3'};
		public static var carrierCertType4:Object = {label:"营业执照", data:'4'};
		public static var carrierCertType5:Object = {label:"银行卡复印件", data:'5'};
		public static var carrierCertType6:Object = {label:"道路运输许可证", data:'6'};
		public static var carrierCertType7:Object = {label:"挂靠协议", data:'7'};
		
		public static var truckCertType1:Object = {label:"行驶证", data:'1'};
		public static var truckCertType2:Object = {label:"道路运输许可证", data:'2'};
		public static var truckCertType3:Object = {label:"挂靠协议", data:'3'};
		public static var truckCertType4:Object = {label:"保险单", data:'4'};
		public static var truckCertType5:Object = {label:"车辆购置税证", data:'5'};
		
		public static var todayDayType:Object = {label:"当日", data:'0'};
		public static var tomorrowDayType:Object = {label:"次日", data:'1'};
		public static var afterTomorrowDayType:Object = {label:"第三日", data:'2'};
		
		public static var licenseType1:Object = {label:"身份证", data:'IDENTITY'};
		public static var licenseType2:Object = {label:"营业执照", data:'LICENSE'};
		
		public static var rsJobType1:Object = {label:"正常", data:'REGULAR'};
		public static var rsJobType2:Object = {label:"加班", data:'TEMP'};
		public static var rsJobType3:Object = {label:"紧急", data:'EMERGENCY'};
		public static var rsJobType4:Object = {label:"放空", data:'EMPTY'};
		
		public static var eventPhase1:Object = {label:"进港", data:'INBOUND'};
		public static var eventPhase2:Object = {label:"出港", data:'OUTBOUND'};
		public static var eventPhase3:Object = {label:"派车", data:'ASSIGNVECHICLE'};
		public static var eventPhase4:Object = {label:"换车", data:'CHANGEVECHICLE'};
		public static var eventPhase5:Object = {label:"发布", data:'PUBLISH'};
		public static var eventPhase6:Object = {label:"打卡", data:'PUNCH'};
		public static var eventPhase7:Object = {label:"终止", data:'TERMINATE'};
		public static var eventPhase8:Object = {label:"途中", data:'ENROUTE'};
		public static var eventPhase9:Object = {label:"取消派车", data:'CANCEL'};
		public static var eventPhase10:Object = {label:"出发无费率本", data:'NO_PRICE'};
		public static var eventPhase11:Object = {label:"到达无费率本", data:'STILL_NO_PRICE'};
		public static var eventPhase12:Object = {label:"重算无费率本", data:'PAY_NO_PRICE'};
		public static var eventPhase13:Object = {label:"缴费重算无费率本", data:'FEE_NO_PRICE'};
		public static var eventPhase14:Object = {label:"调整扫描时间", data:'ADDJUST_TIME'};
		public static var eventPhase15:Object = {label:"备注", data:'REMARK'};
		public static var eventPhase16:Object = {label:"调整经停站点", data:'ADJUST_STOP'};
		
		public static var truckReason1:Object = {label:'车辆创建', data:'TRUCK_CREATED'};
		public static var truckReason2:Object = {label:'车辆状态更改', data:'TRUCK_STATUS_UPDATED'};
		public static var truckReason3:Object = {label:'运行状态更改', data:'RUNNING_STATUS_UPDATED'};
		
		public static var year1:Object = {label:'2011年', data:'2011'};
		public static var year2:Object = {label:'2012年', data:'2012'};
		public static var year3:Object = {label:'2013年', data:'2013'};
		public static var year4:Object = {label:'2014年', data:'2014'};
		public static var year5:Object = {label:'2015年', data:'2015'};
		
		public static var month1:Object = {label:'1月', data:'01'};
		public static var month2:Object = {label:'2月', data:'02'};
		public static var month3:Object = {label:'3月', data:'03'};
		public static var month4:Object = {label:'4月', data:'04'};
		public static var month5:Object = {label:'5月', data:'05'};
		public static var month6:Object = {label:'6月', data:'06'};
		public static var month7:Object = {label:'7月', data:'07'};
		public static var month8:Object = {label:'8月', data:'08'};
		public static var month9:Object = {label:'9月', data:'09'};
		public static var month10:Object = {label:'10月', data:'10'};
		public static var month11:Object = {label:'11月', data:'11'};
		public static var month12:Object = {label:'12月', data:'12'};
		
		public static var fee1:Object = {label:'已关帐', data:'1'};
		public static var fee2:Object = {label:'未关帐 ', data:'0'};
		
		public static var feeItem1:Object = {label:'已申请', data:'1'};
		public static var feeItem2:Object = {label:'未申请 ', data:'0'};
		
		public static var expType1:Object = {label:'一般延误', data:'DELAY'};
		public static var expType2:Object = {label:'车辆故障', data:'BREAKDOWN'};
		public static var expType3:Object = {label:'交通事故', data:'TRAFFIC_ACCIDENTS'};
		public static var expType4:Object = {label:'交通事故堵车', data:'TRAFFIC'};
		public static var expType5:Object = {label:'异常天气慢行', data:'ABNORMAL_SLOW'};
		public static var expType6:Object = {label:'异常天气封道', data:'ABNORMAL_CLOSEROAD'};
		public static var expType7:Object = {label:'修路绕行', data:'ROADBYPASS'};
		public static var expType8:Object = {label:'行政（交警）执法查车', data:'TRAFFIC_CHECK'};
		public static var expType9:Object = {label:'其他', data:'OTHER'};
		
		public static var expGrade1:Object = {label:'一般', data:'E1_GENERAL'};
		public static var expGrade2:Object = {label:'紧急', data:'E2_EMERGENCY'};
		public static var expGrade3:Object = {label:'特急', data:'E3_EXPRESS'};
		
		public static var expDealStatus1:Object = {label:'未处理', data:'UNPROCESSED'};
		public static var expDealStatus2:Object = {label:'已处理', data:'PROCESSED'};
		
		public static var menuItemType1:Object = {label:'菜单',data:'NORMAL'};
		public static var menuItemType2:Object = {label:'按钮权限',data:'PERMISSION'};
		
		public static var expStatus1:Object = {label:'处理',data:'PROCESSED'};
		public static var expStatus12:Object = {label:'未处理',data:'UNPROCESSED'};
		
		public static var expirate1:Object = {label:'合同到期',data:'CONTRACT'};
		public static var expirate2:Object = {label:'保险到期',data:'INSURE'};
		
		public static var depositType1:Object = {label:'自购', data:'OWNER'};
		public static var depositType2:Object = {label:'指定购买', data:'BUY'};
		public static var depositType3:Object = {label:'以旧换新', data:'OLD2NEW'};
		
		public static var reportType1:Object = {label:'应付班车费用报表', data:'PAYMENT_ITEM'};
		public static var reportType2:Object = {label:'应收应付班车费用报表', data:'FEE_ITEM'};
		
		
		public static var payType1:Object = {label:"现金", data:'CASH'};
		public static var payType2:Object = {label:"合同", data:'CONTRACT'};
		
		public static var autoFee:Object = {label:"自动结算", data:'false'};
		public static var manualFee:Object = {label:"手工结算", data:'true'};
		
		public static var isDisposed1:Object = {label:"未处理", data:'false'};
		public static var isDisposed2:Object = {label:"已处理", data:'true'};
		
		public static var INOUTATTENCE:Object = {label:"每日考核报表", data:'INOUTATTENCE'};
		public static var DAILYTRUCKATTENCE:Object = {label:"每日班车进出港明细报表", data:'DAILYTRUCKATTENCE'};
		public static var DAILYTRUCKFEE:Object = {label:"每日车辆费用明细报表", data:'DAILYTRUCKFEE'};
		public static var DAILYTRUCKFEEITEM:Object = {label:"每日应付班车费明细报表", data:'DAILYTRUCKFEEITEM'};
		public static var NO_PRICE_JOB:Object = {label:"当日的无法生成费用的任务表", data:'NO_PRICE_JOB'};
		public static var JOBPRINT:Object = {label:"每日任务单领取报表", data:'JOBPRINT'};
		public static var TRANSAUDIT:Object = {label:"运行监控报表", data:'TRANSAUDIT'};
		public static var TRUCKBILL:Object = {label:"车辆运行对帐单", data:'TRUCKBILL'};
		public static var PLAN_ARRIVE:Object = {label:"每日计划到达日报表", data:'PLAN_ARRIVE'};
		public static var NOT_CHECK:Object = {label:"每日未考勤车辆报表", data:'NOT_CHECK'};
		public static var OPERATE_STATS:Object = {label:"每日网络班车运营情况表(仓位)", data:'OPERATE_STATS'};
		public static var PLAN_ACTUAL_ROUTE:Object = {label:"调度线路与实际线路对比表", data:'PLAN_ACTUAL_ROUTE'};
		public static var OPERATION:Object = {label:"运行报表", data:'OPERATION'};
		
		/**
		 * excel错误
		 */
		public static var NOERROR:Object = {label:"没有错误", data:"NOERROR"};
		public static var NO_DATA:Object = {label:"没有数据", data:"NO_DATA"};
		public static var TRSJOB_NULL:Object = {label:"任务单名称不能为空", data:"TRSJOB_NULL"};
		public static var TRSJOB_NOT_EXIST:Object = {label:"任务单名称在系统中不存在", data:"TRSJOB_NOT_EXIST"};
		public static var TRSJOB_NOT_PUBLISH:Object = {label:"任务单未发布", data:"TRSJOB_NOT_PUBLISH"};
		public static var SCANED_TIME_NULL:Object = {label:"扫描时间不能为空", data:"SCANED_TIME_NULL"};
		public static var SCAN_TYPE_ERROR:Object = {label:"进出港错误", data:"SCAN_TYPE_ERROR"};
		public static var SCAN_TYPE_NULL:Object = {label:"进出港不能为空", data:"SCAN_TYPE_NULL"};
		public static var POS_NULL:Object = {label:"POS不能为空", data:"POS_NULL"};
		public static var POS_NOT_EXIST:Object = {label:"POS在系统中不存在", data:"POS_NOT_EXIST"};
		public static var STOPSEQ_NULL:Object = {label:"站序不能为空", data:"STOPSEQ_NULL"};
		public static var STOPSEQ_ERROR:Object = {label:"站序错误", data:"STOPSEQ_ERROR"};
		public static var TIME_RECODE_NOT_EXIST:Object = {label:"系统中相应的考勤记录不存在", data:"TIME_RECODE_NOT_EXIST"};
		public static var ROUTE_NULL:Object = {label:"线路名称不能为空", data:"ROUTE_NULL"};
		public static var ROUTE_NOT_EXIST:Object = {label:"线路在系统中不存在", data:"ROUTE_NOT_EXIST"};
		public static var TRUCK_TYPE_NULL:Object = {label:"车型不能为空", data:"TRUCK_TYPE_NULL"};
		public static var PRICE_NULL:Object = {label:"正常结算价格不能为空", data:"PRICE_NULL"};
		public static var VENTING_PRICE_NULL:Object = {label:"放空结算价格不能为空", data:"VENTING_PRICE_NULL"};
		public static var OVERTIME_PRICE_NULL:Object = {label:"加班车结算价格不能为空", data:"OVERTIME_PRICE_NULL"};
		public static var PERIOD_START_NULL:Object = {label:"启用时间不能为空", data:"PERIOD_START_NULL"};
		
		public static function getExcelErrorList():ArrayCollection{
			return new ArrayCollection([NOERROR, NO_DATA, TRSJOB_NULL, TRSJOB_NOT_EXIST, TRSJOB_NOT_PUBLISH,
				SCANED_TIME_NULL, SCAN_TYPE_ERROR, SCAN_TYPE_NULL, POS_NULL, POS_NOT_EXIST, TIME_RECODE_NOT_EXIST,
				ROUTE_NULL, ROUTE_NOT_EXIST, TRUCK_TYPE_NULL, PRICE_NULL, VENTING_PRICE_NULL, OVERTIME_PRICE_NULL,
				PERIOD_START_NULL, STOPSEQ_NULL, STOPSEQ_ERROR]);
		}
		
		public static function getExpirateList():ArrayCollection{
			return new ArrayCollection([expirate1,expirate2]);
		}
		/**
		 * 报表类型
		 */
		public static function getReportTypeList():ArrayCollection{
			return new ArrayCollection([base,INOUTATTENCE,DAILYTRUCKATTENCE,DAILYTRUCKFEE,DAILYTRUCKFEEITEM, OPERATION,
				NO_PRICE_JOB,JOBPRINT,TRANSAUDIT,TRUCKBILL, PLAN_ARRIVE, NOT_CHECK, OPERATE_STATS, PLAN_ACTUAL_ROUTE]);
		}
		
		public static function getDailyReportTypes():ArrayCollection{
			return new ArrayCollection([INOUTATTENCE.data,DAILYTRUCKATTENCE.data,DAILYTRUCKFEE.data,DAILYTRUCKFEEITEM.data,NO_PRICE_JOB.data,JOBPRINT.data,TRANSAUDIT.data,TRUCKBILL.data]);
		}
		
		public static function getPriceReportTypes():ArrayCollection{
			return new ArrayCollection([reportType1.data,reportType2.data]);
		}
		
		public static function getOperationStateStatus():ArrayCollection{
			return new ArrayCollection([base, OperateStateStatus1, OperateStateStatus2, OperateStateStatus3, OperateStateStatus4]);
		}
		
		public static function getFeeTypes():ArrayCollection{
			return new ArrayCollection([base, autoFee,manualFee]);
		}
		
		public static function getIsDisposedType():ArrayCollection{
			return new ArrayCollection([base, isDisposed1,isDisposed2]);
		}
		
		public static function getDepositType():ArrayCollection{
			return new ArrayCollection([depositType1,depositType2,depositType3]);
		}
		
		public static function getExpDealStatus():ArrayCollection{
			return new ArrayCollection([expDealStatus1,expDealStatus2]);
		}
		
		public static function getExpGrade():ArrayCollection{
			return new ArrayCollection([expGrade1,expGrade2,expGrade3]);
		}
		
		public static function getExpType():ArrayCollection{
			return new ArrayCollection([expType1,expType2,expType3,expType4,expType5,expType6,expType7,expType8,expType9]);
		}
		
		public static function getExpGrade4list():ArrayCollection{
			return new ArrayCollection([base,expGrade1,expGrade2,expGrade3]);
		}
		
		public static function getExpType4list():ArrayCollection{
			return new ArrayCollection([base,expType1,expType2,expType3,expType4,expType5,expType6,expType7,expType8,expType9]);
		}
		
		public static function getTruckCertType():ArrayCollection{
			return new ArrayCollection([truckCertType1,truckCertType2,truckCertType3,truckCertType4,truckCertType5]);
		}
		
		public static function getCertType():ArrayCollection{
			return new ArrayCollection([certType1,certType2,certType3,certType4]);
		}
		
		public static function getAllowedTruck():ArrayCollection{
			return new ArrayCollection([allowedTruck1,allowedTruck2,allowedTruck3]);
		}
		
		public static function getDriverStatus():ArrayCollection{
			return new ArrayCollection([base,driverStatus1,driverStatus2]);
		}
		
		public static function getPriceStatus():ArrayCollection{
			return new ArrayCollection([base,priceStatus1,priceStatus2,priceStatus3]);
		}
		
		public static function getTruckLevel4list():ArrayCollection{
			return new ArrayCollection([base,truckLevel1,truckLevel2,truckLevel3]);
		}
		
		public static function getTruckType4list():ArrayCollection{
			return new ArrayCollection([base,truckType1,truckType2,truckType3,truckType4,truckType5,truckType6,truckType7,truckType8,truckType9]);
		}
		
		public static function getTruckLevel():ArrayCollection{
			return new ArrayCollection([truckLevel1,truckLevel2,truckLevel3]);
		}
		
		public static function getTruckType():ArrayCollection{
			return new ArrayCollection([truckType1,truckType2,truckType3,truckType4,truckType5,truckType6,truckType7,truckType8,truckType9]);
		}
		
		public static function getPOSType():ArrayCollection{
			return new ArrayCollection([POSType1,POSType2,POSType3]);
		}
		
		public static function getRouteStatus():ArrayCollection{
			return new ArrayCollection([base,routeStatus1,routeStatus2,routeStatus3]);
		}
		
		public static function getReportTypes():ArrayCollection{
			return new ArrayCollection([base,reportType1,reportType2]);
		}
		
		public static function getTruckRunningStatus():ArrayCollection{
			return new ArrayCollection([truckRunningStatus1,truckRunningStatus2,truckRunningStatus3,truckRunningStatus4,truckRunningStatus5]);
		}
		
		public static function getTruckStatus4list():ArrayCollection{
			return new ArrayCollection([base,truckStatus1,truckStatus2,truckStatus3,truckStatus4,truckStatus5]);
		}
		
		public static function getTruckStatus():ArrayCollection{
			return new ArrayCollection([truckStatus1,truckStatus2,truckStatus3,truckStatus4,truckStatus5]);
		}
		
		public static function getTruckResourceType():ArrayCollection{
			return new ArrayCollection([truckResourceType1,truckResourceType2,truckResourceType3]);
		}
		
		public static function getTruckResourceType4List():ArrayCollection{
			return new ArrayCollection([base,truckResourceType1,truckResourceType2,truckResourceType3]);
		}
		
		public static function getTruckReason():ArrayCollection{
			return new ArrayCollection([truckReason1,truckReason2,truckReason3]);
		}
		
		public static function getCarrierStatus4list():ArrayCollection{
			return new ArrayCollection([base,carrierStatus1,carrierStatus2,carrierStatus3,carrierStatus4]);
		}
		
		public static function getCarrierStatus():ArrayCollection{
			return new ArrayCollection([carrierStatus1,carrierStatus2,carrierStatus3,carrierStatus4]);
		}
		
		public static function getCarrierType4list():ArrayCollection{
			return new ArrayCollection([base,carrierType1,carrierType2]);
		}
		
		public static function getCarrierType():ArrayCollection{
			return new ArrayCollection([carrierType1,carrierType2]);
		}
		
		public static function getPayWay():ArrayCollection{
			return new ArrayCollection([payWay1,payWay2,payWay3]);
		}
		
		public static function getRSJobStatus():ArrayCollection{
			return new ArrayCollection([RSJobStatus1,RSJobStatus2,RSJobStatus3,RSJobStatus4,RSJobStatus5,RSJobStatus6,RSJobStatus7]);
		}
		
		public static function getRSJobStatusr4list():ArrayCollection{
			return new ArrayCollection([base,RSJobStatus1,RSJobStatus2,RSJobStatus3,RSJobStatus4,RSJobStatus5]);
		}
		public static function getRSJobStatusr4TruckRSJobDialog():ArrayCollection{
			return new ArrayCollection([base,RSJobStatus1,RSJobStatus2,RSJobStatus3,RSJobStatus4,RSJobStatus5,RSJobStatus6,RSJobStatus7]);
		}
		
		public static function getRsJobStatus4UnPlaned():ArrayCollection{
			return new ArrayCollection([base,RSJobStatus1,RSJobStatus2]);
		}
		
		public static function getExtRSJobStatusr4list():ArrayCollection{
			return new ArrayCollection([base,RSJobStatus1,RSJobStatus2,RSJobStatus3,RSJobStatus4,RSJobStatus5]);
		}
		
		public static function getExceptionRSJobStatusr4list():ArrayCollection{
			return new ArrayCollection([base,RSJobStatus3,RSJobStatus4,RSJobStatus5,RSJobStatus7]);
		}
		
		public static function getRSJobStatusr4DispatchDock():ArrayCollection{
			return new ArrayCollection([RSJobStatus1.data,RSJobStatus2.data,RSJobStatus3.data,RSJobStatus4.data,RSJobStatus5.data,RSJobStatus6.data,RSJobStatus7.data]);
		}
		
		public static function getRSJobStatusr4DispatchDockList():ArrayCollection{
			return new ArrayCollection([base,RSJobStatus1,RSJobStatus2,RSJobStatus3,RSJobStatus4,RSJobStatus5,RSJobStatus6,RSJobStatus7]);
		}
		
		public static function getRSJobStatusr4OperationTimeReport():ArrayCollection{
			return new ArrayCollection([base,RSJobStatus3,RSJobStatus4,RSJobStatus5,RSJobStatus7]);
		}

		public static function getRSJobstatus4ListFilter():ArrayCollection{
			return new ArrayCollection([RSJobStatus1.data,RSJobStatus2.data,RSJobStatus3.data,RSJobStatus4.data,RSJobStatus5.data]);
		}
		
		public static function getRSScheduleStatus():ArrayCollection{
			return new ArrayCollection([base,RSScheduleStatus1,RSScheduleStatus2,RSScheduleStatus3]);
		}
		
		public static function getCarrierCertType():ArrayCollection{
			return new ArrayCollection([carrierCertType1,carrierCertType2,carrierCertType3,carrierCertType4,carrierCertType5,carrierCertType6,carrierCertType7]);
		}
		public static function getDayType():ArrayCollection{
			return new ArrayCollection([todayDayType,tomorrowDayType,afterTomorrowDayType]);
		}
		
		public static function getLicenseType():ArrayCollection{
			return new ArrayCollection([licenseType1,licenseType2]);
		}
		
		public static function getYesNoType():ArrayCollection{
			return new ArrayCollection([yesType,noType]);
		}
		
		public static function getBooelanYesNoType():ArrayCollection{
			return new ArrayCollection([booleanYesType,booleanNoType]);
		}
		
		public static function getBooelanNoYesType():ArrayCollection{
			return new ArrayCollection([booleanNoType,booleanYesType]);
		}
		
		public static function getBooelanInOutType():ArrayCollection{
			return new ArrayCollection([booleanOutType,booleanInType]);
		}
		
		public static function getRsjobType():ArrayCollection{
			return new ArrayCollection([rsJobType1,rsJobType2,rsJobType3,rsJobType4]);
		}
		
		public static function getRsjobType4Temp():ArrayCollection{
			return new ArrayCollection([rsJobType2,rsJobType4]);
		}
		
		public static function getRsjobType4List():ArrayCollection{
			return new ArrayCollection([base,rsJobType1,rsJobType2,rsJobType3,rsJobType4])
		}
		
		public static function getEventPhase():ArrayCollection{
			return new ArrayCollection([eventPhase1,eventPhase2,eventPhase3,eventPhase4,eventPhase5,eventPhase6,eventPhase7,eventPhase8,eventPhase9,eventPhase10,eventPhase11,eventPhase12,eventPhase13,eventPhase14,eventPhase15])
		}
		
		public static function getMonth():ArrayCollection{
			return new ArrayCollection([month1,month2,month3,month4,month5,month6,month7,month8,month9,month10,month11,month12])
		}
		
		public static function getYear():ArrayCollection{
			return new ArrayCollection([year1,year2,year3,year4,year5])
		}
		
		public static function getFeeStatusType():ArrayCollection{
			return new ArrayCollection([fee1,fee2]);
		}
		
		public static function getFeeItemStatusType():ArrayCollection{
			return new ArrayCollection([feeItem1,feeItem2]);
		}
		public static function getFeeStatus():ArrayCollection{
			return new ArrayCollection([base,fee1,fee2]);
		}
		
		public static function getFeeItemStatus():ArrayCollection{
			return new ArrayCollection([base,feeItem1,feeItem2]);
		}
		
		public static function getMenuItemType():ArrayCollection{
			return new ArrayCollection([menuItemType1,menuItemType2]);
		}
		
		public static function getExpStatus():ArrayCollection{
			return new ArrayCollection([expStatus1,expStatus12]);
		}
		
		public static function getPayTypes():ArrayCollection{
			return new ArrayCollection([payType1,payType2]);
		}
		
		public static function getCashPayTypes():ArrayCollection{
			return new ArrayCollection([payType1]);
		}
		
		public static function getTruckPro():ArrayCollection{
			return new ArrayCollection([base,truckPro1,truckPro2,truckPro3]);
		}
		
		public static function getDisplayText(val:String,arrs:ArrayCollection):String{
			for each(var obj:Object in arrs){
				if(obj.data == val){
					return obj.label;
				}
			}
			return val;
		}
		
		public static function getSelectedIndex(val:String,arrs:ArrayCollection):int{
			for(var dex:int=0;dex<arrs.length;dex++){
				var obj:Object = arrs[dex];
				if(obj.data == val){
					return dex;
				}
			}
			return -1;
		}
		
		public static function getTypes4RsJobList():ArrayCollection{
			var retList:ArrayCollection = new ArrayCollection;
			retList.addItem(rsJobType3.data);
			return retList;
		}

		public static function getMenuItemTypeList():ArrayCollection{
			return new ArrayCollection([menuItemType1,menuItemType2]);
		}
		
		public static function getAllTypes4RsJobList():ArrayCollection{
			var retList:ArrayCollection = new ArrayCollection;
			retList.addItem(rsJobType1.data);
			retList.addItem(rsJobType2.data);
			retList.addItem(rsJobType3.data);
			retList.addItem(rsJobType4.data);
			return retList;
		}
	}
}