package com.oasis.component.menu
{
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.menuItem.MenuItemVO")]
	public class MenuItem
	{
		public var id:Number;
		
		public var action:String;
		
		public var sortIndex:Number;
		
		public var location:String;
		
		public var name:String;
		
		public var parentId:Number;
		
		public var title:String;
		
		public var type:String;
		
		public var lockVersion:Number;
		
		public var domainId:Number;
		
		/**
		 * 网络访问权限
		 * 三位
		 * 比如：“000”、“111”
		 * 第一个0表示内网不可以访问,1表示内网可以访问
		 * 第二个0表示VPN不可以访问，1表示VPN可以访问
		 * 第三个0表示外网不可以访问，1表示外网可以访问
		 */
		public var netAuthority:String;
		
		public function MenuItem(){
		
		}
	}
}