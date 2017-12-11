package com.jixi.pojo;

import java.util.ArrayList;
import java.util.List;

public class AllorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AllorderExample() {
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

        public Criteria andSellSumsIsNull() {
            addCriterion("sell_sums is null");
            return (Criteria) this;
        }

        public Criteria andSellSumsIsNotNull() {
            addCriterion("sell_sums is not null");
            return (Criteria) this;
        }

        public Criteria andSellSumsEqualTo(Double value) {
            addCriterion("sell_sums =", value, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsNotEqualTo(Double value) {
            addCriterion("sell_sums <>", value, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsGreaterThan(Double value) {
            addCriterion("sell_sums >", value, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_sums >=", value, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsLessThan(Double value) {
            addCriterion("sell_sums <", value, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsLessThanOrEqualTo(Double value) {
            addCriterion("sell_sums <=", value, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsIn(List<Double> values) {
            addCriterion("sell_sums in", values, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsNotIn(List<Double> values) {
            addCriterion("sell_sums not in", values, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsBetween(Double value1, Double value2) {
            addCriterion("sell_sums between", value1, value2, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsNotBetween(Double value1, Double value2) {
            addCriterion("sell_sums not between", value1, value2, "sellSums");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthIsNull() {
            addCriterion("sell_sums_rateGrowth is null");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthIsNotNull() {
            addCriterion("sell_sums_rateGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthEqualTo(String value) {
            addCriterion("sell_sums_rateGrowth =", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthNotEqualTo(String value) {
            addCriterion("sell_sums_rateGrowth <>", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthGreaterThan(String value) {
            addCriterion("sell_sums_rateGrowth >", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthGreaterThanOrEqualTo(String value) {
            addCriterion("sell_sums_rateGrowth >=", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthLessThan(String value) {
            addCriterion("sell_sums_rateGrowth <", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthLessThanOrEqualTo(String value) {
            addCriterion("sell_sums_rateGrowth <=", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthLike(String value) {
            addCriterion("sell_sums_rateGrowth like", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthNotLike(String value) {
            addCriterion("sell_sums_rateGrowth not like", value, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthIn(List<String> values) {
            addCriterion("sell_sums_rateGrowth in", values, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthNotIn(List<String> values) {
            addCriterion("sell_sums_rateGrowth not in", values, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthBetween(String value1, String value2) {
            addCriterion("sell_sums_rateGrowth between", value1, value2, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsRategrowthNotBetween(String value1, String value2) {
            addCriterion("sell_sums_rateGrowth not between", value1, value2, "sellSumsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsIsNull() {
            addCriterion("sell_counts is null");
            return (Criteria) this;
        }

        public Criteria andSellCountsIsNotNull() {
            addCriterion("sell_counts is not null");
            return (Criteria) this;
        }

        public Criteria andSellCountsEqualTo(Integer value) {
            addCriterion("sell_counts =", value, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsNotEqualTo(Integer value) {
            addCriterion("sell_counts <>", value, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsGreaterThan(Integer value) {
            addCriterion("sell_counts >", value, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("sell_counts >=", value, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsLessThan(Integer value) {
            addCriterion("sell_counts <", value, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsLessThanOrEqualTo(Integer value) {
            addCriterion("sell_counts <=", value, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsIn(List<Integer> values) {
            addCriterion("sell_counts in", values, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsNotIn(List<Integer> values) {
            addCriterion("sell_counts not in", values, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsBetween(Integer value1, Integer value2) {
            addCriterion("sell_counts between", value1, value2, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("sell_counts not between", value1, value2, "sellCounts");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthIsNull() {
            addCriterion("sell_counts_rateGrowth is null");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthIsNotNull() {
            addCriterion("sell_counts_rateGrowth is not null");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthEqualTo(String value) {
            addCriterion("sell_counts_rateGrowth =", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthNotEqualTo(String value) {
            addCriterion("sell_counts_rateGrowth <>", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthGreaterThan(String value) {
            addCriterion("sell_counts_rateGrowth >", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthGreaterThanOrEqualTo(String value) {
            addCriterion("sell_counts_rateGrowth >=", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthLessThan(String value) {
            addCriterion("sell_counts_rateGrowth <", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthLessThanOrEqualTo(String value) {
            addCriterion("sell_counts_rateGrowth <=", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthLike(String value) {
            addCriterion("sell_counts_rateGrowth like", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthNotLike(String value) {
            addCriterion("sell_counts_rateGrowth not like", value, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthIn(List<String> values) {
            addCriterion("sell_counts_rateGrowth in", values, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthNotIn(List<String> values) {
            addCriterion("sell_counts_rateGrowth not in", values, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthBetween(String value1, String value2) {
            addCriterion("sell_counts_rateGrowth between", value1, value2, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellCountsRategrowthNotBetween(String value1, String value2) {
            addCriterion("sell_counts_rateGrowth not between", value1, value2, "sellCountsRategrowth");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgIsNull() {
            addCriterion("sell_sums_avg is null");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgIsNotNull() {
            addCriterion("sell_sums_avg is not null");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgEqualTo(Double value) {
            addCriterion("sell_sums_avg =", value, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgNotEqualTo(Double value) {
            addCriterion("sell_sums_avg <>", value, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgGreaterThan(Double value) {
            addCriterion("sell_sums_avg >", value, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_sums_avg >=", value, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgLessThan(Double value) {
            addCriterion("sell_sums_avg <", value, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgLessThanOrEqualTo(Double value) {
            addCriterion("sell_sums_avg <=", value, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgIn(List<Double> values) {
            addCriterion("sell_sums_avg in", values, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgNotIn(List<Double> values) {
            addCriterion("sell_sums_avg not in", values, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgBetween(Double value1, Double value2) {
            addCriterion("sell_sums_avg between", value1, value2, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsAvgNotBetween(Double value1, Double value2) {
            addCriterion("sell_sums_avg not between", value1, value2, "sellSumsAvg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgIsNull() {
            addCriterion("sell_sums_dayAvg is null");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgIsNotNull() {
            addCriterion("sell_sums_dayAvg is not null");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgEqualTo(Double value) {
            addCriterion("sell_sums_dayAvg =", value, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgNotEqualTo(Double value) {
            addCriterion("sell_sums_dayAvg <>", value, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgGreaterThan(Double value) {
            addCriterion("sell_sums_dayAvg >", value, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_sums_dayAvg >=", value, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgLessThan(Double value) {
            addCriterion("sell_sums_dayAvg <", value, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgLessThanOrEqualTo(Double value) {
            addCriterion("sell_sums_dayAvg <=", value, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgIn(List<Double> values) {
            addCriterion("sell_sums_dayAvg in", values, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgNotIn(List<Double> values) {
            addCriterion("sell_sums_dayAvg not in", values, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgBetween(Double value1, Double value2) {
            addCriterion("sell_sums_dayAvg between", value1, value2, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellSumsDayavgNotBetween(Double value1, Double value2) {
            addCriterion("sell_sums_dayAvg not between", value1, value2, "sellSumsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgIsNull() {
            addCriterion("sell_counts_dayAvg is null");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgIsNotNull() {
            addCriterion("sell_counts_dayAvg is not null");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgEqualTo(Double value) {
            addCriterion("sell_counts_dayAvg =", value, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgNotEqualTo(Double value) {
            addCriterion("sell_counts_dayAvg <>", value, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgGreaterThan(Double value) {
            addCriterion("sell_counts_dayAvg >", value, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_counts_dayAvg >=", value, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgLessThan(Double value) {
            addCriterion("sell_counts_dayAvg <", value, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgLessThanOrEqualTo(Double value) {
            addCriterion("sell_counts_dayAvg <=", value, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgIn(List<Double> values) {
            addCriterion("sell_counts_dayAvg in", values, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgNotIn(List<Double> values) {
            addCriterion("sell_counts_dayAvg not in", values, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgBetween(Double value1, Double value2) {
            addCriterion("sell_counts_dayAvg between", value1, value2, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andSellCountsDayavgNotBetween(Double value1, Double value2) {
            addCriterion("sell_counts_dayAvg not between", value1, value2, "sellCountsDayavg");
            return (Criteria) this;
        }

        public Criteria andPickSumsIsNull() {
            addCriterion("pick_sums is null");
            return (Criteria) this;
        }

        public Criteria andPickSumsIsNotNull() {
            addCriterion("pick_sums is not null");
            return (Criteria) this;
        }

        public Criteria andPickSumsEqualTo(Double value) {
            addCriterion("pick_sums =", value, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsNotEqualTo(Double value) {
            addCriterion("pick_sums <>", value, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsGreaterThan(Double value) {
            addCriterion("pick_sums >", value, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsGreaterThanOrEqualTo(Double value) {
            addCriterion("pick_sums >=", value, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsLessThan(Double value) {
            addCriterion("pick_sums <", value, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsLessThanOrEqualTo(Double value) {
            addCriterion("pick_sums <=", value, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsIn(List<Double> values) {
            addCriterion("pick_sums in", values, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsNotIn(List<Double> values) {
            addCriterion("pick_sums not in", values, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsBetween(Double value1, Double value2) {
            addCriterion("pick_sums between", value1, value2, "pickSums");
            return (Criteria) this;
        }

        public Criteria andPickSumsNotBetween(Double value1, Double value2) {
            addCriterion("pick_sums not between", value1, value2, "pickSums");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitIsNull() {
            addCriterion("real_grossProfit is null");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitIsNotNull() {
            addCriterion("real_grossProfit is not null");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitEqualTo(Double value) {
            addCriterion("real_grossProfit =", value, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitNotEqualTo(Double value) {
            addCriterion("real_grossProfit <>", value, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitGreaterThan(Double value) {
            addCriterion("real_grossProfit >", value, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitGreaterThanOrEqualTo(Double value) {
            addCriterion("real_grossProfit >=", value, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitLessThan(Double value) {
            addCriterion("real_grossProfit <", value, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitLessThanOrEqualTo(Double value) {
            addCriterion("real_grossProfit <=", value, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitIn(List<Double> values) {
            addCriterion("real_grossProfit in", values, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitNotIn(List<Double> values) {
            addCriterion("real_grossProfit not in", values, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitBetween(Double value1, Double value2) {
            addCriterion("real_grossProfit between", value1, value2, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andRealGrossprofitNotBetween(Double value1, Double value2) {
            addCriterion("real_grossProfit not between", value1, value2, "realGrossprofit");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetIsNull() {
            addCriterion("pin_off_itemOffset is null");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetIsNotNull() {
            addCriterion("pin_off_itemOffset is not null");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetEqualTo(Double value) {
            addCriterion("pin_off_itemOffset =", value, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetNotEqualTo(Double value) {
            addCriterion("pin_off_itemOffset <>", value, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetGreaterThan(Double value) {
            addCriterion("pin_off_itemOffset >", value, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetGreaterThanOrEqualTo(Double value) {
            addCriterion("pin_off_itemOffset >=", value, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetLessThan(Double value) {
            addCriterion("pin_off_itemOffset <", value, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetLessThanOrEqualTo(Double value) {
            addCriterion("pin_off_itemOffset <=", value, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetIn(List<Double> values) {
            addCriterion("pin_off_itemOffset in", values, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetNotIn(List<Double> values) {
            addCriterion("pin_off_itemOffset not in", values, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetBetween(Double value1, Double value2) {
            addCriterion("pin_off_itemOffset between", value1, value2, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andPinOffItemoffsetNotBetween(Double value1, Double value2) {
            addCriterion("pin_off_itemOffset not between", value1, value2, "pinOffItemoffset");
            return (Criteria) this;
        }

        public Criteria andGrossmarginIsNull() {
            addCriterion("grossMargin is null");
            return (Criteria) this;
        }

        public Criteria andGrossmarginIsNotNull() {
            addCriterion("grossMargin is not null");
            return (Criteria) this;
        }

        public Criteria andGrossmarginEqualTo(String value) {
            addCriterion("grossMargin =", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginNotEqualTo(String value) {
            addCriterion("grossMargin <>", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginGreaterThan(String value) {
            addCriterion("grossMargin >", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginGreaterThanOrEqualTo(String value) {
            addCriterion("grossMargin >=", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginLessThan(String value) {
            addCriterion("grossMargin <", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginLessThanOrEqualTo(String value) {
            addCriterion("grossMargin <=", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginLike(String value) {
            addCriterion("grossMargin like", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginNotLike(String value) {
            addCriterion("grossMargin not like", value, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginIn(List<String> values) {
            addCriterion("grossMargin in", values, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginNotIn(List<String> values) {
            addCriterion("grossMargin not in", values, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginBetween(String value1, String value2) {
            addCriterion("grossMargin between", value1, value2, "grossmargin");
            return (Criteria) this;
        }

        public Criteria andGrossmarginNotBetween(String value1, String value2) {
            addCriterion("grossMargin not between", value1, value2, "grossmargin");
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

        public Criteria andFreightSupplierIsNull() {
            addCriterion("freight_supplier is null");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierIsNotNull() {
            addCriterion("freight_supplier is not null");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierEqualTo(Double value) {
            addCriterion("freight_supplier =", value, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierNotEqualTo(Double value) {
            addCriterion("freight_supplier <>", value, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierGreaterThan(Double value) {
            addCriterion("freight_supplier >", value, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierGreaterThanOrEqualTo(Double value) {
            addCriterion("freight_supplier >=", value, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierLessThan(Double value) {
            addCriterion("freight_supplier <", value, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierLessThanOrEqualTo(Double value) {
            addCriterion("freight_supplier <=", value, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierIn(List<Double> values) {
            addCriterion("freight_supplier in", values, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierNotIn(List<Double> values) {
            addCriterion("freight_supplier not in", values, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierBetween(Double value1, Double value2) {
            addCriterion("freight_supplier between", value1, value2, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightSupplierNotBetween(Double value1, Double value2) {
            addCriterion("freight_supplier not between", value1, value2, "freightSupplier");
            return (Criteria) this;
        }

        public Criteria andFreightJixiIsNull() {
            addCriterion("freight_jixi is null");
            return (Criteria) this;
        }

        public Criteria andFreightJixiIsNotNull() {
            addCriterion("freight_jixi is not null");
            return (Criteria) this;
        }

        public Criteria andFreightJixiEqualTo(Double value) {
            addCriterion("freight_jixi =", value, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiNotEqualTo(Double value) {
            addCriterion("freight_jixi <>", value, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiGreaterThan(Double value) {
            addCriterion("freight_jixi >", value, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiGreaterThanOrEqualTo(Double value) {
            addCriterion("freight_jixi >=", value, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiLessThan(Double value) {
            addCriterion("freight_jixi <", value, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiLessThanOrEqualTo(Double value) {
            addCriterion("freight_jixi <=", value, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiIn(List<Double> values) {
            addCriterion("freight_jixi in", values, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiNotIn(List<Double> values) {
            addCriterion("freight_jixi not in", values, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiBetween(Double value1, Double value2) {
            addCriterion("freight_jixi between", value1, value2, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightJixiNotBetween(Double value1, Double value2) {
            addCriterion("freight_jixi not between", value1, value2, "freightJixi");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerIsNull() {
            addCriterion("freight_customer is null");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerIsNotNull() {
            addCriterion("freight_customer is not null");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerEqualTo(Double value) {
            addCriterion("freight_customer =", value, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerNotEqualTo(Double value) {
            addCriterion("freight_customer <>", value, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerGreaterThan(Double value) {
            addCriterion("freight_customer >", value, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerGreaterThanOrEqualTo(Double value) {
            addCriterion("freight_customer >=", value, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerLessThan(Double value) {
            addCriterion("freight_customer <", value, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerLessThanOrEqualTo(Double value) {
            addCriterion("freight_customer <=", value, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerIn(List<Double> values) {
            addCriterion("freight_customer in", values, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerNotIn(List<Double> values) {
            addCriterion("freight_customer not in", values, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerBetween(Double value1, Double value2) {
            addCriterion("freight_customer between", value1, value2, "freightCustomer");
            return (Criteria) this;
        }

        public Criteria andFreightCustomerNotBetween(Double value1, Double value2) {
            addCriterion("freight_customer not between", value1, value2, "freightCustomer");
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