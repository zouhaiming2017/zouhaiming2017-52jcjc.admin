package com.jixi.pojo;

import java.util.ArrayList;
import java.util.List;

public class SellorderAllExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SellorderAllExample() {
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

        public Criteria andTimeMonthIsNull() {
            addCriterion("time_month is null");
            return (Criteria) this;
        }

        public Criteria andTimeMonthIsNotNull() {
            addCriterion("time_month is not null");
            return (Criteria) this;
        }

        public Criteria andTimeMonthEqualTo(String value) {
            addCriterion("time_month =", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthNotEqualTo(String value) {
            addCriterion("time_month <>", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthGreaterThan(String value) {
            addCriterion("time_month >", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthGreaterThanOrEqualTo(String value) {
            addCriterion("time_month >=", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthLessThan(String value) {
            addCriterion("time_month <", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthLessThanOrEqualTo(String value) {
            addCriterion("time_month <=", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthLike(String value) {
            addCriterion("time_month like", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthNotLike(String value) {
            addCriterion("time_month not like", value, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthIn(List<String> values) {
            addCriterion("time_month in", values, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthNotIn(List<String> values) {
            addCriterion("time_month not in", values, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthBetween(String value1, String value2) {
            addCriterion("time_month between", value1, value2, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andTimeMonthNotBetween(String value1, String value2) {
            addCriterion("time_month not between", value1, value2, "timeMonth");
            return (Criteria) this;
        }

        public Criteria andAllsumsIsNull() {
            addCriterion("allsums is null");
            return (Criteria) this;
        }

        public Criteria andAllsumsIsNotNull() {
            addCriterion("allsums is not null");
            return (Criteria) this;
        }

        public Criteria andAllsumsEqualTo(Double value) {
            addCriterion("allsums =", value, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsNotEqualTo(Double value) {
            addCriterion("allsums <>", value, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsGreaterThan(Double value) {
            addCriterion("allsums >", value, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsGreaterThanOrEqualTo(Double value) {
            addCriterion("allsums >=", value, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsLessThan(Double value) {
            addCriterion("allsums <", value, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsLessThanOrEqualTo(Double value) {
            addCriterion("allsums <=", value, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsIn(List<Double> values) {
            addCriterion("allsums in", values, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsNotIn(List<Double> values) {
            addCriterion("allsums not in", values, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsBetween(Double value1, Double value2) {
            addCriterion("allsums between", value1, value2, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllsumsNotBetween(Double value1, Double value2) {
            addCriterion("allsums not between", value1, value2, "allsums");
            return (Criteria) this;
        }

        public Criteria andAllcountsIsNull() {
            addCriterion("allcounts is null");
            return (Criteria) this;
        }

        public Criteria andAllcountsIsNotNull() {
            addCriterion("allcounts is not null");
            return (Criteria) this;
        }

        public Criteria andAllcountsEqualTo(Integer value) {
            addCriterion("allcounts =", value, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsNotEqualTo(Integer value) {
            addCriterion("allcounts <>", value, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsGreaterThan(Integer value) {
            addCriterion("allcounts >", value, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("allcounts >=", value, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsLessThan(Integer value) {
            addCriterion("allcounts <", value, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsLessThanOrEqualTo(Integer value) {
            addCriterion("allcounts <=", value, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsIn(List<Integer> values) {
            addCriterion("allcounts in", values, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsNotIn(List<Integer> values) {
            addCriterion("allcounts not in", values, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsBetween(Integer value1, Integer value2) {
            addCriterion("allcounts between", value1, value2, "allcounts");
            return (Criteria) this;
        }

        public Criteria andAllcountsNotBetween(Integer value1, Integer value2) {
            addCriterion("allcounts not between", value1, value2, "allcounts");
            return (Criteria) this;
        }

        public Criteria andDCountIsNull() {
            addCriterion("d_count is null");
            return (Criteria) this;
        }

        public Criteria andDCountIsNotNull() {
            addCriterion("d_count is not null");
            return (Criteria) this;
        }

        public Criteria andDCountEqualTo(Integer value) {
            addCriterion("d_count =", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountNotEqualTo(Integer value) {
            addCriterion("d_count <>", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountGreaterThan(Integer value) {
            addCriterion("d_count >", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_count >=", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountLessThan(Integer value) {
            addCriterion("d_count <", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountLessThanOrEqualTo(Integer value) {
            addCriterion("d_count <=", value, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountIn(List<Integer> values) {
            addCriterion("d_count in", values, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountNotIn(List<Integer> values) {
            addCriterion("d_count not in", values, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountBetween(Integer value1, Integer value2) {
            addCriterion("d_count between", value1, value2, "dCount");
            return (Criteria) this;
        }

        public Criteria andDCountNotBetween(Integer value1, Integer value2) {
            addCriterion("d_count not between", value1, value2, "dCount");
            return (Criteria) this;
        }

        public Criteria andCCountIsNull() {
            addCriterion("c_count is null");
            return (Criteria) this;
        }

        public Criteria andCCountIsNotNull() {
            addCriterion("c_count is not null");
            return (Criteria) this;
        }

        public Criteria andCCountEqualTo(Integer value) {
            addCriterion("c_count =", value, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountNotEqualTo(Integer value) {
            addCriterion("c_count <>", value, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountGreaterThan(Integer value) {
            addCriterion("c_count >", value, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_count >=", value, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountLessThan(Integer value) {
            addCriterion("c_count <", value, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountLessThanOrEqualTo(Integer value) {
            addCriterion("c_count <=", value, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountIn(List<Integer> values) {
            addCriterion("c_count in", values, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountNotIn(List<Integer> values) {
            addCriterion("c_count not in", values, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountBetween(Integer value1, Integer value2) {
            addCriterion("c_count between", value1, value2, "cCount");
            return (Criteria) this;
        }

        public Criteria andCCountNotBetween(Integer value1, Integer value2) {
            addCriterion("c_count not between", value1, value2, "cCount");
            return (Criteria) this;
        }

        public Criteria andBCountIsNull() {
            addCriterion("b_count is null");
            return (Criteria) this;
        }

        public Criteria andBCountIsNotNull() {
            addCriterion("b_count is not null");
            return (Criteria) this;
        }

        public Criteria andBCountEqualTo(Integer value) {
            addCriterion("b_count =", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountNotEqualTo(Integer value) {
            addCriterion("b_count <>", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountGreaterThan(Integer value) {
            addCriterion("b_count >", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_count >=", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountLessThan(Integer value) {
            addCriterion("b_count <", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountLessThanOrEqualTo(Integer value) {
            addCriterion("b_count <=", value, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountIn(List<Integer> values) {
            addCriterion("b_count in", values, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountNotIn(List<Integer> values) {
            addCriterion("b_count not in", values, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountBetween(Integer value1, Integer value2) {
            addCriterion("b_count between", value1, value2, "bCount");
            return (Criteria) this;
        }

        public Criteria andBCountNotBetween(Integer value1, Integer value2) {
            addCriterion("b_count not between", value1, value2, "bCount");
            return (Criteria) this;
        }

        public Criteria andACountIsNull() {
            addCriterion("a_count is null");
            return (Criteria) this;
        }

        public Criteria andACountIsNotNull() {
            addCriterion("a_count is not null");
            return (Criteria) this;
        }

        public Criteria andACountEqualTo(Integer value) {
            addCriterion("a_count =", value, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountNotEqualTo(Integer value) {
            addCriterion("a_count <>", value, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountGreaterThan(Integer value) {
            addCriterion("a_count >", value, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountGreaterThanOrEqualTo(Integer value) {
            addCriterion("a_count >=", value, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountLessThan(Integer value) {
            addCriterion("a_count <", value, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountLessThanOrEqualTo(Integer value) {
            addCriterion("a_count <=", value, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountIn(List<Integer> values) {
            addCriterion("a_count in", values, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountNotIn(List<Integer> values) {
            addCriterion("a_count not in", values, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountBetween(Integer value1, Integer value2) {
            addCriterion("a_count between", value1, value2, "aCount");
            return (Criteria) this;
        }

        public Criteria andACountNotBetween(Integer value1, Integer value2) {
            addCriterion("a_count not between", value1, value2, "aCount");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthIsNull() {
            addCriterion("d_count_rateGrowth is null");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthIsNotNull() {
            addCriterion("d_count_rateGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthEqualTo(String value) {
            addCriterion("d_count_rateGrowth =", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthNotEqualTo(String value) {
            addCriterion("d_count_rateGrowth <>", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthGreaterThan(String value) {
            addCriterion("d_count_rateGrowth >", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthGreaterThanOrEqualTo(String value) {
            addCriterion("d_count_rateGrowth >=", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthLessThan(String value) {
            addCriterion("d_count_rateGrowth <", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthLessThanOrEqualTo(String value) {
            addCriterion("d_count_rateGrowth <=", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthLike(String value) {
            addCriterion("d_count_rateGrowth like", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthNotLike(String value) {
            addCriterion("d_count_rateGrowth not like", value, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthIn(List<String> values) {
            addCriterion("d_count_rateGrowth in", values, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthNotIn(List<String> values) {
            addCriterion("d_count_rateGrowth not in", values, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthBetween(String value1, String value2) {
            addCriterion("d_count_rateGrowth between", value1, value2, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDCountRategrowthNotBetween(String value1, String value2) {
            addCriterion("d_count_rateGrowth not between", value1, value2, "dCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumIsNull() {
            addCriterion("d_sum is null");
            return (Criteria) this;
        }

        public Criteria andDSumIsNotNull() {
            addCriterion("d_sum is not null");
            return (Criteria) this;
        }

        public Criteria andDSumEqualTo(Double value) {
            addCriterion("d_sum =", value, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumNotEqualTo(Double value) {
            addCriterion("d_sum <>", value, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumGreaterThan(Double value) {
            addCriterion("d_sum >", value, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumGreaterThanOrEqualTo(Double value) {
            addCriterion("d_sum >=", value, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumLessThan(Double value) {
            addCriterion("d_sum <", value, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumLessThanOrEqualTo(Double value) {
            addCriterion("d_sum <=", value, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumIn(List<Double> values) {
            addCriterion("d_sum in", values, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumNotIn(List<Double> values) {
            addCriterion("d_sum not in", values, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumBetween(Double value1, Double value2) {
            addCriterion("d_sum between", value1, value2, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumNotBetween(Double value1, Double value2) {
            addCriterion("d_sum not between", value1, value2, "dSum");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthIsNull() {
            addCriterion("d_sum_rateGrowth is null");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthIsNotNull() {
            addCriterion("d_sum_rateGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthEqualTo(String value) {
            addCriterion("d_sum_rateGrowth =", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthNotEqualTo(String value) {
            addCriterion("d_sum_rateGrowth <>", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthGreaterThan(String value) {
            addCriterion("d_sum_rateGrowth >", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthGreaterThanOrEqualTo(String value) {
            addCriterion("d_sum_rateGrowth >=", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthLessThan(String value) {
            addCriterion("d_sum_rateGrowth <", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthLessThanOrEqualTo(String value) {
            addCriterion("d_sum_rateGrowth <=", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthLike(String value) {
            addCriterion("d_sum_rateGrowth like", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthNotLike(String value) {
            addCriterion("d_sum_rateGrowth not like", value, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthIn(List<String> values) {
            addCriterion("d_sum_rateGrowth in", values, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthNotIn(List<String> values) {
            addCriterion("d_sum_rateGrowth not in", values, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthBetween(String value1, String value2) {
            addCriterion("d_sum_rateGrowth between", value1, value2, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andDSumRategrowthNotBetween(String value1, String value2) {
            addCriterion("d_sum_rateGrowth not between", value1, value2, "dSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthIsNull() {
            addCriterion("c_count_rateGrowth is null");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthIsNotNull() {
            addCriterion("c_count_rateGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthEqualTo(String value) {
            addCriterion("c_count_rateGrowth =", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthNotEqualTo(String value) {
            addCriterion("c_count_rateGrowth <>", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthGreaterThan(String value) {
            addCriterion("c_count_rateGrowth >", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthGreaterThanOrEqualTo(String value) {
            addCriterion("c_count_rateGrowth >=", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthLessThan(String value) {
            addCriterion("c_count_rateGrowth <", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthLessThanOrEqualTo(String value) {
            addCriterion("c_count_rateGrowth <=", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthLike(String value) {
            addCriterion("c_count_rateGrowth like", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthNotLike(String value) {
            addCriterion("c_count_rateGrowth not like", value, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthIn(List<String> values) {
            addCriterion("c_count_rateGrowth in", values, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthNotIn(List<String> values) {
            addCriterion("c_count_rateGrowth not in", values, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthBetween(String value1, String value2) {
            addCriterion("c_count_rateGrowth between", value1, value2, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCCountRategrowthNotBetween(String value1, String value2) {
            addCriterion("c_count_rateGrowth not between", value1, value2, "cCountRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumIsNull() {
            addCriterion("c_sum is null");
            return (Criteria) this;
        }

        public Criteria andCSumIsNotNull() {
            addCriterion("c_sum is not null");
            return (Criteria) this;
        }

        public Criteria andCSumEqualTo(Double value) {
            addCriterion("c_sum =", value, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumNotEqualTo(Double value) {
            addCriterion("c_sum <>", value, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumGreaterThan(Double value) {
            addCriterion("c_sum >", value, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumGreaterThanOrEqualTo(Double value) {
            addCriterion("c_sum >=", value, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumLessThan(Double value) {
            addCriterion("c_sum <", value, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumLessThanOrEqualTo(Double value) {
            addCriterion("c_sum <=", value, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumIn(List<Double> values) {
            addCriterion("c_sum in", values, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumNotIn(List<Double> values) {
            addCriterion("c_sum not in", values, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumBetween(Double value1, Double value2) {
            addCriterion("c_sum between", value1, value2, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumNotBetween(Double value1, Double value2) {
            addCriterion("c_sum not between", value1, value2, "cSum");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthIsNull() {
            addCriterion("c_sum_rateGrowth is null");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthIsNotNull() {
            addCriterion("c_sum_rateGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthEqualTo(String value) {
            addCriterion("c_sum_rateGrowth =", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthNotEqualTo(String value) {
            addCriterion("c_sum_rateGrowth <>", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthGreaterThan(String value) {
            addCriterion("c_sum_rateGrowth >", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthGreaterThanOrEqualTo(String value) {
            addCriterion("c_sum_rateGrowth >=", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthLessThan(String value) {
            addCriterion("c_sum_rateGrowth <", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthLessThanOrEqualTo(String value) {
            addCriterion("c_sum_rateGrowth <=", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthLike(String value) {
            addCriterion("c_sum_rateGrowth like", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthNotLike(String value) {
            addCriterion("c_sum_rateGrowth not like", value, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthIn(List<String> values) {
            addCriterion("c_sum_rateGrowth in", values, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthNotIn(List<String> values) {
            addCriterion("c_sum_rateGrowth not in", values, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthBetween(String value1, String value2) {
            addCriterion("c_sum_rateGrowth between", value1, value2, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andCSumRategrowthNotBetween(String value1, String value2) {
            addCriterion("c_sum_rateGrowth not between", value1, value2, "cSumRategrowth");
            return (Criteria) this;
        }

        public Criteria andBSumIsNull() {
            addCriterion("b_sum is null");
            return (Criteria) this;
        }

        public Criteria andBSumIsNotNull() {
            addCriterion("b_sum is not null");
            return (Criteria) this;
        }

        public Criteria andBSumEqualTo(Double value) {
            addCriterion("b_sum =", value, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumNotEqualTo(Double value) {
            addCriterion("b_sum <>", value, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumGreaterThan(Double value) {
            addCriterion("b_sum >", value, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumGreaterThanOrEqualTo(Double value) {
            addCriterion("b_sum >=", value, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumLessThan(Double value) {
            addCriterion("b_sum <", value, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumLessThanOrEqualTo(Double value) {
            addCriterion("b_sum <=", value, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumIn(List<Double> values) {
            addCriterion("b_sum in", values, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumNotIn(List<Double> values) {
            addCriterion("b_sum not in", values, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumBetween(Double value1, Double value2) {
            addCriterion("b_sum between", value1, value2, "bSum");
            return (Criteria) this;
        }

        public Criteria andBSumNotBetween(Double value1, Double value2) {
            addCriterion("b_sum not between", value1, value2, "bSum");
            return (Criteria) this;
        }

        public Criteria andASumIsNull() {
            addCriterion("a_sum is null");
            return (Criteria) this;
        }

        public Criteria andASumIsNotNull() {
            addCriterion("a_sum is not null");
            return (Criteria) this;
        }

        public Criteria andASumEqualTo(Double value) {
            addCriterion("a_sum =", value, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumNotEqualTo(Double value) {
            addCriterion("a_sum <>", value, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumGreaterThan(Double value) {
            addCriterion("a_sum >", value, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumGreaterThanOrEqualTo(Double value) {
            addCriterion("a_sum >=", value, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumLessThan(Double value) {
            addCriterion("a_sum <", value, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumLessThanOrEqualTo(Double value) {
            addCriterion("a_sum <=", value, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumIn(List<Double> values) {
            addCriterion("a_sum in", values, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumNotIn(List<Double> values) {
            addCriterion("a_sum not in", values, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumBetween(Double value1, Double value2) {
            addCriterion("a_sum between", value1, value2, "aSum");
            return (Criteria) this;
        }

        public Criteria andASumNotBetween(Double value1, Double value2) {
            addCriterion("a_sum not between", value1, value2, "aSum");
            return (Criteria) this;
        }

        public Criteria andDSumAvgIsNull() {
            addCriterion("d_sum_avg is null");
            return (Criteria) this;
        }

        public Criteria andDSumAvgIsNotNull() {
            addCriterion("d_sum_avg is not null");
            return (Criteria) this;
        }

        public Criteria andDSumAvgEqualTo(Double value) {
            addCriterion("d_sum_avg =", value, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgNotEqualTo(Double value) {
            addCriterion("d_sum_avg <>", value, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgGreaterThan(Double value) {
            addCriterion("d_sum_avg >", value, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgGreaterThanOrEqualTo(Double value) {
            addCriterion("d_sum_avg >=", value, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgLessThan(Double value) {
            addCriterion("d_sum_avg <", value, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgLessThanOrEqualTo(Double value) {
            addCriterion("d_sum_avg <=", value, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgIn(List<Double> values) {
            addCriterion("d_sum_avg in", values, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgNotIn(List<Double> values) {
            addCriterion("d_sum_avg not in", values, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgBetween(Double value1, Double value2) {
            addCriterion("d_sum_avg between", value1, value2, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumAvgNotBetween(Double value1, Double value2) {
            addCriterion("d_sum_avg not between", value1, value2, "dSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgIsNull() {
            addCriterion("c_sum_avg is null");
            return (Criteria) this;
        }

        public Criteria andCSumAvgIsNotNull() {
            addCriterion("c_sum_avg is not null");
            return (Criteria) this;
        }

        public Criteria andCSumAvgEqualTo(Double value) {
            addCriterion("c_sum_avg =", value, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgNotEqualTo(Double value) {
            addCriterion("c_sum_avg <>", value, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgGreaterThan(Double value) {
            addCriterion("c_sum_avg >", value, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgGreaterThanOrEqualTo(Double value) {
            addCriterion("c_sum_avg >=", value, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgLessThan(Double value) {
            addCriterion("c_sum_avg <", value, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgLessThanOrEqualTo(Double value) {
            addCriterion("c_sum_avg <=", value, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgIn(List<Double> values) {
            addCriterion("c_sum_avg in", values, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgNotIn(List<Double> values) {
            addCriterion("c_sum_avg not in", values, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgBetween(Double value1, Double value2) {
            addCriterion("c_sum_avg between", value1, value2, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andCSumAvgNotBetween(Double value1, Double value2) {
            addCriterion("c_sum_avg not between", value1, value2, "cSumAvg");
            return (Criteria) this;
        }

        public Criteria andDSumProIsNull() {
            addCriterion("d_sum_pro is null");
            return (Criteria) this;
        }

        public Criteria andDSumProIsNotNull() {
            addCriterion("d_sum_pro is not null");
            return (Criteria) this;
        }

        public Criteria andDSumProEqualTo(String value) {
            addCriterion("d_sum_pro =", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProNotEqualTo(String value) {
            addCriterion("d_sum_pro <>", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProGreaterThan(String value) {
            addCriterion("d_sum_pro >", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProGreaterThanOrEqualTo(String value) {
            addCriterion("d_sum_pro >=", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProLessThan(String value) {
            addCriterion("d_sum_pro <", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProLessThanOrEqualTo(String value) {
            addCriterion("d_sum_pro <=", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProLike(String value) {
            addCriterion("d_sum_pro like", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProNotLike(String value) {
            addCriterion("d_sum_pro not like", value, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProIn(List<String> values) {
            addCriterion("d_sum_pro in", values, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProNotIn(List<String> values) {
            addCriterion("d_sum_pro not in", values, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProBetween(String value1, String value2) {
            addCriterion("d_sum_pro between", value1, value2, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andDSumProNotBetween(String value1, String value2) {
            addCriterion("d_sum_pro not between", value1, value2, "dSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProIsNull() {
            addCriterion("c_sum_pro is null");
            return (Criteria) this;
        }

        public Criteria andCSumProIsNotNull() {
            addCriterion("c_sum_pro is not null");
            return (Criteria) this;
        }

        public Criteria andCSumProEqualTo(String value) {
            addCriterion("c_sum_pro =", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProNotEqualTo(String value) {
            addCriterion("c_sum_pro <>", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProGreaterThan(String value) {
            addCriterion("c_sum_pro >", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProGreaterThanOrEqualTo(String value) {
            addCriterion("c_sum_pro >=", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProLessThan(String value) {
            addCriterion("c_sum_pro <", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProLessThanOrEqualTo(String value) {
            addCriterion("c_sum_pro <=", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProLike(String value) {
            addCriterion("c_sum_pro like", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProNotLike(String value) {
            addCriterion("c_sum_pro not like", value, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProIn(List<String> values) {
            addCriterion("c_sum_pro in", values, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProNotIn(List<String> values) {
            addCriterion("c_sum_pro not in", values, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProBetween(String value1, String value2) {
            addCriterion("c_sum_pro between", value1, value2, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andCSumProNotBetween(String value1, String value2) {
            addCriterion("c_sum_pro not between", value1, value2, "cSumPro");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountIsNull() {
            addCriterion("d_customer_count is null");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountIsNotNull() {
            addCriterion("d_customer_count is not null");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountEqualTo(Integer value) {
            addCriterion("d_customer_count =", value, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountNotEqualTo(Integer value) {
            addCriterion("d_customer_count <>", value, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountGreaterThan(Integer value) {
            addCriterion("d_customer_count >", value, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_customer_count >=", value, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountLessThan(Integer value) {
            addCriterion("d_customer_count <", value, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountLessThanOrEqualTo(Integer value) {
            addCriterion("d_customer_count <=", value, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountIn(List<Integer> values) {
            addCriterion("d_customer_count in", values, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountNotIn(List<Integer> values) {
            addCriterion("d_customer_count not in", values, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountBetween(Integer value1, Integer value2) {
            addCriterion("d_customer_count between", value1, value2, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andDCustomerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("d_customer_count not between", value1, value2, "dCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountIsNull() {
            addCriterion("c_customer_count is null");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountIsNotNull() {
            addCriterion("c_customer_count is not null");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountEqualTo(Integer value) {
            addCriterion("c_customer_count =", value, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountNotEqualTo(Integer value) {
            addCriterion("c_customer_count <>", value, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountGreaterThan(Integer value) {
            addCriterion("c_customer_count >", value, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_customer_count >=", value, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountLessThan(Integer value) {
            addCriterion("c_customer_count <", value, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountLessThanOrEqualTo(Integer value) {
            addCriterion("c_customer_count <=", value, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountIn(List<Integer> values) {
            addCriterion("c_customer_count in", values, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountNotIn(List<Integer> values) {
            addCriterion("c_customer_count not in", values, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountBetween(Integer value1, Integer value2) {
            addCriterion("c_customer_count between", value1, value2, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andCCustomerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("c_customer_count not between", value1, value2, "cCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountIsNull() {
            addCriterion("all_customer_count is null");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountIsNotNull() {
            addCriterion("all_customer_count is not null");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountEqualTo(Integer value) {
            addCriterion("all_customer_count =", value, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountNotEqualTo(Integer value) {
            addCriterion("all_customer_count <>", value, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountGreaterThan(Integer value) {
            addCriterion("all_customer_count >", value, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_customer_count >=", value, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountLessThan(Integer value) {
            addCriterion("all_customer_count <", value, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountLessThanOrEqualTo(Integer value) {
            addCriterion("all_customer_count <=", value, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountIn(List<Integer> values) {
            addCriterion("all_customer_count in", values, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountNotIn(List<Integer> values) {
            addCriterion("all_customer_count not in", values, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountBetween(Integer value1, Integer value2) {
            addCriterion("all_customer_count between", value1, value2, "allCustomerCount");
            return (Criteria) this;
        }

        public Criteria andAllCustomerCountNotBetween(Integer value1, Integer value2) {
            addCriterion("all_customer_count not between", value1, value2, "allCustomerCount");
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