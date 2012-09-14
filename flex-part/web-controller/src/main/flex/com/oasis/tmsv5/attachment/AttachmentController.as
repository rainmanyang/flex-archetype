package com.oasis.tmsv5.attachment
{
	import com.oasis.security.ModelLocator;
	import com.oasis.tmsv5.BaseController;
	import com.oasis.tmsv5.common.SimpleServiceHelper;
	import com.oasis.wolfburg.vo.attachment.Attachment;
	
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.events.ResultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class AttachmentController extends BaseController
	{
		[Inject( source="attachmentServiceFacade" )]
		public var AttachmentService:RemoteObject;
		
		[Inject]
		public var serviceHelper : SimpleServiceHelper;
		
		public function AttachmentController(){
			super();
		}
		
		public function doUpload(vo:Attachment,callback:Function = null): void {
			clientContext = ModelLocator.getInstance().getContext();
			serviceHelper.executeSimpleCall( AttachmentService.doUpload(clientContext,vo),
				function(event:ResultEvent):void{
					//var arr:String = event.result as String;
					//var arrs:Array = arr.split("||");
					//vo.host = arrs[0];
					//vo.url = arrs[1];
					vo.fileUrl = event.result as String;
					if(callback != null) {
						callback();
					}
				});
		}
		
		
	}
}