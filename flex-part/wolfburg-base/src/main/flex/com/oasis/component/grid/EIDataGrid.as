package com.oasis.component.grid
{
	import flash.events.ContextMenuEvent;
	import flash.events.Event;
	import flash.events.KeyboardEvent;
	import flash.events.TextEvent;
	import flash.system.System;
	import flash.text.TextField;
	import flash.text.TextFieldType;
	import flash.ui.ContextMenu;
	import flash.ui.ContextMenuItem;
	
	import mx.collections.ArrayCollection;
	import mx.collections.ListCollectionView;
	import mx.controls.*;
	import mx.controls.dataGridClasses.DataGridColumn;
	import mx.events.FlexEvent;

	/**
	 * 支持从excel复制数据到grid，并且可以从grid复制数据到excel中
	 * @author BL00064
	 *
	 */
	public class EIDataGrid extends DataGrid
	{
		/**
		 * grid item对应的类 
		 * @default Object
		 */
		public var itemClass:Class = Object;
		/**
		 * 把粘贴板里面的文本转换为grid item list的函数: 
		 * 	eg. function getItemsFromText(text:String):Array
		 * @default getItemsFromText
		 */
		public var textToItemConverter:Function = getItemsFromText;
		/**
		 * 把grid item list转换为粘贴板里面的文本的函数
		 * eg. function getTextFromItems(items:Array):String
		 * @default getTextFromItems
		 */
		public var itemTotextConverter:Function = getTextFromItems;
		/**
		 * 是否自动调整datagrid高度，以便在没有滚动条的情况下把所有行都显示出来(打印的时候需要如此)
		 */
		public var showAllRowWithoutScroll:Boolean = false;
		/**
		 * 是否允许从Excel中粘贴数据
		 */
		public var allowPasteDataFromExcel:Boolean = false;
		/**
		 * 上次高度调整值
		 */
		private var lastHeightAdjustDiff:int = -1;
		/**
		 * 上次高度调整的进行操作
		 * 有两个:1.growUp,2.growDown
		 */
		private var lastHeightAdjustOperation:String = null;
		/**
		 * 重复循环调整高度次数
		 */
		private var repeatCount:int = 0;
		
		public function EIDataGrid()
		{
			super();
			this.variableRowHeight = true;
			
		}
		
		override public function initialize():void{
			super.initialize();
			
			if(allowPasteDataFromExcel){
				this.addEventListener(KeyboardEvent.KEY_DOWN, KeyDownHandler);
				this.addEventListener(KeyboardEvent.KEY_UP, KeyUpHandler);
			}
			this.addEventListener(FlexEvent.UPDATE_COMPLETE, onUpdateComplete);
			this.contextMenu = getContextMenu();
		}
		
		protected function getContextMenu():ContextMenu{
			var myContextMenu:ContextMenu = new ContextMenu();
			var item:ContextMenuItem = new ContextMenuItem("复制选中行");
			myContextMenu.customItems.push(item);
			item.addEventListener(ContextMenuEvent.MENU_ITEM_SELECT, copyGridRowsToClipboard);
			
			return myContextMenu;
		}
		///严重警告：
		///不能override DataGrid 的set dataProvider函数，否则
		///
		override public function set dataProvider(value:Object):void
		{
			//严重警告：这里不能修改value.sort, 否则会导致FooterDataGrid里面的自动sum等不自动计算。
			//          具体原因暂时还不知道。DataGrid太神奇了
			//start: 解决DataGridColumnNested当dataField为多级(eg. "address.state")时抛异常的bug
			/*if(value != null && value is ArrayCollection){
				ArrayCollection(value).sort = new Sort();
			}*/
			/////////////////// end //////////////
			if(this.showAllRowWithoutScroll){
				if(value != null && value is ListCollectionView){
					var length:int = ListCollectionView(value).length;
					if(length < 3){
						length += 2;
					}
					var newHeight:Number = this.measureHeightOfItems(0, length) + this.headerHeight;
					if(newHeight > this.height){
						this.height = newHeight;
					}
					if( this.height <= this.headerHeight){
						this.height = this.headerHeight*2;
					}
					
				}
			}
			super.dataProvider = value;
		}
		
		/**
		 *  @private
		 *  Sizes and positions the column headers, columns, and items based on the
		 *  size of the DataGrid.
		 */
		protected function onUpdateComplete(event:FlexEvent):void
		{
						
			if( lastHeightAdjustDiff == -1 ){
				lastHeightAdjustDiff  = this.height*2;
			}
			if( repeatCount >= 2  ){
				lastHeightAdjustDiff = lastHeightAdjustDiff/2;
				if( lastHeightAdjustDiff > 50 ){
					repeatCount = 0; 
				}
			}
			if( repeatCount < 2 ){
				
				var t:int;
				if(this.showAllRowWithoutScroll && this.verticalScrollBar != null 
					&& this.verticalScrollBar.visible){
					t = computeAdjustHeight("growUp");
					this.height += t;
					lastHeightAdjustDiff = t;
					lastHeightAdjustOperation = "growUp";
				}else{
					if( lastHeightAdjustOperation != null ){
						t = computeAdjustHeight("growDown");;
						this.height -= t;
						lastHeightAdjustDiff = t;
						if( lastHeightAdjustOperation == "growUp" ){
							repeatCount++;
						}
						lastHeightAdjustOperation = "growDown";
					}
				}
			}
			if(!isNaN(this.maxHeight) && this.height > maxHeight){
				this.height = maxHeight;
			}
		}
		/**
		 * 获取当前需要调整的高度
		 */
		private function computeAdjustHeight( currentHeightAdjustOperation:String ):int{
			var result:int;
			if( currentHeightAdjustOperation == "growUp" ){
				result = lastHeightAdjustDiff*2;
			}else{
				result = lastHeightAdjustDiff/2;
			}
			return result;
		}
		
		private function KeyDownHandler(event:KeyboardEvent):void
		{
			//86 is the "V" character
			if (event.ctrlKey && event.keyCode == 86 && !this.getChildByName("clipboardProxy"))
			{
				trace('KeyDownHandler');
				// Add an invisible TextField object to the DataGrid
				var textField:TextField=new TextField();
				textField.name="clipboardProxy";
				this.addChild(textField);
				textField.visible=false;

				textField.type=TextFieldType.INPUT;
				textField.multiline=true;

				// Populate the TextField with selected data in TSV format

				textField.text=getTextFromItems(this.selectedItems);
				textField.setSelection(0, textField.text.length - 1);

				// Listen for textInput event

				textField.addEventListener(TextEvent.TEXT_INPUT, clipboardProxyPasteHandler);
				textField.addEventListener("change", handleValueChanged);
				// Set player-level focus to the TextField

				systemManager.stage.focus=textField;
			}
		} //end function
		/**
		 * 复制选中行数据到剪贴板中
		 */
		private function copyGridRowsToClipboard(event:ContextMenuEvent):void{
			System.setClipboard(getTextFromItems(this.selectedItems));
		}
		private function KeyUpHandler(event:KeyboardEvent):void
		{
			if (!event.ctrlKey)
			{
				var textField:TextField=TextField(this.getChildByName("clipboardProxy"));
				if (textField)
					this.removeChild(textField);
			}
		} //end function

		protected function handleValueChanged(event:Event):void
		{
			event.stopImmediatePropagation();
		}

		private function clipboardProxyPasteHandler(event:TextEvent):void
		{
			// Extract values from TSV format and populate the DataGrid

			var items:Array = textToItemConverter(event.text);
			for each (var item:Object in items)
				this.dataProvider.addItem(item);
		} //end function

		private function getItemsFromText(text:String):Array
		{
			var rows:Array=text.split("\n");
			if (!rows[rows.length - 1])
				rows.pop();

			var columns:Array=this.columns;
			var itemsFromText:Array=[];

			for each (var rw:String in rows)
			{
				var fields:Array=rw.split("\t");

				var n:int=Math.min(columns.length, fields.length);
				var item:Object = new itemClass();
				var last:int = -1;
				var i:int = 0;
				var j:int = 0;
				for (; i < n;i++){
					if(columns[i].dataField != null){
						item[columns[i].dataField] = fields[j];
						j++;
					}
				}
				itemsFromText.push(item);
			}

			return itemsFromText;
		}

		private function getTextFromItems(items:Array):String
		{
			var columns:Array=this.columns;
			var textFromItems:String="";
			var value:Object;
			
			if (items != null)
			{
				for each (var column:DataGridColumn in columns)
				{
					
					if (column.dataField != null && column.visible == true )
					{
						value= column.headerText;
						if (value == null)
						{
							value="";
						}
						textFromItems += value + "\t";
					}
					
				}
				textFromItems+="\n";
				var reversedItems:Array = new ArrayCollection(items).toArray();
				reversedItems.reverse();
			
				for each (var it:Object in reversedItems)
				{
					for each (var c:DataGridColumn in columns)
					{
						if (c.dataField != null && c.visible == true)
						{
							value= c.itemToLabel(it);
							if (value == null)
							{
								value="";
							}
							textFromItems += value + "\t";
						}

					}
					textFromItems+="\n";
				}
			}
			return textFromItems;
		}
		
	}
}

