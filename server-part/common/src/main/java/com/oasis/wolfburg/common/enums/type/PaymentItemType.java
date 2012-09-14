package com.oasis.wolfburg.common.enums.type;

public enum PaymentItemType {
    CONTRACK_PRICE("prd11"), OVERTIME_PRICE("prd12");

    private String prdCode;

    private PaymentItemType(String prdCode) {
        this.prdCode = prdCode;

    }

    public String getPrdCode() {
        return prdCode;
    }

}
