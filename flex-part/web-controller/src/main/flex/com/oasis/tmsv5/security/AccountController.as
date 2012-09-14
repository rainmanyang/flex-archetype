package com.oasis.tmsv5.security
{
	import com.best.oasis.flexbase.util.BeanUtils;
	import com.oasis.component.page.PageList;
	import com.oasis.security.ClientContext;
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.tmsv5.error.ErrorCode;
	import com.oasis.tmsv5.so.security.AccountSO;
	import com.oasis.tmsv5.vo.security.Account;
	import com.oasis.tmsv5.vo.security.Authentication;
	import com.oasis.tmsv5.vo.security.CheckedOrg;
	import com.oasis.tmsv5.vo.security.CheckedRole;
	
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class AccountController extends BaseController
	{
		[Inject( source="accountServiceFacade" )]
		public var accountService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		[Dispatcher]
		public var dispatcher:IEventDispatcher;
		
		public function AccountController(){
			super();
		}
		
		/**
		 * 
		 * 用户登录
		 * 
		 */
		public function login( vo : Authentication,callBack:Function=null) : void
		{
			serviceHelper.executeSimpleCall( accountService.login(vo), 
				function(event:ResultEvent):void{
					var result:ClientContext= event.result as ClientContext;
					if(result.accountId != 0){
						if(checkNetAuthority(result)){
							ModelLocator.getInstance().mainContentViewStackSelectedIndex=1;
							ModelLocator.getInstance().setContext(result);
							//获取用户菜单权限
							getPremission(result.accountId);
							if(callBack != null){
								callBack();
							}
						}
					}
					else{
						Alert.show("login error!");
					}
				},
				function(event:FaultEvent):void{
					if(event.fault.faultString == ErrorCode.BAD_CREDENTIALS){
						Alert.show("密码错误！请重新输入!");
					}else if(event.fault.faultString == ErrorCode.USER_NOT_EXIST){
						Alert.show("用户名或密码错误!");
					}else if(event.fault.faultString == ErrorCode.SEND_FAILED){
						Alert.show("连接服务器出错!");
					}else{
						Alert.show(event.fault.faultString);
					}
				});
			
		}
		
		/**
		 * 校验用户的网络访问权限
		 * 0:0:0:0:0:0:0:1为本地
		 * 以172开头的为内网
		 * 已172.18.24\172.18.25开头的为VPN
		 * 其余为外网
		 */
		public function checkNetAuthority(clientContext:ClientContext):Boolean{
			var inSegment:String = clientContext.ip.slice(0, 3);
			var vpnSegment:String = clientContext.ip.slice(0, 9);
			//本地
			if(clientContext.ip == "0:0:0:0:0:0:0:1"){
				return true;
			}else if(inSegment == "172"
				&& vpnSegment != "172.18.24"
				&& vpnSegment != "172.18.25"){//内网
				if(clientContext.netAuthority.charAt(0) == "0"){
					Alert.show("你无权在内网环境下使用系统！");
					return false;
				}
			} else if(vpnSegment == "172.18.24"
				|| vpnSegment == "172.18.25"){//VPN
				if(clientContext.netAuthority.charAt(1) == "0"){
					Alert.show("你无权在VPN环境下使用系统！");
					return false;
				}
			} else {//外网
				if(clientContext.netAuthority.charAt(2) == "0"){
					Alert.show("你无权在公网环境下使用系统！");
					return false;
				}
			}
			return true;
		}
		
		/**
		 * 注销 
		 * @param callback
		 * 
		 */
		public function logout(callback:Function = null) : void  
		{
			serviceHelper.executeSimpleCall( accountService.userLogout(),
				function(event:ResultEvent):void{
					if(event.result != null){
						ModelLocator.getInstance().mainContentViewStackSelectedIndex = 0
						ModelLocator.getInstance().authMsg = '';
						ModelLocator.getInstance().setContext(null);
						if(callback!=null){
							callback();
						}	
					}else{
						Alert.show("注销失败！");
					}
				});
		}
		
		/**
		 *创建用户 
		 * 
		 */
		public function createAccount(account:Account,successCallback:Function = null,failCallBack:Function = null) :void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.createAccount(clientContext,account),
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
		
		public function getPageList(so:AccountSO,pageList:PageList,callback:Function = null): void 
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.getPagelist(clientContext,so),
				function(event:ResultEvent):void{
					var tpageList:PageList = event.result as PageList;
					BeanUtils.copyProperties(pageList,tpageList);
					if(callback != null) {
						callback();
					}
				});
		}
		
		
		public function update(account:Account,callback:Function,faultCallBack:Function): void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.update(clientContext,account),
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
			serviceHelper.executeSimpleCall( accountService.remove(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function getCheckedRoles(id:Number,callback:Function=null):void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.getCheckedRole(clientContext,id),
				function(event:ResultEvent):void{
					var result:CheckedRole = event.result as CheckedRole;
					if(callback != null) {
						callback(result);
					}
				}
			);
		}
		
		public function getCheckedOrgs(id:Number,callback:Function=null):void
		{
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.getCheckedOrg(clientContext,id),
				function(event:ResultEvent):void{
					var result:CheckedOrg = event.result as CheckedOrg;
					if(callback != null) {
						callback(result);
					}
				});
		}
		
		public function changePassword(vo:Account,callback:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.changePassword(clientContext,vo),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
		
		public function resetPassword(ids:ArrayCollection,callback:Function=null):void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( accountService.resetPass(clientContext,ids),
				function(event:ResultEvent):void{
					if(callback != null) {
						callback();
					}
				});
		}
	}
}