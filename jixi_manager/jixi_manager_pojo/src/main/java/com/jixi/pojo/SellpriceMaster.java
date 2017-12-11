package com.jixi.pojo;

public class SellpriceMaster {
    private String itemcode;

    private String itemname;

    private String itemnamecode;

    private String standard;

    private String standardcode;

    private String model;

    private String modelcode;

    private String brandname;

    private String brandcode;

    private String chargeunit;

    private Double outprice;

    private String packingsize;

    private String suppliercode;

    public SellpriceMaster() {}

    public SellpriceMaster(String itemcode, String itemname, String itemnamecode, String standard, String standardcode, String model, String modelcode, String brandname, String brandcode, String chargeunit, Double outprice, String packingsize, String suppliercode) {
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.itemnamecode = itemnamecode;
        this.standard = standard;
        this.standardcode = standardcode;
        this.model = model;
        this.modelcode = modelcode;
        this.brandname = brandname;
        this.brandcode = brandcode;
        this.chargeunit = chargeunit;
        this.outprice = outprice;
        this.packingsize = packingsize;
        this.suppliercode = suppliercode;
    }

    @Override
    public String toString() {
        return "SellpriceMaster{" +
                "itemcode='" + itemcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", itemnamecode='" + itemnamecode + '\'' +
                ", standard='" + standard + '\'' +
                ", standardcode='" + standardcode + '\'' +
                ", model='" + model + '\'' +
                ", modelcode='" + modelcode + '\'' +
                ", brandname='" + brandname + '\'' +
                ", brandcode='" + brandcode + '\'' +
                ", chargeunit='" + chargeunit + '\'' +
                ", outprice=" + outprice +
                ", packingsize='" + packingsize + '\'' +
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

    public String getItemnamecode() {
        return itemnamecode;
    }

    public void setItemnamecode(String itemnamecode) {
        this.itemnamecode = itemnamecode == null ? null : itemnamecode.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public String getStandardcode() {
        return standardcode;
    }

    public void setStandardcode(String standardcode) {
        this.standardcode = standardcode == null ? null : standardcode.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getModelcode() {
        return modelcode;
    }

    public void setModelcode(String modelcode) {
        this.modelcode = modelcode == null ? null : modelcode.trim();
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
    }

    public String getBrandcode() {
        return brandcode;
    }

    public void setBrandcode(String brandcode) {
        this.brandcode = brandcode == null ? null : brandcode.trim();
    }

    public String getChargeunit() {
        return chargeunit;
    }

    public void setChargeunit(String chargeunit) {
        this.chargeunit = chargeunit == null ? null : chargeunit.trim();
    }

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
    }

    public String getPackingsize() {
        return packingsize;
    }

    public void setPackingsize(String packingsize) {
        this.packingsize = packingsize == null ? null : packingsize.trim();
    }

    public String getSuppliercode() {
        return suppliercode;
    }

    public void setSuppliercode(String suppliercode) {
        this.suppliercode = suppliercode == null ? null : suppliercode.trim();
    }
}