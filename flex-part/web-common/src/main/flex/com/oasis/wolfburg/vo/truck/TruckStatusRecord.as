package com.oasis.wolfburg.vo.truck
{
    import com.oasis.tmsv5.vo.BaseVO;

    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.truck.TruckStatusRecordVO")]
    public class TruckStatusRecord extends com.oasis.tmsv5.vo.BaseVO
    {

        public function TruckStatusRecord(){}
        public var licensePlate:String;
        public var executeDate:Date;
        public var updatePerson:String;
        public var truckStatus:String;
        public var runningStatus:String;
        public var resourceType:String;
        public var reason:String;
     }
}
