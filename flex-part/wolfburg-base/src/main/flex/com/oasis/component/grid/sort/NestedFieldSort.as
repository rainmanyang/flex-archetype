package com.oasis.component.grid.sort
{
	import mx.collections.Sort;
	
	/**
	 * 解决DataGridColumnNested当dataField为多级(eg. "address.state")时抛异常的bug
	 */
	public class NestedFieldSort extends Sort
	{
		public function NestedFieldSort()
		{
			super();
		}
		/**
		 *  Finds the specified object within the specified array (or the insertion
		 *  point if asked for), returning the index if found or -1 if not.
		 *  The ListCollectionView class <code>find<i>xxx</i>()</code> methods use 
		 *  this method to find the requested item; as a general rule, it is 
		 *  easier to use these functions, and not <code>findItem()</code> to find 
		 *  data in ListCollectionView-based objects. 
		 *  You call the <code>findItem()</code> method directly when writing a class
		 *  that supports sorting, such as a new ICollectionView implementation.
		 *
		 *  @param items the Array within which to search.
		 *  @param values Object containing the properties to look for (or
		 *                the object to search for, itself).
		 *                The object must consist of field name/value pairs, where
		 *                the field names are names of fields specified by the 
		 *                <code>SortFields</code> property, in the same order they 
		 *                are used in that property. 
		 *                You do not have to specify all of the fields from the 
		 *                <code>SortFields</code> property, but you 
		 *                cannot skip any in the order. 
		 *                Therefore, if the <code>SortFields</code>
		 *                properity lists three fields, you can specify its first
		 *                and second fields in this parameter, but you cannot specify 
		 *                only the first and third fields.
		 *  @param mode String containing the type of find to perform.
		 *           Valid values are
		 *                 <ul>
		 *                   <li>ANY_INDEX_MODE</li> Return any position that
		 *                   is valid for the values.
		 *                   <li>FIRST_INDEX_MODE</li> Return the position
		 *                   where the first occurrance of the values is found.
		 *                   <li>LAST_INDEX_MODE</li> Return the position
		 *                   where the
		 *                   last ocurrance of the specified values is found.
		 *                 </ul>
		 *  @param returnInsertionIndex If the method does not find an item identified
		 *                     by the <code>values</code> parameter, and this parameter
		 *                     is <code>true</code> the <code>findItem()</code>
		 *                     method returns the insertion point for the values,
		 *                     that is the point in the sorted order where you should 
		 *                     insert the item.
		 *  @param compareFunction a comparator function to use to find the item.  If 
		 *                 you do not specify this parameter, the function uses 
		 *                 the function determined by the Sort instance's 
		 *                 <code>compareFunction</code> property, 
		 *                 passing in the array of fields determined
		 *                 by the values object and the current SortFields.
		 *  @return int The index in the array of the found item.
		 *                If the <code>returnInsertionIndex</code> parameter is
		 *              <code>false</code> and the item is not found, returns -1.
		 *                If the <code>returnInsertionIndex</code> parameter is
		 *              <code>true</code> and the item is not found, returns
		 *                the index of the point in the sorted array where the values
		 *              would be inserted.
		 */
		override public function findItem(items:Array,
								 values:Object,
								 mode:String,
								 returnInsertionIndex:Boolean = false,
								 compareFunction:Function = null):int
		{
			try{
				return super.findItem(items, values, mode, returnInsertionIndex, compareFunction);
			}catch(e:Error){
				trace('Warning:NestedFieldSort ' + e);
			}
			return -1;
		}
	}
}