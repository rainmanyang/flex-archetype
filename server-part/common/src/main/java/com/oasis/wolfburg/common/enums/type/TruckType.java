package com.oasis.wolfburg.common.enums.type;

public enum TruckType {

    T6_2M("prd013"), T9_6M("prd016"), T7_6M("prd014"), T4_2M("prd017"),  T7_1M("prd018"), T8_6M("prd015");
    //T6_5M,T7_2M, T6_8M, T7_55M, T5_6M, T7_4M, T5_8M;
    private String value;

    private TruckType(String value) {
        this.value = value;

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
