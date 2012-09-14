package com.oasis.wolfburg.vo.configurePage
{
	import com.oasis.tmsv5.vo.BaseVO;
	[Bindable]
	[RemoteClass(alias="com.oasis.wolfburg.common.vo.configurePage.ConfigurePageVO")]
	public class ConfigurePage extends BaseVO
	{
		public function ConfigurePage()
		{
			super();
		}
		
		/**
		 * 描述
		 */
		public var description :String;
		
		/**
		 * name
		 */
		public var name:String;
		/**
		 * 类型
		 */
		public var type:String;
		/**
		 * 显示顺序
		 */
		public var  sortIndex:Number;
		
	}
}