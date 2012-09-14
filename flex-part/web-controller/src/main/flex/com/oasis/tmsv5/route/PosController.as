package com.oasis.tmsv5.route
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.route.PosSO;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.vo.route.Pos;
	import com.oasis.wolfburg.vo.route.PosView;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class PosController extends BaseController
	{
		[Inject( source="posServiceFacade" )]
		public var posService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function PosController(){
			super();
		}
		
		public function getPageList(so:PosSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( posService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:PosView,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( posService.findView(clientContext,vo.id),
				function(event:ResultEvent):void{
					var pos:PosView = event.result as PosView;
					BeanUtils.copyProperties(vo,pos);
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建pos
		 * 
		 */
		public function create(pos:Pos,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( posService.create(clientContext,pos),
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
		
		public function update(pos:PosView,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( posService.update(clientContext,pos),
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
			serviceHelper.executeSimpleCall( posService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getByRouteName(routeName:String,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( posService.getByRouteName(clientContext,routeName),
				function(event:ResultEvent):void{
					var poss:ArrayCollection = event.result as ArrayCollection;
					if(callback != null) {
						callback(poss);
					}
				});
		}
	}
}