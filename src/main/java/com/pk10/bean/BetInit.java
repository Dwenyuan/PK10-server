package com.pk10.bean;

public class BetInit {
    private Integer id;

    private String gName;

    private String type;

    private Double rate;

    private Double moneyLimit;

    private Double initMoney;

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

    public BetInit(String gName) {
		super();
		this.gName = gName;
	}

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(Double moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public Double getInitMoney() {
        return initMoney;
    }

    public void setInitMoney(Double initMoney) {
        this.initMoney = initMoney;
    }
}