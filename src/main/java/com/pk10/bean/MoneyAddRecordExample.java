package com.pk10.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MoneyAddRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public MoneyAddRecordExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddMoneyIsNull() {
            addCriterion("add_money is null");
            return (Criteria) this;
        }

        public Criteria andAddMoneyIsNotNull() {
            addCriterion("add_money is not null");
            return (Criteria) this;
        }

        public Criteria andAddMoneyEqualTo(Double value) {
            addCriterion("add_money =", value, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyNotEqualTo(Double value) {
            addCriterion("add_money <>", value, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyGreaterThan(Double value) {
            addCriterion("add_money >", value, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("add_money >=", value, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyLessThan(Double value) {
            addCriterion("add_money <", value, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyLessThanOrEqualTo(Double value) {
            addCriterion("add_money <=", value, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyIn(List<Double> values) {
            addCriterion("add_money in", values, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyNotIn(List<Double> values) {
            addCriterion("add_money not in", values, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyBetween(Double value1, Double value2) {
            addCriterion("add_money between", value1, value2, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddMoneyNotBetween(Double value1, Double value2) {
            addCriterion("add_money not between", value1, value2, "addMoney");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameIsNull() {
            addCriterion("add_agent_name is null");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameIsNotNull() {
            addCriterion("add_agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameEqualTo(String value) {
            addCriterion("add_agent_name =", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameNotEqualTo(String value) {
            addCriterion("add_agent_name <>", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameGreaterThan(String value) {
            addCriterion("add_agent_name >", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("add_agent_name >=", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameLessThan(String value) {
            addCriterion("add_agent_name <", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameLessThanOrEqualTo(String value) {
            addCriterion("add_agent_name <=", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameLike(String value) {
            addCriterion("add_agent_name like", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameNotLike(String value) {
            addCriterion("add_agent_name not like", value, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameIn(List<String> values) {
            addCriterion("add_agent_name in", values, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameNotIn(List<String> values) {
            addCriterion("add_agent_name not in", values, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameBetween(String value1, String value2) {
            addCriterion("add_agent_name between", value1, value2, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentNameNotBetween(String value1, String value2) {
            addCriterion("add_agent_name not between", value1, value2, "addAgentName");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdIsNull() {
            addCriterion("add_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdIsNotNull() {
            addCriterion("add_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdEqualTo(Integer value) {
            addCriterion("add_agent_id =", value, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdNotEqualTo(Integer value) {
            addCriterion("add_agent_id <>", value, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdGreaterThan(Integer value) {
            addCriterion("add_agent_id >", value, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("add_agent_id >=", value, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdLessThan(Integer value) {
            addCriterion("add_agent_id <", value, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("add_agent_id <=", value, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdIn(List<Integer> values) {
            addCriterion("add_agent_id in", values, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdNotIn(List<Integer> values) {
            addCriterion("add_agent_id not in", values, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("add_agent_id between", value1, value2, "addAgentId");
            return (Criteria) this;
        }

        public Criteria andAddAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("add_agent_id not between", value1, value2, "addAgentId");
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