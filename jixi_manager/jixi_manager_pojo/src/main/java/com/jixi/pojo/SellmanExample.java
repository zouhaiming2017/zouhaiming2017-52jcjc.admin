package com.jixi.pojo;

import java.util.ArrayList;
import java.util.List;

public class SellmanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellmanExample() {
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

        public Criteria andSellmancodeIsNull() {
            addCriterion("sellmanCode is null");
            return (Criteria) this;
        }

        public Criteria andSellmancodeIsNotNull() {
            addCriterion("sellmanCode is not null");
            return (Criteria) this;
        }

        public Criteria andSellmancodeEqualTo(String value) {
            addCriterion("sellmanCode =", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeNotEqualTo(String value) {
            addCriterion("sellmanCode <>", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeGreaterThan(String value) {
            addCriterion("sellmanCode >", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeGreaterThanOrEqualTo(String value) {
            addCriterion("sellmanCode >=", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeLessThan(String value) {
            addCriterion("sellmanCode <", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeLessThanOrEqualTo(String value) {
            addCriterion("sellmanCode <=", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeLike(String value) {
            addCriterion("sellmanCode like", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeNotLike(String value) {
            addCriterion("sellmanCode not like", value, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeIn(List<String> values) {
            addCriterion("sellmanCode in", values, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeNotIn(List<String> values) {
            addCriterion("sellmanCode not in", values, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeBetween(String value1, String value2) {
            addCriterion("sellmanCode between", value1, value2, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmancodeNotBetween(String value1, String value2) {
            addCriterion("sellmanCode not between", value1, value2, "sellmancode");
            return (Criteria) this;
        }

        public Criteria andSellmannameIsNull() {
            addCriterion("sellmanName is null");
            return (Criteria) this;
        }

        public Criteria andSellmannameIsNotNull() {
            addCriterion("sellmanName is not null");
            return (Criteria) this;
        }

        public Criteria andSellmannameEqualTo(String value) {
            addCriterion("sellmanName =", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameNotEqualTo(String value) {
            addCriterion("sellmanName <>", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameGreaterThan(String value) {
            addCriterion("sellmanName >", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameGreaterThanOrEqualTo(String value) {
            addCriterion("sellmanName >=", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameLessThan(String value) {
            addCriterion("sellmanName <", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameLessThanOrEqualTo(String value) {
            addCriterion("sellmanName <=", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameLike(String value) {
            addCriterion("sellmanName like", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameNotLike(String value) {
            addCriterion("sellmanName not like", value, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameIn(List<String> values) {
            addCriterion("sellmanName in", values, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameNotIn(List<String> values) {
            addCriterion("sellmanName not in", values, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameBetween(String value1, String value2) {
            addCriterion("sellmanName between", value1, value2, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andSellmannameNotBetween(String value1, String value2) {
            addCriterion("sellmanName not between", value1, value2, "sellmanname");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressIsNull() {
            addCriterion("sellmanAddress is null");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressIsNotNull() {
            addCriterion("sellmanAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressEqualTo(String value) {
            addCriterion("sellmanAddress =", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressNotEqualTo(String value) {
            addCriterion("sellmanAddress <>", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressGreaterThan(String value) {
            addCriterion("sellmanAddress >", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressGreaterThanOrEqualTo(String value) {
            addCriterion("sellmanAddress >=", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressLessThan(String value) {
            addCriterion("sellmanAddress <", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressLessThanOrEqualTo(String value) {
            addCriterion("sellmanAddress <=", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressLike(String value) {
            addCriterion("sellmanAddress like", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressNotLike(String value) {
            addCriterion("sellmanAddress not like", value, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressIn(List<String> values) {
            addCriterion("sellmanAddress in", values, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressNotIn(List<String> values) {
            addCriterion("sellmanAddress not in", values, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressBetween(String value1, String value2) {
            addCriterion("sellmanAddress between", value1, value2, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andSellmanaddressNotBetween(String value1, String value2) {
            addCriterion("sellmanAddress not between", value1, value2, "sellmanaddress");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNull() {
            addCriterion("leader is null");
            return (Criteria) this;
        }

        public Criteria andLeaderIsNotNull() {
            addCriterion("leader is not null");
            return (Criteria) this;
        }

        public Criteria andLeaderEqualTo(String value) {
            addCriterion("leader =", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotEqualTo(String value) {
            addCriterion("leader <>", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThan(String value) {
            addCriterion("leader >", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("leader >=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThan(String value) {
            addCriterion("leader <", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLessThanOrEqualTo(String value) {
            addCriterion("leader <=", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderLike(String value) {
            addCriterion("leader like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotLike(String value) {
            addCriterion("leader not like", value, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderIn(List<String> values) {
            addCriterion("leader in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotIn(List<String> values) {
            addCriterion("leader not in", values, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderBetween(String value1, String value2) {
            addCriterion("leader between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andLeaderNotBetween(String value1, String value2) {
            addCriterion("leader not between", value1, value2, "leader");
            return (Criteria) this;
        }

        public Criteria andSellmannatureIsNull() {
            addCriterion("sellmanNature is null");
            return (Criteria) this;
        }

        public Criteria andSellmannatureIsNotNull() {
            addCriterion("sellmanNature is not null");
            return (Criteria) this;
        }

        public Criteria andSellmannatureEqualTo(String value) {
            addCriterion("sellmanNature =", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureNotEqualTo(String value) {
            addCriterion("sellmanNature <>", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureGreaterThan(String value) {
            addCriterion("sellmanNature >", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureGreaterThanOrEqualTo(String value) {
            addCriterion("sellmanNature >=", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureLessThan(String value) {
            addCriterion("sellmanNature <", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureLessThanOrEqualTo(String value) {
            addCriterion("sellmanNature <=", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureLike(String value) {
            addCriterion("sellmanNature like", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureNotLike(String value) {
            addCriterion("sellmanNature not like", value, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureIn(List<String> values) {
            addCriterion("sellmanNature in", values, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureNotIn(List<String> values) {
            addCriterion("sellmanNature not in", values, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureBetween(String value1, String value2) {
            addCriterion("sellmanNature between", value1, value2, "sellmannature");
            return (Criteria) this;
        }

        public Criteria andSellmannatureNotBetween(String value1, String value2) {
            addCriterion("sellmanNature not between", value1, value2, "sellmannature");
            return (Criteria) this;
        }
    }

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