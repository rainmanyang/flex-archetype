package com.oasis.tmsv5.vo.naturalZone
{
	import com.oasis.component.tree.TreeNode;
	import com.oasis.tmsv5.vo.BaseVO;
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.zone.CheckedNaturalZoneTreeVO")]
	public class CheckedNaturalZoneTree extends BaseVO
	{
		public function CheckedNaturalZoneTree()
		{
			super();
		}
		
		public var nZoneTree:TreeNode;
		
		public var checkedNzone:ArrayCollection;
	}
}