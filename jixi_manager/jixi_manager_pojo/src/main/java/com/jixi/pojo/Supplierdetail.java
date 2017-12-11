package com.jixi.pojo;

public class Supplierdetail {
    private String suppliermonthcode;

    private String suppliername;

    private Double suppliersums;

    private Double supplierfreights;

    private String freightpro;

    public String getSuppliermonthcode() {
        return suppliermonthcode;
    }

    public void setSuppliermonthcode(String suppliermonthcode) {
        this.suppliermonthcode = suppliermonthcode == null ? null : suppliermonthcode.trim();
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername == null ? null : suppliername.trim();
    }

    public Double getSuppliersums() {
        return suppliersums;
    }

    public void setSuppliersums(Double suppliersums) {
        this.suppliersums = suppliersums;
    }

    public Double getSupplierfreights() {
        return supplierfreights;
    }

    public void setSupplierfreights(Double supplierfreights) {
        this.supplierfreights = supplierfreights;
    }

    public String getFreightpro() {
        return freightpro;
    }

    public void setFreightpro(String freightpro) {
        this.freightpro = freightpro == null ? null : freightpro.trim();
    }
}