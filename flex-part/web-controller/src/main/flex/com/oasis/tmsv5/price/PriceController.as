package com.oasis.tmsv5.price
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.price.PriceSO;
	import com.oasis.wolfburg.vo.excel.ExcelParsePackageVO;
	import com.oasis.wolfburg.vo.price.Price;
	
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class PriceController extends BaseController{
		[Inject( source="priceServiceFacade" )]
		public var priceService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function PriceController(){
			super();
		}
		
		public function getPageList(so:PriceSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:Price,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.find(clientContext,vo.id),
				function(event:ResultEvent):void{
					var price:Price = event.result as Price;
					BeanUtils.copyProperties(vo,price);
					if(callback != null) {
						callback();
					}
				});
		}
	
		/**
		 * 
		 *创建price
		 * 
		 */
		public function create(price:Price,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.create(clientContext,price),
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
		
		/**
		 * 费率本延期
		 */
		public function delayPrice(price:Price,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.delayPrice(clientContext,price),
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
		
		/**
		 * 费率本编辑
		 */
		public function editPrice(price:Price,callback:Function,faultCallBack:Function) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.editPrice(clientContext,price),
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
		
		public function updateStatus(ids:ArrayCollection,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.updateStatus(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function delay(ids:ArrayCollection,days:Number) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.delay(clientContext,ids,days),
				function(event:ResultEvent):void{
				});
		}
		/**
		 * 批量导入
		 */
		public function batchImport(data:ByteArray,callback:Function=null, failCallBack:Function = null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.batchImport(clientContext,data),
				function(event:ResultEvent):void{
					var rst:ExcelParsePackageVO=event.result as ExcelParsePackageVO;
					if(callback != null) {
						callback(rst);
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null) {
						failCallBack(event);
					}
				});
		}
		public function export(so:PriceSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( priceService.export(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				});
		}
	}
}