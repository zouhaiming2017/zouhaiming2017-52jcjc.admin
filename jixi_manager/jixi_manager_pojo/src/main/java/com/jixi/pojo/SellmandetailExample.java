package com.jixi.pojo;

import java.util.ArrayList;
import java.util.List;

public class SellmandetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellmandetailExample() {
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

        public Criteria andSellmanmonthcodeIsNull() {
            addCriterion("sellmanMonthCode is null");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeIsNotNull() {
            addCriterion("sellmanMonthCode is not null");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeEqualTo(String value) {
            addCriterion("sellmanMonthCode =", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeNotEqualTo(String value) {
            addCriterion("sellmanMonthCode <>", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeGreaterThan(String value) {
            addCriterion("sellmanMonthCode >", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeGreaterThanOrEqualTo(String value) {
            addCriterion("sellmanMonthCode >=", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeLessThan(String value) {
            addCriterion("sellmanMonthCode <", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeLessThanOrEqualTo(String value) {
            addCriterion("sellmanMonthCode <=", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeLike(String value) {
            addCriterion("sellmanMonthCode like", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeNotLike(String value) {
            addCriterion("sellmanMonthCode not like", value, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeIn(List<String> values) {
            addCriterion("sellmanMonthCode in", values, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeNotIn(List<String> values) {
            addCriterion("sellmanMonthCode not in", values, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeBetween(String value1, String value2) {
            addCriterion("sellmanMonthCode between", value1, value2, "sellmanmonthcode");
            return (Criteria) this;
        }

        public Criteria andSellmanmonthcodeNotBetween(String value1, String value2) {
            addCriterion("sellmanMonthCode not between", value1, value2, "sellmanmonthcode");
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

        public Criteria andDiscountpricesIsNull() {
            addCriterion("discountPrices is null");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesIsNotNull() {
            addCriterion("discountPrices is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesEqualTo(Double value) {
            addCriterion("discountPrices =", value, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesNotEqualTo(Double value) {
            addCriterion("discountPrices <>", value, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesGreaterThan(Double value) {
            addCriterion("discountPrices >", value, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesGreaterThanOrEqualTo(Double value) {
            addCriterion("discountPrices >=", value, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesLessThan(Double value) {
            addCriterion("discountPrices <", value, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesLessThanOrEqualTo(Double value) {
            addCriterion("discountPrices <=", value, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesIn(List<Double> values) {
            addCriterion("discountPrices in", values, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesNotIn(List<Double> values) {
            addCriterion("discountPrices not in", values, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesBetween(Double value1, Double value2) {
            addCriterion("discountPrices between", value1, value2, "discountprices");
            return (Criteria) this;
        }

        public Criteria andDiscountpricesNotBetween(Double value1, Double value2) {
            addCriterion("discountPrices not between", value1, value2, "discountprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesIsNull() {
            addCriterion("recievePrices is null");
            return (Criteria) this;
        }

        public Criteria andRecievepricesIsNotNull() {
            addCriterion("recievePrices is not null");
            return (Criteria) this;
        }

        public Criteria andRecievepricesEqualTo(Double value) {
            addCriterion("recievePrices =", value, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesNotEqualTo(Double value) {
            addCriterion("recievePrices <>", value, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesGreaterThan(Double value) {
            addCriterion("recievePrices >", value, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesGreaterThanOrEqualTo(Double value) {
            addCriterion("recievePrices >=", value, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesLessThan(Double value) {
            addCriterion("recievePrices <", value, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesLessThanOrEqualTo(Double value) {
            addCriterion("recievePrices <=", value, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesIn(List<Double> values) {
            addCriterion("recievePrices in", values, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesNotIn(List<Double> values) {
            addCriterion("recievePrices not in", values, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesBetween(Double value1, Double value2) {
            addCriterion("recievePrices between", value1, value2, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andRecievepricesNotBetween(Double value1, Double value2) {
            addCriterion("recievePrices not between", value1, value2, "recieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesIsNull() {
            addCriterion("noRecievePrices is null");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesIsNotNull() {
            addCriterion("noRecievePrices is not null");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesEqualTo(Double value) {
            addCriterion("noRecievePrices =", value, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesNotEqualTo(Double value) {
            addCriterion("noRecievePrices <>", value, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesGreaterThan(Double value) {
            addCriterion("noRecievePrices >", value, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesGreaterThanOrEqualTo(Double value) {
            addCriterion("noRecievePrices >=", value, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesLessThan(Double value) {
            addCriterion("noRecievePrices <", value, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesLessThanOrEqualTo(Double value) {
            addCriterion("noRecievePrices <=", value, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesIn(List<Double> values) {
            addCriterion("noRecievePrices in", values, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesNotIn(List<Double> values) {
            addCriterion("noRecievePrices not in", values, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesBetween(Double value1, Double value2) {
            addCriterion("noRecievePrices between", value1, value2, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andNorecievepricesNotBetween(Double value1, Double value2) {
            addCriterion("noRecievePrices not between", value1, value2, "norecieveprices");
            return (Criteria) this;
        }

        public Criteria andCommissionsIsNull() {
            addCriterion("commissions is null");
            return (Criteria) this;
        }

        public Criteria andCommissionsIsNotNull() {
            addCriterion("commissions is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionsEqualTo(Double value) {
            addCriterion("commissions =", value, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsNotEqualTo(Double value) {
            addCriterion("commissions <>", value, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsGreaterThan(Double value) {
            addCriterion("commissions >", value, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsGreaterThanOrEqualTo(Double value) {
            addCriterion("commissions >=", value, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsLessThan(Double value) {
            addCriterion("commissions <", value, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsLessThanOrEqualTo(Double value) {
            addCriterion("commissions <=", value, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsIn(List<Double> values) {
            addCriterion("commissions in", values, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsNotIn(List<Double> values) {
            addCriterion("commissions not in", values, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsBetween(Double value1, Double value2) {
            addCriterion("commissions between", value1, value2, "commissions");
            return (Criteria) this;
        }

        public Criteria andCommissionsNotBetween(Double value1, Double value2) {
            addCriterion("commissions not between", value1, value2, "commissions");
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