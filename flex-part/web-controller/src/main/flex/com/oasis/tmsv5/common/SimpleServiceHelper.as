package com.oasis.tmsv5.common
{
	import com.adobe.serialization.json.JSON;
	import com.oasis.tmsv5.error.ErrorCode;
	import com.oasis.tmsv5.event.LogOutEvent;
	import com.oasis.tmsv5.event.PopExceptionWinEvent;
	import com.oasis.tmsv5.security.AccountController;
	
	import flash.events.IEventDispatcher;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.managers.PopUpManager;
	import mx.rpc.AsyncToken;
	import mx.rpc.events.FaultEvent;
	
	import org.swizframework.utils.services.ServiceHelper;
	
	public class SimpleServiceHelper extends ServiceHelper
	{
		[Dispatcher]
		public var dispatcher:IEventDispatcher;
		
		public function SimpleServiceHelper()
		{
			super();
		}
		
		private var TIMEOUT_CODE:String="Client.Error.MessageSend";
		
		/**
		 * 
		 */
		public function executeSimpleCall( call:AsyncToken, successResultHandler:Function,faultResultHandler:Function = null):AsyncToken{	
			
			if(faultResultHandler == null) 
				super.executeServiceCall(call,successResultHandler, simpleFaultHandler ) ;		
			else 
				super.executeServiceCall(call,successResultHandler,faultResultHandler );
			return call;
		}
		
		/**
		 * 
		 * create,update需要校验调用此方法
		 *  
		 */
		public function executeSimpleCallWithValidation( call:AsyncToken, successResultHandler:Function,faultResultHandler:Function):AsyncToken{	
			
			super.executeServiceCall(call,successResultHandler,faultResultHandler);
			return call;
		}
		
		private function simpleFaultHandler(event:FaultEvent):void
		{
			if(event.fault.faultString == ErrorCode.CAN_NOT_FIND_SECURITY_CONTEXT){
				dispatcher.dispatchEvent(new LogOutEvent(LogOutEvent.LOG_OUT));
				return;
			}
			dispatcher.dispatchEvent(new PopExceptionWinEvent(PopExceptionWinEvent.POP_EXCEPTION_WIN,event.fault.faultString));
		}
	}
}