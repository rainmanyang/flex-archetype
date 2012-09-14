package com.oasis.layout
{
	
	import mx.containers.TabNavigator;
	import mx.core.UIComponent;
	import mx.modules.ModuleLoader;
	
	public class ModuleManager
	{
		static private var __instance:ModuleManager=null;
		private var openModules:Object = new Object();
		
		[Bindable]
		public var content:UIComponent;
		public function ModuleManager():void{
			if(__instance != null){
				throw new Error("Singleton!");
			}
		}
		static public function getInstance():ModuleManager
		{
			if(__instance == null)
			{
				__instance=new ModuleManager();
			}
			return __instance;
		}
		public function loadModule(url:String, title:String):void
		{
			trace("loading module: " + title + " " + url);
			var moduleLoader:ModuleLoader = new ModuleLoader();
			moduleLoader.label = title;
			moduleLoader.loadModule(url);
			content.addChild(moduleLoader);
			if(content is TabNavigator){
				var t:TabNavigator = TabNavigator(content);
				t.selectedIndex = t.getChildren().length - 1
			}
			openModules[url] = moduleLoader;
		}
		public function unloadModule(url:String):void{
			trace("unloading module: " + url);
			var moduleLoader:ModuleLoader = openModules[url];
			if(moduleLoader != null){
				moduleLoader.unloadModule();
				content.removeChild(moduleLoader);
				openModules[url] = null;
			}else{
				trace("the module is not in the opened module list!");
			}
		}
			
	}
}