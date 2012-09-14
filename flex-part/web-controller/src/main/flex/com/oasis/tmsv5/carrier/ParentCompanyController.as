package com.oasis.tmsv5.carrier
{
	import com.oasis.component.page.PageList;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.security.ModelLocator;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.so.carrier.ParentCompanySO;
	import com.oasis.wolfburg.vo.carrier.ParentCompany;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class ParentCompanyController extends BaseController
	{
		[Inject( source="parentCompanyServiceFacade" )]
		public var parentCompanyService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function ParentCompanyController(){
			super();
		}
		
		public function getPageList(so:ParentCompanySO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( parentCompanyService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:ParentCompany,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( parentCompanyService.find(clientContext,vo.id),
				function(event:ResultEvent):void{
					var parentCompany:ParentCompany = event.result as ParentCompany;
					BeanUtils.copyProperties(vo,parentCompany);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建parentCompany
		 * 
		 */
		public function create(parentCompany:ParentCompany,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( parentCompanyService.create(clientContext,parentCompany),
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
		
		public function update(parentCompany:ParentCompany,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( parentCompanyService.update(clientContext,parentCompany),
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
			serviceHelper.executeSimpleCall( parentCompanyService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
	}
}