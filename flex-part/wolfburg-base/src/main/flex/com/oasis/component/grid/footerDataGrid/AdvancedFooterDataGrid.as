package com.oasis.component.grid.footerDataGrid
{
	import mx.controls.AdvancedDataGrid;
	import mx.controls.advancedDataGridClasses.AdvancedDataGridListData;
	import mx.controls.listClasses.BaseListData;

	public class AdvancedFooterDataGrid extends AdvancedDataGrid implements IFooterDataGrid
	{
		
		
		public function createListData(text:String, dataField:String, i:int):BaseListData
		{
			return new AdvancedDataGridListData(text, dataField, i, null, this, -1);
		}
				
				
		//include "_footerDataGrid.as" //start;		
		
		import flash.events.Event;
		
		import mx.collections.ListCollectionView;
		import mx.core.UIComponent;
		
		private var _footer:Array = null;
		public var footerHeight:int = 0;
		public var totalFooterHeight:int = 0;
		private var footerDirty:Boolean = false;
		
		override public function set dataProvider(value:Object):void
		{
			if (value is ListCollectionView)
				value.addEventListener('collectionChange', onCollectionChange);
		
			super.dataProvider = value;
		}
		
		private function onCollectionChange(event:Event):void
		{
			dispatchEvent(new Event('collectionChange'));
		}
		
		public function set footer(value:Array):void
		{
		    footerHeight = 22;
		    
		    // need to clear out any old footer children that might exist
		    if(_footer != null)
		    {
		        for each (var child:UIComponent in _footer)
		        {
		             if(this.contains(child))
		             {
		                 removeChild(child);
		             }
		        }
		    }
		    
		    _footer = value;
		    footerDirty = true;
		    invalidateProperties();
		    invalidateList();
		}
		
		public function get footer():Array
		{
			return _footer;
		}
		
		override protected function commitProperties():void
		{
		    super.commitProperties();
		
		    if (footerDirty)
		    {
		        footerDirty = false;
		        
		        for each (var child:UIComponent in footer)
		        {
		            if(!(child is com.oasis.component.grid.footerDataGrid.SummaryFooter))
		            {
		                throw new Error("All Footers must be SummaryFooter");
		            }
		            
		            var childFooter:SummaryFooter = child as SummaryFooter;
		            childFooter.styleName = this;
		            childFooter.dataGrid = this;
		            addChild(childFooter);
		        }
		    }
		}
		
		
		override protected function adjustListContent(unscaledWidth:Number = -1, unscaledHeight:Number = -1):void
		{
		    if(footer != null && footer.length > 0)
		    {
		        if(!isNaN(rowHeight))
		        {
		            footerHeight = rowHeight;
		            totalFooterHeight = rowHeight * footer.length;
		        }
		    }
		    
		    super.adjustListContent(unscaledWidth, unscaledHeight);
			
			var scrollBarHeight:Number = 0;
			if(this.horizontalScrollBar != null){
				scrollBarHeight = this.horizontalScrollBar.height;
				if(isNaN(scrollBarHeight)){
					scrollBarHeight = 0;
				}
			}
		    if(footer != null && footer.length > 0)
		    {
		        listContent.setActualSize(unscaledWidth, unscaledHeight - totalFooterHeight
															- scrollBarHeight);
		        
		        var offset:int = -scrollBarHeight;
		        for each (var child:UIComponent in footer)
		        {
		            child.setActualSize(unscaledWidth - 2, footerHeight);
		            child.move(listContent.x, unscaledHeight - totalFooterHeight - 1 + offset);
		            offset += footerHeight; 
		        }
		    }
		}
		
		override public function invalidateDisplayList():void
		{
		    super.invalidateDisplayList();
		    
		    if(footer && footer.length >= 0)
		    {
		        for each (var child:UIComponent in footer)
		        {
		            child.invalidateDisplayList();
		        }
		    }
		}
		//include "_footerDataGrid.as" //end;	
	}
}