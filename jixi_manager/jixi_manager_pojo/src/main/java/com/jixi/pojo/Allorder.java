package com.jixi.pojo;

public class Allorder {
    private String timeMonth;

    private Double sellSums;

    private String sellSumsRategrowth;

    private Integer sellCounts;

    private String sellCountsRategrowth;

    private Double sellSumsAvg;

    private Double sellSumsDayavg;

    private Double sellCountsDayavg;

    private Double pickSums;

    private Double realGrossprofit;

    private Double pinOffItemoffset;

    private String grossmargin;

    private String freightpro;

    private Double freightSupplier;

    private Double freightJixi;

    private Double freightCustomer;

    private String remark;

    @Override
    public String toString() {
        return "Allorder{" +
                "timeMonth='" + timeMonth + '\'' +
                ", sellSums=" + sellSums +
                ", sellSumsRategrowth='" + sellSumsRategrowth + '\'' +
                ", sellCounts=" + sellCounts +
                ", sellCountsRategrowth='" + sellCountsRategrowth + '\'' +
                ", sellSumsAvg=" + sellSumsAvg +
                ", sellSumsDayavg=" + sellSumsDayavg +
                ", sellCountsDayavg=" + sellCountsDayavg +
                ", pickSums=" + pickSums +
                ", realGrossprofit=" + realGrossprofit +
                ", pinOffItemoffset=" + pinOffItemoffset +
                ", grossmargin='" + grossmargin + '\'' +
                ", freightpro='" + freightpro + '\'' +
                ", freightSupplier=" + freightSupplier +
                ", freightJixi=" + freightJixi +
                ", freightCustomer=" + freightCustomer +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getTimeMonth() {
        return timeMonth;
    }

    public void setTimeMonth(String timeMonth) {
        this.timeMonth = timeMonth == null ? null : timeMonth.trim();
    }

    public Double getSellSums() {
        return sellSums;
    }

    public void setSellSums(Double sellSums) {
        this.sellSums = sellSums;
    }

    public String getSellSumsRategrowth() {
        return sellSumsRategrowth;
    }

    public void setSellSumsRategrowth(String sellSumsRategrowth) {
        this.sellSumsRategrowth = sellSumsRategrowth == null ? null : sellSumsRategrowth.trim();
    }

    public Integer getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(Integer sellCounts) {
        this.sellCounts = sellCounts;
    }

    public String getSellCountsRategrowth() {
        return sellCountsRategrowth;
    }

    public void setSellCountsRategrowth(String sellCountsRategrowth) {
        this.sellCountsRategrowth = sellCountsRategrowth == null ? null : sellCountsRategrowth.trim();
    }

    public Double getSellSumsAvg() {
        return sellSumsAvg;
    }

    public void setSellSumsAvg(Double sellSumsAvg) {
        this.sellSumsAvg = sellSumsAvg;
    }

    public Double getSellSumsDayavg() {
        return sellSumsDayavg;
    }

    public void setSellSumsDayavg(Double sellSumsDayavg) {
        this.sellSumsDayavg = sellSumsDayavg;
    }

    public Double getSellCountsDayavg() {
        return sellCountsDayavg;
    }

    public void setSellCountsDayavg(Double sellCountsDayavg) {
        this.sellCountsDayavg = sellCountsDayavg;
    }

    public Double getPickSums() {
        return pickSums;
    }

    public void setPickSums(Double pickSums) {
        this.pickSums = pickSums;
    }

    public Double getRealGrossprofit() {
        return realGrossprofit;
    }

    public void setRealGrossprofit(Double realGrossprofit) {
        this.realGrossprofit = realGrossprofit;
    }

    public Double getPinOffItemoffset() {
        return pinOffItemoffset;
    }

    public void setPinOffItemoffset(Double pinOffItemoffset) {
        this.pinOffItemoffset = pinOffItemoffset;
    }

    public String getGrossmargin() {
        return grossmargin;
    }

    public void setGrossmargin(String grossmargin) {
        this.grossmargin = grossmargin == null ? null : grossmargin.trim();
    }

    public String getFreightpro() {
        return freightpro;
    }

    public void setFreightpro(String freightpro) {
        this.freightpro = freightpro == null ? null : freightpro.trim();
    }

    public Double getFreightSupplier() {
        return freightSupplier;
    }

    public void setFreightSupplier(Double freightSupplier) {
        this.freightSupplier = freightSupplier;
    }

    public Double getFreightJixi() {
        return freightJixi;
    }

    public void setFreightJixi(Double freightJixi) {
        this.freightJixi = freightJixi;
    }

    public Double getFreightCustomer() {
        return freightCustomer;
    }

    public void setFreightCustomer(Double freightCustomer) {
        this.freightCustomer = freightCustomer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}