package com.jixi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PickorderSumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PickorderSumExample() {
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

        public Criteria andPickordercodeIsNull() {
            addCriterion("pickorderCode is null");
            return (Criteria) this;
        }

        public Criteria andPickordercodeIsNotNull() {
            addCriterion("pickorderCode is not null");
            return (Criteria) this;
        }

        public Criteria andPickordercodeEqualTo(String value) {
            addCriterion("pickorderCode =", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeNotEqualTo(String value) {
            addCriterion("pickorderCode <>", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeGreaterThan(String value) {
            addCriterion("pickorderCode >", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeGreaterThanOrEqualTo(String value) {
            addCriterion("pickorderCode >=", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeLessThan(String value) {
            addCriterion("pickorderCode <", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeLessThanOrEqualTo(String value) {
            addCriterion("pickorderCode <=", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeLike(String value) {
            addCriterion("pickorderCode like", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeNotLike(String value) {
            addCriterion("pickorderCode not like", value, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeIn(List<String> values) {
            addCriterion("pickorderCode in", values, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeNotIn(List<String> values) {
            addCriterion("pickorderCode not in", values, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeBetween(String value1, String value2) {
            addCriterion("pickorderCode between", value1, value2, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickordercodeNotBetween(String value1, String value2) {
            addCriterion("pickorderCode not between", value1, value2, "pickordercode");
            return (Criteria) this;
        }

        public Criteria andPickdataIsNull() {
            addCriterion("pickData is null");
            return (Criteria) this;
        }

        public Criteria andPickdataIsNotNull() {
            addCriterion("pickData is not null");
            return (Criteria) this;
        }

        public Criteria andPickdataEqualTo(Date value) {
            addCriterion("pickData =", value, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataNotEqualTo(Date value) {
            addCriterion("pickData <>", value, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataGreaterThan(Date value) {
            addCriterion("pickData >", value, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataGreaterThanOrEqualTo(Date value) {
            addCriterion("pickData >=", value, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataLessThan(Date value) {
            addCriterion("pickData <", value, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataLessThanOrEqualTo(Date value) {
            addCriterion("pickData <=", value, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataIn(List<Date> values) {
            addCriterion("pickData in", values, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataNotIn(List<Date> values) {
            addCriterion("pickData not in", values, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataBetween(Date value1, Date value2) {
            addCriterion("pickData between", value1, value2, "pickdata");
            return (Criteria) this;
        }

        public Criteria andPickdataNotBetween(Date value1, Date value2) {
            addCriterion("pickData not between", value1, value2, "pickdata");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
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

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andSumIsNull() {
            addCriterion("sum is null");
            return (Criteria) this;
        }

        public Criteria andSumIsNotNull() {
            addCriterion("sum is not null");
            return (Criteria) this;
        }

        public Criteria andSumEqualTo(Double value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(Double value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(Double value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(Double value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(Double value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(Double value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<Double> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<Double> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(Double value1, Double value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(Double value1, Double value2) {
            addCriterion("sum not between", value1, value2, "sum");
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
            addCriterion("allSum is null");
            return (Criteria) this;
        }

        public Criteria andAllsumIsNotNull() {
            addCriterion("allSum is not null");
            return (Criteria) this;
        }

        public Criteria andAllsumEqualTo(Double value) {
            addCriterion("allSum =", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumNotEqualTo(Double value) {
            addCriterion("allSum <>", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumGreaterThan(Double value) {
            addCriterion("allSum >", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumGreaterThanOrEqualTo(Double value) {
            addCriterion("allSum >=", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumLessThan(Double value) {
            addCriterion("allSum <", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumLessThanOrEqualTo(Double value) {
            addCriterion("allSum <=", value, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumIn(List<Double> values) {
            addCriterion("allSum in", values, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumNotIn(List<Double> values) {
            addCriterion("allSum not in", values, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumBetween(Double value1, Double value2) {
            addCriterion("allSum between", value1, value2, "allsum");
            return (Criteria) this;
        }

        public Criteria andAllsumNotBetween(Double value1, Double value2) {
            addCriterion("allSum not between", value1, value2, "allsum");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andReceivedsumIsNull() {
            addCriterion("receivedsum is null");
            return (Criteria) this;
        }

        public Criteria andReceivedsumIsNotNull() {
            addCriterion("receivedsum is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedsumEqualTo(Double value) {
            addCriterion("receivedsum =", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumNotEqualTo(Double value) {
            addCriterion("receivedsum <>", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumGreaterThan(Double value) {
            addCriterion("receivedsum >", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumGreaterThanOrEqualTo(Double value) {
            addCriterion("receivedsum >=", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumLessThan(Double value) {
            addCriterion("receivedsum <", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumLessThanOrEqualTo(Double value) {
            addCriterion("receivedsum <=", value, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumIn(List<Double> values) {
            addCriterion("receivedsum in", values, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumNotIn(List<Double> values) {
            addCriterion("receivedsum not in", values, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumBetween(Double value1, Double value2) {
            addCriterion("receivedsum between", value1, value2, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andReceivedsumNotBetween(Double value1, Double value2) {
            addCriterion("receivedsum not between", value1, value2, "receivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumIsNull() {
            addCriterion("noreceivedsum is null");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumIsNotNull() {
            addCriterion("noreceivedsum is not null");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumEqualTo(Double value) {
            addCriterion("noreceivedsum =", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumNotEqualTo(Double value) {
            addCriterion("noreceivedsum <>", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumGreaterThan(Double value) {
            addCriterion("noreceivedsum >", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumGreaterThanOrEqualTo(Double value) {
            addCriterion("noreceivedsum >=", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumLessThan(Double value) {
            addCriterion("noreceivedsum <", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumLessThanOrEqualTo(Double value) {
            addCriterion("noreceivedsum <=", value, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumIn(List<Double> values) {
            addCriterion("noreceivedsum in", values, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumNotIn(List<Double> values) {
            addCriterion("noreceivedsum not in", values, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumBetween(Double value1, Double value2) {
            addCriterion("noreceivedsum between", value1, value2, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andNoreceivedsumNotBetween(Double value1, Double value2) {
            addCriterion("noreceivedsum not between", value1, value2, "noreceivedsum");
            return (Criteria) this;
        }

        public Criteria andTicketstatusIsNull() {
            addCriterion("ticketstatus is null");
            return (Criteria) this;
        }

        public Criteria andTicketstatusIsNotNull() {
            addCriterion("ticketstatus is not null");
            return (Criteria) this;
        }

        public Criteria andTicketstatusEqualTo(String value) {
            addCriterion("ticketstatus =", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotEqualTo(String value) {
            addCriterion("ticketstatus <>", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusGreaterThan(String value) {
            addCriterion("ticketstatus >", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusGreaterThanOrEqualTo(String value) {
            addCriterion("ticketstatus >=", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusLessThan(String value) {
            addCriterion("ticketstatus <", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusLessThanOrEqualTo(String value) {
            addCriterion("ticketstatus <=", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusLike(String value) {
            addCriterion("ticketstatus like", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotLike(String value) {
            addCriterion("ticketstatus not like", value, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusIn(List<String> values) {
            addCriterion("ticketstatus in", values, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotIn(List<String> values) {
            addCriterion("ticketstatus not in", values, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusBetween(String value1, String value2) {
            addCriterion("ticketstatus between", value1, value2, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andTicketstatusNotBetween(String value1, String value2) {
            addCriterion("ticketstatus not between", value1, value2, "ticketstatus");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueIsNull() {
            addCriterion("allpaystatue is null");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueIsNotNull() {
            addCriterion("allpaystatue is not null");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueEqualTo(String value) {
            addCriterion("allpaystatue =", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotEqualTo(String value) {
            addCriterion("allpaystatue <>", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueGreaterThan(String value) {
            addCriterion("allpaystatue >", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueGreaterThanOrEqualTo(String value) {
            addCriterion("allpaystatue >=", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueLessThan(String value) {
            addCriterion("allpaystatue <", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueLessThanOrEqualTo(String value) {
            addCriterion("allpaystatue <=", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueLike(String value) {
            addCriterion("allpaystatue like", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotLike(String value) {
            addCriterion("allpaystatue not like", value, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueIn(List<String> values) {
            addCriterion("allpaystatue in", values, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotIn(List<String> values) {
            addCriterion("allpaystatue not in", values, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueBetween(String value1, String value2) {
            addCriterion("allpaystatue between", value1, value2, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andAllpaystatueNotBetween(String value1, String value2) {
            addCriterion("allpaystatue not between", value1, value2, "allpaystatue");
            return (Criteria) this;
        }

        public Criteria andTicketnoIsNull() {
            addCriterion("ticketno is null");
            return (Criteria) this;
        }

        public Criteria andTicketnoIsNotNull() {
            addCriterion("ticketno is not null");
            return (Criteria) this;
        }

        public Criteria andTicketnoEqualTo(String value) {
            addCriterion("ticketno =", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotEqualTo(String value) {
            addCriterion("ticketno <>", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoGreaterThan(String value) {
            addCriterion("ticketno >", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoGreaterThanOrEqualTo(String value) {
            addCriterion("ticketno >=", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoLessThan(String value) {
            addCriterion("ticketno <", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoLessThanOrEqualTo(String value) {
            addCriterion("ticketno <=", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoLike(String value) {
            addCriterion("ticketno like", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotLike(String value) {
            addCriterion("ticketno not like", value, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoIn(List<String> values) {
            addCriterion("ticketno in", values, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotIn(List<String> values) {
            addCriterion("ticketno not in", values, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoBetween(String value1, String value2) {
            addCriterion("ticketno between", value1, value2, "ticketno");
            return (Criteria) this;
        }

        public Criteria andTicketnoNotBetween(String value1, String value2) {
            addCriterion("ticketno not between", value1, value2, "ticketno");
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