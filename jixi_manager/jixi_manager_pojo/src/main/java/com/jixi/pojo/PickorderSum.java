package com.jixi.pojo;

import java.util.Date;

public class PickorderSum {
    private String pickordercode;

    private Date pickdata;

    private String supplier;

    private String address;

    private String linkman;

    private Double sum;

    private Double freight;

    private Double allsum;

    private String pickman;

    private String remark;

    private Double receivedsum;

    private Double noreceivedsum;

    private String ticketstatus;

    private String allpaystatue;

    private String ticketno;

    @Override
    public String toString() {
        return "PickorderSum{" +
                "pickordercode='" + pickordercode + '\'' +
                ", pickdata=" + pickdata +
                ", supplier='" + supplier + '\'' +
                ", address='" + address + '\'' +
                ", linkman='" + linkman + '\'' +
                ", sum=" + sum +
                ", freight=" + freight +
                ", allsum=" + allsum +
                ", pickman='" + pickman + '\'' +
                ", remark='" + remark + '\'' +
                ", receivedsum=" + receivedsum +
                ", noreceivedsum=" + noreceivedsum +
                ", ticketstatus='" + ticketstatus + '\'' +
                ", allpaystatue='" + allpaystatue + '\'' +
                ", ticketno='" + ticketno + '\'' +
                '}';
    }

    public String getPickordercode() {
        return pickordercode;
    }

    public void setPickordercode(String pickordercode) {
        this.pickordercode = pickordercode == null ? null : pickordercode.trim();
    }

    public Date getPickdata() {
        return pickdata;
    }

    public void setPickdata(Date pickdata) {
        this.pickdata = pickdata;
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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getAllsum() {
        return allsum;
    }

    public void setAllsum(Double allsum) {
        this.allsum = allsum;
    }

    public String getPickman() {
        return pickman;
    }

    public void setPickman(String pickman) {
        this.pickman = pickman == null ? null : pickman.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Double getReceivedsum() {
        return receivedsum;
    }

    public void setReceivedsum(Double receivedsum) {
        this.receivedsum = receivedsum;
    }

    public Double getNoreceivedsum() {
        return noreceivedsum;
    }

    public void setNoreceivedsum(Double noreceivedsum) {
        this.noreceivedsum = noreceivedsum;
    }

    public String getTicketstatus() {
        return ticketstatus;
    }

    public void setTicketstatus(String ticketstatus) {
        this.ticketstatus = ticketstatus == null ? null : ticketstatus.trim();
    }

    public String getAllpaystatue() {
        return allpaystatue;
    }

    public void setAllpaystatue(String allpaystatue) {
        this.allpaystatue = allpaystatue == null ? null : allpaystatue.trim();
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno == null ? null : ticketno.trim();
    }
}