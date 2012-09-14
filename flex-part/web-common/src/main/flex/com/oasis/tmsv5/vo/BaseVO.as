package com.oasis.tmsv5.vo
{
	import com.best.oasis.flexbase.lang.IEqualable;

	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.vo.BaseVO")]
	public class BaseVO implements IEqualable
	{
		public var id:Number;
		
		public var lockVersion:Number;
		
		public var domainId:Number;
		
		public function BaseVO()
		{
		}
		public function equals(o:Object):Boolean{
			if(o is BaseVO){
				var t:BaseVO = BaseVO(o);
				if(id == t.id){
					return true;
				}
			}
			return false;
		}
	}
}