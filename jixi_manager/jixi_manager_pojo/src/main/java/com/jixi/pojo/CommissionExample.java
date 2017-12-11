package com.jixi.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommissionExample() {
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

        public Criteria andT1IsNull() {
            addCriterion("T1 is null");
            return (Criteria) this;
        }

        public Criteria andT1IsNotNull() {
            addCriterion("T1 is not null");
            return (Criteria) this;
        }

        public Criteria andT1EqualTo(Double value) {
            addCriterion("T1 =", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotEqualTo(Double value) {
            addCriterion("T1 <>", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThan(Double value) {
            addCriterion("T1 >", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1GreaterThanOrEqualTo(Double value) {
            addCriterion("T1 >=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThan(Double value) {
            addCriterion("T1 <", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1LessThanOrEqualTo(Double value) {
            addCriterion("T1 <=", value, "t1");
            return (Criteria) this;
        }

        public Criteria andT1In(List<Double> values) {
            addCriterion("T1 in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotIn(List<Double> values) {
            addCriterion("T1 not in", values, "t1");
            return (Criteria) this;
        }

        public Criteria andT1Between(Double value1, Double value2) {
            addCriterion("T1 between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT1NotBetween(Double value1, Double value2) {
            addCriterion("T1 not between", value1, value2, "t1");
            return (Criteria) this;
        }

        public Criteria andT2IsNull() {
            addCriterion("T2 is null");
            return (Criteria) this;
        }

        public Criteria andT2IsNotNull() {
            addCriterion("T2 is not null");
            return (Criteria) this;
        }

        public Criteria andT2EqualTo(Double value) {
            addCriterion("T2 =", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotEqualTo(Double value) {
            addCriterion("T2 <>", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThan(Double value) {
            addCriterion("T2 >", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2GreaterThanOrEqualTo(Double value) {
            addCriterion("T2 >=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThan(Double value) {
            addCriterion("T2 <", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2LessThanOrEqualTo(Double value) {
            addCriterion("T2 <=", value, "t2");
            return (Criteria) this;
        }

        public Criteria andT2In(List<Double> values) {
            addCriterion("T2 in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotIn(List<Double> values) {
            addCriterion("T2 not in", values, "t2");
            return (Criteria) this;
        }

        public Criteria andT2Between(Double value1, Double value2) {
            addCriterion("T2 between", value1, value2, "t2");
            return (Criteria) this;
        }

        public Criteria andT2NotBetween(Double value1, Double value2) {
            addCriterion("T2 not between", value1, value2, "t2");
            return (Criteria) this;
        }

        public Criteria andT3IsNull() {
            addCriterion("T3 is null");
            return (Criteria) this;
        }

        public Criteria andT3IsNotNull() {
            addCriterion("T3 is not null");
            return (Criteria) this;
        }

        public Criteria andT3EqualTo(Double value) {
            addCriterion("T3 =", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotEqualTo(Double value) {
            addCriterion("T3 <>", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3GreaterThan(Double value) {
            addCriterion("T3 >", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3GreaterThanOrEqualTo(Double value) {
            addCriterion("T3 >=", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3LessThan(Double value) {
            addCriterion("T3 <", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3LessThanOrEqualTo(Double value) {
            addCriterion("T3 <=", value, "t3");
            return (Criteria) this;
        }

        public Criteria andT3In(List<Double> values) {
            addCriterion("T3 in", values, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotIn(List<Double> values) {
            addCriterion("T3 not in", values, "t3");
            return (Criteria) this;
        }

        public Criteria andT3Between(Double value1, Double value2) {
            addCriterion("T3 between", value1, value2, "t3");
            return (Criteria) this;
        }

        public Criteria andT3NotBetween(Double value1, Double value2) {
            addCriterion("T3 not between", value1, value2, "t3");
            return (Criteria) this;
        }

        public Criteria andT4IsNull() {
            addCriterion("T4 is null");
            return (Criteria) this;
        }

        public Criteria andT4IsNotNull() {
            addCriterion("T4 is not null");
            return (Criteria) this;
        }

        public Criteria andT4EqualTo(Double value) {
            addCriterion("T4 =", value, "t4");
            return (Criteria) this;
        }

        public Criteria andT4NotEqualTo(Double value) {
            addCriterion("T4 <>", value, "t4");
            return (Criteria) this;
        }

        public Criteria andT4GreaterThan(Double value) {
            addCriterion("T4 >", value, "t4");
            return (Criteria) this;
        }

        public Criteria andT4GreaterThanOrEqualTo(Double value) {
            addCriterion("T4 >=", value, "t4");
            return (Criteria) this;
        }

        public Criteria andT4LessThan(Double value) {
            addCriterion("T4 <", value, "t4");
            return (Criteria) this;
        }

        public Criteria andT4LessThanOrEqualTo(Double value) {
            addCriterion("T4 <=", value, "t4");
            return (Criteria) this;
        }

        public Criteria andT4In(List<Double> values) {
            addCriterion("T4 in", values, "t4");
            return (Criteria) this;
        }

        public Criteria andT4NotIn(List<Double> values) {
            addCriterion("T4 not in", values, "t4");
            return (Criteria) this;
        }

        public Criteria andT4Between(Double value1, Double value2) {
            addCriterion("T4 between", value1, value2, "t4");
            return (Criteria) this;
        }

        public Criteria andT4NotBetween(Double value1, Double value2) {
            addCriterion("T4 not between", value1, value2, "t4");
            return (Criteria) this;
        }

        public Criteria andT5IsNull() {
            addCriterion("T5 is null");
            return (Criteria) this;
        }

        public Criteria andT5IsNotNull() {
            addCriterion("T5 is not null");
            return (Criteria) this;
        }

        public Criteria andT5EqualTo(Double value) {
            addCriterion("T5 =", value, "t5");
            return (Criteria) this;
        }

        public Criteria andT5NotEqualTo(Double value) {
            addCriterion("T5 <>", value, "t5");
            return (Criteria) this;
        }

        public Criteria andT5GreaterThan(Double value) {
            addCriterion("T5 >", value, "t5");
            return (Criteria) this;
        }

        public Criteria andT5GreaterThanOrEqualTo(Double value) {
            addCriterion("T5 >=", value, "t5");
            return (Criteria) this;
        }

        public Criteria andT5LessThan(Double value) {
            addCriterion("T5 <", value, "t5");
            return (Criteria) this;
        }

        public Criteria andT5LessThanOrEqualTo(Double value) {
            addCriterion("T5 <=", value, "t5");
            return (Criteria) this;
        }

        public Criteria andT5In(List<Double> values) {
            addCriterion("T5 in", values, "t5");
            return (Criteria) this;
        }

        public Criteria andT5NotIn(List<Double> values) {
            addCriterion("T5 not in", values, "t5");
            return (Criteria) this;
        }

        public Criteria andT5Between(Double value1, Double value2) {
            addCriterion("T5 between", value1, value2, "t5");
            return (Criteria) this;
        }

        public Criteria andT5NotBetween(Double value1, Double value2) {
            addCriterion("T5 not between", value1, value2, "t5");
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