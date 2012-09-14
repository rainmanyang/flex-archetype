package com.oasis.utils
{
	import com.best.oasis.flexbase.components.multicolumnform.MultiColumnForm;
	import com.best.oasis.flexbase.components.multicolumnform.MultiColumnFormItem;
	import com.best.oasis.flexbase.lang.IEqualable;
	import com.best.oasis.flexbase.util.LangUtil;
	
	import mx.collections.ArrayCollection;
	import mx.controls.DataGrid;
	import mx.core.UIComponent;
	
	import spark.components.SkinnableContainer;
	import spark.components.supportClasses.ListBase;
	import spark.components.supportClasses.SkinnableComponent;
	import spark.components.supportClasses.SkinnableTextBase;
	
	public class ViewUtils
	{	
		/**
		 * 清空所有错误信息
		 */ 
		public static function clearErrorString(obj:Object):void {
			
//			if(obj is UIComponent){
//				if(! (obj is MultiColumnFormItem || obj is MultiColumnForm)){
//					obj.errorString = "";
//				}
//			}
//			var nums:int = 0;
//			if(obj.hasOwnProperty("numElements")){
//				nums = obj.numElements;
//			}
//			for(var i:int = 0; i<nums; i++){
//				var component:Object = obj.getElementAt(i);
//				clearErrorString(component);
//			}
		}
		
		/**
		 * 清空所有element内容
		 */ 
		public static function clearDate(obj:Object):void {
			/**
			 * combobox&dropdownlist 
			 */ 
			if(obj is ListBase){
				obj = obj as ListBase;
				//obj.selectedIndex = NaN;
				obj.clearSelected();
				obj.dataProvider = null;
			}
			/**
			 * textinput
			 */ 
			if(obj is SkinnableTextBase){
				obj.text = null;
			}
			
		}
		
		public static function clearFrom(obj:Object):void{
			clearDate(obj);
			clearErrorString(obj);
		}
		
	}
	
	
}