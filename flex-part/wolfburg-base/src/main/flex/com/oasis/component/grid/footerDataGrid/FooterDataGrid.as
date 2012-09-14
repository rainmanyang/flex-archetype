package com.oasis.component.grid.footerDataGrid
{
	import com.best.oasis.flexbase.components.grid.SelectableDataGrid;
	
	import mx.controls.dataGridClasses.DataGridListData;
	import mx.controls.listClasses.BaseListData;

	public class FooterDataGrid extends SelectableDataGrid implements IFooterDataGrid
	{
		public function createListData(text:String, dataField:String, i:int):BaseListData
		{
			return new DataGridListData(text, dataField, i, null, this, -1);
		}
		
		
		//include "_footerDataGrid.as" //start;		
		import flash.events.Event;
		
		import mx.collections.ListCollectionView;
		import mx.core.UIComponent;
		
		private var _footer:Array = null;
		public var footerHeight:int = 0;
		public var totalFooterHeight:int = 0;
		
		/**
		 * 设置footer中每行的高度，如果为-1则自动计算其高度
		 */
		public var footerRowHeight:int = 30;
		
		private var footerDirty:Boolean = false;
		
		override public function initialize():void{
			super.initialize();
			ajustFooter(_footer);
		}
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
		/**
		 * 如果showControlColumn == true,需要自动在footer中也增加一列
		 */
		protected function ajustFooter(footerValue:Array):void{
			if(this.showControlColumn){
				var summaryFooter:SummaryFooter;
				for each(var o:Object in footerValue){
					summaryFooter = SummaryFooter(o);
					var sc = new SummaryColumn();
					summaryFooter.columns.splice(0, 0, sc);
				}
			}
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
		            if(!(child is SummaryFooter))
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
					//设置footer中每行的高度，如果为-1则自动计算其高度
					if(footerRowHeight == -1){
		            	footerHeight = rowHeight;
					}else{
						footerHeight = footerRowHeight;
					}
		            totalFooterHeight = (footerHeight) * footer.length;
					if(this.horizontalScrollBar != null){
						totalFooterHeight += footerHeight - 4;
					}
					//totalFooterHeight += 6;
		        }
		    }
		    
		    super.adjustListContent(unscaledWidth, unscaledHeight);
		
		    if(footer != null && footer.length > 0)
		    {
		        listContent.setActualSize(unscaledWidth, unscaledHeight - totalFooterHeight - 20);
		        
		        var offset:int = 0;
				var count:int = 0;
				var childHeight:Number = footerHeight;
		        for each (var child:UIComponent in footer)
		        {
					count++;
					if(count == footer.length - 1){
						//childHeight -= 6;
					}
		            child.setActualSize(unscaledWidth - 2, childHeight);
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