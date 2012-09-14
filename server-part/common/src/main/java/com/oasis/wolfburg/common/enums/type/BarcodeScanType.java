package com.oasis.wolfburg.common.enums.type;

public enum BarcodeScanType {
    SCAN(0), MANUAL(1);

    private int value;

    private BarcodeScanType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
