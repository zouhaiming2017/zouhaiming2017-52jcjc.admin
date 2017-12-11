package com.jixi.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PickorderMasterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PickorderMasterExample() {
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

        public Criteria andInpriceIsNull() {
            addCriterion("inprice is null");
            return (Criteria) this;
        }

        public Criteria andInpriceIsNotNull() {
            addCriterion("inprice is not null");
            return (Criteria) this;
        }

        public Criteria andInpriceEqualTo(Double value) {
            addCriterion("inprice =", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceNotEqualTo(Double value) {
            addCriterion("inprice <>", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceGreaterThan(Double value) {
            addCriterion("inprice >", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("inprice >=", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceLessThan(Double value) {
            addCriterion("inprice <", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceLessThanOrEqualTo(Double value) {
            addCriterion("inprice <=", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceIn(List<Double> values) {
            addCriterion("inprice in", values, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceNotIn(List<Double> values) {
            addCriterion("inprice not in", values, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceBetween(Double value1, Double value2) {
            addCriterion("inprice between", value1, value2, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceNotBetween(Double value1, Double value2) {
            addCriterion("inprice not between", value1, value2, "inprice");
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

        public Criteria andPickdateIsNull() {
            addCriterion("pickDate is null");
            return (Criteria) this;
        }

        public Criteria andPickdateIsNotNull() {
            addCriterion("pickDate is not null");
            return (Criteria) this;
        }

        public Criteria andPickdateEqualTo(Date value) {
            addCriterion("pickDate =", value, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateNotEqualTo(Date value) {
            addCriterion("pickDate <>", value, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateGreaterThan(Date value) {
            addCriterion("pickDate >", value, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateGreaterThanOrEqualTo(Date value) {
            addCriterion("pickDate >=", value, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateLessThan(Date value) {
            addCriterion("pickDate <", value, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateLessThanOrEqualTo(Date value) {
            addCriterion("pickDate <=", value, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateIn(List<Date> values) {
            addCriterion("pickDate in", values, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateNotIn(List<Date> values) {
            addCriterion("pickDate not in", values, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateBetween(Date value1, Date value2) {
            addCriterion("pickDate between", value1, value2, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickdateNotBetween(Date value1, Date value2) {
            addCriterion("pickDate not between", value1, value2, "pickdate");
            return (Criteria) this;
        }

        public Criteria andPickaddressIsNull() {
            addCriterion("pickAddress is null");
            return (Criteria) this;
        }

        public Criteria andPickaddressIsNotNull() {
            addCriterion("pickAddress is not null");
            return (Criteria) this;
        }

        public Criteria andPickaddressEqualTo(String value) {
            addCriterion("pickAddress =", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotEqualTo(String value) {
            addCriterion("pickAddress <>", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressGreaterThan(String value) {
            addCriterion("pickAddress >", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressGreaterThanOrEqualTo(String value) {
            addCriterion("pickAddress >=", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressLessThan(String value) {
            addCriterion("pickAddress <", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressLessThanOrEqualTo(String value) {
            addCriterion("pickAddress <=", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressLike(String value) {
            addCriterion("pickAddress like", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotLike(String value) {
            addCriterion("pickAddress not like", value, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressIn(List<String> values) {
            addCriterion("pickAddress in", values, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotIn(List<String> values) {
            addCriterion("pickAddress not in", values, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressBetween(String value1, String value2) {
            addCriterion("pickAddress between", value1, value2, "pickaddress");
            return (Criteria) this;
        }

        public Criteria andPickaddressNotBetween(String value1, String value2) {
            addCriterion("pickAddress not between", value1, value2, "pickaddress");
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