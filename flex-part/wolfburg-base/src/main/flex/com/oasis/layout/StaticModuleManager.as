package com.oasis.layout
{
	
	import com.best.oasis.flexbase.util.layout.ContentView;
	
	import flash.events.Event;
	import flash.events.EventDispatcher;
	
	import mx.containers.TabNavigator;
	import mx.core.UIComponent;
	
	import org.hamcrest.mxml.object.Null;
	
	[Event(name="change", type="flash.events.Event")]
	public class StaticModuleManager extends EventDispatcher
	{
		static private var __instance:StaticModuleManager=null;
		private var openModules:Object = new Object();
		/**
		 * 当前焦点模块的index
		 */
		private var currentFocusModuleIndex:int = 0;
		private var removedModuleIndex:int = -1;
		[Bindable]
		public var content:UIComponent;
		public function StaticModuleManager():void{
			if(__instance != null){
				throw new Error("Singleton!");
			}
		}
		static public function getInstance():StaticModuleManager
		{
			if(__instance == null)
			{
				__instance=new StaticModuleManager();
			}
			return __instance;
		}
		public function loadModule(moduleClass:Class, title:String,arg:Number=NaN):void
		{
			trace("loading module: " + title + " " + moduleClass);
			var module:Object = new moduleClass();
			module["label"] = title;
			if(! isNaN(arg)){
				module['rsScheduleId'] = arg;
			}
			var contentView:ContentView = new ContentView();
			contentView.addChild(UIComponent(module));
			contentView.label = title;
			content.addChild(contentView);
			if(content is TabNavigator){
				var t:TabNavigator = TabNavigator(content);
				t.addEventListener(Event.ACTIVATE, onModuleActive);
				t.addEventListener(Event.REMOVED, onModuleRemoved);
				
				t.selectedIndex = t.getChildren().length - 1
			}
			openModules[t.selectedIndex] = module;
			this.currentFocusModuleIndex = t.selectedIndex;
		}
		public function unloadModule(index:int):void{
			var module:Object = openModules[index];
			if(module != null){
				trace("unloading module: " + module["label"]);
				content.removeChild(UIComponent(module).parent);
				openModules[index] = null;
				dispatchRemovedEvent(index);
			}else{
				trace("the module is not in the opened module list!");
			}
		}
		public function getCurrentFocusModuleIndex():int{
			return currentFocusModuleIndex;
		}
		private function onModuleActive(event:Event):void{
			var tabNavigator:TabNavigator = event.target as TabNavigator;
			if(tabNavigator.numChildren > 0){
				var contentView:ContentView = ContentView(tabNavigator.getChildAt(0));
				var index:int = getModuleIndex(contentView.getChildAt(0));
				if(index != -1){
					this.currentFocusModuleIndex = index;
				}else{
					trace('error: currentFocusModuleIndex = -1');
				}
			}
		}
		private function onModuleRemoved(event:Event):void{
			var tabNavigator:TabNavigator = event.currentTarget as TabNavigator;
			var index:int = -1;
			if(tabNavigator != null && tabNavigator.getChildren().length > 0){
				var contentView:ContentView = ContentView(tabNavigator.getChildAt(0));
				index= getModuleIndex(contentView.getChildAt(0));
			}
			if(index != -1){
				dispatchRemovedEvent(index);
			}else{
				trace('error: currentFocusModuleIndex = -1');
			}
		}
		private function dispatchRemovedEvent(removedModuleIndex:int):void{
			var event:Event = new Event(Event.REMOVED);
			dispatchEvent(new Event(Event.REMOVED));
		}
		private function getModuleIndex(module:Object):int{
			var result:int = -1;
			for(var index:String in openModules){
				if(openModules[index] == module){
					result = new Number(index);
				}
			}
			return result;
		}
	}
}