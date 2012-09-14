package com.oasis.tmsv5.vo.security
{
	
	import com.oasis.component.tree.TreeNode;
	
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.CheckedPremissionTreeVO")]
	public class CheckedPremissionTree
	{
		public var premissionTree:TreeNode;
		
		public var checkedPremission:ArrayCollection;
		
		public function CheckedPremissionTree()
		{
		}
	}
}