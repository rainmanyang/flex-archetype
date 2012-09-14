package com.oasis.security
{
	
	import com.oasis.security.ClientContext;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	public class ModelLocator
	{
		/**
		 * 主程序是显示那个界面  
		 */		
		public var mainContentViewStackSelectedIndex:int = 0;
		
		/**
		 * 登录页面提示信息
		 * @default '' 
		 */
		public var authMsg:String = '';
		
		/**
		 * 当前登录用户
		 */
		public var clientContext:ClientContext;
		
		public var premission:Object;

		//codeGenerator-ModelLocator            			
		public var menuItems:ArrayCollection;				
			
		static private var _instance:ModelLocator=null;
		
		public function ModelLocator(){
			if(_instance != null){
				throw new Error("Singleton!");
			}
		}
		
		public static function getInstance():ModelLocator {
			if(!_instance)
				_instance = new ModelLocator;
			return _instance;
		}
		
		public function setContext(context:ClientContext):void{
			clientContext = context;
		}
		
		public function getContext():ClientContext{
			return clientContext;
		}
		
	}
}
