package com.oasis.component.page {
	
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.util.page.BasePageSO")]
	public class BasePageSO {
	    /**
	     * 当前页码
	     */
	    public var pageNumber:int = 1;
	    /**
	     * 每页记录数 page size
	     */
	    public var objectsPerPage:int = 50;
	    
	    /**
	     * 排序字段
	     */
	    public var orderFields:ArrayCollection;
	    
	    /**
	     * 排序类型
	     */
	    public var orderType:String = OrderType.DESC;
		/**
		 * 排序类型
		 */
		public var orderTypes:ArrayCollection;
	    /**
	     * 是否需要取数据列表回来
	     * 用来处理某些查询只需要返回记录总条数的情况
	     */
	    public var withoutListData:Boolean= false;
	    
	    public function BasePageSO() {
	    }
	}
}