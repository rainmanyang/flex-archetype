package com.oasis.wolfburg.vo.carrier
{
    import com.oasis.tmsv5.vo.BaseVO;

    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.carrier.ParentCompanyVO")]
    public class ParentCompany extends com.oasis.tmsv5.vo.BaseVO
    {

        public function ParentCompany(){}
        public var companyName:String;
     }
}
