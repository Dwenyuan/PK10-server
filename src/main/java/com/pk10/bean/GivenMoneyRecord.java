package com.pk10.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dengfengdecao on 16/9/24.
 */
public class GivenMoneyRecord implements Serializable {

    private long id;
    private String currentUsername;
    private String opposingUsername;
    private Double givenMoney; // 要赠送的金额
    private Date time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrentUsername() {
        return currentUsername;
    }

    public void setCurrentUsername(String currentUsername) {
        this.currentUsername = currentUsername;
    }

    public String getOpposingUsername() {
        return opposingUsername;
    }

    public void setOpposingUsername(String opposingUsername) {
        this.opposingUsername = opposingUsername;
    }

    public Double getGivenMoney() {
        return givenMoney;
    }

    public void setGivenMoney(Double givenMoney) {
        this.givenMoney = givenMoney;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
