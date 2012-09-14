package com.oasis.component.page {
	
	import mx.collections.ArrayCollection;
	[Bindable]
	[RemoteClass(alias="com.oasis.tmsv5.common.util.page.PageList")]
	public class PageList {
	    /**
	     * 每页的列表
	     */
	    public var list:ArrayCollection;
	
	    /**
	     * 总记录数
	     */
	    public var fullListSize:int= 0;
	
	    /**
	     * 当前页码
	     */
	    public var pageNumber:int= 1;
	
	    /**
	     * 每页记录数 page size
	     */
	    public var objectsPerPage:int= 20;
	
	    public var sortCriterion:String;
	
	    public var searchId:String;
	
	}
}