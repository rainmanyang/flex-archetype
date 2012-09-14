package com.oasis.tmsv5.base
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.price.PriceSO;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.vo.base.PredefinedCode;
	import com.oasis.wolfburg.so.predefinedCode.PredefinedCodeSO;
	import com.oasis.wolfburg.vo.price.Price;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class PredefinedCodeController extends BaseController{
		[Inject( source="predefinedCodeServiceFacade" )]
		public var predefinedCodeService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function PredefinedCodeController(){
			super();
		}
		
		public function findByCode(code:String,predefinedCode:PredefinedCode,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( predefinedCodeService.getPredefinedCodesByCode(clientContext,code),
				function(event:ResultEvent):void{
					var result:PredefinedCode = event.result as PredefinedCode;
					BeanUtils.copyProperties(predefinedCode,result);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function findByType4MainReceivableBill(list:ArrayCollection,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( predefinedCodeService.getPredefinedCodesByType4MainReceivableBill(clientContext),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(list,result);
					if(callback != null) {
						callback();
					}
				});
		}
		public function findByType4ExceptionReceivableBill(list:ArrayCollection,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( predefinedCodeService.getPredefinedCodesByType4ExceptionReceivableBill(clientContext),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(list,result);
					if(callback != null) {
						callback();
					}
				});
		}
		
		
		public function findByType4OtherReceivableBill(list:ArrayCollection,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( predefinedCodeService.getPredefinedCodesByType4OtherReceivableBill(clientContext),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(list,result);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function findByType4AllReceivableBill(list:ArrayCollection,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( predefinedCodeService.getPredefinedCodesByType4AllReceivableBill(clientContext),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(list,result);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function create(predefinedCode:PredefinedCode,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( predefinedCodeService.create(clientContext,predefinedCode),
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
		
		public function queryPredefinedCodes(list:ArrayCollection,so:PredefinedCodeSO,callback:Function = null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( predefinedCodeService.queryPredefinedCodes(clientContext,so),
				function(event:ResultEvent):void{
					var result:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(list,result);
					if(callback != null) {
						callback();
					}
				});
		}
	}
}