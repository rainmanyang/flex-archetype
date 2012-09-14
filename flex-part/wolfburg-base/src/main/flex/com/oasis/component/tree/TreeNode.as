package com.oasis.component.tree {
	
	import com.best.oasis.flexbase.lang.IEqualable;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.util.tree.TreeNode")]	
	public class TreeNode implements IEqualable {
		[Transient]
		public var parent:TreeNode;
		public var children:ArrayCollection;
		public var key:String;
		public var value:String;
		public var isLeaf:Boolean = false;
		public var checkboxVisible:Boolean = true; 
		/**
		 * 1: 选中并且不灰（所有子孙节点都被选中）； 2: 不选中； 3：选中但是灰掉（子孙节点中有没被选中的）
		 */
		public var checkboxState:int = 2; 
		public var data:Object; 
		
		public function addChild(child:TreeNode):void{
			if(children == null){
				children = new ArrayCollection();
			}
			children.addItem(child);
		}
	    
	   
	    /**
		 * visitor 设计模式
		 * 遍历(宽度优先)所有子节点（包括自己）
		 * @param visitor
		 * 			遍历的处理类
		 * @param isIncludeTheRoot 是否包含根节点
		 */
		public function widthFirstTraverse(visitor:Visitor, isIncludeTheRoot:Boolean = true):void{
			var queue:Array = new Array();
			queue.push(this);
			var node:TreeNode;
			var children:ArrayCollection;
			var i:int=0;
			while(true){
				if(queue.length == 0){
					break;
				}
				node = queue.shift();
				children = node.children;
				if(!isIncludeTheRoot && node == this){
					if(children != null){
						for(i=0; i<children.length; i++){
							queue.push(children.getItemAt(i));
						}
					}
				}else{
					if(visitor.visit(node)){
						if(children != null){
							for(i=0; i<children.length; i++){
								queue.push(children.getItemAt(i));
							}
						}
					}
				}
			}
		}
	    public function toString():String{
	    	return "[" + key + "," + value + "," + isLeaf + "," + checkboxState + "]";
	    }
	    public function equals(o:Object):Boolean{
	    	if(o != null && o is TreeNode){
	    		var target:TreeNode = TreeNode(o);
	    		if(target.key == this.key){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	}
}