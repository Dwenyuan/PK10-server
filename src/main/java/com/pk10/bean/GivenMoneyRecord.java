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
    private Integer currentMoney; // 当前用户赠送之后的余额
    private Integer opposingMoney; // 对方用户增加金币后的余额
    private Integer givenMoney; // 要赠送的金额
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

    public Integer getGivenMoney() {
        return givenMoney;
    }

    public void setGivenMoney(Integer givenMoney) {
        this.givenMoney = givenMoney;
    }

    public Integer getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(Integer currentMoney) {
        this.currentMoney = currentMoney;
    }

    public Integer getOpposingMoney() {
        return opposingMoney;
    }

    public void setOpposingMoney(Integer opposingMoney) {
        this.opposingMoney = opposingMoney;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
