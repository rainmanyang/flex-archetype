package com.oasis.tmsv5.security
{
	import com.oasis.component.tree.TreeNode;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.vo.organization.Organization;
	
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class OrganizationController extends BaseController
	{
		
		[Inject( source="organizationServiceFacade" )]
		public var orgService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function OrganizationController()  
		{  
			super();
		}  
		
		public function createOrg(org:Organization,successCallBack:Function,failCallBack:Function=null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.create(clientContext,org),
				function(event:ResultEvent):void{
					if(successCallBack != null){
						successCallBack();
					}
			    },function(event:FaultEvent):void{
					if(failCallBack != null) {
						failCallBack(event);
					}
				});
		}
		
		public function updateOrg(org:Organization,callBack:Function = null,failCallBack:Function = null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.update(clientContext,org),
				function(event:ResultEvent):void{
					if(callBack != null){
						callBack();
					}
				},function(event:FaultEvent):void{
					if(failCallBack != null){
						failCallBack(event);
					}
				});
		}
		
		/**
		 * 
		 *获取组织树 
		 */
		public function getOrgTree(condition:String,callBack:Function = null):void{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.getOrgTree(clientContext,condition),
				function(event:ResultEvent):void{
					var result:TreeNode = event.result as TreeNode;
					if(callBack != null){
						callBack(result);
					}
				});
		}
		
		public function view(id:Number,callBack:Function = null):void {
			clientContext  = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.view(clientContext,id),
				function(event:ResultEvent):void{
					var organization:Organization = event.result as Organization
					if(callBack != null){
						callBack(organization);
					}
				});
		}
		
		public function remove(id:Number,callBack:Function = null):void{
			clientContext  = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( orgService.remove(clientContext,id),
				function(event:ResultEvent):void{
					var organization:Organization = event.result as Organization
					if(callBack != null){
						callBack();
					}
				});
		}
		
	}
}