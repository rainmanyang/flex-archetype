package com.oasis.component.grid
{
	import mx.controls.advancedDataGridClasses.AdvancedDataGridColumn;
	import mx.core.ClassFactory;
	import mx.formatters.DateFormatter;
	import mx.resources.ResourceManager;

	import com.best.oasis.flexbase.components.grid.columnRender.CopyableDataGridItemRenderer;
	
	public class AdvancedDataGridColumnNested extends AdvancedDataGridColumn
	{
		public function AdvancedDataGridColumnNested(columnName:String=null)
	    {
	    	super(columnName);
			//这个默认必须设为false，因为如果dataField为多级的时候，排序会抛异常
	    	this.sortable = true;
			this.wordWrap = true;
			this.itemRenderer = new ClassFactory(CopyableDataGridItemRenderer);
	    }
	   
	    override public function itemToLabel(data:Object, withFormatting:Boolean  = true):String
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
	      		label = super.itemToLabel(data, withFormatting);
	    	}
			return label;
		}
		private function dateItemToLabel(date:Date):String{
			var result:String = "";
			var format:String = ResourceManager.getInstance().getString("format", "dateFormat");
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
