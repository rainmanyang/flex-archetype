package com.oasis.wolfburg.vo.route
{
    import com.oasis.tmsv5.vo.BaseVO;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.route.StopVO")]
    public class Stop extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Stop(){}
        public var routeId:Number;
		public var code:String;
        public var posId:Number;
        public var posName:String;
        public var seqNum:Number;
		public var arrivalDayType:Number;
		public var leaveDayType:Number;
		public var planInboundTime:Date;
		public var planOutboundTime:Date;
		
		//和页面值绑定,临时使用
		public var arrivalDate:Date = new Date();
		public var arrivalHour:Number = 0;
		public var arrivalMinute:Number = 0;
		public var leaveDate:Date = new Date();
		public var leaveHour:Number = 0;
		public var leaveMinute:Number= 0;
		
		public var arrivalText:String;
		public var leaveText:String;
		
		public var enrouteTime:String;
     }
}
