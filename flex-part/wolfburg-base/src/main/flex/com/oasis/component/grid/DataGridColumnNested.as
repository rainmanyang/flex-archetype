package com.oasis.component.grid
{
	import com.best.oasis.flexbase.components.grid.columnRender.CopyableDataGridItemRenderer;
	
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.core.ClassFactory;
	import mx.formatters.DateFormatter;
	import mx.resources.ResourceManager;
	
	public class DataGridColumnNested extends DataGridColumn
	{
		/**
		 * 是否自动根据headerText的内容自动计算宽度
		 */
		private var _autoComputeWidth:Boolean = false;
		/**
		 * 是否显示Date类型的时间
		 */
		public var showDateTime:Boolean = false;
		public function DataGridColumnNested(columnName:String=null)
	    {
	    	super(columnName);
			//这个默认必须设为false，因为如果dataFiled为多级的时候，排序会抛异常
	    	this.sortable = false;
			if(this.wordWrap == null){
				this.wordWrap = true;
			}
			if(this.wordWrap){
				this.itemRenderer = new ClassFactory(CopyableDataGridItemRenderer);
			}
			
			if(autoComputeWidth){
				doAutoComputeWidth();
			}
	    }
		/**
		 * 按照中文宽度和headerText的字数，计算该列的宽度
		 */
	   	protected function doAutoComputeWidth():void{
			this.width = this.headerText.length * 14 + 6;
		}
		public function get autoComputeWidth():Boolean{
			return _autoComputeWidth;
		}
		public function set autoComputeWidth(value:Boolean):void{
			_autoComputeWidth = value;
			doAutoComputeWidth();
		}
		/**
		 *  @private
		 */
		override public function set wordWrap(value:*):void
		{
			
			if(!value){
				this.itemRenderer = null;
			}
			super.wordWrap = value;
		}
	    override public function itemToLabel(data:Object):String
	    {
	      	var fields:Array;
		    var attribute:String;
		    var label:String;
	     
		    var dataFieldSplit:String = dataField;
		    var currentData:Object = data;
	     
	     	if(currentData == null){
	     		return "";
	     	}
			//label function
	        if (labelFunction != null)
	            return labelFunction(data, this);
	            
	  		if(dataField != null && dataField.indexOf("@") != -1)
		    {
		  		fields = dataFieldSplit.split("@");
			    dataFieldSplit = fields[0];
			    attribute = fields[1];
		    }
	     
		    if(dataField != null && dataField.indexOf(".") != -1)
		    {
			    fields = dataFieldSplit.split(".");
    			for each(var f:String in fields){
    				if(currentData != null){
	        			currentData = currentData[f];
	        		}
	      		}
	         	
	    	}else{
		      	if(dataFieldSplit != null && dataFieldSplit != "" && currentData != null)
		        	currentData = currentData[dataFieldSplit];
	    	}
		     
	    	if(attribute)
	    	{
		      	if(currentData is XML || currentData is XMLList)
		        	currentData = XML(currentData).attribute(attribute);
		      	else  
		        	currentData = currentData[attribute];
	    	}
	     
	    	try
	    	{
	    		if(currentData is Date){
	    			label = dateItemToLabel(currentData as Date);
	    		}else if(currentData is Number){
					label = numberItemToLabel(currentData as Number);
					
				}else{
	      			label = currentData.toString();
	      		}
	    	}catch(e:Error)
	    	{
	      		label = super.itemToLabel(data);
	    	}
			return label;
		}
		private function dateItemToLabel(date:Date):String{
			var result:String = "";
			var format:String;
			if(showDateTime){
				format = ResourceManager.getInstance().getString("format", "dateTimeFormat");
			}else{
				format = ResourceManager.getInstance().getString("format", "dateFormat");
			}
			var dateFormatter:DateFormatter = new DateFormatter();
			dateFormatter.formatString = format;
			result = dateFormatter.format(date);
			return result;
		}
		/**
		 * 当数字为NaN时显示为”“
		 * @param item
		 * @return 
		 * 
		 */
		private function numberItemToLabel(item:Number):String{
			var result:String = "";
			if(isNaN(item)){
				result = "";
			}else{
				result = item.toString();
			}
			return result;
		}
	}
}
