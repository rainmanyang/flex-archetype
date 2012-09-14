package com.oasis.tmsv5.driver
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.driver.DriverSO;
	import com.oasis.wolfburg.vo.driver.Driver;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class DriverController extends BaseController{
		[Inject( source="driverServiceFacade" )]
		public var DriverService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function DriverController(){
			super();
		}
		
		public function getPageList(so:DriverSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( DriverService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:Driver,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( DriverService.find(clientContext,vo.id),
				function(event:ResultEvent):void{
					var driver:Driver = event.result as Driver;
					BeanUtils.copyProperties(vo,driver);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建司机
		 * 
		 */
		public function create(driver:Driver,files:ArrayCollection,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( DriverService.create(clientContext,driver,files),
				function(event:ResultEvent):void{
					if(successCallback != null) {
						driver.id=event.result as Number;
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		public function update(driver:Driver,files:ArrayCollection,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( DriverService.update(clientContext,driver,files),
				function(event:ResultEvent):void{
					driver.lockVersion++;
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
		 * 
		 *司机状态:冻结
		 * 
		 */
		public function updateStatus(ids:ArrayCollection,status:String,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( DriverService.updateStatus(clientContext,ids,status),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
	}
}