package com.oasis.component.tree
{
	
	import flash.events.MouseEvent;
	import flash.geom.Rectangle;
	
	import mx.collections.*;
	import mx.controls.CheckBox;
	import mx.controls.Tree;
	import mx.controls.listClasses.*;
	import mx.controls.treeClasses.*;
	import mx.events.ListEvent;
	/**
     * 三状态复选框树控件
     * <br /><br />
     */   
    public class CheckTreeRenderer extends TreeItemRenderer  
    {  
        protected var myCheckBox:CheckBox;  
        /**
         * STATE_SCHRODINGER : 部分子项选中 <br />
         * STATE_CHECKED :     全部子项选中 <br />
         * STATE_UNCHECKED :   全部子项未选中 <br />
         */
        static public var STATE_SCHRODINGER:int=3;  
        static public var STATE_CHECKED:int=1;  
        static public var STATE_UNCHECKED:int=2;  

        private var myTree:CheckTree;  

        public function CheckTreeRenderer()  
        {  
            super();  
            mouseEnabled=true;  

        }  

        /**
         * 初始化完成时处理复选框和图片对象
         *
         */
        override protected function createChildren():void
        {  
            myCheckBox=new CheckBox();  
			myCheckBox.width = 18;
			myCheckBox.height = 14;
			
            addChild(myCheckBox);  
            myCheckBox.addEventListener(MouseEvent.CLICK, checkBoxToggleHandler);  
              
            myTree = this.owner as CheckTree;  
              
            super.createChildren();  
              
            myTree.addEventListener(ListEvent.CHANGE,onPropertyChange);  
              
        }  
        protected function onPropertyChange(e:ListEvent=null):void
        {  
            this.updateDisplayList(unscaledWidth,unscaledHeight);  
        }  
        /**
         * // TODO : 递归设置父项目的状态
         * @param item 项目
         * @param tree 树对象
         * @param state 目标状态
         *
         */
        private function toggleParents(item:Object, tree:Tree, state:int):void
        {  
            if (item == null)  
                return ;  
            else
            {  
                var stateField:String=myTree.checkBoxStateField;  
                var tmpTree:IList=myTree.dataProvider as IList;  
                var oldValue:Number=item[stateField] as Number;  
                var newValue:Number=state as Number;  
                  
                item[myTree.checkBoxStateField]=state;  
                tmpTree.itemUpdated(item,stateField,oldValue,newValue);  
                  
                //item[myTree.checkBoxStateField]=state;  
                var parentItem:Object=tree.getParentItem(item);  
                if(null!=parentItem)  
                    toggleParents(parentItem, tree, getState(tree, parentItem));  
            }  
        }  
        /**
         * // TODO : 递归设置父项目的状态, 这个是用来设置父子不联动情况下附项目状态的
         * @param item 项目
         * @param tree 树对象
         * @param state 目标状态
         *
         */
		private function toggleUncascadeParents(item:Object, tree:Tree, state:int):void{
			if (item == null)  
                return ;  
            else
            {
            	var stateField:String = myTree.checkBoxStateField;  
                var tmpTree:IList = myTree.dataProvider as IList;  
                var oldValue:int = item[stateField] as int;  
                var newValue:int;
                
                //如果原来不是全部选中的，需要检查是否有子孙节点被选中:
                //    1.如果有, item的状态就是部分子项选中状态，
                //    2.如果没有, item的状态 就是未选中状态
                if(oldValue != STATE_CHECKED){
	            	if(TreeUtil.isNodeHasDescendantChecked(TreeNode(item))){
	            		newValue = STATE_SCHRODINGER;
	            	}else{
	            		newValue = STATE_UNCHECKED;
	            	}
	            	item[myTree.checkBoxStateField] = newValue;  
	                tmpTree.itemUpdated(item,stateField,oldValue,newValue); 
	                var parentItem:Object=tree.getParentItem(item);  
	                if(null!=parentItem)  
	                    toggleUncascadeParents(parentItem, tree, newValue);  
                }
            	
            }
		}
        /**
         * // TODO : 设置项目的状态和子项的状态
         * @param item 项目
         * @param tree 树对象
         * @param state 目标状态
         *
         */
        private function toggleChildren(item:Object, tree:Tree, state:int):void
        {  
            if (item == null)  
                return ;  
            else
            {  
            	if(!myTree.checkBoxCascadeOnCheck){
                	var node:TreeNode = TreeNode(this.data);
                	if(TreeUtil.isNodeHasDescendantChecked(node)){
                		if(state == STATE_UNCHECKED){
                			state = STATE_SCHRODINGER;
                		}
                	}
                }
                var stateField:String=myTree.checkBoxStateField;  
                var tmpTree:IList=myTree.dataProvider as IList;  
                var oldValue:Number=item[stateField] as Number;  
                var newValue:Number=state as Number;  
                  
                item[myTree.checkBoxStateField]=state;  
                tmpTree.itemUpdated(item,stateField,oldValue,newValue);  
                  
                var treeData:ITreeDataDescriptor=tree.dataDescriptor;  
                if (myTree.checkBoxCascadeOnCheck)  
                {  
                	if(treeData.hasChildren(item)){
	                    var children:ICollectionView=treeData.getChildren(item);  
	                    var cursor:IViewCursor=children.createCursor();  
	                    while(!cursor.afterLast)  
	                    {  
	                        toggleChildren(cursor.current, tree, state);  
	                        cursor.moveNext();  
	                    }
	                }  
                }
            }  
        }  

        /**
         * //TODO:获得parent的状态
         * @param tree 树对象
         * @param parent 目标项
         * @return 状态
         *
         */
        private function getState(tree:Tree, parent:Object):int
        {  
            var noChecks:int=0;  
            var noCats:int=0;  
            var noUnChecks:int=0;  
            if (parent != null)  
            {  
                var treeData:ITreeDataDescriptor=tree.dataDescriptor;  
                var cursor:IViewCursor=treeData.getChildren(parent).createCursor();  
                while(!cursor.afterLast)  
                {  
                    if (cursor.current[myTree.checkBoxStateField] == STATE_CHECKED)  
                        noChecks++;  
                    else if (cursor.current[myTree.checkBoxStateField] == STATE_UNCHECKED)  
                        noUnChecks++;  
                    else
                        noCats++;  
                    cursor.moveNext();  
                }  
            }  

            if ((noChecks > 0 && noUnChecks > 0) || noCats > 0)  
                return STATE_SCHRODINGER;  
            else if (noChecks > 0)  
                return STATE_CHECKED;  
            else
                return STATE_UNCHECKED;  
        }  

        /**
         * //TODO:设置项目的父项状态和子项状态
         * @param event 事件
         *
         */
        private function checkBoxToggleHandler(event:MouseEvent):void
        {  
            if (data)  
            {  
                var myListData:TreeListData=TreeListData(this.listData);  
                var selectedNode:Object=myListData.item;  
                myTree=myListData.owner as CheckTree;  
                var toggle:Boolean=myCheckBox.selected;  
                if (toggle)  
                {  
                    toggleChildren(data, myTree, STATE_CHECKED);  
                    if (myTree.checkBoxOpenItemsOnCheck)  
                        myTree.expandChildrenOf(data, true);  
                }  
                else
                {  
                    toggleChildren(data, myTree, STATE_UNCHECKED);  
                    if (myTree.checkBoxCloseItemsOnUnCheck)  
                        myTree.expandChildrenOf(data, false);  
                }  
                //TODO:如果所有子项选中时需要选中父项则执行以下代码  
                var parent:Object=myTree.getParentItem(data);  
                if(null!=parent){
                	if (myTree.checkBoxCascadeOnCheck){  
                        toggleParents(parent, myTree, getState(myTree, parent));  
	                }else{
	                	var stateField:String=myTree.checkBoxStateField;  
                        toggleUncascadeParents(parent, myTree, data[stateField]);  
	                }
                }  
                
                this.myTree.computeCheckedNodes();
                //trace(this.myTree.checkedNodes);
            }  
            //myTree.PropertyChange();  
            //dispatchEvent(new FlexEvent(FlexEvent.DATA_CHANGE));  
        }  

        /**
         * 设置本项的复选框状态
         * @param checkBox 复选框
         * @param value
         * @param state 状态
         *
         */
        private function setCheckState(checkBox:CheckBox, value:Object, state:int):void
        {  
            if (state == STATE_CHECKED)  
                checkBox.selected=true;  
            else if (state == STATE_UNCHECKED)  
                checkBox.selected=false;  
            else if (state == STATE_SCHRODINGER)  
                checkBox.selected=false;  
        }  
		/**
		 * 设置本项的复选框是否显示
		 * @param checkBox 复选框
		 * @param value
		 * @param visible 状态
		 *
		 */
		private function setCheckBoxVisible(checkBox:CheckBox, value:Object, visible:Boolean):void
		{  
			checkBox.visible =  visible;
			checkBox.includeInLayout = visible;
			//checkBox.width = 0;
			//checkBox.height = 0;
			//checkBox.paddingLeft = 0;
			//checkBox.enabled = visible;
		}  
        override public function set data(value:Object):void
        {  
            if (value != null)  
            {  
                super.data=value;
				//trace('set data : ' + value);
                setCheckState(myCheckBox, value, value[myTree.checkBoxStateField]);  
				setCheckBoxVisible(myCheckBox, value, value[myTree.checkBoxVisibleField]);  
            }  
        }  
        override protected function updateDisplayList(unscaledWidth:Number, unscaledHeight:Number):void
        {  
            super.updateDisplayList(unscaledWidth, unscaledHeight);  
            if (super.data)  
            {  
				setCheckBoxVisible(myCheckBox, data, data[myTree.checkBoxVisibleField]);  
				
                if (super.icon != null)  
                {  
					myCheckBox.x=super.icon.x + myTree.checkBoxLeftGap;  
					myCheckBox.y=(height - myCheckBox.height) / 2;  
					if(data[myTree.checkBoxVisibleField]){
						super.icon.x=myCheckBox.x + myCheckBox.width + myTree.checkBoxRightGap; 
					}
                    super.label.x=super.icon.x + super.icon.width + 3;  
                }  
                else
                {  
					myCheckBox.x=super.label.x + myTree.checkBoxLeftGap;  
					myCheckBox.y=(height - myCheckBox.height) / 2;  
                    super.label.x=myCheckBox.x + myCheckBox.width + myTree.checkBoxRightGap;  
                }  
                setCheckState(myCheckBox, data, data[myTree.checkBoxStateField]);  
                if (myTree.checkBoxEnableState && data[myTree.checkBoxStateField] == STATE_SCHRODINGER)  
                {  
                    fillCheckBox(true);  
                }  
                else
                    fillCheckBox(false);  
            }  
        }  

        protected function fillCheckBox(isFill:Boolean):void
        {  
            myCheckBox.graphics.clear();  

            if (isFill)  
            {  
                var myRect:Rectangle=getCheckTreeBgRect(myTree.checkBoxBgPadding);  
				//trace('myRect:' + myRect.x + ',' + myRect.y + ',' + myRect.width + ',' + myRect.height);
                myCheckBox.graphics.beginFill(myTree.checkBoxBgColor, myTree.checkBoxBgAlpha)  
                myCheckBox.graphics.drawRoundRect(myRect.x, myRect.y, myRect.width, myRect.height, myTree.checkBoxBgElips, myTree.checkBoxBgElips);  
                myCheckBox.graphics.endFill();  
            }  
        }  

        protected function getCheckTreeBgRect(checkTreeBgPadding:Number):Rectangle  
        {  
            var myRect:Rectangle=myCheckBox.getBounds(myCheckBox);  
			if(myRect.height > 14){
				myRect.height = 14;
				myRect.width = 14;
			}
            myRect.top+=checkTreeBgPadding;  
            myRect.left+=checkTreeBgPadding;  
            myRect.bottom-=checkTreeBgPadding;  
            myRect.right-=checkTreeBgPadding;  
            return myRect;  
        }  


    } //end class 
}
