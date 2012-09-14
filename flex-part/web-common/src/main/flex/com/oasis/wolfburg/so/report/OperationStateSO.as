package com.oasis.wolfburg.so.report
{
	import com.oasis.component.page.BasePageSO;
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.report.OperationStateSO")]
	public class OperationStateSO extends BasePageSO
	{
		public function OperationStateSO()
		{
			super();
		}
		
		public var code:String;
		
		public var routeName:String;
		
		public var licensePlate:String;
		
		public var beginDate:Date;
		
		public var endDate:Date;
		
		public var requestUrl:String;
		
		public var status:String;
		
		
	}
}