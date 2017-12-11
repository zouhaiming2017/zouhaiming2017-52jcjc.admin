package com.jixi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellorderSumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellorderSumExample() {
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

        public Criteria andSellordercodeIsNull() {
            addCriterion("sellOrderCode is null");
            return (Criteria) this;
        }

        public Criteria andSellordercodeIsNotNull() {
            addCriterion("sellOrderCode is not null");
            return (Criteria) this;
        }

        public Criteria andSellordercodeEqualTo(String value) {
            addCriterion("sellOrderCode =", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotEqualTo(String value) {
            addCriterion("sellOrderCode <>", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeGreaterThan(String value) {
            addCriterion("sellOrderCode >", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeGreaterThanOrEqualTo(String value) {
            addCriterion("sellOrderCode >=", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeLessThan(String value) {
            addCriterion("sellOrderCode <", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeLessThanOrEqualTo(String value) {
            addCriterion("sellOrderCode <=", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeLike(String value) {
            addCriterion("sellOrderCode like", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotLike(String value) {
            addCriterion("sellOrderCode not like", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeIn(List<String> values) {
            addCriterion("sellOrderCode in", values, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotIn(List<String> values) {
            addCriterion("sellOrderCode not in", values, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeBetween(String value1, String value2) {
            addCriterion("sellOrderCode between", value1, value2, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotBetween(String value1, String value2) {
            addCriterion("sellOrderCode not between", value1, value2, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSelldateIsNull() {
            addCriterion("sellDate is null");
            return (Criteria) this;
        }

        public Criteria andSelldateIsNotNull() {
            addCriterion("sellDate is not null");
            return (Criteria) this;
        }

        public Criteria andSelldateEqualTo(Date value) {
            addCriterion("sellDate =", value, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateNotEqualTo(Date value) {
            addCriterion("sellDate <>", value, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateGreaterThan(Date value) {
            addCriterion("sellDate >", value, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateGreaterThanOrEqualTo(Date value) {
            addCriterion("sellDate >=", value, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateLessThan(Date value) {
            addCriterion("sellDate <", value, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateLessThanOrEqualTo(Date value) {
            addCriterion("sellDate <=", value, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateIn(List<Date> values) {
            addCriterion("sellDate in", values, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateNotIn(List<Date> values) {
            addCriterion("sellDate not in", values, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateBetween(Date value1, Date value2) {
            addCriterion("sellDate between", value1, value2, "selldate");
            return (Criteria) this;
        }

        public Criteria andSelldateNotBetween(Date value1, Date value2) {
            addCriterion("sellDate not between", value1, value2, "selldate");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNull() {
            addCriterion("projectName is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("projectName is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("projectName =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("projectName <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("projectName >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("projectName >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("projectName <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("projectName <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("projectName like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("projectName not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("projectName in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("projectName not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("projectName between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("projectName not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
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

        public Criteria andCustomerphoneIsNull() {
            addCriterion("customerPhone is null");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneIsNotNull() {
            addCriterion("customerPhone is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneEqualTo(String value) {
            addCriterion("customerPhone =", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneNotEqualTo(String value) {
            addCriterion("customerPhone <>", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneGreaterThan(String value) {
            addCriterion("customerPhone >", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneGreaterThanOrEqualTo(String value) {
            addCriterion("customerPhone >=", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneLessThan(String value) {
            addCriterion("customerPhone <", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneLessThanOrEqualTo(String value) {
            addCriterion("customerPhone <=", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneLike(String value) {
            addCriterion("customerPhone like", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneNotLike(String value) {
            addCriterion("customerPhone not like", value, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneIn(List<String> values) {
            addCriterion("customerPhone in", values, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneNotIn(List<String> values) {
            addCriterion("customerPhone not in", values, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneBetween(String value1, String value2) {
            addCriterion("customerPhone between", value1, value2, "customerphone");
            return (Criteria) this;
        }

        public Criteria andCustomerphoneNotBetween(String value1, String value2) {
            addCriterion("customerPhone not between", value1, value2, "customerphone");
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

        public Criteria andSendmanIsNull() {
            addCriterion("sendman is null");
            return (Criteria) this;
        }

        public Criteria andSendmanIsNotNull() {
            addCriterion("sendman is not null");
            return (Criteria) this;
        }

        public Criteria andSendmanEqualTo(String value) {
            addCriterion("sendman =", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanNotEqualTo(String value) {
            addCriterion("sendman <>", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanGreaterThan(String value) {
            addCriterion("sendman >", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanGreaterThanOrEqualTo(String value) {
            addCriterion("sendman >=", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanLessThan(String value) {
            addCriterion("sendman <", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanLessThanOrEqualTo(String value) {
            addCriterion("sendman <=", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanLike(String value) {
            addCriterion("sendman like", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanNotLike(String value) {
            addCriterion("sendman not like", value, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanIn(List<String> values) {
            addCriterion("sendman in", values, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanNotIn(List<String> values) {
            addCriterion("sendman not in", values, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanBetween(String value1, String value2) {
            addCriterion("sendman between", value1, value2, "sendman");
            return (Criteria) this;
        }

        public Criteria andSendmanNotBetween(String value1, String value2) {
            addCriterion("sendman not between", value1, value2, "sendman");
            return (Criteria) this;
        }

        public Criteria andPickmanIsNull() {
            addCriterion("pickman is null");
            return (Criteria) this;
        }

        public Criteria andPickmanIsNotNull() {
            addCriterion("pickman is not null");
            return (Criteria) this;
        }

        public Criteria andPickmanEqualTo(String value) {
            addCriterion("pickman =", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanNotEqualTo(String value) {
            addCriterion("pickman <>", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanGreaterThan(String value) {
            addCriterion("pickman >", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanGreaterThanOrEqualTo(String value) {
            addCriterion("pickman >=", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanLessThan(String value) {
            addCriterion("pickman <", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanLessThanOrEqualTo(String value) {
            addCriterion("pickman <=", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanLike(String value) {
            addCriterion("pickman like", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanNotLike(String value) {
            addCriterion("pickman not like", value, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanIn(List<String> values) {
            addCriterion("pickman in", values, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanNotIn(List<String> values) {
            addCriterion("pickman not in", values, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanBetween(String value1, String value2) {
            addCriterion("pickman between", value1, value2, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanNotBetween(String value1, String value2) {
            addCriterion("pickman not between", value1, value2, "pickman");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneIsNull() {
            addCriterion("pickmanPhone is null");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneIsNotNull() {
            addCriterion("pickmanPhone is not null");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneEqualTo(String value) {
            addCriterion("pickmanPhone =", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneNotEqualTo(String value) {
            addCriterion("pickmanPhone <>", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneGreaterThan(String value) {
            addCriterion("pickmanPhone >", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneGreaterThanOrEqualTo(String value) {
            addCriterion("pickmanPhone >=", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneLessThan(String value) {
            addCriterion("pickmanPhone <", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneLessThanOrEqualTo(String value) {
            addCriterion("pickmanPhone <=", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneLike(String value) {
            addCriterion("pickmanPhone like", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneNotLike(String value) {
            addCriterion("pickmanPhone not like", value, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneIn(List<String> values) {
            addCriterion("pickmanPhone in", values, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneNotIn(List<String> values) {
            addCriterion("pickmanPhone not in", values, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneBetween(String value1, String value2) {
            addCriterion("pickmanPhone between", value1, value2, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andPickmanphoneNotBetween(String value1, String value2) {
            addCriterion("pickmanPhone not between", value1, value2, "pickmanphone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNull() {
            addCriterion("sendType is null");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNotNull() {
            addCriterion("sendType is not null");
            return (Criteria) this;
        }

        public Criteria andSendtypeEqualTo(String value) {
            addCriterion("sendType =", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotEqualTo(String value) {
            addCriterion("sendType <>", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThan(String value) {
            addCriterion("sendType >", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThanOrEqualTo(String value) {
            addCriterion("sendType >=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThan(String value) {
            addCriterion("sendType <", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThanOrEqualTo(String value) {
            addCriterion("sendType <=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLike(String value) {
            addCriterion("sendType like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotLike(String value) {
            addCriterion("sendType not like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIn(List<String> values) {
            addCriterion("sendType in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotIn(List<String> values) {
            addCriterion("sendType not in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeBetween(String value1, String value2) {
            addCriterion("sendType between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotBetween(String value1, String value2) {
            addCriterion("sendType not between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andOnlinesumIsNull() {
            addCriterion("onlineSum is null");
            return (Criteria) this;
        }

        public Criteria andOnlinesumIsNotNull() {
            addCriterion("onlineSum is not null");
            return (Criteria) this;
        }

        public Criteria andOnlinesumEqualTo(Double value) {
            addCriterion("onlineSum =", value, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumNotEqualTo(Double value) {
            addCriterion("onlineSum <>", value, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumGreaterThan(Double value) {
            addCriterion("onlineSum >", value, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumGreaterThanOrEqualTo(Double value) {
            addCriterion("onlineSum >=", value, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumLessThan(Double value) {
            addCriterion("onlineSum <", value, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumLessThanOrEqualTo(Double value) {
            addCriterion("onlineSum <=", value, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumIn(List<Double> values) {
            addCriterion("onlineSum in", values, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumNotIn(List<Double> values) {
            addCriterion("onlineSum not in", values, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumBetween(Double value1, Double value2) {
            addCriterion("onlineSum between", value1, value2, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andOnlinesumNotBetween(Double value1, Double value2) {
            addCriterion("onlineSum not between", value1, value2, "onlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumIsNull() {
            addCriterion("underlineSum is null");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumIsNotNull() {
            addCriterion("underlineSum is not null");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumEqualTo(Double value) {
            addCriterion("underlineSum =", value, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumNotEqualTo(Double value) {
            addCriterion("underlineSum <>", value, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumGreaterThan(Double value) {
            addCriterion("underlineSum >", value, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumGreaterThanOrEqualTo(Double value) {
            addCriterion("underlineSum >=", value, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumLessThan(Double value) {
            addCriterion("underlineSum <", value, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumLessThanOrEqualTo(Double value) {
            addCriterion("underlineSum <=", value, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumIn(List<Double> values) {
            addCriterion("underlineSum in", values, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumNotIn(List<Double> values) {
            addCriterion("underlineSum not in", values, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumBetween(Double value1, Double value2) {
            addCriterion("underlineSum between", value1, value2, "underlinesum");
            return (Criteria) this;
        }

        public Criteria andUnderlinesumNotBetween(Double value1, Double value2) {
            addCriterion("underlineSum not between", value1, value2, "underlinesum");
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

        public Criteria andAllsumIsNull() {
            addCriterion("allsum is null");
            return (Criteria) this;
        }

        public Criteria andAllsumIsNotNull() {
            addCriterion("allsum is not null");
            return (Criteria) this;
        }

        public Criteria andAllsumEqualTo(Double value) {
            addCriterion("allsum =", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumNotEqualTo(Double value) {
            addCriterion("allsum <>", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumGreaterThan(Double value) {
            addCriterion("allsum >", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumGreaterThanOrEqualTo(Double value) {
            addCriterion("allsum >=", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumLessThan(Double value) {
            addCriterion("allsum <", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumLessThanOrEqualTo(Double value) {
            addCriterion("allsum <=", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumIn(List<Double> values) {
            addCriterion("allsum in", values, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumNotIn(List<Double> values) {
            addCriterion("allsum not in", values, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumBetween(Double value1, Double value2) {
            addCriterion("allsum between", value1, value2, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumNotBetween(Double value1, Double value2) {
            addCriterion("allsum not between", value1, value2, "allsum");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceIsNull() {
            addCriterion("discountPrice is null");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceIsNotNull() {
            addCriterion("discountPrice is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceEqualTo(Double value) {
            addCriterion("discountPrice =", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceNotEqualTo(Double value) {
            addCriterion("discountPrice <>", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceGreaterThan(Double value) {
            addCriterion("discountPrice >", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("discountPrice >=", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceLessThan(Double value) {
            addCriterion("discountPrice <", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceLessThanOrEqualTo(Double value) {
            addCriterion("discountPrice <=", value, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceIn(List<Double> values) {
            addCriterion("discountPrice in", values, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceNotIn(List<Double> values) {
            addCriterion("discountPrice not in", values, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceBetween(Double value1, Double value2) {
            addCriterion("discountPrice between", value1, value2, "discountprice");
            return (Criteria) this;
        }

        public Criteria andDiscountpriceNotBetween(Double value1, Double value2) {
            addCriterion("discountPrice not between", value1, value2, "discountprice");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(Double value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(Double value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(Double value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(Double value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(Double value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(Double value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<Double> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<Double> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(Double value1, Double value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(Double value1, Double value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andReceivedsumIsNull() {
            addCriterion("receivedSum is null");
            return (Criteria) this;
        }

        public Criteria andReceivedsumIsNotNull() {
            addCriterion("receivedSum is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedsumEqualTo(Double value) {
            addCriterion("receivedSum =", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumNotEqualTo(Double value) {
            addCriterion("receivedSum <>", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumGreaterThan(Double value) {
            addCriterion("receivedSum >", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumGreaterThanOrEqualTo(Double value) {
            addCriterion("receivedSum >=", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumLessThan(Double value) {
            addCriterion("receivedSum <", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumLessThanOrEqualTo(Double value) {
            addCriterion("receivedSum <=", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumIn(List<Double> values) {
            addCriterion("receivedSum in", values, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumNotIn(List<Double> values) {
            addCriterion("receivedSum not in", values, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumBetween(Double value1, Double value2) {
            addCriterion("receivedSum between", value1, value2, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumNotBetween(Double value1, Double value2) {
            addCriterion("receivedSum not between", value1, value2, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumIsNull() {
            addCriterion("noReceivedSum is null");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumIsNotNull() {
            addCriterion("noReceivedSum is not null");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumEqualTo(Double value) {
            addCriterion("noReceivedSum =", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumNotEqualTo(Double value) {
            addCriterion("noReceivedSum <>", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumGreaterThan(Double value) {
            addCriterion("noReceivedSum >", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumGreaterThanOrEqualTo(Double value) {
            addCriterion("noReceivedSum >=", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumLessThan(Double value) {
            addCriterion("noReceivedSum <", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumLessThanOrEqualTo(Double value) {
            addCriterion("noReceivedSum <=", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumIn(List<Double> values) {
            addCriterion("noReceivedSum in", values, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumNotIn(List<Double> values) {
            addCriterion("noReceivedSum not in", values, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumBetween(Double value1, Double value2) {
            addCriterion("noReceivedSum between", value1, value2, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumNotBetween(Double value1, Double value2) {
            addCriterion("noReceivedSum not between", value1, value2, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andMaketablemanIsNull() {
            addCriterion("makeTableMan is null");
            return (Criteria) this;
        }

        public Criteria andMaketablemanIsNotNull() {
            addCriterion("makeTableMan is not null");
            return (Criteria) this;
        }

        public Criteria andMaketablemanEqualTo(String value) {
            addCriterion("makeTableMan =", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanNotEqualTo(String value) {
            addCriterion("makeTableMan <>", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanGreaterThan(String value) {
            addCriterion("makeTableMan >", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanGreaterThanOrEqualTo(String value) {
            addCriterion("makeTableMan >=", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanLessThan(String value) {
            addCriterion("makeTableMan <", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanLessThanOrEqualTo(String value) {
            addCriterion("makeTableMan <=", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanLike(String value) {
            addCriterion("makeTableMan like", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanNotLike(String value) {
            addCriterion("makeTableMan not like", value, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanIn(List<String> values) {
            addCriterion("makeTableMan in", values, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanNotIn(List<String> values) {
            addCriterion("makeTableMan not in", values, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanBetween(String value1, String value2) {
            addCriterion("makeTableMan between", value1, value2, "maketableman");
            return (Criteria) this;
        }

        public Criteria andMaketablemanNotBetween(String value1, String value2) {
            addCriterion("makeTableMan not between", value1, value2, "maketableman");
            return (Criteria) this;
        }

        public Criteria andTicketstatusIsNull() {
            addCriterion("ticketStatus is null");
            return (Criteria) this;
        }

        public Criteria andTicketstatusIsNotNull() {
            addCriterion("ticketStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTicketstatusEqualTo(String value) {
            addCriterion("ticketStatus =", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotEqualTo(String value) {
            addCriterion("ticketStatus <>", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusGreaterThan(String value) {
            addCriterion("ticketStatus >", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusGreaterThanOrEqualTo(String value) {
            addCriterion("ticketStatus >=", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusLessThan(String value) {
            addCriterion("ticketStatus <", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusLessThanOrEqualTo(String value) {
            addCriterion("ticketStatus <=", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusLike(String value) {
            addCriterion("ticketStatus like", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotLike(String value) {
            addCriterion("ticketStatus not like", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusIn(List<String> values) {
            addCriterion("ticketStatus in", values, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotIn(List<String> values) {
            addCriterion("ticketStatus not in", values, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusBetween(String value1, String value2) {
            addCriterion("ticketStatus between", value1, value2, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotBetween(String value1, String value2) {
            addCriterion("ticketStatus not between", value1, value2, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketnoIsNull() {
            addCriterion("ticketNo is null");
            return (Criteria) this;
        }

        public Criteria andTicketnoIsNotNull() {
            addCriterion("ticketNo is not null");
            return (Criteria) this;
        }

        public Criteria andTicketnoEqualTo(String value) {
            addCriterion("ticketNo =", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotEqualTo(String value) {
            addCriterion("ticketNo <>", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoGreaterThan(String value) {
            addCriterion("ticketNo >", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoGreaterThanOrEqualTo(String value) {
            addCriterion("ticketNo >=", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoLessThan(String value) {
            addCriterion("ticketNo <", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoLessThanOrEqualTo(String value) {
            addCriterion("ticketNo <=", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoLike(String value) {
            addCriterion("ticketNo like", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotLike(String value) {
            addCriterion("ticketNo not like", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoIn(List<String> values) {
            addCriterion("ticketNo in", values, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotIn(List<String> values) {
            addCriterion("ticketNo not in", values, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoBetween(String value1, String value2) {
            addCriterion("ticketNo between", value1, value2, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotBetween(String value1, String value2) {
            addCriterion("ticketNo not between", value1, value2, "ticketno");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueIsNull() {
            addCriterion("allPayStatue is null");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueIsNotNull() {
            addCriterion("allPayStatue is not null");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueEqualTo(String value) {
            addCriterion("allPayStatue =", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotEqualTo(String value) {
            addCriterion("allPayStatue <>", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueGreaterThan(String value) {
            addCriterion("allPayStatue >", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueGreaterThanOrEqualTo(String value) {
            addCriterion("allPayStatue >=", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueLessThan(String value) {
            addCriterion("allPayStatue <", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueLessThanOrEqualTo(String value) {
            addCriterion("allPayStatue <=", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueLike(String value) {
            addCriterion("allPayStatue like", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotLike(String value) {
            addCriterion("allPayStatue not like", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueIn(List<String> values) {
            addCriterion("allPayStatue in", values, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotIn(List<String> values) {
            addCriterion("allPayStatue not in", values, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueBetween(String value1, String value2) {
            addCriterion("allPayStatue between", value1, value2, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotBetween(String value1, String value2) {
            addCriterion("allPayStatue not between", value1, value2, "allpaystatue");
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