package com.jixi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SellorderMasterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellorderMasterExample() {
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

        public Criteria andSellordercodeIsNull() {
            addCriterion("sellorderCode is null");
            return (Criteria) this;
        }

        public Criteria andSellordercodeIsNotNull() {
            addCriterion("sellorderCode is not null");
            return (Criteria) this;
        }

        public Criteria andSellordercodeEqualTo(String value) {
            addCriterion("sellorderCode =", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotEqualTo(String value) {
            addCriterion("sellorderCode <>", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeGreaterThan(String value) {
            addCriterion("sellorderCode >", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeGreaterThanOrEqualTo(String value) {
            addCriterion("sellorderCode >=", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeLessThan(String value) {
            addCriterion("sellorderCode <", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeLessThanOrEqualTo(String value) {
            addCriterion("sellorderCode <=", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeLike(String value) {
            addCriterion("sellorderCode like", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotLike(String value) {
            addCriterion("sellorderCode not like", value, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeIn(List<String> values) {
            addCriterion("sellorderCode in", values, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotIn(List<String> values) {
            addCriterion("sellorderCode not in", values, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeBetween(String value1, String value2) {
            addCriterion("sellorderCode between", value1, value2, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andSellordercodeNotBetween(String value1, String value2) {
            addCriterion("sellorderCode not between", value1, value2, "sellordercode");
            return (Criteria) this;
        }

        public Criteria andItemcodeIsNull() {
            addCriterion("itemCode is null");
            return (Criteria) this;
        }

        public Criteria andItemcodeIsNotNull() {
            addCriterion("itemCode is not null");
            return (Criteria) this;
        }

        public Criteria andItemcodeEqualTo(String value) {
            addCriterion("itemCode =", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotEqualTo(String value) {
            addCriterion("itemCode <>", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeGreaterThan(String value) {
            addCriterion("itemCode >", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeGreaterThanOrEqualTo(String value) {
            addCriterion("itemCode >=", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeLessThan(String value) {
            addCriterion("itemCode <", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeLessThanOrEqualTo(String value) {
            addCriterion("itemCode <=", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeLike(String value) {
            addCriterion("itemCode like", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotLike(String value) {
            addCriterion("itemCode not like", value, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeIn(List<String> values) {
            addCriterion("itemCode in", values, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotIn(List<String> values) {
            addCriterion("itemCode not in", values, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeBetween(String value1, String value2) {
            addCriterion("itemCode between", value1, value2, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemcodeNotBetween(String value1, String value2) {
            addCriterion("itemCode not between", value1, value2, "itemcode");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNull() {
            addCriterion("itemName is null");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNotNull() {
            addCriterion("itemName is not null");
            return (Criteria) this;
        }

        public Criteria andItemnameEqualTo(String value) {
            addCriterion("itemName =", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotEqualTo(String value) {
            addCriterion("itemName <>", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThan(String value) {
            addCriterion("itemName >", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThanOrEqualTo(String value) {
            addCriterion("itemName >=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThan(String value) {
            addCriterion("itemName <", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThanOrEqualTo(String value) {
            addCriterion("itemName <=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLike(String value) {
            addCriterion("itemName like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotLike(String value) {
            addCriterion("itemName not like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameIn(List<String> values) {
            addCriterion("itemName in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotIn(List<String> values) {
            addCriterion("itemName not in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameBetween(String value1, String value2) {
            addCriterion("itemName between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotBetween(String value1, String value2) {
            addCriterion("itemName not between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("standard is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("standard is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(String value) {
            addCriterion("standard =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(String value) {
            addCriterion("standard <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(String value) {
            addCriterion("standard >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(String value) {
            addCriterion("standard >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(String value) {
            addCriterion("standard <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(String value) {
            addCriterion("standard <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLike(String value) {
            addCriterion("standard like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotLike(String value) {
            addCriterion("standard not like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<String> values) {
            addCriterion("standard in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<String> values) {
            addCriterion("standard not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(String value1, String value2) {
            addCriterion("standard between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(String value1, String value2) {
            addCriterion("standard not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNull() {
            addCriterion("brandName is null");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNotNull() {
            addCriterion("brandName is not null");
            return (Criteria) this;
        }

        public Criteria andBrandnameEqualTo(String value) {
            addCriterion("brandName =", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotEqualTo(String value) {
            addCriterion("brandName <>", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThan(String value) {
            addCriterion("brandName >", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThanOrEqualTo(String value) {
            addCriterion("brandName >=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThan(String value) {
            addCriterion("brandName <", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThanOrEqualTo(String value) {
            addCriterion("brandName <=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLike(String value) {
            addCriterion("brandName like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotLike(String value) {
            addCriterion("brandName not like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameIn(List<String> values) {
            addCriterion("brandName in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotIn(List<String> values) {
            addCriterion("brandName not in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameBetween(String value1, String value2) {
            addCriterion("brandName between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotBetween(String value1, String value2) {
            addCriterion("brandName not between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andPackingsizeIsNull() {
            addCriterion("packingSize is null");
            return (Criteria) this;
        }

        public Criteria andPackingsizeIsNotNull() {
            addCriterion("packingSize is not null");
            return (Criteria) this;
        }

        public Criteria andPackingsizeEqualTo(String value) {
            addCriterion("packingSize =", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeNotEqualTo(String value) {
            addCriterion("packingSize <>", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeGreaterThan(String value) {
            addCriterion("packingSize >", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeGreaterThanOrEqualTo(String value) {
            addCriterion("packingSize >=", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeLessThan(String value) {
            addCriterion("packingSize <", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeLessThanOrEqualTo(String value) {
            addCriterion("packingSize <=", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeLike(String value) {
            addCriterion("packingSize like", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeNotLike(String value) {
            addCriterion("packingSize not like", value, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeIn(List<String> values) {
            addCriterion("packingSize in", values, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeNotIn(List<String> values) {
            addCriterion("packingSize not in", values, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeBetween(String value1, String value2) {
            addCriterion("packingSize between", value1, value2, "packingsize");
            return (Criteria) this;
        }

        public Criteria andPackingsizeNotBetween(String value1, String value2) {
            addCriterion("packingSize not between", value1, value2, "packingsize");
            return (Criteria) this;
        }

        public Criteria andChargeunitIsNull() {
            addCriterion("chargeUnit is null");
            return (Criteria) this;
        }

        public Criteria andChargeunitIsNotNull() {
            addCriterion("chargeUnit is not null");
            return (Criteria) this;
        }

        public Criteria andChargeunitEqualTo(String value) {
            addCriterion("chargeUnit =", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotEqualTo(String value) {
            addCriterion("chargeUnit <>", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitGreaterThan(String value) {
            addCriterion("chargeUnit >", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitGreaterThanOrEqualTo(String value) {
            addCriterion("chargeUnit >=", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitLessThan(String value) {
            addCriterion("chargeUnit <", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitLessThanOrEqualTo(String value) {
            addCriterion("chargeUnit <=", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitLike(String value) {
            addCriterion("chargeUnit like", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotLike(String value) {
            addCriterion("chargeUnit not like", value, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitIn(List<String> values) {
            addCriterion("chargeUnit in", values, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotIn(List<String> values) {
            addCriterion("chargeUnit not in", values, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitBetween(String value1, String value2) {
            addCriterion("chargeUnit between", value1, value2, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andChargeunitNotBetween(String value1, String value2) {
            addCriterion("chargeUnit not between", value1, value2, "chargeunit");
            return (Criteria) this;
        }

        public Criteria andOutpriceIsNull() {
            addCriterion("outprice is null");
            return (Criteria) this;
        }

        public Criteria andOutpriceIsNotNull() {
            addCriterion("outprice is not null");
            return (Criteria) this;
        }

        public Criteria andOutpriceEqualTo(Double value) {
            addCriterion("outprice =", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceNotEqualTo(Double value) {
            addCriterion("outprice <>", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceGreaterThan(Double value) {
            addCriterion("outprice >", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("outprice >=", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceLessThan(Double value) {
            addCriterion("outprice <", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceLessThanOrEqualTo(Double value) {
            addCriterion("outprice <=", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceIn(List<Double> values) {
            addCriterion("outprice in", values, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceNotIn(List<Double> values) {
            addCriterion("outprice not in", values, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceBetween(Double value1, Double value2) {
            addCriterion("outprice between", value1, value2, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceNotBetween(Double value1, Double value2) {
            addCriterion("outprice not between", value1, value2, "outprice");
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

        public Criteria andSelladdressIsNull() {
            addCriterion("sellAddress is null");
            return (Criteria) this;
        }

        public Criteria andSelladdressIsNotNull() {
            addCriterion("sellAddress is not null");
            return (Criteria) this;
        }

        public Criteria andSelladdressEqualTo(String value) {
            addCriterion("sellAddress =", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressNotEqualTo(String value) {
            addCriterion("sellAddress <>", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressGreaterThan(String value) {
            addCriterion("sellAddress >", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressGreaterThanOrEqualTo(String value) {
            addCriterion("sellAddress >=", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressLessThan(String value) {
            addCriterion("sellAddress <", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressLessThanOrEqualTo(String value) {
            addCriterion("sellAddress <=", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressLike(String value) {
            addCriterion("sellAddress like", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressNotLike(String value) {
            addCriterion("sellAddress not like", value, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressIn(List<String> values) {
            addCriterion("sellAddress in", values, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressNotIn(List<String> values) {
            addCriterion("sellAddress not in", values, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressBetween(String value1, String value2) {
            addCriterion("sellAddress between", value1, value2, "selladdress");
            return (Criteria) this;
        }

        public Criteria andSelladdressNotBetween(String value1, String value2) {
            addCriterion("sellAddress not between", value1, value2, "selladdress");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
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