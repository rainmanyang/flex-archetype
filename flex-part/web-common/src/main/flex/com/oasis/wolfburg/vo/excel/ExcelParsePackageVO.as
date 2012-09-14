package com.oasis.wolfburg.vo.excel
{
	import mx.collections.ArrayCollection;
	
	/**
	 * 导入excel信息时，返回该对象，包含解析excel的错误
	 */
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.excel.ExcelParsePackageVO")]
	public class ExcelParsePackageVO
	{
		/**
		 * 解析的数据条数
		 */
		public var totalNum:int;
		/**
		 * 解析出来的数据对象列表(可不传)
		 */
		public var list:ArrayCollection;
		/**
		 * excel内容校验错误
		 */
		public var errors:ArrayCollection;
		
		public function ExcelParsePackageVO()
		{
		}
		
		public function toString():String{
			var result:String = '';
			for each(var error:ExcelRowErrorVO in errors){
				result += (error + '\r');
			}
			return result;
		}
	}
}