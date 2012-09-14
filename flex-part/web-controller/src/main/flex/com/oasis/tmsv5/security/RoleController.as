package com.oasis.tmsv5.security
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.so.security.RolePremissionSO;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.vo.security.RolePremission;
	
	import mx.collections.ArrayCollection;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class RoleController extends BaseController
	{
		
		[Inject( source="roleServiceFacade" )]
		public var orgService:RemoteObject;
		
		[Inject( source="accountServiceFacade" )]
		public var accountService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function RoleController()  
		{  
			super();
		}  
		
		/**
		 *创建角色
		 * 
		 */
		public function createRole(rolePremission:RolePremission,callBack:Function,faultCallBack:Function):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.createRole(clientContext,rolePremission),
				function(event:ResultEvent):void{
					if(callBack != null){
						callBack();
					}
				},function(event:FaultEvent):void{
					if(faultCallBack != null){
						faultCallBack(event);
					}
				});
		}
		
		/** 
		 * 获取角色列表
		 * 
		 */
	    public function getPageList(so:RolePremissionSO,pageList:PageList,callBack:Function=null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.getPageList(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callBack != null){
						callBack();
					}
				});
		}
		
		/**
		 * 删除角色
		 * 
		 */
		public function remove(ids:ArrayCollection,callBack:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callBack != null){
						callBack();
					}
				});
		}
		
		/**
		 * 更新角色
		 * 
		 */
		public function update(vo:RolePremission,callBack:Function,faultCallBack:Function):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.update(clientContext,vo),
				function(event:ResultEvent):void{
					//更新当前用户按钮权限
					getPremission(clientContext.accountId);
					if(callBack != null){
						callBack();
					}
				},
				function(event:FaultEvent):void{
					if(callBack != null) {
						faultCallBack(event);
					}
				}
			);
		}
		
		public function getPremission(id:Number,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.getPremissionByAccount(clientContext,id),
				function(event:ResultEvent):void{
					ModelLocator.getInstance().premission = event.result;
					if(successCallback != null) {
						successCallback();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				})
		}
	}
}