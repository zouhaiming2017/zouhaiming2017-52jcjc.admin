package com.jixi.pojo;

import java.util.Date;

public class Customerdetail {
    private String customermonthcode;

    private String customername;

    private String sellman;

    private Double discountprices;

    private Double freight;

    private String freightpro;

    private Long count;

    private String customertype;

    private String commissionpro;

    private Double sellmancommission;

    private Date themonth;

    @Override
    public String toString() {
        return "Customerdetail{" +
                "customermonthcode='" + customermonthcode + '\'' +
                ", customername='" + customername + '\'' +
                ", sellman='" + sellman + '\'' +
                ", discountprices=" + discountprices +
                ", freight=" + freight +
                ", freightpro='" + freightpro + '\'' +
                ", count=" + count +
                ", customertype='" + customertype + '\'' +
                ", commissionpro='" + commissionpro + '\'' +
                ", sellmancommission=" + sellmancommission +
                ", themonth=" + themonth +
                '}';
    }

    public String getCustomermonthcode() {
        return customermonthcode;
    }

    public void setCustomermonthcode(String customermonthcode) {
        this.customermonthcode = customermonthcode == null ? null : customermonthcode.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getSellman() {
        return sellman;
    }

    public void setSellman(String sellman) {
        this.sellman = sellman == null ? null : sellman.trim();
    }

    public Double getDiscountprices() {
        return discountprices;
    }

    public void setDiscountprices(Double discountprices) {
        this.discountprices = discountprices;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getFreightpro() {
        return freightpro;
    }

    public void setFreightpro(String freightpro) {
        this.freightpro = freightpro == null ? null : freightpro.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype == null ? null : customertype.trim();
    }

    public String getCommissionpro() {
        return commissionpro;
    }

    public void setCommissionpro(String commissionpro) {
        this.commissionpro = commissionpro == null ? null : commissionpro.trim();
    }

    public Double getSellmancommission() {
        return sellmancommission;
    }

    public void setSellmancommission(Double sellmancommission) {
        this.sellmancommission = sellmancommission;
    }

    public Date getThemonth() {
        return themonth;
    }

    public void setThemonth(Date themonth) {
        this.themonth = themonth;
    }
}