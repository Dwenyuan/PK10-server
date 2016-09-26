package com.pk10.bean;

/**
 * Created by dengfengdecao on 16/9/26.
 */
public enum AccountChangeType {

    RECHARGE("充值记录"), BET("投注记录"), LOTTERY("中奖记录");

    private String name;
    private AccountChangeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
