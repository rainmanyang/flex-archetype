package com.oasis.wolfburg.vo.truckRSSchedule
{
    import com.oasis.tmsv5.vo.BaseVO;
    
    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.truckRSSchedule.TruckRSScheduleVO")]
    public class TruckRSSchedule extends com.oasis.tmsv5.vo.BaseVO
    {

        public function TruckRSSchedule(){}
        public var name:String;
        public var routeId:Number;
        public var routeName:String;
        public var opOrgId:Number;
        public var opOrgName:String;
		public var orgTreePath:String;
        public var truckId:Number;
        public var truckType:String ;
        public var allTime:String;
		public var beginDate:Date;
		public var endDate:Date;
		public var excludingDates:String;
		//public var stopPlanTime:String;
		public var status:String;
		public var includingDates:String;
		public var stopList:ArrayCollection;
		
		public var sunday:Boolean = false;
		public var monday:Boolean = false;
		public var tuesday:Boolean = false;
		public var wednesday:Boolean = false;
		public var thursday:Boolean = false;
		public var friday:Boolean = false;
		public var saturday:Boolean = false;
		
		public var stops:ArrayCollection = new ArrayCollection();
		
		public var departureTime:String;
		public var arrivalTime:String;
     }
}
