package com.oasis.utils
{
	

	public class NumberNANUtil
	{
		
		public function NumberNANUtil()
		{
		}
		
		/**
		 * 当数字为NaN时显示为”“
		 * @param item
		 * @return 
		 * 
		 */
		public static function format2String(item:Number):String{
			var result:String = "";
			if(isNaN(item)){
				result = "";
			}else{
				result = item.toString();
			}
			return result;
		}
		
	}
}