package com.oasis.tmsv5.truck
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.wolfburg.so.truck.TruckSO;
	import com.oasis.wolfburg.vo.truck.Truck;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class TruckController extends BaseController
	{
		[Inject( source="truckServiceFacade" )]
		public var truckService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function TruckController(){
			super();
		}
		
		public function getPageList(so:TruckSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function findTruck(vo:Truck,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.findTruck(clientContext,vo.id),
				function(event:ResultEvent):void{
					var truck:Truck = event.result as Truck;
					BeanUtils.copyProperties(vo,truck);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建truck
		 * 
		 */
		public function createTruck(truck:Truck,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.createAllTruckInfo(clientContext,truck),
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
		
		public function createTempTruck(truck:Truck,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.createTempTruck(clientContext,truck),
				function(event:ResultEvent):void{
					var truckId:Number = event.result as Number;
					if(successCallback != null) {
						successCallback(truckId);
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		public function updateTempTruck(vo:Truck,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.updateTempTruck(clientContext,vo),
				function(event:ResultEvent):void{
					var truck:Truck = event.result as Truck;
					BeanUtils.copyProperties(vo,truck);
					if(callback != null) {
						callback();
					}
				},function(event:FaultEvent):void{
					if(faultCallBack != null) {
						faultCallBack(event);
					}
				});
		}
		
		public function updateTruck(vo:Truck,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.updateAllTruckInfo(clientContext,vo),
				function(event:ResultEvent):void{
					var truck:Truck = event.result as Truck;
					BeanUtils.copyProperties(vo,truck);
					if(callback != null) {
						callback();
					}
				},function(event:FaultEvent):void{
					if(faultCallBack != null) {
						faultCallBack(event);
					}
				});
		}
		
		public function batchUpdateTruckStatus(idList:ArrayCollection,truckStatus:String,callback:Function = null): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.batchUpdateTruckStatus(clientContext,idList,truckStatus),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function removeTruck(ids:ArrayCollection,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.removeTruck(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function updateRunningStatus(truck:Truck,desc:String,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.updateRunningStatus(clientContext,truck,desc),
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
		
		public function updateTruckStatus(truck:Truck,desc:String,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.updateTruckStatus(clientContext,truck,desc),
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
		
		public function updateResourceType(truck:Truck,desc:String,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.updateResourceType(clientContext,truck,desc),
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
		
		public function getPopPageList(so:TruckSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.getPopPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getExpiratePageList(so:TruckSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.getExpiratePageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *truck
		 * 
		 */
		public function updateTruckRouteRelation(truck:Truck,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.updateTruckRouteRelation(clientContext,truck),
				function(event:ResultEvent):void{
					var truck:Truck = event.result as Truck;
					BeanUtils.copyProperties(truck,truck);
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		/**
		 * 
		 *truck
		 * 
		 */
		public function updateContactPhone(truck:Truck,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckService.updateTruckContactPhone(clientContext,truck),
				function(event:ResultEvent):void{
					var truck:Truck = event.result as Truck;
					BeanUtils.copyProperties(truck,truck);
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
	}
}