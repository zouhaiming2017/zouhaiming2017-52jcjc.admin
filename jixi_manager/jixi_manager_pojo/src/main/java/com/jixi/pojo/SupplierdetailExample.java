package com.jixi.pojo;

import java.util.ArrayList;
import java.util.List;

public class SupplierdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SupplierdetailExample() {
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

        public Criteria andSuppliermonthcodeIsNull() {
            addCriterion("supplierMonthCode is null");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeIsNotNull() {
            addCriterion("supplierMonthCode is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeEqualTo(String value) {
            addCriterion("supplierMonthCode =", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeNotEqualTo(String value) {
            addCriterion("supplierMonthCode <>", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeGreaterThan(String value) {
            addCriterion("supplierMonthCode >", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeGreaterThanOrEqualTo(String value) {
            addCriterion("supplierMonthCode >=", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeLessThan(String value) {
            addCriterion("supplierMonthCode <", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeLessThanOrEqualTo(String value) {
            addCriterion("supplierMonthCode <=", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeLike(String value) {
            addCriterion("supplierMonthCode like", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeNotLike(String value) {
            addCriterion("supplierMonthCode not like", value, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeIn(List<String> values) {
            addCriterion("supplierMonthCode in", values, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeNotIn(List<String> values) {
            addCriterion("supplierMonthCode not in", values, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeBetween(String value1, String value2) {
            addCriterion("supplierMonthCode between", value1, value2, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliermonthcodeNotBetween(String value1, String value2) {
            addCriterion("supplierMonthCode not between", value1, value2, "suppliermonthcode");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIsNull() {
            addCriterion("supplierName is null");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIsNotNull() {
            addCriterion("supplierName is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliernameEqualTo(String value) {
            addCriterion("supplierName =", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotEqualTo(String value) {
            addCriterion("supplierName <>", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameGreaterThan(String value) {
            addCriterion("supplierName >", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameGreaterThanOrEqualTo(String value) {
            addCriterion("supplierName >=", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLessThan(String value) {
            addCriterion("supplierName <", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLessThanOrEqualTo(String value) {
            addCriterion("supplierName <=", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameLike(String value) {
            addCriterion("supplierName like", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotLike(String value) {
            addCriterion("supplierName not like", value, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameIn(List<String> values) {
            addCriterion("supplierName in", values, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotIn(List<String> values) {
            addCriterion("supplierName not in", values, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameBetween(String value1, String value2) {
            addCriterion("supplierName between", value1, value2, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliernameNotBetween(String value1, String value2) {
            addCriterion("supplierName not between", value1, value2, "suppliername");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsIsNull() {
            addCriterion("supplierSums is null");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsIsNotNull() {
            addCriterion("supplierSums is not null");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsEqualTo(Double value) {
            addCriterion("supplierSums =", value, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsNotEqualTo(Double value) {
            addCriterion("supplierSums <>", value, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsGreaterThan(Double value) {
            addCriterion("supplierSums >", value, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsGreaterThanOrEqualTo(Double value) {
            addCriterion("supplierSums >=", value, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsLessThan(Double value) {
            addCriterion("supplierSums <", value, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsLessThanOrEqualTo(Double value) {
            addCriterion("supplierSums <=", value, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsIn(List<Double> values) {
            addCriterion("supplierSums in", values, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsNotIn(List<Double> values) {
            addCriterion("supplierSums not in", values, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsBetween(Double value1, Double value2) {
            addCriterion("supplierSums between", value1, value2, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSuppliersumsNotBetween(Double value1, Double value2) {
            addCriterion("supplierSums not between", value1, value2, "suppliersums");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsIsNull() {
            addCriterion("supplierFreights is null");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsIsNotNull() {
            addCriterion("supplierFreights is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsEqualTo(Double value) {
            addCriterion("supplierFreights =", value, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsNotEqualTo(Double value) {
            addCriterion("supplierFreights <>", value, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsGreaterThan(Double value) {
            addCriterion("supplierFreights >", value, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsGreaterThanOrEqualTo(Double value) {
            addCriterion("supplierFreights >=", value, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsLessThan(Double value) {
            addCriterion("supplierFreights <", value, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsLessThanOrEqualTo(Double value) {
            addCriterion("supplierFreights <=", value, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsIn(List<Double> values) {
            addCriterion("supplierFreights in", values, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsNotIn(List<Double> values) {
            addCriterion("supplierFreights not in", values, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsBetween(Double value1, Double value2) {
            addCriterion("supplierFreights between", value1, value2, "supplierfreights");
            return (Criteria) this;
        }

        public Criteria andSupplierfreightsNotBetween(Double value1, Double value2) {
            addCriterion("supplierFreights not between", value1, value2, "supplierfreights");
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