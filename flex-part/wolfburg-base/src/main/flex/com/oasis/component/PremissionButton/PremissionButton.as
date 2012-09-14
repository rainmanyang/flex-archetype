package com.oasis.component.PremissionButton
{
	import com.oasis.security.ClientContext;
	import com.oasis.security.ModelLocator;
	
	import mx.collections.ArrayCollection;
	import mx.controls.Button;

	public class PremissionButton extends Button
	{
		private var _premission:String;
		
		private var _module:String;
		
		override public function initialize():void{
			super.initialize();
			super.visible = false;
			var premission:Object = ModelLocator.getInstance().premission;
			if(premission != null) {
				var preList:ArrayCollection = premission[_module] as ArrayCollection;
				if(preList != null && preList.contains(_premission)){
					super.visible = true;
				}
			}
		}
		
		public function set module(module:String):void {
			_module = module;
		}
		
		public function set premission(premission:String):void {
			_premission = premission;
		}
	}
}