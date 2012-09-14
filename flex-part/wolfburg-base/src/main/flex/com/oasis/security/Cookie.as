package com.oasis.security
{
	public class Cookie
	{
		import flash.net.SharedObject;
		
		public static const LOGIN_USERNAME:String = "LoginUserName";
		public static const SAVE_PASSWORD:String = "SavePassword";
		public static const PASSWORD:String = "Password";
		
		//私有变量，保存读取的本地shareobject
		private static var cookie:SharedObject = SharedObject.getLocal("cookie","/");
		
		public function Cookie()
		{
		}
		/**
		 * 读取cookie的value
		 */ 
		public static function getCookie(cookieName:String):Object{
			return cookie.data[cookieName];
		}
		/**
		 * 设置cookie的value，返回旧的cookieValue
		 */ 
		public static function setCookie(cookieName:String, cookieValue:Object):Object{
			var result:Object = cookie.data[cookieName];
			cookie.data[cookieName] = cookieValue;
			cookie.flush();
			return result;
		}
	}
}