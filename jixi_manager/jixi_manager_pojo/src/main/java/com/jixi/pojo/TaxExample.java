package com.jixi.pojo;

import java.util.ArrayList;
import java.util.List;

public class TaxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaxExample() {
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

        public Criteria andIncomTaxIsNull() {
            addCriterion("incom_tax is null");
            return (Criteria) this;
        }

        public Criteria andIncomTaxIsNotNull() {
            addCriterion("incom_tax is not null");
            return (Criteria) this;
        }

        public Criteria andIncomTaxEqualTo(Double value) {
            addCriterion("incom_tax =", value, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxNotEqualTo(Double value) {
            addCriterion("incom_tax <>", value, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxGreaterThan(Double value) {
            addCriterion("incom_tax >", value, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxGreaterThanOrEqualTo(Double value) {
            addCriterion("incom_tax >=", value, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxLessThan(Double value) {
            addCriterion("incom_tax <", value, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxLessThanOrEqualTo(Double value) {
            addCriterion("incom_tax <=", value, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxIn(List<Double> values) {
            addCriterion("incom_tax in", values, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxNotIn(List<Double> values) {
            addCriterion("incom_tax not in", values, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxBetween(Double value1, Double value2) {
            addCriterion("incom_tax between", value1, value2, "incomTax");
            return (Criteria) this;
        }

        public Criteria andIncomTaxNotBetween(Double value1, Double value2) {
            addCriterion("incom_tax not between", value1, value2, "incomTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxIsNull() {
            addCriterion("ticket_tax is null");
            return (Criteria) this;
        }

        public Criteria andTicketTaxIsNotNull() {
            addCriterion("ticket_tax is not null");
            return (Criteria) this;
        }

        public Criteria andTicketTaxEqualTo(Double value) {
            addCriterion("ticket_tax =", value, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxNotEqualTo(Double value) {
            addCriterion("ticket_tax <>", value, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxGreaterThan(Double value) {
            addCriterion("ticket_tax >", value, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxGreaterThanOrEqualTo(Double value) {
            addCriterion("ticket_tax >=", value, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxLessThan(Double value) {
            addCriterion("ticket_tax <", value, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxLessThanOrEqualTo(Double value) {
            addCriterion("ticket_tax <=", value, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxIn(List<Double> values) {
            addCriterion("ticket_tax in", values, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxNotIn(List<Double> values) {
            addCriterion("ticket_tax not in", values, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxBetween(Double value1, Double value2) {
            addCriterion("ticket_tax between", value1, value2, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andTicketTaxNotBetween(Double value1, Double value2) {
            addCriterion("ticket_tax not between", value1, value2, "ticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxIsNull() {
            addCriterion("noTicket_tax is null");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxIsNotNull() {
            addCriterion("noTicket_tax is not null");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxEqualTo(Double value) {
            addCriterion("noTicket_tax =", value, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxNotEqualTo(Double value) {
            addCriterion("noTicket_tax <>", value, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxGreaterThan(Double value) {
            addCriterion("noTicket_tax >", value, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxGreaterThanOrEqualTo(Double value) {
            addCriterion("noTicket_tax >=", value, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxLessThan(Double value) {
            addCriterion("noTicket_tax <", value, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxLessThanOrEqualTo(Double value) {
            addCriterion("noTicket_tax <=", value, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxIn(List<Double> values) {
            addCriterion("noTicket_tax in", values, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxNotIn(List<Double> values) {
            addCriterion("noTicket_tax not in", values, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxBetween(Double value1, Double value2) {
            addCriterion("noTicket_tax between", value1, value2, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andNoticketTaxNotBetween(Double value1, Double value2) {
            addCriterion("noTicket_tax not between", value1, value2, "noticketTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxIsNull() {
            addCriterion("sell_tax is null");
            return (Criteria) this;
        }

        public Criteria andSellTaxIsNotNull() {
            addCriterion("sell_tax is not null");
            return (Criteria) this;
        }

        public Criteria andSellTaxEqualTo(Double value) {
            addCriterion("sell_tax =", value, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxNotEqualTo(Double value) {
            addCriterion("sell_tax <>", value, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxGreaterThan(Double value) {
            addCriterion("sell_tax >", value, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxGreaterThanOrEqualTo(Double value) {
            addCriterion("sell_tax >=", value, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxLessThan(Double value) {
            addCriterion("sell_tax <", value, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxLessThanOrEqualTo(Double value) {
            addCriterion("sell_tax <=", value, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxIn(List<Double> values) {
            addCriterion("sell_tax in", values, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxNotIn(List<Double> values) {
            addCriterion("sell_tax not in", values, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxBetween(Double value1, Double value2) {
            addCriterion("sell_tax between", value1, value2, "sellTax");
            return (Criteria) this;
        }

        public Criteria andSellTaxNotBetween(Double value1, Double value2) {
            addCriterion("sell_tax not between", value1, value2, "sellTax");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceIsNull() {
            addCriterion("in_sell_difference is null");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceIsNotNull() {
            addCriterion("in_sell_difference is not null");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceEqualTo(Double value) {
            addCriterion("in_sell_difference =", value, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceNotEqualTo(Double value) {
            addCriterion("in_sell_difference <>", value, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceGreaterThan(Double value) {
            addCriterion("in_sell_difference >", value, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceGreaterThanOrEqualTo(Double value) {
            addCriterion("in_sell_difference >=", value, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceLessThan(Double value) {
            addCriterion("in_sell_difference <", value, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceLessThanOrEqualTo(Double value) {
            addCriterion("in_sell_difference <=", value, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceIn(List<Double> values) {
            addCriterion("in_sell_difference in", values, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceNotIn(List<Double> values) {
            addCriterion("in_sell_difference not in", values, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceBetween(Double value1, Double value2) {
            addCriterion("in_sell_difference between", value1, value2, "inSellDifference");
            return (Criteria) this;
        }

        public Criteria andInSellDifferenceNotBetween(Double value1, Double value2) {
            addCriterion("in_sell_difference not between", value1, value2, "inSellDifference");
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