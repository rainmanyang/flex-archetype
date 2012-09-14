package com.oasis.tmsv5.vo.security
{
	import com.oasis.component.tree.TreeNode;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]          
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.security.CheckedOrgVO")]
	public class CheckedOrg
	{
		public function CheckedOrg(){}
		
		public var orgTree:TreeNode;
		
		public var checkedOrg:ArrayCollection;
		
	}
}