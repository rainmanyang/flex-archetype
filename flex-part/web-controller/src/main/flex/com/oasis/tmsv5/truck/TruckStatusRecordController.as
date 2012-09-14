package com.oasis.tmsv5.truck
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.security.ModelLocator;
	import com.oasis.wolfburg.so.truck.TruckStatusRecordSO;
	import com.oasis.wolfburg.vo.truck.TruckStatusRecord;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class TruckStatusRecordController extends BaseController
	{
		[Inject( source="truckStatusRecordServiceFacade" )]
		public var truckStatusRecordService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function TruckStatusRecordController(){
			super();
		}
		
		public function getPageList(so:TruckStatusRecordSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckStatusRecordService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:TruckStatusRecord,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckStatusRecordService.find(clientContext,vo.id),
				function(event:ResultEvent):void{
					var truckStatusRecord:TruckStatusRecord = event.result as TruckStatusRecord;
					BeanUtils.copyProperties(vo,truckStatusRecord);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建truckStatusRecord
		 * 
		 */
		public function create(truckStatusRecord:TruckStatusRecord,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckStatusRecordService.create(clientContext,truckStatusRecord),
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
		
		public function update(truckStatusRecord:TruckStatusRecord,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckStatusRecordService.update(clientContext,truckStatusRecord),
				function(event:ResultEvent):void{
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
			serviceHelper.executeSimpleCall( truckStatusRecordService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
	}
}