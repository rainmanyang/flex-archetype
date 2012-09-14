package com.oasis.component.tree
{
	
	import mx.collections.ArrayCollection;
	import mx.controls.Tree;
	import mx.core.ClassFactory;
	import mx.events.ListEvent;
     
	public class CheckTree extends Tree
	{
		/**
		 * 已选中节点对象key集合(如果是传进来装饰树的，checkedNodeKeys和checkedNodes两者传一个就可以了)
		 */
		public var checkedNodeKeys:ArrayCollection;
		/**
		 * 已选中节点对象集合(如果是传进来装饰树的，checkedNodeKeys和checkedNodes两者传一个就可以了)
		 */
		public var checkedNodes:ArrayCollection;
		/**
		 * 计算选中节点时是否计算全部选中子孙节点（包括已选中节点的所有子孙节点) 
		 */		
		public var isComputeAllCheckedNodeDescendants:Boolean = false;
        /**
         * 是否显示三状态  
         */        
        [Bindable]  
        public var checkBoxEnableState:Boolean=true;  
        
        /**
         * 与父项子项关联  
         */        
        [Bindable]  
        public var checkBoxCascadeOnCheck:Boolean=true;  

        /**
         * 双击项目
         */
        public var itemDClickSelect:Boolean=true;  

		
		/**
         * 数据源中状态字段  
         */		
        public var checkBoxStateField:String="checkboxState"; 
        public var checkBoxVisibleField:String="checkboxVisible"; 
        /**
         * 部分选中的填充色  
         */         
        [Bindable]  
        public var checkBoxBgColor:uint=0x009900;  
        
        /**
         * 填充色的透明度
         */        
        [Bindable]  
        public var checkBoxBgAlpha:Number=1; 
        
        /**
         * 填充色的边距  
         */         
        [Bindable]  
        public var checkBoxBgPadding:Number=3;  
        
        /**
         * 填充色的四角弧度  
         */
        [Bindable]  
        public var checkBoxBgElips:Number=2;  
        
        /**
         * 取消选择是否收回子项  
         */
        [Bindable]  
        public var checkBoxCloseItemsOnUnCheck:Boolean=false;  
        
        /**
         * 选择项时是否展开子项  
         */        
        [Bindable]  
        public var checkBoxOpenItemsOnCheck:Boolean=false;  
        
        /**
         * 选择框左边距的偏移量  
         */        
        [Bindable]  
        public var checkBoxLeftGap:int=8;  
        
        /**
         * 选择框右边距的偏移量  
         */        
        [Bindable]  
        public var checkBoxRightGap:int=10;  
        
		
        public function CheckTree()  
        {  
            super();  
            doubleClickEnabled=true;  
			init();
        }  
		/**
		 * 如果checkedNodeKeys变化之后，需要重新init，不然树上的checkbox状态会不对
		 * 通常是用在异步获取数据和弹出对话窗口的情况下 
		 * 
		 */		
		public function init():void{
			if(checkedNodeKeys == null && checkedNodes != null){
				computeCheckedNodeKeysFromCheckedNodes();
			}
			if(checkedNodeKeys != null && checkedNodeKeys.length > 0){
				var root:TreeNode = getRootNode();
				if(root != null){
					TreeUtil.markTreeWithParentReference(getRootNode());
					computeCheckboxStateByCheckedNodeKeys();
				}
			}
		}
        override protected function createChildren():void
        {  
            var myFactory:ClassFactory=new ClassFactory(CheckTreeRenderer);  
            this.itemRenderer=myFactory;  
            super.createChildren();  
            addEventListener(ListEvent.ITEM_DOUBLE_CLICK, onItemDClick);  
        }  
        public function PropertyChange():void
        {  
            dispatchEvent(new ListEvent(mx.events.ListEvent.CHANGE));  
        }  


        /**
         * 树菜单，双击事件
         * @param evt 双击事件源
         *
         */
        public function onItemDClick(e:ListEvent):void
        {  
            if(itemDClickSelect)  
                OpenItems();  
        }  

        /**
         * 打开Tree节点函数，被 有打开节点功能的函数调用
         * @param item 要打开的节点
         *
         */
        public function OpenItems():void
        {  
            if (this.selectedIndex >= 0 && this.dataDescriptor.isBranch(this.selectedItem))  
                this.expandItem(this.selectedItem, !this.isItemOpen(this.selectedItem), true);  
        }  
		/**
		 *  Opens or closes a branch item.
		 *  When a branch item opens, it restores the open and closed states
		 *  of its child branches if they were already opened.
		 * 
		 *  If you set <code>dataProvider</code> and then immediately call
		 *  <code>expandItem()</code> you may not see the correct behavior. 
		 *  You should either wait for the component to validate
		 *  or call <code>validateNow()</code>.
		 *
		 *  @param item Item to affect.
		 *
		 *  @param open Specify <code>true</code> to open, <code>false</code> to close.
		 *
		 *  @param animate Specify <code>true</code> to animate the transition. (Note:
		 *  If a branch has over 20 children, it does not animate the first time it opens,
		 *  for performance reasons.)
		 *
		 *  @param dispatchEvent Controls whether the tree fires an <code>open</code> event
		 *                       after the open animation is complete.
		 *
		 *  @param cause The event, if any, that initiated the item open action.
		 *
		 */
		override public function expandItem(item:Object, open:Boolean,
								   animate:Boolean = false,
								   dispatchEvent:Boolean = false,    
								   cause:Event = null):void{
			if(this.checkBoxCascadeOnCheck){
				var node:TreeNode = TreeNode(item);
				if(node.checkboxState == CheckTreeRenderer.STATE_CHECKED){
					if(node.children != null){
						for each(var child:TreeNode in node.children){
							child.checkboxState = CheckTreeRenderer.STATE_CHECKED;
						}
					}
				}
			}
			super.expandItem(item, open, animate, dispatchEvent, cause);
		}
        private function getRootNode():TreeNode{
        	var roots:ArrayCollection = ArrayCollection(this.dataProvider);
			if(roots.length > 0){
        		return TreeNode(roots.getItemAt(0));
			}else{
				return null;
			}
        }
        
        /**
         * 重新计算选中节点列表（当用户点击某个checkbox时，该checkbox状态变化后，需要调用该函数)
         * 
         */ 
        public function computeCheckedNodes():void
        {
        	var root:TreeNode = getRootNode();
			if(root != null){
	        	var visitor:ComputeCheckedNodesVisitor = new ComputeCheckedNodesVisitor();
	        	visitor.checkBoxCascadeOnCheck = this.checkBoxCascadeOnCheck;
				visitor.isComputeAllCheckedNodeDescendants = 
							this.isComputeAllCheckedNodeDescendants;
	        	root.widthFirstTraverse(visitor);
	        	this.checkedNodes = visitor.checkedNodes;
				this.checkedNodeKeys = visitor.checkedNodeKeys;
			}
        }
		/**
		 * 根据checkedNodes计算 checkedNodeKeys
		 * 
		 */		
		public function computeCheckedNodeKeysFromCheckedNodes():void{
			for each(var checkedNode:TreeNode in this.checkedNodes){
				if(checkedNodeKeys == null){
					checkedNodeKeys = new ArrayCollection();
				}
				checkedNodeKeys.addItem(checkedNode.key);
			}
		}
		/**
		 * 根据选中节点key列表来计算所有节点的checkbox状态
		 * 
		 */
		public function computeCheckboxStateByCheckedNodeKeys():void{
			var root:TreeNode = getRootNode();
			//trace('checkedNodeKeys:' + checkedNodeKeys);
			if(root == null){
				return;
			}
			if(checkedNodeKeys == null || checkedNodeKeys.length == 0){
				return;
			}
			var visitor:ComputeCheckboxStateByCheckedNodeKeys = 
						new ComputeCheckboxStateByCheckedNodeKeys();
			visitor.checkedNodeKeys = this.checkedNodeKeys;
			if(this.checkedNodes == null){
				this.checkedNodes = new ArrayCollection();
			}
			visitor.checkedNodes = this.checkedNodes;
			visitor.checkBoxCascadeOnCheck = this.checkBoxCascadeOnCheck;
			
			root.widthFirstTraverse(visitor);
			//trace('computeCheckboxStateByCheckedNodeKeys: root = ' + root);
		}
	}
}




import com.oasis.component.tree.CheckTreeRenderer;
import com.oasis.component.tree.TreeNode;
import com.oasis.component.tree.Visitor;

import mx.collections.ArrayCollection;

class ComputeCheckedNodesVisitor implements Visitor{
	public var checkedNodeKeys:ArrayCollection = new ArrayCollection();
	public var checkedNodes:ArrayCollection = new ArrayCollection();
	public var isComputeAllCheckedNodeDescendants:Boolean;
	//与父项子项关联  
	public var checkBoxCascadeOnCheck:Boolean = true;  
	public function visit(o:Object):Boolean {
		var node:TreeNode = TreeNode(o);
		if(node.checkboxState == CheckTreeRenderer.STATE_CHECKED){
			checkedNodes.addItem(node);
			checkedNodeKeys.addItem(node.key);
		}
		//1. 如果需要计算所有被选中的子子孙孙节点，必须遍历所有子节点
		//2. 父子项关联的，只有部分选中的节点才需要继续遍历子节点；
		//3. 父子项不关联的，必须继续遍历所有子节点
		if(isComputeAllCheckedNodeDescendants){
			return true;
		}else if(checkBoxCascadeOnCheck){
			if(node.checkboxState == CheckTreeRenderer.STATE_SCHRODINGER){
				return true;
			}else{
				return false;
			}
		}else{
			return true;
		}
	}
}

/**
 * 根据选中节点keys来计算树上的checkbox状态 
 * @author BL00064
 * 
 */
class ComputeCheckboxStateByCheckedNodeKeys implements Visitor{
	public var checkedNodeKeys:ArrayCollection;
	public var checkedNodes:ArrayCollection;
	//与父项子项关联  
	public var checkBoxCascadeOnCheck:Boolean = true; 
	public function visit(o:Object):Boolean {
		var node:TreeNode = TreeNode(o);
		var parentNode:TreeNode;
		if(checkedNodeKeys == null){
			return false;
		}
		if(checkedNodeKeys.contains(node.key) 
			|| checkedNodeKeys.contains(parseInt(node.key))){
			node.checkboxState = CheckTreeRenderer.STATE_CHECKED;
			checkedNodes.addItem(node);
			//trace('ComputeCheckboxStateByCheckedNodeKeys: node = ' + node);
		}else{
			parentNode = node.parent;
			if(checkBoxCascadeOnCheck){
				if(parentNode != null && parentNode.checkboxState == CheckTreeRenderer.STATE_CHECKED){
					node.checkboxState = CheckTreeRenderer.STATE_CHECKED;	
				}
			}
		}
		
		if(checkBoxCascadeOnCheck){
			if(node.checkboxState == CheckTreeRenderer.STATE_CHECKED){
				parentNode = node.parent;
				while(parentNode != null){
					if(parentNode.checkboxState != CheckTreeRenderer.STATE_CHECKED){
						parentNode.checkboxState = CheckTreeRenderer.STATE_SCHRODINGER;
					}
					parentNode = TreeNode(parentNode.parent);
				}
			}
		}
		return true;
	}
}
