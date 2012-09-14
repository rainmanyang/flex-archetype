package com.oasis.tmsv5.security
{
	import com.oasis.component.menu.MenuItem;
	import com.oasis.component.tree.TreeNode;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.*;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.vo.security.CheckedPremissionTree;
	import com.oasis.utils.BeanUtils;
	
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import org.swizframework.utils.services.ServiceHelper;

	public class MenuItemController extends BaseController
	{
		[Inject( source="menuItemFacade" )]
		public var munuItemService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function MenuItemController(){
			super();
		}
		
		[PostConstruct]		
		public function show() : void
		{
		}
		
		
		/**
		 * 
		 * 获取leftmenu目录树
		 * 
		 */
		public function getMenuItemTree(callback:Function=null) : void
		{	
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( munuItemService.getMenuItemTree(clientContext), 
				function(event:ResultEvent):void{
					var result:TreeNode = event.result as TreeNode;
					if(callback != null){
						callback(result);
					}
				}, 
				function(event:FaultEvent):void{
					trace(event.fault);
					Alert.show("获取当前用户菜单失败！" + event.fault.faultString);
				});
		}
		
		/**
		 * 
		 * 获取菜单管理菜单树
		 * 
		 */
		public function getMenuItemTreeWidthPre(callback:Function=null) : void
		{	
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( munuItemService.getMenuItemTreeWithPremission(clientContext), 
				function(event:ResultEvent):void{
					var result:TreeNode = event.result as TreeNode;
					if(callback != null){
						callback(result);
					}
				});
		}
		
		/**
		 * 
		 * 获取角色对应的权限树 
		 * 角色创建roleid为0取整棵权限树
		 * 
		 */
		public function getMenuItemTree4Premission(roleId:Number,callback:Function=null) : void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeServiceCall( munuItemService.getMenuItemTree4Premission(clientContext,roleId), 
				function(event:ResultEvent):void{
					var result:CheckedPremissionTree = event.result as CheckedPremissionTree;
					if(callback != null){
						callback(result);
					}
				}, 
				function(event:FaultEvent):void{
					trace(event.fault);
				});
		}
		
		public function createMenuItem(vo:MenuItem,callback:Function = null,faultCallback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( munuItemService.create(clientContext,vo), 
				function(event:ResultEvent):void{
					if(callback != null){
						callback();
					}
				},function(event:FaultEvent):void {
					if(faultCallback != null){
						faultCallback(event);
					}
				});
		}
		
		public function updateMenuItem(vo:MenuItem,callback:Function = null,faultCallback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( munuItemService.update(clientContext,vo), 
				function(event:ResultEvent):void{
					if(callback != null){
						callback();
					}
				},function(event:FaultEvent):void {
					if(faultCallback != null){
						faultCallback(event);
					}
				});
		}
		
		public function find(vo:MenuItem,callback:Function = null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( munuItemService.find(clientContext,vo.id), 
				function(event:ResultEvent):void{
					var ret:MenuItem = event.result as MenuItem;
					BeanUtils.copyProperties(vo,ret);
					if(callback != null){
						callback(vo);
					}
				});
		}
		
	}
}