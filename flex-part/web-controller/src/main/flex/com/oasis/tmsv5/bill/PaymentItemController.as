package com.oasis.tmsv5.bill
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.bill.PaymentItemSO;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.vo.bill.PaymentItem;
	import com.oasis.wolfburg.vo.truckRSSchedule.TruckRSJob;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class PaymentItemController extends BaseController
	{
		[Inject( source="paymentItemServiceFacade" )]
		public var paymentItemService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function PaymentItemController(){
			super();
		}
		
		public function getPageList(so:PaymentItemSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.getPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		public function export(so:PaymentItemSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.export(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				});
		}
		public function getPageList4Report(so:PaymentItemSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.getPageList4Report(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:PaymentItem,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.findView(clientContext,vo.id),
				function(event:ResultEvent):void{
					var paymentItem:PaymentItem = event.result as PaymentItem;
					BeanUtils.copyProperties(vo,paymentItem);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建paymentItem
		 * 
		 */
		public function create(paymentItem:PaymentItem,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.create(clientContext,paymentItem),
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
		
		public function update(paymentItem:PaymentItem,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.update(clientContext,paymentItem),
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
			serviceHelper.executeSimpleCall( paymentItemService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function exportToExcel(so:PaymentItemSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.exportToExcel(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				},function(event:FaultEvent):void{
					Alert.show(event.fault.faultString);
				});
		}
		
		public function batchUpdateFlag(so:PaymentItemSO,flag:String,reportId:Number,callback:Function = null,failCallBack:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.batchUpdateFlag(clientContext,so,flag,reportId),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				});
		}
		public function checkApply(reportId:Number,mark:Boolean,data:Object,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.checkApply(clientContext,reportId),
				function(event:ResultEvent):void{
					var result:Boolean = event.result as Boolean;
					mark = result;
					if(callback != null) {
						callback(mark,data);
					}
				});
		}
		
		public function createByTruckrsjob(truckRsjob:TruckRSJob,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.createByTruckrsjob(clientContext,truckRsjob),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		/**
		 * 费率重算
		 */
		public function reCost(so:PaymentItemSO,pageNum:int, pageSize:int,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.reCost(clientContext,so),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback(pageNum, pageSize);
					}
				});
		}
		/**
		 * 费率重算
		 */
		public function doReCost(paymentItem:PaymentItem,pageNum:int, pageSize:int,callback:Function = null, failCallBack:Function=null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( paymentItemService.doReCost(clientContext,paymentItem),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback(pageNum, pageSize);
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				});
		}
	}
}