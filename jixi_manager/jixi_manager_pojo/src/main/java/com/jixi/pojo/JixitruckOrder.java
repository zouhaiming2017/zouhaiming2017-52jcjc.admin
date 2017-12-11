package com.jixi.pojo;

import java.util.Date;

public class JixitruckOrder {
    private String sellordercode;

    private String supplier;

    private String address;

    private Double freight;

    private Date senddate;

    @Override
    public String toString() {
        return "JixitruckOrder{" +
                "sellordercode='" + sellordercode + '\'' +
                ", supplier='" + supplier + '\'' +
                ", address='" + address + '\'' +
                ", freight=" + freight +
                ", senddate=" + senddate +
                '}';
    }

    public String getSellordercode() {
        return sellordercode;
    }

    public void setSellordercode(String sellordercode) {
        this.sellordercode = sellordercode == null ? null : sellordercode.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }
}