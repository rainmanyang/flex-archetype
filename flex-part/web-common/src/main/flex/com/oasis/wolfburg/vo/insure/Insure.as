package com.oasis.wolfburg.vo.insure
{
    import com.oasis.tmsv5.vo.BaseVO;
    
    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.insure.InsureVO")]
    public class Insure extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Insure(){}
        public var insurer:String;
        public var insureCode:String;
        public var insureFrom:Date;
        public var insureTo:Date;
		public var truckId:Number;
		public var licensePlate:String;
     }
}
