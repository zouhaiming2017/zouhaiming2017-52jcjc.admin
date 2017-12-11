package com.jixi.pojo;

public class Supplier {
    private String suppliercode;

    private String suppliername;

    private String linkman;

    private String phone;

    private String taxpoint;

    private String address;

    private String vip;

    private String supplierindex;

    public String getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode == null ? null : suppliercode.trim();
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername == null ? null : suppliername.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTaxpoint() {
        return taxpoint;
    }

    public void setTaxpoint(String taxpoint) {
        this.taxpoint = taxpoint == null ? null : taxpoint.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getVip() {
        return vip;
    }

    public void setVip(String vip) {
        this.vip = vip == null ? null : vip.trim();
    }

    public String getSupplierindex() {
        return supplierindex;
    }

    public void setSupplierindex(String supplierindex) {
        this.supplierindex = supplierindex == null ? null : supplierindex.trim();
    }
}