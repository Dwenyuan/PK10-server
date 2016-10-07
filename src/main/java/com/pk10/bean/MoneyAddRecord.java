package com.pk10.bean;

import java.util.Date;

public class MoneyAddRecord {
    private Integer id;

    private Integer userId;

    private Date addTime;

    private Double addMoney;

    private String addAgentName;

    private Integer addAgentId;

    private String userName;

    private int balance; // 充值后的余额

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
       this.addTime = addTime;
    }

    public Double getAddMoney() {
        return addMoney;
    }

    public void setAddMoney(Double addMoney) {
        this.addMoney = addMoney;
    }

    public String getAddAgentName() {
        return addAgentName;
    }

    public void setAddAgentName(String addAgentName) {
        this.addAgentName = addAgentName;
    }

    public Integer getAddAgentId() {
        return addAgentId;
    }

    public void setAddAgentId(Integer addAgentId) {
        this.addAgentId = addAgentId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}