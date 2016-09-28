package com.pk10.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 赠送金币记录
 * Created by dengfengdecao on 16/9/24.
 */
public class GivenMoneyRecord implements Serializable {

    private long id;
    private String currentUsername;
    private String opposingUsername;
    private Double currentMoney; // 当前用户赠送之后的余额
    private Double opposingMoney; // 对方用户增加金币后的余额
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

    public Double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(Double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public Double getOpposingMoney() {
        return opposingMoney;
    }

    public void setOpposingMoney(Double opposingMoney) {
        this.opposingMoney = opposingMoney;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
