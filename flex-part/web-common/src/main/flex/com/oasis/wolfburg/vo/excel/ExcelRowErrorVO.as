package com.oasis.wolfburg.vo.excel
{
	import com.oasis.wolfburg.enum.EnumManage;
	
	import mx.resources.ResourceManager;
	
	/**
	 * 上传excel的错误
	 * 
	 */
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.excel.ExcelRowErrorVO")]
	public class ExcelRowErrorVO
	{
		public var sheetIndex:int;			//错误所在sheet index
		public var rowIndex:int;			//错误所在的行
		public var errorType:String;//错误类型
		public var errorCode:String; //错误编码
		public var error:String; //错误描述
		
		public function ExcelRowErrorVO()
		{
		}
		
		public function toString():String{
			
			return "sheet " + sheetIndex + ", 第" + rowIndex + "行:" 
				+ EnumManage.getDisplayText(errorCode, EnumManage.getExcelErrorList()) + " " + error; 
		}
		public function get errorStr():String{
			return EnumManage.getDisplayText(errorType, EnumManage.getExcelErrorList()); 
		}
	}
}