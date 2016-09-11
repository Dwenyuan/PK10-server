package com.pk10.bean;

import java.util.Date;

public class RateHistory {
    private Integer id;

    private String normaluser;

    private Double distributorget;

    private Double agentget;

    private Double userAdd;

    private String agent;

    private String distributor;

    private Date creatat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNormaluser() {
        return normaluser;
    }

    public void setNormaluser(String normaluser) {
        this.normaluser = normaluser;
    }

    public Double getDistributorget() {
        return distributorget;
    }

    public void setDistributorget(Double distributorget) {
        this.distributorget = distributorget;
    }

    public Double getAgentget() {
        return agentget;
    }

    public void setAgentget(Double agentget) {
        this.agentget = agentget;
    }

    public Double getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(Double userAdd) {
        this.userAdd = userAdd;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public Date getCreatat() {
        return creatat;
    }

    public void setCreatat(Date creatat) {
        this.creatat = creatat;
    }
}