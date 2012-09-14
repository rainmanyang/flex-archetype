package com.oasis.wolfburg.so.truckRSSchedule
{
	import com.oasis.component.page.BasePageSO;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truckRSSchedule.ClientBarcodeRecordSO")]
	public class ClientBarcodeRecordSO extends BasePageSO
	{

	public var posName:String;
	
	public var scanTimeBegin:Date;
	
	public var scanTimeEnd:Date;
	
	public var barcode:String;
	
	
	public function ClientBarcodeRecordSO()
	{
	}
	}
}
