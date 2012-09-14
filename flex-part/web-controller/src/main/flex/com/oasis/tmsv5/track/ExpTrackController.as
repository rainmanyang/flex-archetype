package com.oasis.tmsv5.track
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.track.ExpTrackSO;
	import com.oasis.wolfburg.vo.track.ExpTrack;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class ExpTrackController extends BaseController{
		[Inject( source="expTrackServiceFacade" )]
		public var expTrackService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function ExpTrackController()
		{
			super();
		}
		
		public function getPageList(so:ExpTrackSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( expTrackService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:ExpTrack,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( expTrackService.find(clientContext,vo.id),
				function(event:ResultEvent):void{
					var expTrack:ExpTrack = event.result as ExpTrack;
					BeanUtils.copyProperties(vo,expTrack);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function create(expTrack:ExpTrack,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( expTrackService.create(clientContext,expTrack),
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
		
		public function getRsJobInfoByLicensePlate(licensePlate:String,autoExpTrack:ExpTrack,successCallback:Function = null,failCallBack:Function = null) :void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( expTrackService.getRsJobInfoByLicensePlate(clientContext,licensePlate),
				function(event:ResultEvent):void{
					var res:ExpTrack = event.result as ExpTrack;
					BeanUtils.copyProperties(autoExpTrack,res);
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		public function findRsJobListBySO(expTrackList:ArrayCollection,so:ExpTrackSO,successCallback:Function = null,failCallBack:Function = null) :void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( expTrackService.findRsJobListBySO(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(expTrackList,tpageList);
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		public function findRsJobListByRsJobId(expTrackList:ArrayCollection,rsJobId:Number,successCallback:Function = null,failCallBack:Function = null) :void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( expTrackService.findRsJobListByRsJobId(clientContext,rsJobId),
				function(event:ResultEvent):void{
					var tpageList:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(expTrackList,tpageList);
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
		
		public function getCurrentExpList(expList:ArrayCollection,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			//expList = new ArrayCollection();
			serviceHelper.executeSimpleCall( expTrackService.getCurExps(clientContext),
				function(event:ResultEvent):void{
					var tpageList:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(expList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function process(expTrack:ExpTrack,successCallback:Function = null,failCallBack:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( expTrackService.process(clientContext,expTrack),
				function(event:ResultEvent):void{
					var exp:ExpTrack = event.result as ExpTrack;
					BeanUtils.copyProperties(expTrack,exp);
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