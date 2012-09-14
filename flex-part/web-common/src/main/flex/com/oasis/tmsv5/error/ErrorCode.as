package com.oasis.tmsv5.error
{
	public class ErrorCode
	{
		public static const USER_NOT_EXIST:String = "USER_NOT_EXIST";
		public static const BAD_CREDENTIALS:String = "BAD_CREDENTIALS";
		/**
		 * 没有登录 
		 */
		public static const NOT_LOGINED:String = "NOT_LOGINED";
		/**
		 * 数据无效 
		 */
		public static const DATA_INVALID:String = "DATA_INVALID";
		public static const SEND_FAILED:String = "Send failed";
		public function ErrorCode()
		{
		}
		
		public static const CAN_NOT_FIND_SECURITY_CONTEXT:String = "can not find security context";

	}
}