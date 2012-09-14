package com.oasis.utils
{
	import com.best.oasis.flexbase.components.autoComplete.components.autoComplete.classes.SelectedItem;
	
	import mx.controls.Alert;
	import mx.controls.DataGrid;

	/**
	 * CRUD 工具类
	 * @author BL00064
	 * 
	 */	
	public class CRUDUtil
	{
		public function CRUDUtil()
		{
		}
		
		/**
		 * 检查是否可以查看 
		 * @param grid 要查看数据的datagrid
		 * @return 
		 * 
		 */
		static public function checkIfDoView(grid:DataGrid):Boolean{
			if(grid.selectedItem == null){
				Alert.show("请选择要查看的数据.");
				return false;
			}else if(grid.selectedItems.length > 1){
				Alert.show("每次只能查看一条数据.");
				return false;
			}
			return true;
		}
		/**
		 * 检查是否可以编辑
		 * @param grid 要编辑数据的datagrid
		 * @return 
		 * 
		 */
		static public function checkIfDoEdit(grid:DataGrid):Boolean{
			if(grid.selectedItem == null){
				Alert.show("请选择要编辑的数据.");
				return false;
			}else if(grid.selectedItems.length > 1){
				Alert.show("每次只能编辑一条数据.");
				return false;
			}
			return true;
		}
		
		/**
		 * 检查是否可以编辑
		 * @param grid 要编辑数据的datagrid
		 * @return 
		 * 
		 */
		static public function checkIfDoViewEdit(grid:DataGrid):Boolean{
			if(grid.selectedItem == null){
				Alert.show("请选择要查看/编辑的数据.");
				return false;
			}else if(grid.selectedItems.length > 1){
				Alert.show("每次只能查看/编辑一条数据.");
				return false;
			}
			return true;
		}
		
		static public function checkIfEmpty(grid:DataGrid):Boolean{
			if(grid.selectedItem == null) {
				Alert.show("请选择要发布的任务.");
				return true;
			}
			return false;
		}
		
		/**
		 * 检查是否可以发布
		 * @param grid 要发布数据的datagrid
		 * @return 
		 * 
		 */
		static public function checkIfDopublish(grid:DataGrid):Boolean{
			if(grid.selectedItem == null){
				Alert.show("请选择要发布的任务.");
				return false;
			}else if(grid.selectedItems.length > 1){
				Alert.show("每次只能发布一条任务.");
				return false;
			}
			return true;
		}
		
		static public function checkIfCanMultiOrEmptySelect(grid:DataGrid,alertMes1:String,alertMes2:String=null):Boolean{
			if(grid.selectedItem == null){
				Alert.show(alertMes1);
				return false;
			}
			if(alertMes2 != null){
				if(grid.selectedItems.length > 1){
					Alert.show(alertMes2);
					return false;
				}
			}
			return true;
		}
		
		static public function checkIfCanMultiSelect(grid:DataGrid,alertMes1:String,alertMes2:String=null):Boolean{
			
			if(alertMes2 != null){
				if(grid.selectedItems.length > 1){
					Alert.show(alertMes2);
					return false;
				}
			}
			return true;
		}
	}
}