package com.oasis.tmsv5.truckRSSchedule
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.wolfburg.so.truckRSSchedule.TruckRSJobTimeRecordSO;
	import com.oasis.wolfburg.vo.excel.ExcelParsePackageVO;
	import com.oasis.wolfburg.vo.truckRSSchedule.TRSJobTimeRecordMaintainView;
	import com.oasis.wolfburg.vo.truckRSSchedule.TruckRSJobTimeRecord;
	
	import flash.utils.ByteArray;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class TruckRSJobTimeRecordController extends BaseController
	{
		[Inject( source="truckRSJobTimeRecordServiceFacade" )]
		public var truckRSJobTimeRecordService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function TruckRSJobTimeRecordController(){
			super();
		}
		
		public function getPageList(so:TruckRSJobTimeRecordSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobTimeRecordService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function exportExcel(so:TruckRSJobTimeRecordSO,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobTimeRecordService.exportToExcel(clientContext,so),
				function(event:ResultEvent):void{
					var downloadUrl:String = event.result as String;
					if(callback != null) {
						callback(downloadUrl);
					}
				});
		}
		
		public function updateManualScanedTime(vo:TRSJobTimeRecordMaintainView,order:Number,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall(truckRSJobTimeRecordService.updateManualScanedTime(clientContext,vo),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getMaintainPageList(so:TruckRSJobTimeRecordSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobTimeRecordService.getMaintainPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 批量导入
		 */
		public function batchImport(data:ByteArray,callback:Function=null, failCallBack:Function = null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( truckRSJobTimeRecordService.batchImport(clientContext,data),
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

	}
}