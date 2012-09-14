package com.oasis.tmsv5.customer
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.customer.CustomerSO;
	import com.oasis.utils.BeanUtils;
	
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class CustomerController extends BaseController
	{
		[Inject( source="customerServiceFacade" )]
		public var customerService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function CustomerController(){
			super();
		}
		
		public function getPageList(so:CustomerSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( customerService.getPagelist(clientContext,so),
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