package com.oasis.wolfburg.so.truck
{
	import com.oasis.component.page.BasePageSO;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.truck.TruckStatusRecordSO")]
	public class TruckStatusRecordSO extends BasePageSO
	{
		public function TruckStatusRecordSO()
		{
		}
		public var licensePlate:String;
		public var updatePerson:String;
		public var executeDateFrom:Date;
		public var executeDateTo:Date;

		
	}
}

