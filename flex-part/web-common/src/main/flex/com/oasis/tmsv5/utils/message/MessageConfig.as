package com.oasis.tmsv5.utils.message
{
	import flash.events.Event;
	import flash.net.URLLoader;
	import flash.net.URLRequest;
	
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.messaging.channels.StreamingAMFChannel;

	public class MessageConfig
	{
		
		private static var channelSet:ChannelSet=null;	
		private static var poolingChannelSet:ChannelSet=null;
		public function MessageConfig()
		{
			
			
		}
		
		public static function init():void{		
			var XML_URL:String = "messageChannel.xml";
			var myXMLURL:URLRequest = new URLRequest(XML_URL);
			var loader:URLLoader = new URLLoader(); 
			loader.load(myXMLURL);
			loader.addEventListener(Event.COMPLETE, xmlLoaded);					
		}
		
		private static function xmlLoaded(event:Event):void
		{		
			var myXML:XML = new XML();
			myXML = XML(event.target.data);
			
			var myPoolingAmfEndPoint:String=myXML.channel.(@id=="my-polling-amf").endpoint.@["url"]				
			var myPollingAMF:AMFChannel = new AMFChannel("my-polling-amf", myPoolingAmfEndPoint);
			
			var myStreamAmfEndPoint:String=myXML.channel.(@id=="my-streaming-amf").endpoint.@["url"]				
			var myStreamAMF:AMFChannel = new StreamingAMFChannel("my-streaming-amf", myStreamAmfEndPoint);
			trace(myPoolingAmfEndPoint);
			
			myPollingAMF.pollingEnabled = true;
			myPollingAMF.pollingInterval = 4000;
			
			channelSet = new ChannelSet();
			channelSet.addChannel(myStreamAMF);
			
		}
		
		public static function getChannelSet():ChannelSet{		
		   if(channelSet==null){
			   trace("message configuration not loaded.");
		   }
		   return channelSet;
		}
		
		public static function getPoolingChannelSet():ChannelSet{		
			if(poolingChannelSet==null){
				trace("message configuration not loaded.");
			}
			return poolingChannelSet;
		}
		/**
		 * initialize Stream channel [default]
		 * */
		public static function initializeChannel(channels:ChannelSet):void{
			channelSet=channels;
		}
		/**
		 * initialize pooling channel
		 * */
		public static function initializePoolingChannel(channels:ChannelSet):void{
			poolingChannelSet=channels;
		}
	}
	
	
}