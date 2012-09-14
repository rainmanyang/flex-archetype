package com.oasis.tmsv5.truckRSSchedule
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.utils.BeanUtils;
	import com.oasis.utils.DateFormatterUtil;
	import com.oasis.wolfburg.so.truckRSSchedule.StopRSJobSO;
	import com.oasis.wolfburg.so.truckRSSchedule.TruckRSJobSO;
	import com.oasis.wolfburg.vo.route.Stop;
	import com.oasis.wolfburg.vo.truck.Truck;
	import com.oasis.wolfburg.vo.truckRSSchedule.TruckRSJob;
	
	import mx.collections.ArrayCollection;
	import mx.formatters.DateFormatter;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class TruckRSJobController extends BaseController
	{
		[Inject( source="truckRSJobServiceFacade" )]
		public var truckRSJobService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function TruckRSJobController(){
			super();
		}
		
		public function getTruckRSJobList(so:TruckRSJobSO,pageList:ArrayCollection,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.getTruckRSJobListBySO(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:ArrayCollection = event.result as ArrayCollection;
					pageList.removeAll();
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getTruckRSJobPageList(so:TruckRSJobSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					if(tpageList.list != null){
						for each(var item:TruckRSJob in tpageList.list){
							item.formatSDate = DateFormatterUtil.format6(item.startDate);
							item.weekDay = DateFormatterUtil.weekDay(item.startDate.day);
						}
						BeanUtils.copyProperties(pageList,tpageList);
						if(callback != null) {
							callback();
						}
					}
				});
		}
		
		public function find(vo:TruckRSJob,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.findTruckRSJob(clientContext,vo.id),
				function(event:ResultEvent):void{
					var truck:TruckRSJob = event.result as TruckRSJob;
					BeanUtils.copyProperties(vo,truck);
					if(callback != null) {
						callback(truck);
					}
				});
		}
		
		public function create(truck:TruckRSJob,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.createTruckRSJob(clientContext,truck),
				function(event:ResultEvent):void{
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		public function assignTruck2RSJob(job:TruckRSJob,callback:Function,faultCallBack:Function=null): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.assignTruck2RSJob(clientContext,job),
				function(event:ResultEvent):void{
					var retJob:TruckRSJob = event.result as TruckRSJob;
					retJob.formatSDate = DateFormatterUtil.format1(retJob.startDate);
					retJob.weekDay = DateFormatterUtil.weekDay(retJob.startDate.day);
					BeanUtils.copyProperties(job,retJob);
					if(callback != null) {
						callback();
					}
				},function(event:FaultEvent):void{
					if(faultCallBack != null) {
						faultCallBack(event);
					}
				});
		}
		
		
		public function remove(ids:ArrayCollection,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.removeTruckRSJob(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function changeTruck(vo:TruckRSJob,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.changeJobTruck(clientContext,vo),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		
		public function publish(list:Array,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.publish(clientContext,list),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getCalendarByRs(job:Number,list:ArrayCollection,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.getCalendarByRs(clientContext,job),
				function(event:ResultEvent):void{
					var tempjob:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(list,tempjob);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function terminatJob(job:TruckRSJob,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.terminatJob(clientContext,job.id),
				function(event:ResultEvent):void{
					var tempjob:TruckRSJob = event.result as TruckRSJob;
					tempjob.formatSDate = DateFormatterUtil.format1(tempjob.startDate);
					tempjob.weekDay = DateFormatterUtil.weekDay(tempjob.startDate.day);
					BeanUtils.copyProperties(job,tempjob);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function cancleJob(job:TruckRSJob,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.cancleJob(clientContext,job.id),
				function(event:ResultEvent):void{
					var tempjob:TruckRSJob = event.result as TruckRSJob;
					tempjob.formatSDate = DateFormatterUtil.format1(tempjob.startDate);
					tempjob.weekDay = DateFormatterUtil.weekDay(tempjob.startDate.day);
					BeanUtils.copyProperties(job,tempjob);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function addTempTruckRsJob(job:TruckRSJob,stops:ArrayCollection,callback:Function = null,failcallback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.generateTempTruckRSJob(clientContext,job,stops),
				function(event:ResultEvent):void{
					var tempjob:TruckRSJob = event.result as TruckRSJob;
					if(callback != null) {
						callback(tempjob);
					}
			},function(event:FaultEvent):void {
				if(failcallback != null){
					failcallback(event);
				}
			});
		}
		
		public function addEmTruckRsJob(job:TruckRSJob,callback:Function = null,failcallback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.generateEmergentTruckRSJob(clientContext,job),
				function(event:ResultEvent):void{
					var tempjob:TruckRSJob = event.result as TruckRSJob;
					tempjob.formatSDate = DateFormatterUtil.format1(tempjob.startDate);
					tempjob.weekDay = DateFormatterUtil.weekDay(tempjob.startDate.day);
					if(callback != null) {
						callback(tempjob);
					}
			},function(event:FaultEvent):void {
				if(failcallback != null){
					failcallback(event);
				}
			});
		}
		
		
		public function batchArriavlRSJob(list:Array,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.batchArriavlRSJob(clientContext,list),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
			});
		}
		public function arriavlRSJobById(id:Number, pageNum:int, pageSize:int,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.arriavlRSJobById(clientContext,id),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback(pageNum,pageSize);
					}
			});
		}
		
		public function getStopsByTimeRecordAndTruckrsJobId(id:Number,stops:ArrayCollection,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.getStopsByTimeRecordAndTruckrsJobId(clientContext,id),
				function(event:ResultEvent):void{
					var retStops:ArrayCollection = event.result as ArrayCollection;
					for each(var elm:Stop in retStops){
						if(elm.arrivalDate != null){
							elm.arrivalText = DateFormatterUtil.format2(elm.arrivalDate);
						}
						if(elm.leaveDate != null){
							elm.leaveText = DateFormatterUtil.format2(elm.leaveDate);
						}
					}
					BeanUtils.copyProperties(stops,retStops);
					if(callback != null) {
						callback();
					}
			});
		}
		
		/**
		 * 批量派车
		 */ 
		public function batchArrange(rsList:ArrayCollection,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.batchArrange(clientContext,rsList),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
			});
		}
		
		public function getRsJobByScheduleAfterYesterday(scheculeId:Number,rsjobList:ArrayCollection,callback:Function = null):void {
			serviceHelper.executeSimpleCall(truckRSJobService.getRsJobByScheduleAfterYesterday(clientContext,scheculeId),
				function(event:ResultEvent):void{
					var ret:ArrayCollection = event.result as ArrayCollection;
					for each(var elm:TruckRSJob in ret){
						elm.formatSDate = DateFormatterUtil.format1(elm.startDate);
						elm.weekDay = DateFormatterUtil.weekDay(elm.startDate.day);
					}
					BeanUtils.copyProperties(rsjobList,ret);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function cancelArrange(rsjobList:Array,callback:Function = null):void {
			serviceHelper.executeSimpleCall(truckRSJobService.cancelArrange(clientContext,rsjobList),
				function(event:ResultEvent):void{
					if(callback != null){
						callback();
					}
				});
		}
		
		public function checkIfCanCharge(truckrsjob:TruckRSJob,callback:Function = null):void {
			serviceHelper.executeSimpleCall(truckRSJobService.checkIfCanCharge(clientContext,truckrsjob),
				function(event:ResultEvent):void{
					var flag:Boolean = event.result as Boolean;
					if(callback != null){
						callback(flag);
					}
				});
		}
		
		public function getStopTruckJobView(so:StopRSJobSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.getStopTruckJobView(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getAlreadyUsedRsJobBySchedule(scheculeId:Number,rsjobList:ArrayCollection,callback:Function = null):void {
			serviceHelper.executeSimpleCall(truckRSJobService.getAlreadyUsedRsJobBySchedule(clientContext,scheculeId),
				function(event:ResultEvent):void{
					var ret:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(rsjobList,ret);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function removeStopOnJob(jobId:Number,posIds:ArrayCollection,callback:Function = null):void {
			serviceHelper.executeSimpleCall(truckRSJobService.removeStopOnJob(clientContext,jobId,posIds),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getStopsByJob(jobId:Number,callback:Function = null):void {
			serviceHelper.executeSimpleCall(truckRSJobService.getStopsByJob(clientContext,jobId),
				function(event:ResultEvent):void{
					var ret:ArrayCollection = event.result as ArrayCollection;
					if(callback != null) {
						callback(ret);
					}
				});
		}
		
		public function getExceptionalPageList(so:TruckRSJobSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.getExceptionalPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function batchCloselExceptionalRSJob(list:Array,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.batchCloselExceptionalRSJob(clientContext,list),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function updateJob4realRoute(job:TruckRSJob,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobService.updateJob4realRoute(clientContext,job),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
	}
}