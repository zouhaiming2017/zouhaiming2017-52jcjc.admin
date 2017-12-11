package com.jixi.pojo;

public class Sellmandetail {
    private String sellmanmonthcode;

    private String sellmanname;

    private Double discountprices;

    private Double recieveprices;

    private Double norecieveprices;

    private Double commissions;

    public String getSellmanmonthcode() {
        return sellmanmonthcode;
    }

    public void setSellmanmonthcode(String sellmanmonthcode) {
        this.sellmanmonthcode = sellmanmonthcode == null ? null : sellmanmonthcode.trim();
    }

    public String getSellmanname() {
        return sellmanname;
    }

    public void setSellmanname(String sellmanname) {
        this.sellmanname = sellmanname == null ? null : sellmanname.trim();
    }

    public Double getDiscountprices() {
        return discountprices;
    }

    public void setDiscountprices(Double discountprices) {
        this.discountprices = discountprices;
    }

    public Double getRecieveprices() {
        return recieveprices;
    }

    public void setRecieveprices(Double recieveprices) {
        this.recieveprices = recieveprices;
    }

    public Double getNorecieveprices() {
        return norecieveprices;
    }

    public void setNorecieveprices(Double norecieveprices) {
        this.norecieveprices = norecieveprices;
    }

    public Double getCommissions() {
        return commissions;
    }

    public void setCommissions(Double commissions) {
        this.commissions = commissions;
    }
}