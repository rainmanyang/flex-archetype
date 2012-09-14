package com.oasis.component.grid
{
	import com.best.oasis.flexbase.util.ArrayCollectionUtil;
	import com.oasis.component.grid.filter.FilterDialog;
	import com.oasis.component.grid.find.DataGridCellPosition;
	import com.oasis.component.grid.find.FindDialog;
	
	import flash.display.DisplayObject;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.MouseEvent;
	import flash.ui.Keyboard;
	import flash.utils.Dictionary;
	
	import mx.collections.ArrayCollection;
	import mx.collections.ICollectionView;
	import mx.containers.HBox;
	import mx.controls.CheckBox;
	import mx.controls.RadioButton;
	import mx.controls.RadioButtonGroup;
	import mx.controls.Text;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.controls.listClasses.IListItemRenderer;
	import mx.controls.listClasses.ListBaseContentHolder;
	import mx.core.ClassFactory;
	import mx.core.UIComponent;
	import mx.core.UITextField;
	import mx.core.mx_internal;
	import mx.events.CloseEvent;
	import mx.events.CollectionEvent;
	import mx.events.DataGridEvent;
	import mx.events.FlexEvent;
	import mx.events.ListEvent;
	import mx.events.ScrollEvent;
	import mx.managers.PopUpManager;

	use namespace mx_internal;
	
	[Event(name="selectedItemChanged", type="mx.events.FlexEvent")]

	/**
	 * 这个SelectableDataGrid会在原来的DataGrid上面增强了每行的选中功能：
	 * 	1. 如果可以多选（allowMultipleSelection=true)，grid的第一列为CheckBox，用户可以通过CheckBox来选中该行
	 *  2. 如果为单选（allowMultipleSelection=false)，grid的第一列为RadioButton，
	 * 	        用户可以通过RadioButton来选中该行
	 * @author BL00064
	 * 
	 */
	public class SelectableDataGrid extends EIDataGrid
	{
		public static var SELECTED_ITEM_CHANGE_EVENT:String="selectedItemChanged";
		/**
		 * 是否显示每行的控制列，控制列是checkbox（多选）或者radiobox(单选)组成的
		 * default: true 
		 */		
		public var showControlColumn:Boolean = true;
		/**
		 * 是否显示工具栏
		 */
		public var showToolBar:Boolean = true;
		/**
		 * 是否显示head上的全选按钮
		 */ 
		public var showHeadCheckBox:Boolean = true;
		/**
		 * 是否已经添加控制列 
		 */		
		private var controlColumnAdded:Boolean = false;
		/**
		 * 控制列的宽度 
		 */		
		public var controlColumnWidth:int = 29;
		/**
		 * 工具栏
		 */
		public var toolBar:ToolBar;
		
		/**
		 * 用来记录高亮显示前itemRenderer的style，以itemRenderer为key，style对象为value（style的结构：{color:'',fontStyle:''}）
		 */
		private var itemRendererDefaultStyle:Dictionary = new Dictionary();
		/**
		 * 高亮显示的cell的位置列表
		 */
		private var highlightCellPos:ArrayCollection = new ArrayCollection();
		
		/**
		 * 查找对话框的实例
		 */
		private var findDialog:com.oasis.component.grid.find.FindDialog;
		/**
		 * 过滤列对话框的实例
		 */
		private var filterDialog:FilterDialog;
		/**
		 * 用来把radioButton圈起来
		 */
		private var radioGroup:RadioButtonGroup;
		
		public function SelectableDataGrid()
		{
			super();
		}
		
		override public function initialize():void{
			if(this.doubleClickEnabled){
				this.addEventListener(ListEvent.ITEM_DOUBLE_CLICK, itemDoubleClick, false, 1000);
			}
			super.initialize();
			if(this.selectable == false){
				showControlColumn = false;
			}
			if(showControlColumn){
				if(controlColumnAdded){
					var tArr:Array = this.columns;
					tArr.splice(0, 1);
					this.columns = tArr;
				}
				addControlColumn();
				controlColumnAdded = true;
				//把控制列锁住，横向滚动的时候不跟着滚动
				if(this.lockedColumnCount == 0){
					//this.lockedColumnCount = 1;
				}
			}else{
				removeControlColumn();
			}
			if(showControlColumn){
				this.addEventListener(ListEvent.CHANGE, onChange);
				this.addEventListener(ScrollEvent.SCROLL, onScroll);
				//为了在排序后选中的行的checkbox不丢失
				//在最后再次调用onchange事件，否则前面调用的onchange事件中的itemRenderer['selected']会丢失
				//期间不知道又有什么事件改编了itemRenderer的属性
				this.addEventListener(mx.events.FlexEvent.UPDATE_COMPLETE, onUpdateComplete);
			}
			if(showToolBar){
			//初始化"全选"按钮
				initToolBar();
			}
		}
		/**
		 * 键盘事件处理
		 * 初始化快捷键
		 */
		override protected function keyDownHandler(event:KeyboardEvent):void{
			super.keyDownHandler(event);
			if(event.ctrlKey){
				if(event.keyCode == 70){
					this.find();
				}
			}else if(event.keyCode == Keyboard.F3){
				this.find();
			}
		}
		/**
		 * 初始化工具栏："全选"按钮
		 */
		private function initToolBar():void{
			var hbox:HBox;
			var index:int = parent.getChildIndex(this);
			if(index < parent.numChildren - 1){
				var t:Object = parent.getChildAt(index + 1);
				if(t is HBox){
					hbox = t as HBox;
				}
			}else{
				hbox = new HBox();
				if(this.percentWidth > 0){
					hbox.percentWidth = this.percentWidth;
				}
				if(this.width > 0){
					hbox.width = this.width;
				}
				parent.addChildAt(hbox, index + 1);
				
			}
			var t1:Object;
			if(hbox.numChildren > 0){
				t1 = hbox.getChildAt(0);
			}
			var toolBar:ToolBar;
			if(t1 is ToolBar){
				toolBar = t1 as ToolBar;
			}else{
				toolBar = new ToolBar();
				toolBar.grid = this;
				
				toolBar.horizontalScrollPolicy = "off";
				toolBar.setStyle("paddingLeft", getControlColumnPaddingLeft());
				hbox.addChildAt(toolBar, 0);
	
				}
			if(this.allowMultipleSelection){
				toolBar.showSelectAllCheckBox();
				//toolBar.width = 90;
			}else{
				//toolBar.width = 30;
				toolBar.hideSelectAllCheckBox();
			}
		}
			
		private function addControlColumn():void{
			var controlColumn:DataGridColumn = generateControlColumn();
			if(this.allowMultipleSelection){
				if(showHeadCheckBox){
					controlColumn.headerRenderer = new ClassFactory(MyCheckBoxHeaderRenderer);
				}
				controlColumn.sortable = false;
			}
			var arrayCollection:ArrayCollection = new ArrayCollection(this.columns);
			arrayCollection.addItemAt(controlColumn, 0);
			this.columns = arrayCollection.toArray();
		}
		
		private function removeControlColumn():void{
			if(controlColumnAdded){
				var arrayCollection:ArrayCollection = new ArrayCollection(this.columns);
				arrayCollection.removeItemAt(0);
				this.columns = arrayCollection.toArray();
				controlColumnAdded = false;
			}
		}
		/**
		 * 生成控制列 
		 * 
		 */		
		protected function generateControlColumn():DataGridColumn{
			var result:DataGridColumn = new DataGridColumn();
			result.width = controlColumnWidth;
			result.editable = false;
			if(this.allowMultipleSelection){
				result.itemRenderer = new ClassFactory(CheckBox);				
			}else{
				result.itemRenderer = new ClassFactory(RadioButton);
				radioGroup = new RadioButtonGroup();
			}		
			
			return result;
		}
		override protected function setupColumnItemRenderer(c:DataGridColumn, contentHolder:ListBaseContentHolder,
                    rowNum:int, colNum:int, data:Object, uid:String):IListItemRenderer{
            var result:IListItemRenderer = 
            			super.setupColumnItemRenderer(c, contentHolder, rowNum, colNum, data, uid);
            if(showControlColumn){
            	if(colNum == 0){
            		var control:UIComponent = result as UIComponent;
            		if(control != null){
						if(control is CheckBox || control is RadioButton){
			            			control.setStyle("paddingLeft", getControlColumnPaddingLeft());
							control.setStyle("disabledIconColor", "0x000000");
							control.setStyle("borderColor", "0x000000");
							//把checkBox或radioButton设置为disalbed，这样当鼠标点击checkBox的时候就不会
							//  发生设置两次checkBox状态的bug了
							control.enabled = false;
						}
	            	}
            	}
            }        
            return result;    	
        }
		/**
		 * 计算控制列中paddingLeft 
		 * @return 
		 * 
		 */
		protected function getControlColumnPaddingLeft():int{
			if(this.showControlColumn){
				var paddingLeft:int = Math.floor((controlColumnWidth-15)/2);
				if(paddingLeft < 0){
					paddingLeft = 0;
				}
				return paddingLeft;
			}else{
				return 0;
			}
		}
        /**
	     *  Handles <code>MouseEvent.MOUSE_DOWN</code> events from any mouse
	     *  targets contained in the list including the renderers. This method
	     *  finds the renderer that was pressed and prepares to receive
	     *  a <code>MouseEvent.MOUSE_UP</code> event.
	     *
	     *  @param event The MouseEvent object.
	     */
	    override protected function mouseDownHandler(event:MouseEvent):void
	    {
	        if(this.allowMultipleSelection && showControlColumn){
	        	event.ctrlKey = true;
	        } 
	        super.mouseDownHandler(event);
	    }
		
		/**
		 * 当用户点击grid某行，导致选中的行变化时，需要调用该函数来处理 
		 * @param event
		 */        
		private function onChange(event:ListEvent):void{
			var listItems:Array = listContent.listItems;
//			selectedIndices = updateSelectedIndices();
			var target:IListItemRenderer;
			if(event != null){
				target = event.itemRenderer as IListItemRenderer; 
			}
			var itemRenderer:IListItemRenderer;
			for(var i:int=0; i<listItems.length; i++){
				itemRenderer = listItems[i][0];
				if(itemRenderer != null && (itemRenderer is CheckBox || itemRenderer is RadioButton)){
					if(selectedIndices.indexOf(i + this.verticalScrollPosition) != -1){
						if(itemRenderer['selected'] == false){
							itemRenderer['selected'] = true;
						}
					}else{
						if(itemRenderer['selected']){
							itemRenderer['selected'] = false;
						}
					}
					
				}
			}
			if(this.toolBar != null && event != null){
				this.toolBar.selectAllCheckBox.selected = false;
			}
			this.dispatchEvent(new FlexEvent(SELECTED_ITEM_CHANGE_EVENT));
			trace('SelectableDataGrid - onChange');
		}
		
        /**
         * 当用户点击grid某行，导致选中的行变化时，需要调用该函数来处理 
         * @param event
         * 
         */        
        override protected function onUpdateComplete(event:FlexEvent):void{
			super.onUpdateComplete(event);
			//根据selectedItems来修正selectedIndices
			//否则当一列中有2个值一模一样时，selectedIndices会更改
			//如“Name”列，2条数据都为"ABC"，选择这2条时，selectedIndices应该为[0,1]
			//不进行修正时会出现[1,1]这样子的情况
			if(!ArrayCollectionUtil.equals(selectedIndices, updateSelectedIndices())){//判断selectedIndices与tselectedIndices是否相等
				selectedIndices = updateSelectedIndices();
			}
			
			var listItems:Array = listContent.listItems;
			var itemRenderer:IListItemRenderer;
			for(var i:int=0; i<listItems.length; i++){
				itemRenderer = listItems[i][0];
				if(itemRenderer != null && (itemRenderer is CheckBox || itemRenderer is RadioButton)){
					if(selectedIndices.indexOf(i + this.verticalScrollPosition) != -1){
						if(itemRenderer['selected'] == false){
							itemRenderer['selected'] = true;
						}
					}else{
						if(itemRenderer['selected'] == true){
							itemRenderer['selected'] = false;
						}
					}
				}
			}
			if(this.toolBar != null && event != null){
				this.toolBar.selectAllCheckBox.selected = false;
			}
			this.dispatchEvent(new FlexEvent(SELECTED_ITEM_CHANGE_EVENT));
		}
		
		       
		/**
		 * 根据selectedItems来修正selectedIndices
		 */
		private function updateSelectedIndices():Array{
			var i:int = 0;
			var tselectedIndices:Array = new Array();
			for each(var o:Object in this.selectedItems){
				tselectedIndices[i] = getDataIndex(o);
				i++;
			}
			return tselectedIndices;
		}
		
		
		/**
		 * 计算一个data在dataProvider中的第几个
		 */
		private function getDataIndex(data:Object):int{
			var i:int = 0;
			for each(var o:Object in dataProvider){
				if(o == data){
					return i;
				}
				i++;
			}
			return -1;
		}
        private function itemDoubleClick(event:ListEvent):void{
        	var itemRenderer:IListItemRenderer = event.itemRenderer;
			if(!isItemRendererSelected(itemRenderer)){
				this.selectItem(itemRenderer, false, true);
			}
            onChange(event);
        }
	
		/**
		 * when data provider collection changed, reset all the checkbox or radio button to 
		 * unchecked state.
		 * @param event
		 */
		override protected function collectionChangeHandler(event:Event):void{
			super.collectionChangeHandler(event);
			/*
				解决全选后编辑 导致不全选的情况。cEvent 在按回车的时候kind是move
			*/
			var cEvent:CollectionEvent = CollectionEvent(event);
			if(showControlColumn && cEvent.kind != 'update'&& cEvent.kind !='move'){
				
			}
			if(this.toolBar != null){
				this.toolBar.selectAllCheckBox.selected = false;
			}
		}
		public function selectAll():void
		{
			clearSelected();
			var dp:ICollectionView = ICollectionView(this.dataProvider);
			if(dp != null && dp.length > 0){
				this.selectedItem = dp.createCursor().current;
				this.verticalScrollPosition = dp.length - 1;
				var lastListItem:Array = getLastListItem();
				if(lastListItem != null){
					var itemRenderer:IListItemRenderer = lastListItem[0];
					selectItem(itemRenderer, true, false);
					onChange(null);
				}
			}
		}
		
		/**
		 * 找到最后一个含有数据的行
		 * @return 
		 * 
		 */
		protected function getLastListItem():Array{
			var listItems:Array = listContent.listItems;
			var itemRenderer:IListItemRenderer;
			var listItem:Array;
			for(var i:int=listItems.length - 1; i>=0; i--){
				listItem = listItems[i] as Array;
				if(listItem.length != 0){
					return listItem;
				}
			}
			return null;
		}
		/**
		 * 取消全部选中 
		 */
		public function unselectAll():void{
			clearSelected();
			var listItems:Array = listContent.listItems;
			var itemRenderer:IListItemRenderer;
			for(var i:int=0; i<listItems.length; i++){
				itemRenderer = listItems[i][0];
				if(itemRenderer != null && (itemRenderer is CheckBox || itemRenderer is RadioButton)){
					itemRenderer['selected'] = false;
				}
			}
			
		}
		
		/**
		 * datagrid滚动时处理函数 
		 * @param event
		 * 
		 */		
		// 暂时去掉全选功能 
		public function onScroll(event:ScrollEvent):void{
			onChange(null);
			//滚动时，需要重新highlight，不然当原来的位置显示了其他行的数据时，会导致highlight位置错位
			rehighlightOnScroll();
			
		}
		/**
		 * 判断一个itemRender所在的行是否被选中 
		 * @param itemRenderer
		 * @return 
		 * 
		 */
		protected function isItemRendererSelected(itemRenderer:IListItemRenderer):Boolean{
			if(itemRenderer != null && itemRenderer.data != null){
				var uid:String = itemToUID(itemRenderer.data);
				if(selectedData[uid]){
					return true;
				}
			}
			return false;
		}
		/**
		 * 滚动时，需要重新highlight，不然当原来的位置显示了其他行的数据时，会导致highlight位置错位
		 */
			
		protected function rehighlightOnScroll():void{
			eraseAllHighlightCellTrail();
			var len:int = listContent.listItems.length;
			for each(var pos:DataGridCellPosition in highlightCellPos){
				if(pos.rowIndex >= this.verticalScrollPosition
						|| pos.rowIndex <= this.verticalScrollPosition + len){
					try{
						highlightCell(pos.rowIndex, pos.colIndex);
					}catch(e:Error){
						
					}
				}
			}
		}
		/**
		 * 高亮显示某个cell
		 * @param rowIndex
		 * @param colIndex
		 * @param bgColor
		 */		
		public function highlightCell(rowIndex:int, colIndex:int):void{
			var itemRenderer:IListItemRenderer = getCellItemRenderer(rowIndex, colIndex);
			if(itemRenderer == null){
				trace("Warn: can't find the cell you want to highlight. rowIndex=" 
							+ rowIndex + "colIndex=" + colIndex);
				return;
			}
			var oldStyle:Object = new Object();
			
			if(itemRenderer is Text){
				var text:Text = itemRenderer as Text;
				//记录下原始值，以便unhighlight时恢复
				oldStyle['color'] = text.getStyle('color');
				oldStyle['fontWeight'] = text.getStyle('fontWeight');
				
				text.setStyle('color', '#f05124');
				text.setStyle('fontWeight', 'bold');
				
				text.styleName = 'dataGridCellHighlight';
			}else{
				var textField:UITextField = itemRenderer as UITextField;
				if(textField != null){
					//记录下原始值，以便unhighlight时恢复
					oldStyle['color'] = textField.getStyle('color');
					oldStyle['fontStyle'] = textField.getStyle('fontWeight');
					
					textField.setStyle('color', '#f05124');
					textField.setStyle('fontWeight', 'bold');
				}
				//textField.styleName = 'dataGridCellHighlight';
			}
			//防止覆盖了最原始样式
			if(itemRendererDefaultStyle[itemRenderer] == null){
				itemRendererDefaultStyle[itemRenderer] = oldStyle;
			}
			
			var pos:DataGridCellPosition = new DataGridCellPosition(rowIndex, colIndex);
			if(getHighlightCellPosIndex(pos) == -1){
				highlightCellPos.addItem(pos);
			}
		}
		/**
		 * 取消高亮显示某个cell
		 * @param rowIndex
		 * @param colIndex
		 */		
		public function unhighlightCell(rowIndex:int, colIndex:int):void{
			var itemRenderer:IListItemRenderer = getCellItemRenderer(rowIndex, colIndex);
			if(itemRenderer == null){
				return;
			}
			var oldStyle:Object = itemRendererDefaultStyle[itemRenderer];
			if(oldStyle != null){
				if(itemRenderer is Text){
					var text:Text = itemRenderer as Text;
					text.setStyle('color', oldStyle['color']);
					text.setStyle('fontWeight', oldStyle['fontWeight']);
					text.styleName = 'dataGridCellHighlight';
				}else{
					var textField:UITextField = itemRenderer as UITextField;
					textField.setStyle('color', oldStyle['color']);
					textField.setStyle('fontWeight', oldStyle['fontWeight']);
					textField.styleName = 'dataGridCellHighlight';
				}
				delete itemRendererDefaultStyle[itemRenderer];
			}
			
			var pos:DataGridCellPosition = new DataGridCellPosition(rowIndex, colIndex);
			var index:int = getHighlightCellPosIndex(pos);
			if(index != -1){
				highlightCellPos.removeItemAt(index);
			}
		}
		/**
		 * 查找pos在 highlightCellPos中的位置
		 * @param pos
		 * @return 
		 * 
		 */		
		private function getHighlightCellPosIndex(pos:DataGridCellPosition):int{
			var i:int=0;
			for each(var t:DataGridCellPosition in highlightCellPos){
				if(t.rowIndex == pos.rowIndex && t.colIndex == pos.colIndex){
					return i; 
				}
				i++;
			}
			return -1;
		}
		/**
		 * 取消高亮显示所有可见cell
		 */		
		public function unhighlightAllViewableCell():void{
			eraseAllHighlightCellTrail();
			highlightCellPos.removeAll();
		}
		/**
		 * 擦除所有高亮显示cell的痕迹
		 */
		protected function eraseAllHighlightCellTrail():void{
			var listItems:Array = listContent.listItems;
			var itemRenderer:IListItemRenderer;
			for(var i:int=0; i<listItems.length; i++){
				for(var j:int=0; j<listItems[i].length; j++){
					itemRenderer = listItems[i][j];
					var oldStyle:Object = itemRendererDefaultStyle[itemRenderer];
					if(oldStyle != null){
						if(itemRenderer is Text){
							var text:Text = itemRenderer as Text;
							text.setStyle('color', oldStyle['color']);
							text.setStyle('fontWeight', oldStyle['fontWeight']);
							text.styleName = 'dataGridCellHighlight';
						}else{
							var textField:UITextField = itemRenderer as UITextField;
							if(textField != null){
								textField.setStyle('color', oldStyle['color']);
								textField.setStyle('fontWeight', oldStyle['fontWeight']);
								textField.styleName = 'dataGridCellHighlight';
							}
						}
						delete itemRendererDefaultStyle[itemRenderer];
					}
				}
			}
		}
		/**
		 * 根据rowIndex和colIndex找到某个cell的itemRender 
		 * @param rowIndex 行索引
		 * @param colIndex 列索引
		 * @return 
		 * 		找到的cell的itemRender
		 * 
		 */		
		protected function getCellItemRenderer(rowIndex:int, colIndex:int):IListItemRenderer{
			var result:IListItemRenderer;
			
			var listItems:Array = listContent.listItems;
			var rowOffset:int = rowIndex;
			if(this.verticalScrollBar != null){
				rowOffset -= verticalScrollPosition;	
			}
			if(rowOffset >= listItems.length || rowOffset < 0){
				//throw new Error('rowIndex:' + rowIndex + ' out of range.' + 'max=' 
				//					+ (verticalScrollPosition + listItems.length - 1));
				trace("Warn: getCellItemRenderer can't find the cell. RowIndex out of range. rowIndex=" 
					+ rowIndex + " colIndex=" + colIndex);
				return null;
			}
			
			var listItem:Array = listItems[rowOffset];
			
			
			var colOffset:int = colIndex;
			if(this.horizontalScrollBar != null){
				colOffset -= horizontalScrollPosition;	
			}
			if(colOffset >= listItem.length || colOffset < 0){
				//throw new Error('colIndex:' + colIndex + ' out of range.' + 'max=' 
				//	+ (listItem.length - 1));
				trace("Warn: getCellItemRenderer can't find the cell. ColIndex out of range. rowIndex=" 
					+ rowIndex + " colIndex=" + colIndex);
				return null;
			}
			result = listItem[colOffset];
			
			return result;
		}
		/**
		 * 查找按钮点击处理函数
		 */
		public function find():void{
			if(findDialog == null){
				findDialog = PopUpManager.createPopUp(root, FindDialog, false) as FindDialog;
			}
			//查找窗口关闭时，把findDialog置为null
			findDialog.addEventListener(CloseEvent.CLOSE, 
				function():void{
					findDialog = null;	
				});
			PopUpManager.centerPopUp(findDialog);
			findDialog.grid = this;
			findDialog.init();
		}
		public function filter():void{
			if(filterDialog == null){
				filterDialog = PopUpManager.createPopUp(root, FilterDialog, false) as FilterDialog;
			}
			//查找窗口关闭时，把findDialog置为null
			filterDialog.addEventListener(CloseEvent.CLOSE, 
				function():void{
					filterDialog = null;	
				});
			PopUpManager.centerPopUp(filterDialog);
			filterDialog.grid = this;
			filterDialog.init();
		}
		
		
		/**
		 * 父方法updateDisplayList调用commitEditedItemPosition导致selectedIndices不对。
		 * 例如：先全选datagrid，然后点击某行的可编辑的列，其它行都会取消选择。
		 * 所以先保存 后赋值给它
		 */
		override protected function updateDisplayList(unscaledWidth:Number,
													  unscaledHeight:Number):void{
			var tSelectedIndices:Array = this.selectedIndices;
			super.updateDisplayList(unscaledWidth, unscaledHeight);
			/*
			 *只在调用super的updateDisplayList方法后 selectedIndices发生改变了才调用onchange
			*/
			if(!isArrayHasTheSameElement(this.selectedIndices, tSelectedIndices)){
				this.selectedIndices = tSelectedIndices;
				this.onChange(null);
			}
		}
		/**
		 * 比较两个数组，看其包含的元素是否相等。
		 */
		protected function isArrayHasTheSameElement(arr1:Array, arr2:Array):Boolean{
			for each(var e:Object in arr1){
				if(arr2.indexOf(e) == -1){
					return false;
				}
			}
			return true;
		}
		/** 
		 * 致终于来到这里的勇敢的人：
		 * 你是被上帝选中的人，英勇的、不辞劳苦的、不眠不修的来修改
		 * 我们这最棘手的代码的编程骑士。你，我们的救世主，人中之龙，
		 * 我要对你说：永远不要放弃，永远不要对自己失望，永远不要逃走，辜负了自己。
		 * 永远不要哭啼，永远不要说再见。永远不要说谎来伤害自己。
		 * -----------------------以下是正经事儿-------------------------------
		 * Flex会把整个页面的radio放在一个默认的radiogroup中进行管理。
		 * 如果在同一个页面中有两个uicomponent的子类，每个子类中分别放一个selectableDateGrid，
		 * allowMultipleSelection=true,在一个grid已有数据的情况下
		 * 对另一个grid做增删数据的操作报【提供的 DisplayObject 必须是调用者的子级】
		 * 泡爷觉得：在radioButton生成的时候，给他指定一个我们自己新建的radioButtonGroup，这样每个Grid的radioButton属于不同的Group。
		 * 就不会报错了。
		 * 果断按着这个思路走，但是发现不知道什么时候，radioButton就自己从哪里搞了个Group，导致我们写的代码都没执行就报错了。
		 * 经过排查，在DataGrid的commitProperties的时候，截住了那小子。灭之，换上我们自己人。这个世界安静了！
		 */
		override protected function commitProperties():void
		{
			var c:DataGridColumn;
			var n:int;
			var j:int;
			if (iterator && columns.length > 0)
			{
				var data:Object = iterator.current;
				var item:IListItemRenderer;
				n = columns.length;
				for (j = 0; j < n; j++)
				{
					c = columns[j];
					
					if (!c.visible)
						continue;
					
					item = c.getMeasuringRenderer(false, data);
					if (DisplayObject(item).parent == null){
						if(item is RadioButton){
							var radioButton:RadioButton = item as RadioButton;
							radioButton.group = radioGroup;
						}
					}
				}
				
			}
			super.commitProperties();
		}
	}
}