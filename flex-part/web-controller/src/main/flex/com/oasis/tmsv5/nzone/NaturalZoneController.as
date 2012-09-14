package com.oasis.tmsv5.nzone
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.customer.CustomerSO;
	import com.oasis.tmsv5.so.nzone.NaturalZoneSO;
	import com.oasis.security.ModelLocator;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class NaturalZoneController extends BaseController
	{
		[Inject( source="nzoneServiceFacade" )]
		public var nzoneService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function NaturalZoneController(){
			super();
		}
		
		public function getPageList(so:CustomerSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( nzoneService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getNZoneTree(so:NaturalZoneSO,callback:Function=null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( nzoneService.getNZoneTree(clientContext,so),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
			
		}
		
		public function getCheckedNaturalZoneByOrg(id:Number ,callback:Function=null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( nzoneService.getCheckedNaturalZoneByOrg(clientContext,id),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getNaturalZoneByParent(id:Number,dp:ArrayCollection ,callback:Function=null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( nzoneService.getNZoneByParent(clientContext,id),
				function(event:ResultEvent):void{
					dp.removeAll();
					dp.addAll(event.result as ArrayCollection);
					if(callback != null) {
						callback();
					}
				});
		}
		
	}
}