package com.oasis.wolfburg.vo.route
{
    import com.oasis.tmsv5.vo.BaseVO;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.route.RouteLineVO")]
    public class RouteLine extends com.oasis.tmsv5.vo.BaseVO
    {
        public function RouteLine(){}
        public var routeId:Number;
        public var distance:String;
        public var enrouteDays:String;
        public var startStopId:Number;
        public var startStopName:String;
        public var endStopId:Number;
        public var endStopName:String;
		public var startPosId:Number;
		public var endPosId:Number;
     }
}
