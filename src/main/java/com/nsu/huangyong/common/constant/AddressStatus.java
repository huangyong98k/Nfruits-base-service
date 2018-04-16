package com.nsu.huangyong.common.constant;

import lombok.Getter;

public enum AddressStatus {
    AVAILABLE(0),//可用
    NO_AVAILABLE(1);//不可用
    @Getter
    private Integer value;
    AddressStatus(Integer value) {
        this.value = value;
    }
}
