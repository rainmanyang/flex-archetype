package com.oasis.tmsv5.carrier
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.wolfburg.so.carrier.CarrierSO;
	import com.oasis.wolfburg.vo.carrier.Carrier;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class CarrierController extends BaseController
	{
		[Inject( source="carrierServiceFacade" )]
		public var carrierService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function CarrierController(){
			super();
		}
		
		public function getPageList(so:CarrierSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( carrierService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function findCarrier(carrierVO:Carrier,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( carrierService.findCarrier(clientContext,carrierVO.id),
				function(event:ResultEvent):void{
					var carrier:Carrier = event.result as Carrier;
					BeanUtils.copyProperties(carrierVO,carrier);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建carrier
		 * 
		 */
		public function createCarrier(carrierVO:Carrier,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( carrierService.createCarrier(clientContext,carrierVO),
				function(event:ResultEvent):void{
					if(successCallback != null) {
						carrierVO.id=event.result as Number;
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		public function updateCarrier(carrierVO:Carrier,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( carrierService.updateCarrier(clientContext,carrierVO),
				function(event:ResultEvent):void{
					var carrier:Carrier = event.result as Carrier;
					BeanUtils.copyProperties(carrierVO,carrier);
					if(callback != null) {
						callback();
					}
				},function(event:FaultEvent):void{
					if(faultCallBack != null) {
						faultCallBack(event);
					}
				});
		}
		
		public function batchUpdateCarrierStatus(idList:ArrayCollection,carrierStatus:String,callback:Function = null): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( carrierService.batchUpdateCarrierStatus(clientContext,idList,carrierStatus),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
	}
}