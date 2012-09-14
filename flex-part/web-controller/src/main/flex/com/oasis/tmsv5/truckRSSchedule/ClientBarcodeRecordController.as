package com.oasis.tmsv5.truckRSSchedule
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.so.truckRSSchedule.ClientBarcodeRecordSO;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class ClientBarcodeRecordController extends BaseController
	{
		[Inject( source="clientBarcodeRecordServiceFacade" )]
		public var clientBarcodeRecordService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function ClientBarcodeRecordController(){
			super();
		}
		
		public function getPageList(so:ClientBarcodeRecordSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( clientBarcodeRecordService.getPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
	}
}