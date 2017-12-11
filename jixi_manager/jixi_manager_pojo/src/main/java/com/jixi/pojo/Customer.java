package com.jixi.pojo;

public class Customer {
    private String customercode;

    private String nickname;

    private String customername;

    private String company;

    private String customertype;

    private String sellman;

    private String vip;

    @Override
    public String toString() {
        return "Customer{" +
                "customercode='" + customercode + '\'' +
                ", nickname='" + nickname + '\'' +
                ", customername='" + customername + '\'' +
                ", company='" + company + '\'' +
                ", customertype='" + customertype + '\'' +
                ", sellman='" + sellman + '\'' +
                ", vip='" + vip + '\'' +
                '}';
    }

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode == null ? null : customercode.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
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

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip == null ? null : vip.trim();
    }
}