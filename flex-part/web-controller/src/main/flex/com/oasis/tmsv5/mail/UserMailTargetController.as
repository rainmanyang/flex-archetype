package com.oasis.tmsv5.mail
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.mail.UserMailTargetSO;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class UserMailTargetController extends BaseController
	{
		public function UserMailTargetController()
		{
			super();
		}
		[Inject( source="userMailTargetServiceFacade" )]
		public var userMailTargetService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function getPageList(so:UserMailTargetSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( userMailTargetService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var result:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,result);
					if(callback != null) {
						callback();
					}
				});
		}
		/**
		 * 批量保存
		 */
		public function batchUpdate(list:ArrayCollection,successCallback:Function = null,failCallBack:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( userMailTargetService.batchUpdate(clientContext,list),
				function(event:ResultEvent):void{
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				});
		}
	}
}