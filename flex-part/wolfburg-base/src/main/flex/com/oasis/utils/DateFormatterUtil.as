package com.oasis.utils
{
	import mx.formatters.DateFormatter;

	public class DateFormatterUtil
	{
		public static var format_Str0:String = "MM-DD";
		
		public static var format_Str1:String = "YYYY-MM-DD";
		
		public static var format_Str2:String = "YY-MM-DD JJ:NN";
		
		public static var format_Str3:String = "YY-MM-DD JJ:NN:SS";
		
		public static var format_Str4:String = "YYMMDDJJNNSS";
		
		public static var format_Str5:String = "YY年MM月DD日";
		
		public static var format_Str6:String = "YYYY-MM-DD JJ:NN:SS";
		
		public static var format_Str7:String = "YYYY-MM-DD JJ:NN";
		
		public static var format_Str8:String = "JJ:NN";
		
		public function DateFormatterUtil()
		{
		}
		
		public static function format0(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str0;
			return df.format(value);
		}
		
		public static function format1(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str1;
			return df.format(value);
		}
		
		public static function format2(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str2;
			return df.format(value);
		}
		
		public static function format3(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str3;
			return df.format(value);
		}
		
		public static function format4(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str4;
			return df.format(value);
		}
		
		public static function format5(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str5;
			return df.format(value);
		}
		
		public static function format6(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str6;
			return df.format(value);
		}
		public static function format7(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str7;
			return df.format(value);
		}
		
		public static function format8(value:Object):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = format_Str8;
			return df.format(value);
		}
		
		public static function parse(value:String):Date{
			return DateFormatter.parseDateString(value);
		}
		
		public static function weekDay(number:Number=0):String
		{
			var returnString:String;
			switch (number)
			{
				case 0:
					returnString="星期天";
					break;
				case 1:
					returnString="星期一";
					break;
				case 2:
					returnString="星期二";
					break;
				case 3:
					returnString="星期三";
					break;
				case 4:
					returnString="星期四";
					break;
				case 5:
					returnString="星期五";
					break;
				case 6:
					returnString="星期六";
					break;
				default:
					break;
			}
			return returnString;
		}
	}
}