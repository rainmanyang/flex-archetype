package com.oasis.wolfburg.vo.price
{
    import com.oasis.tmsv5.vo.BaseVO;
    
    import mx.collections.ArrayCollection;
    import mx.formatters.DateFormatter;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.price.PriceVO")]
    public class Price extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Price(){
		}
		
        public var status:String;
        public var routeId:Number;
        public var routeName:String;
        public var truckLevel:String;
        public var truckType:String;
        public var price:String;
        public var ventingPrice:String;
        public var overtimePrice:String;
        public var periodStart:Date;
		public var periodEnd:Date;
		public var version:int;
		public var remark:String;
		public var code:String;
		
		public var returnRouteId:Number;
		public var returnRouteName:String;
		public var historyList:ArrayCollection = new ArrayCollection();
     }
}
