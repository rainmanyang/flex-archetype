package com.oasis.wolfburg.vo.carrier
{
    import com.oasis.tmsv5.vo.BaseVO;
    
    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.carrier.CarrierVO")]
    public class Carrier extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Carrier(){}
        public var carrierCode:String;
        public var carrierName:String;
        public var carrierShortName:String;
        public var status:String;
        public var carrierType:String;
        public var licenseType:String;
        public var licenseCode:String;
        public var guarantee:String;
        public var contactPerson:String;
        public var contactAddress:String;
        public var contactPhone:String;
        public var contactMobile:String;
        public var contactFX:String;
        public var contactEmail:String;
        public var contactQQ:String;
        public var invoice:Boolean;
        public var apAge:Number;
        public var bank:String;
        public var bankAccount:String;
        public var remark:String;
        public var payWay:String;
		public var  parentCompanyId:Number;
		public var parentCompanyName:String;
		
		public var attachmentList:ArrayCollection;
     }
}
