package com.oasis.wolfburg.vo.driver
{
    import com.oasis.tmsv5.vo.BaseVO;

    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.driver.DriverVO")]
    public class Driver extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Driver(){}
        public var name:String;
        public var code:String;
        public var mobilePhone:String;
        public var address:String;
        public var status:String;
        public var license:String;
        public var idcard:String;
        public var licenseDate:Date;
        public var periodStart:Date;
        public var periodEnd:Date;
        public var allowedTruck:String;
        public var carrierId:Number;
        public var carrierName:String;
        public var truckId:Number;
        public var truckName:String;
		
		public var attachmentList:ArrayCollection;
     }
}
