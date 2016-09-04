package com.pk10.bean;

public class BetInit {
    private Integer id;

    private String gName;

    private String type;

    private Integer rate;

    private Integer moneyLimit;

    private Integer initMoney;

    public BetInit() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(Integer moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public Integer getInitMoney() {
        return initMoney;
    }

    public BetInit(String gName) {
		super();
		this.gName = gName;
	}

	public void setInitMoney(Integer initMoney) {
        this.initMoney = initMoney;
    }
}