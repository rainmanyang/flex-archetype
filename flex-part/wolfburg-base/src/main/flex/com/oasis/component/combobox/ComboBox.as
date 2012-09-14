package com.oasis.component.combobox
{
	
	import com.oasis.utils.BeanUtils;
	
	import flexlib.controls.sliderClasses.ExtendedSlider;
	
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import spark.components.ComboBox;
	
	public class ComboBox extends spark.components.ComboBox
	{
		
		private var _searchKey:String = "";
		private var _value:Object = null;
		
		public var pageSize:int = 50;
		
		public function ComboBox()
		{
			super();
		}
		
		public function set searchKey(key:String):void{
			this._searchKey = key;
		}
		
		public function set value(val:Object):void{
			if(val != null){
				_value = val;
				if(dataProvider != null){
					selectedIndex = BeanUtils.findIndex(dataProvider as ArrayCollection,_searchKey,_value);
				}
			}else{
				selectedIndex = 0;
			}
		}
		
	}
}