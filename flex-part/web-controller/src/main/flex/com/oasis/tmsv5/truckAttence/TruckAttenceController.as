package com.oasis.tmsv5.truckAttence
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.truckAttence.TruckAttenceSO;
	
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class TruckAttenceController extends BaseController
	{
		[Inject( source="truckAttenceServiceFacade" )]
		public var truckAttenceService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		public function TruckAttenceController()
		{
			super();
		}
		public function getPageList(so:TruckAttenceSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckAttenceService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var result:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,result);
					if(callback != null) {
						callback();
					}
				});
		}
		public function export(so:TruckAttenceSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckAttenceService.export(clientContext,so),
				function(event:ResultEvent):void{
					var result:String = event.result as String;
					if(callback != null) {
						callback(result);
					}
				});
		}
	}
}