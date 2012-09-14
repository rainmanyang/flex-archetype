package com.oasis.component.grid
{
	import mx.binding.utils.BindingUtils;
	import mx.binding.utils.ChangeWatcher;
	import mx.containers.HBox;
	import mx.controls.AdvancedDataGrid;

	/**
	 * add page function to the AdvancedDataGrid
	 */
	[Bindable]
	public class PageableAdvancedDataGrid extends AdvancedDataGrid
	{
		public var currentPageNum:int;
		public var totalItemNum:int;
		public var pageSize:int = 50;
		
		public var getPageData:Function;
		
		protected var pageBar:PageBar;
		public function PageableAdvancedDataGrid()
		{
			super();
		}
		
		override public function initialize():void{
			super.initialize();
			var hbox:HBox;
			var index:int = parent.getChildIndex(this);
			if(index < parent.numChildren - 1){
				var t:Object = parent.getChildAt(index + 1);
				if(t is HBox){
					hbox = t as HBox;
				}
			}
			if(hbox == null){
				hbox = new HBox;
				hbox.height = 20;
				hbox.percentWidth = 100;
				parent.addChildAt(hbox, index + 1);
			}
			if(hbox != null){
				//check whether the PageBar is added
				var t1:Object;
				if(hbox.numChildren == 1){
					t1 = hbox.getChildAt(0);
				}else if(hbox.numChildren == 2){
					t1 = hbox.getChildAt(1);
				}
				if(t1 is PageBar){
					return;
				}
				
				pageBar = new PageBar();
				pageBar.getPageData = getPageData;
				BindingUtils.bindProperty(pageBar, "currentPageNum", this, "currentPageNum");
				BindingUtils.bindProperty(pageBar, "totalItemNum", this, "totalItemNum");
				BindingUtils.bindProperty(pageBar, "pageSize", this, "pageSize");
				BindingUtils.bindSetter(pageBar.updateCurrentPageNum, this, "currentPageNum");
				BindingUtils.bindSetter(pageBar.updateTotalItemNum, this, "totalItemNum");
				BindingUtils.bindSetter(pageBar.updatePageSize, this, "pageSize");
				hbox.addChild(pageBar);
			}
		}
	}
}