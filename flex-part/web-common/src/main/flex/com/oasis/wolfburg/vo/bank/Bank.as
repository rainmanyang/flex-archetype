package com.oasis.wolfburg.vo.bank
{
    import com.oasis.tmsv5.vo.BaseVO;

    import mx.collections.ArrayCollection;

    [Bindable]
    [RemoteClass(alias="com.oasis.wolfburg.common.vo.bank.BankVO")]
    public class Bank extends com.oasis.tmsv5.vo.BaseVO
    {

        public function Bank(){}
        public var bankName:String;
        public var branchName:String;
     }
}
