package com.pk10.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RateHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public RateHistoryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNormaluserIsNull() {
            addCriterion("normaluser is null");
            return (Criteria) this;
        }

        public Criteria andNormaluserIsNotNull() {
            addCriterion("normaluser is not null");
            return (Criteria) this;
        }

        public Criteria andNormaluserEqualTo(String value) {
            addCriterion("normaluser =", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserNotEqualTo(String value) {
            addCriterion("normaluser <>", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserGreaterThan(String value) {
            addCriterion("normaluser >", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserGreaterThanOrEqualTo(String value) {
            addCriterion("normaluser >=", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserLessThan(String value) {
            addCriterion("normaluser <", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserLessThanOrEqualTo(String value) {
            addCriterion("normaluser <=", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserLike(String value) {
            addCriterion("normaluser like", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserNotLike(String value) {
            addCriterion("normaluser not like", value, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserIn(List<String> values) {
            addCriterion("normaluser in", values, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserNotIn(List<String> values) {
            addCriterion("normaluser not in", values, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserBetween(String value1, String value2) {
            addCriterion("normaluser between", value1, value2, "normaluser");
            return (Criteria) this;
        }

        public Criteria andNormaluserNotBetween(String value1, String value2) {
            addCriterion("normaluser not between", value1, value2, "normaluser");
            return (Criteria) this;
        }

        public Criteria andDistributorgetIsNull() {
            addCriterion("distributorget is null");
            return (Criteria) this;
        }

        public Criteria andDistributorgetIsNotNull() {
            addCriterion("distributorget is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorgetEqualTo(Double value) {
            addCriterion("distributorget =", value, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetNotEqualTo(Double value) {
            addCriterion("distributorget <>", value, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetGreaterThan(Double value) {
            addCriterion("distributorget >", value, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetGreaterThanOrEqualTo(Double value) {
            addCriterion("distributorget >=", value, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetLessThan(Double value) {
            addCriterion("distributorget <", value, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetLessThanOrEqualTo(Double value) {
            addCriterion("distributorget <=", value, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetIn(List<Double> values) {
            addCriterion("distributorget in", values, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetNotIn(List<Double> values) {
            addCriterion("distributorget not in", values, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetBetween(Double value1, Double value2) {
            addCriterion("distributorget between", value1, value2, "distributorget");
            return (Criteria) this;
        }

        public Criteria andDistributorgetNotBetween(Double value1, Double value2) {
            addCriterion("distributorget not between", value1, value2, "distributorget");
            return (Criteria) this;
        }

        public Criteria andAgentgetIsNull() {
            addCriterion("agentget is null");
            return (Criteria) this;
        }

        public Criteria andAgentgetIsNotNull() {
            addCriterion("agentget is not null");
            return (Criteria) this;
        }

        public Criteria andAgentgetEqualTo(Double value) {
            addCriterion("agentget =", value, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetNotEqualTo(Double value) {
            addCriterion("agentget <>", value, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetGreaterThan(Double value) {
            addCriterion("agentget >", value, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetGreaterThanOrEqualTo(Double value) {
            addCriterion("agentget >=", value, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetLessThan(Double value) {
            addCriterion("agentget <", value, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetLessThanOrEqualTo(Double value) {
            addCriterion("agentget <=", value, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetIn(List<Double> values) {
            addCriterion("agentget in", values, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetNotIn(List<Double> values) {
            addCriterion("agentget not in", values, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetBetween(Double value1, Double value2) {
            addCriterion("agentget between", value1, value2, "agentget");
            return (Criteria) this;
        }

        public Criteria andAgentgetNotBetween(Double value1, Double value2) {
            addCriterion("agentget not between", value1, value2, "agentget");
            return (Criteria) this;
        }

        public Criteria andUserAddIsNull() {
            addCriterion("user_add is null");
            return (Criteria) this;
        }

        public Criteria andUserAddIsNotNull() {
            addCriterion("user_add is not null");
            return (Criteria) this;
        }

        public Criteria andUserAddEqualTo(Double value) {
            addCriterion("user_add =", value, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddNotEqualTo(Double value) {
            addCriterion("user_add <>", value, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddGreaterThan(Double value) {
            addCriterion("user_add >", value, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddGreaterThanOrEqualTo(Double value) {
            addCriterion("user_add >=", value, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddLessThan(Double value) {
            addCriterion("user_add <", value, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddLessThanOrEqualTo(Double value) {
            addCriterion("user_add <=", value, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddIn(List<Double> values) {
            addCriterion("user_add in", values, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddNotIn(List<Double> values) {
            addCriterion("user_add not in", values, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddBetween(Double value1, Double value2) {
            addCriterion("user_add between", value1, value2, "userAdd");
            return (Criteria) this;
        }

        public Criteria andUserAddNotBetween(Double value1, Double value2) {
            addCriterion("user_add not between", value1, value2, "userAdd");
            return (Criteria) this;
        }

        public Criteria andAgentIsNull() {
            addCriterion("agent is null");
            return (Criteria) this;
        }

        public Criteria andAgentIsNotNull() {
            addCriterion("agent is not null");
            return (Criteria) this;
        }

        public Criteria andAgentEqualTo(String value) {
            addCriterion("agent =", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotEqualTo(String value) {
            addCriterion("agent <>", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThan(String value) {
            addCriterion("agent >", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThanOrEqualTo(String value) {
            addCriterion("agent >=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThan(String value) {
            addCriterion("agent <", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThanOrEqualTo(String value) {
            addCriterion("agent <=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLike(String value) {
            addCriterion("agent like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotLike(String value) {
            addCriterion("agent not like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentIn(List<String> values) {
            addCriterion("agent in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotIn(List<String> values) {
            addCriterion("agent not in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentBetween(String value1, String value2) {
            addCriterion("agent between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotBetween(String value1, String value2) {
            addCriterion("agent not between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andDistributorIsNull() {
            addCriterion("distributor is null");
            return (Criteria) this;
        }

        public Criteria andDistributorIsNotNull() {
            addCriterion("distributor is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorEqualTo(String value) {
            addCriterion("distributor =", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotEqualTo(String value) {
            addCriterion("distributor <>", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorGreaterThan(String value) {
            addCriterion("distributor >", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorGreaterThanOrEqualTo(String value) {
            addCriterion("distributor >=", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLessThan(String value) {
            addCriterion("distributor <", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLessThanOrEqualTo(String value) {
            addCriterion("distributor <=", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLike(String value) {
            addCriterion("distributor like", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotLike(String value) {
            addCriterion("distributor not like", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorIn(List<String> values) {
            addCriterion("distributor in", values, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotIn(List<String> values) {
            addCriterion("distributor not in", values, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorBetween(String value1, String value2) {
            addCriterion("distributor between", value1, value2, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotBetween(String value1, String value2) {
            addCriterion("distributor not between", value1, value2, "distributor");
            return (Criteria) this;
        }

        public Criteria andCreatatIsNull() {
            addCriterion("creatat is null");
            return (Criteria) this;
        }

        public Criteria andCreatatIsNotNull() {
            addCriterion("creatat is not null");
            return (Criteria) this;
        }

        public Criteria andCreatatEqualTo(Date value) {
            addCriterionForJDBCDate("creatat =", value, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatNotEqualTo(Date value) {
            addCriterionForJDBCDate("creatat <>", value, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatGreaterThan(Date value) {
            addCriterionForJDBCDate("creatat >", value, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("creatat >=", value, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatLessThan(Date value) {
            addCriterionForJDBCDate("creatat <", value, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("creatat <=", value, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatIn(List<Date> values) {
            addCriterionForJDBCDate("creatat in", values, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatNotIn(List<Date> values) {
            addCriterionForJDBCDate("creatat not in", values, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("creatat between", value1, value2, "creatat");
            return (Criteria) this;
        }

        public Criteria andCreatatNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("creatat not between", value1, value2, "creatat");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}