package com.jixi.pojo;

public class PickpriceMaster {
    private String itemcode;

    private String itemname;

    private String standard;

    private String model;

    private String brandname;

    private String chargeunit;

    private Double inprice;

    private Double excludingtax;

    private Double limitprice;

    private String packingsize;

    private String supplier;

    private String suppliercode;

    @Override
    public String toString() {
        return "PickpriceMaster{" +
                "itemcode='" + itemcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", standard='" + standard + '\'' +
                ", model='" + model + '\'' +
                ", brandname='" + brandname + '\'' +
                ", chargeunit='" + chargeunit + '\'' +
                ", inprice=" + inprice +
                ", excludingtax=" + excludingtax +
                ", limitprice=" + limitprice +
                ", packingsize='" + packingsize + '\'' +
                ", supplier='" + supplier + '\'' +
                ", suppliercode='" + suppliercode + '\'' +
                '}';
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
    }

    public String getChargeunit() {
        return chargeunit;
    }

    public void setChargeunit(String chargeunit) {
        this.chargeunit = chargeunit == null ? null : chargeunit.trim();
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public Double getExcludingtax() {
        return excludingtax;
    }

    public void setExcludingtax(Double excludingtax) {
        this.excludingtax = excludingtax;
    }

    public Double getLimitprice() {
        return limitprice;
    }

    public void setLimitprice(Double limitprice) {
        this.limitprice = limitprice;
    }

    public String getPackingsize() {
        return packingsize;
    }

    public void setPackingsize(String packingsize) {
        this.packingsize = packingsize == null ? null : packingsize.trim();
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    public String getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode == null ? null : suppliercode.trim();
    }
}