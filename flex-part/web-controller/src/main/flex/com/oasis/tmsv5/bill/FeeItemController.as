package com.oasis.tmsv5.bill
{
	import com.adobe.serialization.json.JSON;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.bill.FeeItemSO;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.vo.bill.FeeItem;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class FeeItemController extends BaseController
	{
		[Inject( source="feeItemServiceFacade" )]
		public var feeItemService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function FeeItemController(){
			super();
		}
		
		public function getPageList(so:FeeItemSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.getPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		public function export(so:FeeItemSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.export(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				});
		}
		
		public function export4FeeCompare(so:FeeItemSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.export4FeeCompare(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				});
		}
		
		public function getPageList4Report(so:FeeItemSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.getPageList4Report(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:FeeItem,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.findView(clientContext,vo.id),
				function(event:ResultEvent):void{
					var feeItem:FeeItem = event.result as FeeItem;
					BeanUtils.copyProperties(vo,feeItem);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建feeItem
		 * 
		 */
		public function create(feeItem:FeeItem,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.create(clientContext,feeItem),
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
		
		public function update(feeItem:FeeItem,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.update(clientContext,feeItem),
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
		
		public function remove(ids:Array,callback:Function,faultCallBack:Function) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.remove(clientContext,ids),
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
		
		public function exportToExcel(so:FeeItemSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.exportToExcel(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				});
		}
		
		public function batchUpdateFlag(so:FeeItemSO,flag:String,reportId:Number, callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.batchUpdateFlag(clientContext,so,flag, reportId),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		/**
		 * 费用重算
		 */
		public function reCost(so:FeeItemSO,pageNum:int, pageSize:int,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.reCost(clientContext,so),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback(pageNum,pageSize);
					}
				});
		}
		/**
		 * 费用重算
		 */
		public function doReCost(feeitem:FeeItem,pageNum:int, pageSize:int,callback:Function = null, failCallBack:Function=null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( feeItemService.doReCost(clientContext,feeitem),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback(pageNum,pageSize);
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null) {
						failCallBack(event);
					}
				});
		}
		
		
	}
}