package com.oasis.tmsv5.insure
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.security.ModelLocator;
	import com.oasis.wolfburg.so.insure.InsureSO;
	import com.oasis.wolfburg.vo.insure.Insure;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class InsureController extends BaseController
	{
		[Inject( source="insureServiceFacade" )]
		public var insureService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function InsureController(){
			super();
		}
		
		public function getPageList(so:InsureSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( insureService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:Insure,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( insureService.find(clientContext,vo.id),
				function(event:ResultEvent):void{
					var insure:Insure = event.result as Insure;
					BeanUtils.copyProperties(vo,insure);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建insure
		 * 
		 */
		public function create(insure:Insure,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( insureService.create(clientContext,insure),
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
		
		public function update(insure:Insure,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( insureService.update(clientContext,insure),
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
			serviceHelper.executeSimpleCall( insureService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
	}
}