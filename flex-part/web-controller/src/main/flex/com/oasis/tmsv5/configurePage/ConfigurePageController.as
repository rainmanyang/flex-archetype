package com.oasis.tmsv5.configurePage
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class ConfigurePageController extends BaseController
	{
		public function ConfigurePageController()
		{
			super();
		}
		[Inject( source="configurePageServiceFacade" )]
		public var configurePageService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function getAllPages(allPages:ArrayCollection,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( configurePageService.getAllPages(clientContext),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(allPages,result);
					if(callback != null) {
						callback();
					}
				});
		}
		public function getCheckedPages(id:Number,checkedPages:ArrayCollection,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( configurePageService.getCheckedPages(clientContext,id),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(checkedPages,result);
					if(callback != null) {
						callback();
					}
				});
		}
		public function getCheckedPagesByAccountId(checkedPages:ArrayCollection,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( configurePageService.getCheckedPagesByAccountId(clientContext,clientContext.accountId),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(checkedPages,result);
					if(callback != null) {
						callback(result);
					}
				});
		}
	}
}