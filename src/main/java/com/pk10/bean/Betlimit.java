package com.pk10.bean;

public class Betlimit {
    private Integer id;

    private String betType;

    private Integer betMultiple;

    private Long betLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
    }

    public Integer getBetMultiple() {
        return betMultiple;
    }

    public void setBetMultiple(Integer betMultiple) {
        this.betMultiple = betMultiple;
    }

    public Long getBetLimit() {
        return betLimit;
    }

    public void setBetLimit(Long betLimit) {
        this.betLimit = betLimit;
    }
}