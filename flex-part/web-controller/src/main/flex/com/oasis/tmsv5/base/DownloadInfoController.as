package com.oasis.tmsv5.base
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.base.DownloadInfoSO;
	import com.oasis.tmsv5.so.route.PosSO;
	import com.oasis.tmsv5.vo.base.DownloadInfo;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.so.carrier.CarrierSO;
	import com.oasis.wolfburg.so.route.RouteSO;
	import com.oasis.wolfburg.so.truck.TruckSO;
	import com.oasis.wolfburg.so.truckRSSchedule.TruckRSScheduleSO;
	
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class DownloadInfoController extends BaseController
	{
		[Inject( source="downloadInfoServiceFacade" )]
		public var downloadInfoService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function DownloadInfoController(){
			super();
		}
		
		public function getPageList(so:DownloadInfoSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.getPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function updateOpened(downloadInfo:DownloadInfo,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.update(clientContext,downloadInfo),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function exportPos(so:PosSO,callback:Function,faultCallBack:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.ExportPos(clientContext,so),
				function(event:ResultEvent):void{
					var url:String = event.result as String;
					if(callback != null) {
						callback(url);
					}
				});
		}
		
		public function exportRoute(so:RouteSO,callback:Function,faultCallBack:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.ExportRoute(clientContext,so),
				function(event:ResultEvent):void{
					var url:String = event.result as String;
					if(callback != null) {
						callback(url);
					}
				});
		}
		public function exportTruckrsSchedule(so:TruckRSScheduleSO,callback:Function,faultCallBack:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.exportTruckrsSchedule(clientContext,so),
				function(event:ResultEvent):void{
					var url:String = event.result as String;
					if(callback != null) {
						callback(url);
					}
				});
		}
		public function exportCarrier(so:CarrierSO,callback:Function,faultCallBack:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.ExportCarrier(clientContext,so),
				function(event:ResultEvent):void{
					var url:String = event.result as String;
					if(callback != null) {
						callback(url);
					}
				});
		}
		public function exportTruck(so:TruckSO,callback:Function,faultCallBack:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.exportTruck(clientContext,so),
				function(event:ResultEvent):void{
					var url:String = event.result as String;
					if(callback != null) {
						callback(url);
					}
				});
		}
		public function exportTruckExpiration(so:TruckSO,callback:Function,faultCallBack:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( downloadInfoService.exportTruckExpiration(clientContext,so),
				function(event:ResultEvent):void{
					var url:String = event.result as String;
					if(callback != null) {
						callback(url);
					}
				});
		}
	}
}