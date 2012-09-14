package com.oasis.component.grid
{
	import flash.events.MouseEvent;
	
	import mx.controls.CheckBox;
	
	public class MyCheckBoxHeaderRenderer extends CheckBox
	{
		
		public function MyCheckBoxHeaderRenderer()
		{
			super();
			this.setStyle("paddingLeft", 6);
			this.addEventListener(MouseEvent.CLICK, onToggleSelectAll);
			this.addEventListener(MouseEvent.MOUSE_OVER, showTip);
		}
		/**
		 * 全选，全不选
		 */
		private function onToggleSelectAll(event:MouseEvent):void{
			var target:MyCheckBoxHeaderRenderer = event.target as MyCheckBoxHeaderRenderer;
			var grid:SelectableDataGrid = this.parent.parent as SelectableDataGrid;
			if(grid != null && grid.allowMultipleSelection){
				if(target.selected){
					grid.selectAll();
				}else{
					grid.unselectAll();
				}
			}
		}
		/**
		 * 当鼠标移过checkbox时
		 * checkbox的状态若为勾选，则显示取消全选
		 * 若为不勾选，则显示全选
		 * 
		 */
		private function showTip(event:MouseEvent):void{
			var target:MyCheckBoxHeaderRenderer = event.target as MyCheckBoxHeaderRenderer;
			if(target.selected){
				target.toolTip = "取消全选";
			} else {
				target.toolTip = "全选";
			}
		}
	}
}