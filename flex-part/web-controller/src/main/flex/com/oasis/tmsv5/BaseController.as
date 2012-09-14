package com.oasis.tmsv5
{
	import com.oasis.security.ClientContext;
	
	
	public class BaseController
	{
		
		public var clientContext:ClientContext;
		
		public function BaseController()  
		{  
//			clientContext = ModelLocator.getInstance().getContext();
		}
	}
}
