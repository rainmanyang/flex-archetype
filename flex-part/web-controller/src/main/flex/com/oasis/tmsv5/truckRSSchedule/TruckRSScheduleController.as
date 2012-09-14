package com.oasis.tmsv5.truckRSSchedule
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.security.ModelLocator;
	import com.oasis.wolfburg.so.truckRSSchedule.TruckRSScheduleSO;
	import com.oasis.wolfburg.vo.truckRSSchedule.TruckRSSchedule;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class TruckRSScheduleController extends BaseController
	{
		[Inject( source="truckRSScheduleServiceFacade" )]
		public var truckRSScheduleService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function TruckRSScheduleController(){
			super();
		}
		
		public function getPageList(so:TruckRSScheduleSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSScheduleService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		
	
		
		public function find(vo:TruckRSSchedule,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSScheduleService.findTruckRSSchedule(clientContext,vo.id),
				function(event:ResultEvent):void{
					var rss:TruckRSSchedule = event.result as TruckRSSchedule;
					BeanUtils.copyProperties(vo,rss);
					if(callback != null) {
						callback(vo);
					}
				});
		}
		
		public function create(truck:TruckRSSchedule,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSScheduleService.createTruckRSSchedule(clientContext,truck),
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
		
		public function update(truckRSSchedule:TruckRSSchedule,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSScheduleService.updateTruckRSSchedule(clientContext,truckRSSchedule),
				function(event:ResultEvent):void{
					var result:TruckRSSchedule = event.result as TruckRSSchedule;
					BeanUtils.copyProperties(truckRSSchedule,result);
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
			serviceHelper.executeSimpleCall( truckRSScheduleService.removeTruckRSSchedule(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function updateStatus(ids:ArrayCollection,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSScheduleService.updateStatus(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function close(truckRSS:TruckRSSchedule,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSScheduleService.close(clientContext,truckRSS),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		public function open(truckRSS:TruckRSSchedule,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSScheduleService.open(clientContext,truckRSS),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
	}
}