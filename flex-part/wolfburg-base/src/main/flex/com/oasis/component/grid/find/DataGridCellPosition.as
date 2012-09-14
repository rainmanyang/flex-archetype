package com.oasis.component.grid.find
{
	/**
	 * DataGrid 中某个cell的位置类
	 */
	public class DataGridCellPosition
	{
		public function DataGridCellPosition(rowIndex:int, colIndex:int)
		{
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
		}
		/**
		 * 行索引 
		 */		
		public var rowIndex:int;
		/**
		 * 列索引 
		 */		
		public var colIndex:int;
		
		public function equals(target:Object):Boolean{
			if(target is DataGridCellPosition){
				var t:DataGridCellPosition = target as DataGridCellPosition;
				if(rowIndex == t.rowIndex && colIndex == t.colIndex){
					return true;
				}
			}
			return false;
		}
	}
}