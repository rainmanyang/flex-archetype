package com.oasis.component.dropDownList
	
{
	import com.oasis.utils.BeanUtils;
	import mx.collections.ArrayCollection;
	import mx.collections.IList;
	
	import spark.components.DropDownList;

	public class DropDownList extends spark.components.DropDownList
	{
		
		private var _searchKey:String = "";
		private var _value:Object = null;
		public var pageSize:int = 50;
		
		public function DropDownList()
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