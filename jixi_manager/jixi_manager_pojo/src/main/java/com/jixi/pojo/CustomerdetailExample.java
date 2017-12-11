package com.jixi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerdetailExample() {
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

        public Criteria andCustomermonthcodeIsNull() {
            addCriterion("customerMonthCode is null");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeIsNotNull() {
            addCriterion("customerMonthCode is not null");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeEqualTo(String value) {
            addCriterion("customerMonthCode =", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeNotEqualTo(String value) {
            addCriterion("customerMonthCode <>", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeGreaterThan(String value) {
            addCriterion("customerMonthCode >", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeGreaterThanOrEqualTo(String value) {
            addCriterion("customerMonthCode >=", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeLessThan(String value) {
            addCriterion("customerMonthCode <", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeLessThanOrEqualTo(String value) {
            addCriterion("customerMonthCode <=", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeLike(String value) {
            addCriterion("customerMonthCode like", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeNotLike(String value) {
            addCriterion("customerMonthCode not like", value, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeIn(List<String> values) {
            addCriterion("customerMonthCode in", values, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeNotIn(List<String> values) {
            addCriterion("customerMonthCode not in", values, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeBetween(String value1, String value2) {
            addCriterion("customerMonthCode between", value1, value2, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomermonthcodeNotBetween(String value1, String value2) {
            addCriterion("customerMonthCode not between", value1, value2, "customermonthcode");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNull() {
            addCriterion("customerName is null");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNotNull() {
            addCriterion("customerName is not null");
            return (Criteria) this;
        }

        public Criteria andCustomernameEqualTo(String value) {
            addCriterion("customerName =", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotEqualTo(String value) {
            addCriterion("customerName <>", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThan(String value) {
            addCriterion("customerName >", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThanOrEqualTo(String value) {
            addCriterion("customerName >=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThan(String value) {
            addCriterion("customerName <", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThanOrEqualTo(String value) {
            addCriterion("customerName <=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLike(String value) {
            addCriterion("customerName like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotLike(String value) {
            addCriterion("customerName not like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameIn(List<String> values) {
            addCriterion("customerName in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotIn(List<String> values) {
            addCriterion("customerName not in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameBetween(String value1, String value2) {
            addCriterion("customerName between", value1, value2, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotBetween(String value1, String value2) {
            addCriterion("customerName not between", value1, value2, "customername");
            return (Criteria) this;
        }

        public Criteria andSellmanIsNull() {
            addCriterion("sellman is null");
            return (Criteria) this;
        }

        public Criteria andSellmanIsNotNull() {
            addCriterion("sellman is not null");
            return (Criteria) this;
        }

        public Criteria andSellmanEqualTo(String value) {
            addCriterion("sellman =", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanNotEqualTo(String value) {
            addCriterion("sellman <>", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanGreaterThan(String value) {
            addCriterion("sellman >", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanGreaterThanOrEqualTo(String value) {
            addCriterion("sellman >=", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanLessThan(String value) {
            addCriterion("sellman <", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanLessThanOrEqualTo(String value) {
            addCriterion("sellman <=", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanLike(String value) {
            addCriterion("sellman like", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanNotLike(String value) {
            addCriterion("sellman not like", value, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanIn(List<String> values) {
            addCriterion("sellman in", values, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanNotIn(List<String> values) {
            addCriterion("sellman not in", values, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanBetween(String value1, String value2) {
            addCriterion("sellman between", value1, value2, "sellman");
            return (Criteria) this;
        }

        public Criteria andSellmanNotBetween(String value1, String value2) {
            addCriterion("sellman not between", value1, value2, "sellman");
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

        public Criteria andFreightIsNull() {
            addCriterion("freight is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("freight is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(Double value) {
            addCriterion("freight =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(Double value) {
            addCriterion("freight <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(Double value) {
            addCriterion("freight >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(Double value) {
            addCriterion("freight >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(Double value) {
            addCriterion("freight <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(Double value) {
            addCriterion("freight <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<Double> values) {
            addCriterion("freight in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<Double> values) {
            addCriterion("freight not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(Double value1, Double value2) {
            addCriterion("freight between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(Double value1, Double value2) {
            addCriterion("freight not between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightproIsNull() {
            addCriterion("freightPro is null");
            return (Criteria) this;
        }

        public Criteria andFreightproIsNotNull() {
            addCriterion("freightPro is not null");
            return (Criteria) this;
        }

        public Criteria andFreightproEqualTo(String value) {
            addCriterion("freightPro =", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproNotEqualTo(String value) {
            addCriterion("freightPro <>", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproGreaterThan(String value) {
            addCriterion("freightPro >", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproGreaterThanOrEqualTo(String value) {
            addCriterion("freightPro >=", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproLessThan(String value) {
            addCriterion("freightPro <", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproLessThanOrEqualTo(String value) {
            addCriterion("freightPro <=", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproLike(String value) {
            addCriterion("freightPro like", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproNotLike(String value) {
            addCriterion("freightPro not like", value, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproIn(List<String> values) {
            addCriterion("freightPro in", values, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproNotIn(List<String> values) {
            addCriterion("freightPro not in", values, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproBetween(String value1, String value2) {
            addCriterion("freightPro between", value1, value2, "freightpro");
            return (Criteria) this;
        }

        public Criteria andFreightproNotBetween(String value1, String value2) {
            addCriterion("freightPro not between", value1, value2, "freightpro");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Long value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Long value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Long value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Long value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Long value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Long value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Long> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Long> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Long value1, Long value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Long value1, Long value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCustomertypeIsNull() {
            addCriterion("customerType is null");
            return (Criteria) this;
        }

        public Criteria andCustomertypeIsNotNull() {
            addCriterion("customerType is not null");
            return (Criteria) this;
        }

        public Criteria andCustomertypeEqualTo(String value) {
            addCriterion("customerType =", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotEqualTo(String value) {
            addCriterion("customerType <>", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeGreaterThan(String value) {
            addCriterion("customerType >", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeGreaterThanOrEqualTo(String value) {
            addCriterion("customerType >=", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeLessThan(String value) {
            addCriterion("customerType <", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeLessThanOrEqualTo(String value) {
            addCriterion("customerType <=", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeLike(String value) {
            addCriterion("customerType like", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotLike(String value) {
            addCriterion("customerType not like", value, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeIn(List<String> values) {
            addCriterion("customerType in", values, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotIn(List<String> values) {
            addCriterion("customerType not in", values, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeBetween(String value1, String value2) {
            addCriterion("customerType between", value1, value2, "customertype");
            return (Criteria) this;
        }

        public Criteria andCustomertypeNotBetween(String value1, String value2) {
            addCriterion("customerType not between", value1, value2, "customertype");
            return (Criteria) this;
        }

        public Criteria andCommissionproIsNull() {
            addCriterion("commissionPro is null");
            return (Criteria) this;
        }

        public Criteria andCommissionproIsNotNull() {
            addCriterion("commissionPro is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionproEqualTo(String value) {
            addCriterion("commissionPro =", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproNotEqualTo(String value) {
            addCriterion("commissionPro <>", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproGreaterThan(String value) {
            addCriterion("commissionPro >", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproGreaterThanOrEqualTo(String value) {
            addCriterion("commissionPro >=", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproLessThan(String value) {
            addCriterion("commissionPro <", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproLessThanOrEqualTo(String value) {
            addCriterion("commissionPro <=", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproLike(String value) {
            addCriterion("commissionPro like", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproNotLike(String value) {
            addCriterion("commissionPro not like", value, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproIn(List<String> values) {
            addCriterion("commissionPro in", values, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproNotIn(List<String> values) {
            addCriterion("commissionPro not in", values, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproBetween(String value1, String value2) {
            addCriterion("commissionPro between", value1, value2, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andCommissionproNotBetween(String value1, String value2) {
            addCriterion("commissionPro not between", value1, value2, "commissionpro");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionIsNull() {
            addCriterion("sellmanCommission is null");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionIsNotNull() {
            addCriterion("sellmanCommission is not null");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionEqualTo(Double value) {
            addCriterion("sellmanCommission =", value, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionNotEqualTo(Double value) {
            addCriterion("sellmanCommission <>", value, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionGreaterThan(Double value) {
            addCriterion("sellmanCommission >", value, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("sellmanCommission >=", value, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionLessThan(Double value) {
            addCriterion("sellmanCommission <", value, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionLessThanOrEqualTo(Double value) {
            addCriterion("sellmanCommission <=", value, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionIn(List<Double> values) {
            addCriterion("sellmanCommission in", values, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionNotIn(List<Double> values) {
            addCriterion("sellmanCommission not in", values, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionBetween(Double value1, Double value2) {
            addCriterion("sellmanCommission between", value1, value2, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andSellmancommissionNotBetween(Double value1, Double value2) {
            addCriterion("sellmanCommission not between", value1, value2, "sellmancommission");
            return (Criteria) this;
        }

        public Criteria andThemonthIsNull() {
            addCriterion("theMonth is null");
            return (Criteria) this;
        }

        public Criteria andThemonthIsNotNull() {
            addCriterion("theMonth is not null");
            return (Criteria) this;
        }

        public Criteria andThemonthEqualTo(Date value) {
            addCriterion("theMonth =", value, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthNotEqualTo(Date value) {
            addCriterion("theMonth <>", value, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthGreaterThan(Date value) {
            addCriterion("theMonth >", value, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthGreaterThanOrEqualTo(Date value) {
            addCriterion("theMonth >=", value, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthLessThan(Date value) {
            addCriterion("theMonth <", value, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthLessThanOrEqualTo(Date value) {
            addCriterion("theMonth <=", value, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthIn(List<Date> values) {
            addCriterion("theMonth in", values, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthNotIn(List<Date> values) {
            addCriterion("theMonth not in", values, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthBetween(Date value1, Date value2) {
            addCriterion("theMonth between", value1, value2, "themonth");
            return (Criteria) this;
        }

        public Criteria andThemonthNotBetween(Date value1, Date value2) {
            addCriterion("theMonth not between", value1, value2, "themonth");
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