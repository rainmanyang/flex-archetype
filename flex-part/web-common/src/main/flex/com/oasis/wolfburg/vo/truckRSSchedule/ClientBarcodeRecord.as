package com.oasis.wolfburg.vo.truckRSSchedule
{
	import com.oasis.tmsv5.vo.BaseVO;
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.truckRSSchedule.ClientBarcodeRecordVO")]
	public class ClientBarcodeRecord extends com.oasis.tmsv5.vo.BaseVO
	{
	
	    public var posId:Number;
	
	    public var barcode:String;
	
	    /**
	     * 0,扫描;1,手工
	     */
	    public var inputType:Number = 0;
	
	    public var scanner:String;
	
	    public var scanTime:Date;
	    
	    /**
	     * 0,进;1,出
	     */
	    public var scanType:Number = 0;
	
	    public var processed:Boolean = false;
		
		public var posName:String;
		
		public var onlined:Boolean = true;
		
		public var offlineUploadTime:Date;
		
		public var serverTime:Date;
		
		public var processedTime:Date;
		
		public var precessedResult:String;
		
		public function ClientBarcodeRecord()
		{
		}
	
	}
}
