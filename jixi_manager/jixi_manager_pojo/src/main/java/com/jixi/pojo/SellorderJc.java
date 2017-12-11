package com.jixi.pojo;

import java.util.Date;

public class SellorderJc {
    private String sellordercode;

    private Date selldate;

    private String projectname;

    private String company;

    private String customername;

    private String customerphone;

    private String customertype;

    private String sellman;

    private String sendman;

    private String pickman;

    private String pickmanphone;

    private String address;

    private String sendtype;

    private Double onlinesum;

    private Double underlinesum;

    private Double freight;

    private Double allsum;

    private Double discountprice;

    private Double commission;

    private Double receivedsum;

    private Double noreceivedsum;

    private String maketableman;

    private String ticketstatus;

    private String ticketno;

    private String allpaystatue;

    public String getSellordercode() {
        return sellordercode;
    }

    public void setSellordercode(String sellordercode) {
        this.sellordercode = sellordercode == null ? null : sellordercode.trim();
    }

    public Date getSelldate() {
        return selldate;
    }

    public void setSelldate(Date selldate) {
        this.selldate = selldate;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone == null ? null : customerphone.trim();
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype == null ? null : customertype.trim();
    }

    public String getSellman() {
        return sellman;
    }

    public void setSellman(String sellman) {
        this.sellman = sellman == null ? null : sellman.trim();
    }

    public String getSendman() {
        return sendman;
    }

    public void setSendman(String sendman) {
        this.sendman = sendman == null ? null : sendman.trim();
    }

    public String getPickman() {
        return pickman;
    }

    public void setPickman(String pickman) {
        this.pickman = pickman == null ? null : pickman.trim();
    }

    public String getPickmanphone() {
        return pickmanphone;
    }

    public void setPickmanphone(String pickmanphone) {
        this.pickmanphone = pickmanphone == null ? null : pickmanphone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSendtype() {
        return sendtype;
    }

    public void setSendtype(String sendtype) {
        this.sendtype = sendtype == null ? null : sendtype.trim();
    }

    public Double getOnlinesum() {
        return onlinesum;
    }

    public void setOnlinesum(Double onlinesum) {
        this.onlinesum = onlinesum;
    }

    public Double getUnderlinesum() {
        return underlinesum;
    }

    public void setUnderlinesum(Double underlinesum) {
        this.underlinesum = underlinesum;
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

    public Double getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Double discountprice) {
        this.discountprice = discountprice;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
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

    public String getMaketableman() {
        return maketableman;
    }

    public void setMaketableman(String maketableman) {
        this.maketableman = maketableman == null ? null : maketableman.trim();
    }

    public String getTicketstatus() {
        return ticketstatus;
    }

    public void setTicketstatus(String ticketstatus) {
        this.ticketstatus = ticketstatus == null ? null : ticketstatus.trim();
    }

    public String getTicketno() {
        return ticketno;
    }

    public void setTicketno(String ticketno) {
        this.ticketno = ticketno == null ? null : ticketno.trim();
    }

    public String getAllpaystatue() {
        return allpaystatue;
    }

    public void setAllpaystatue(String allpaystatue) {
        this.allpaystatue = allpaystatue == null ? null : allpaystatue.trim();
    }
}