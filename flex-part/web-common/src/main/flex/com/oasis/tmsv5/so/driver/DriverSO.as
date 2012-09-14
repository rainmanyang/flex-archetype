package com.oasis.tmsv5.so.driver
{
	import com.oasis.component.page.BasePageSO;
	
	
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.so.driver.DriverSO")]
	public class DriverSO extends BasePageSO
	{
		public function DriverSO(){
		}
		
		public var name:String;
		public var code:String;
		public var status:String;
		public var license:String;
		public var periodStart:Date;
		public var periodEnd:Date;
		public var mobilePhone:String;
	}
}