package com.oasis.wolfburg.vo.route
{
    import com.oasis.tmsv5.vo.BaseVO;
    
    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.route.RouteVO")]
    public class Route extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Route(){}
        public var name:String;
        public var code:String;
        public var charge:String;
        public var distance:String;
        public var startStopName:String;
        public var endStopName:String;
        public var enrouteDays:String ;
        public var status:String;
		public var posNames:String;
		
		public var routeLineList:ArrayCollection;
		
		public var remark:String;
     }
}
