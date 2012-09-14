package com.oasis.tmsv5.route
{
	import com.oasis.component.page.PageList;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.utils.BeanUtils;
	import com.oasis.wolfburg.so.route.RouteSO;
	import com.oasis.wolfburg.vo.route.Route;
	
	import mx.collections.ArrayCollection;
	import mx.collections.Sort;
	import mx.collections.SortField;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class RouteController extends BaseController
	{
		[Inject( source="routeServiceFacade" )]
		public var routeService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function RouteController(){
			super();
		}
		
		public function getPageList(so:RouteSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function find(vo:Route,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.find(clientContext,vo.id),
				function(event:ResultEvent):void{
					var route:Route = event.result as Route;
					BeanUtils.copyProperties(vo,route);
					if(callback != null) {
						callback(route);
					}
				});
		}
		
		public function findStopsByRouteId(stops:ArrayCollection,id:Number,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.getStopsByRouteId(clientContext,id),
				function(event:ResultEvent):void{
					var stopArray:ArrayCollection = event.result as ArrayCollection;
					BeanUtils.copyProperties(stops,stopArray);
					
					//显示时按seqNum排序
					var seqSort:Sort = new Sort();
					var sortField:SortField = new SortField('seqNum');
					seqSort.fields = new Array(sortField);
					stops.sort = seqSort;
					stops.refresh();
					
					//stops = event.result as ArrayCollection;
					if(callback != null) {
						callback();
					}
				});
		}
		
		/**
		 * 
		 *创建Route
		 * 
		 */
		public function create(route:Route,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.create(clientContext,route),
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
		
		public function update(route:Route,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.update(clientContext,route),
				function(event:ResultEvent):void{
					BeanUtils.copyProperties(route,event.result as Route);
					if(callback != null) {
						callback();
					}
				},function(event:FaultEvent):void{
					if(faultCallBack != null) {
						faultCallBack(event);
					}
				});
		}
		
		public function batchUpdateRouteStatus(idList:ArrayCollection,routeStatus:String,callback:Function = null): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.batchUpdateRouteStatus(clientContext,idList,routeStatus),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		public function remove(ids:ArrayCollection,callback:Function=null) :void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function findReturnRoute(route:String,callback:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.findReturnRoute(clientContext,route),
				function(event:ResultEvent):void{
					var res:Route = event.result as Route;
					if(res != null){
						callback(res);
					}
				});
		}
		public function getByName(route:String,callback:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.getByName(clientContext,route),
				function(event:ResultEvent):void{
					var res:Route = event.result as Route;
					if(callback != null){
						callback(res);
					}
				});
		}
		
		public function getStopsByRouteId(id:Number,callback:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( routeService.getStopsByRouteId(clientContext,id),
				function(event:ResultEvent):void{
					var res:ArrayCollection = event.result as ArrayCollection;
					if(res != null){
						callback(res);
					}
				});
		}
		
	}
}