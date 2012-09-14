package com.oasis.tmsv5.utils
{
	public class DateSearchUtils{
		public function DateSearchUtils(){
		}
		public static const millisecondsPerDay:int = 1000 * 60 * 60 * 24;
		
		public static function initDateInterval(interval:Function):void{
			var end:Date = new Date();
			var start:Date = new Date(new Date().setDate(1));
			interval(start,end);
		}
	}
}