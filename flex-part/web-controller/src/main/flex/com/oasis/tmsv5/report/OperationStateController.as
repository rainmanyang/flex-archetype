package com.oasis.tmsv5.report
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.wolfburg.so.report.OperationStateSO;
	
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class OperationStateController extends BaseController
	{
		[Inject( source="operationStateServiceFacade" )]
		public var operationStateService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		public function OperationStateController()
		{
			super();
		}
		
		public function getPageList(so:OperationStateSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( operationStateService.getPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function export(so:OperationStateSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( operationStateService.export(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				});
		}
	}
}