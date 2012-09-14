package com.oasis.component.tree
{
	
	public class TreeUtil
	{
		/**
         * STATE_SCHRODINGER : 部分子项选中 <br />
         * STATE_CHECKED :     全部子项选中 <br />
         * STATE_UNCHECKED :   全部子项未选中 <br />
         */
        static public var STATE_SCHRODINGER:int=3;  
        static public var STATE_CHECKED:int=1;  
        static public var STATE_UNCHECKED:int=2;  
        
		public function TreeUtil()
		{
		}
		/**
		 * 判断一个节点是否有子孙节点被选中 
		 * @param node
		 * 
		 */		
		public static function isNodeHasDescendantChecked(node:TreeNode):Boolean{
        	var visitor:HasDescendantCheckedVisitor = new HasDescendantCheckedVisitor();
        	
        	node.widthFirstTraverse(visitor, false);
        	
        	return visitor.result;
		}
		/**
		 * 自动生成一颗树
		 * @param root
		 * 			树的根节点
		 * @param depth
		 * 			树的深度
		 * @param width
		 * 			树的宽度
		 * 
		 */
		public static function generateTree(root:TreeNode, depth:int, width:int):void{
			var node:TreeNode;
			for(var i:int=0; i<width; i++){
				var key:String = root.key + "^" + depth + "-" + i;
				var value:String = "节点 - " + depth + "-" + i;
				node = new TreeNode();
				node.key = key;
				node.value = value;
				if(depth == 0){
					node.isLeaf = true;
				}
				root.addChild(node);
				if(depth > 0){
					generateTree(node, depth - 1, width);
				}
			}
		}
		/**
		 * 在树上把每个节点的父节点都标记出来 
		 * @param root 树的根节点
		 * 
		 */
		public static function markTreeWithParentReference(root:TreeNode):void{
			var visitor:MarkTreeWithParentReferenceVisitor = 
						new MarkTreeWithParentReferenceVisitor();
			
			root.widthFirstTraverse(visitor, true);
		}
	}
}

import com.oasis.component.tree.TreeNode;
import com.oasis.component.tree.TreeUtil;
import com.oasis.component.tree.Visitor;


/**
 * 是否有子孙节点被选中
 * @author BL00064
 * 
 */
class HasDescendantCheckedVisitor implements Visitor{
	public var result:Boolean = false;  
	public function visit(o:Object):Boolean {
		var node:TreeNode = TreeNode(o);
		if(node.checkboxState == TreeUtil.STATE_CHECKED){
			result = true;
			return false;
		}else{
			return true;
		}
	}
}
/**
 * 标记出每个节点的父节点visitor
 * @author BL00064
 * 
 */
class MarkTreeWithParentReferenceVisitor implements Visitor{
	public var result:Boolean = false;  
	public function visit(o:Object):Boolean {
		var node:TreeNode = TreeNode(o);
		if(node.children != null){
			for each(var child:TreeNode in node.children){
				child.parent = node;	
			}
		}
		return true;
	}
}