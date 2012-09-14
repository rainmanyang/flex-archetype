package com.oasis.wolfburg.vo.truck
{
    import com.oasis.tmsv5.vo.BaseVO;
    
    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.truck.TruckVO")]
    public class Truck extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Truck(){}
		public var operation:Boolean;
        public var licensePlate:String;
        public var truckType:String;
        public var truckLength:String;
        public var truckWidth:String;
        public var truckHeight:String;
        public var loadVolume:String;
        public var loadWeight:String;
        public var status:String;
        public var contactPerson:String;
        public var contactPhone1:String;
		public var contactPhone2:String;
        public var gps:String;
        public var cardCode:String;
        public var carrierId:Number;
        public var ownerName:String;
        public var ownerAddress:String;
        public var ownerPhone:String;
        public var emptyWeight:String;
        public var maxWeight:String;
        public var totalWeight:String;
        public var brand:String;
        public var vin:String;
        public var engineCode:String;
        public var truckCode:String;
        public var licenseDate:Date;
        public var inspectionDate:Date;
        public var inspectionDur:Number;
        public var discardDate:Date;
        public var permissionOrg:String;
        public var insureCode1:String;
        public var insureCode2:String;
        public var insureFrom:Date;
        public var insureTo:Date;
        public var location:String;
        public var city:String;
        public var insurer:String;
        public var truckLevel:String;
        public var dirver1Id:Number;
        public var driver1Name:String;
        public var driver1Phone:String;
        public var dirver2Id:Number;
        public var driver2Name:String;
        public var driver2Phone:String;
        public var runningStatus:String;
        public var trailerCode:String;
        public var contractNumber:String;
        public var contractDate:Date;
        public var contractDateFrom:Date;
        public var contractDateTo:Date;
        public var insureCodes:String;
		public var resourceType:String;
		public var depositType:String;
		public var deposit:String;
		public var guarantee:String;
		public var truckPro:String;
		public var insureList:ArrayCollection = new ArrayCollection();
		public var driverList:ArrayCollection = new ArrayCollection();
		public var contractRouteList:ArrayCollection = new ArrayCollection();
		
		public var attachmentList:ArrayCollection;
		
		override public function equals(o:Object):Boolean{
			if(o.licensePlate == this.licensePlate)
				return true;
			return false;
		}
     }
}
