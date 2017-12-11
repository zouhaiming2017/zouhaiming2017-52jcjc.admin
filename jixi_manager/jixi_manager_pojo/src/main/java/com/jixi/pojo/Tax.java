package com.jixi.pojo;

public class Tax {
    private String timeMonth;

    private Double incomTax;

    private Double ticketTax;

    private Double noticketTax;

    private Double sellTax;

    private Double inSellDifference;

    private String remark;

    public String getTimeMonth() {
        return timeMonth;
    }

    public void setTimeMonth(String timeMonth) {
        this.timeMonth = timeMonth == null ? null : timeMonth.trim();
    }

    public Double getIncomTax() {
        return incomTax;
    }

    public void setIncomTax(Double incomTax) {
        this.incomTax = incomTax;
    }

    public Double getTicketTax() {
        return ticketTax;
    }

    public void setTicketTax(Double ticketTax) {
        this.ticketTax = ticketTax;
    }

    public Double getNoticketTax() {
        return noticketTax;
    }

    public void setNoticketTax(Double noticketTax) {
        this.noticketTax = noticketTax;
    }

    public Double getSellTax() {
        return sellTax;
    }

    public void setSellTax(Double sellTax) {
        this.sellTax = sellTax;
    }

    public Double getInSellDifference() {
        return inSellDifference;
    }

    public void setInSellDifference(Double inSellDifference) {
        this.inSellDifference = inSellDifference;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}