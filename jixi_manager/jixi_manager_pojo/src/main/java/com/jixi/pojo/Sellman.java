package com.jixi.pojo;

public class Sellman {
    private String sellmancode;

    private String sellmanname;

    private String phone;

    private String sellmanaddress;

    private String leader;

    private String sellmannature;

    public String getSellmancode() {
        return sellmancode;
    }

    public void setSellmancode(String sellmancode) {
        this.sellmancode = sellmancode == null ? null : sellmancode.trim();
    }

    public String getSellmanname() {
        return sellmanname;
    }

    public void setSellmanname(String sellmanname) {
        this.sellmanname = sellmanname == null ? null : sellmanname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSellmanaddress() {
        return sellmanaddress;
    }

    public void setSellmanaddress(String sellmanaddress) {
        this.sellmanaddress = sellmanaddress == null ? null : sellmanaddress.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getSellmannature() {
        return sellmannature;
    }

    public void setSellmannature(String sellmannature) {
        this.sellmannature = sellmannature == null ? null : sellmannature.trim();
    }
}