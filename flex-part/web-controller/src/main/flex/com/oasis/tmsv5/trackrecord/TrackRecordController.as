package com.oasis.tmsv5.trackrecord
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.route.PosSO;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.vo.route.Pos;
	import com.oasis.wolfburg.vo.route.PosView;
	import com.oasis.wolfburg.vo.trackRecord.TrackRecord;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class TrackRecordController extends BaseController
	{
		[Inject( source="trackRecordServiceFacade" )]
		public var trackRecordService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function TrackRecordController(){
			super();
		}
		
		public function selectListByFKId(id:Number,pageList:ArrayCollection,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( trackRecordService.selectListByFKId(clientContext,id),
				function(event:ResultEvent):void{
					var tempPageList:ArrayCollection = event.result as ArrayCollection;
					pageList.removeAll();
					BeanUtils.copyProperties(pageList,tempPageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 *备注任务单 
		 */ 
		public function create(vo:TrackRecord,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( trackRecordService.create(clientContext,vo),
				function(event:ResultEvent):void{
					if(callback != null){
						callback();
					}
				});
		}
	}
}