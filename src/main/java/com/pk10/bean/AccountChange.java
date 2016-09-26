package com.pk10.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dengfengdecao on 16/9/26.
 */
public class AccountChange implements Serializable {

    private long id;
    private String username;
    private String type;
    private double money;
    private Date time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
