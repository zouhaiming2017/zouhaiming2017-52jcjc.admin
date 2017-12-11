package com.jixi.pojo;

import java.util.Date;

public class PickorderItem {
    private String id;

    private String itemcode;

    private String itemname;

    private String suppliername;

    private String standard;

    private String model;

    private String brandname;

    private String packingsize;

    private String chargeunit;

    private Double inprice;

    private Double outprice;

    private Integer count;

    private Double sumprice;

    private String remark;

    private Date pickdate;

    @Override
    public String toString() {
        return "PickorderItem{" +
                "id='" + id + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", suppliername='" + suppliername + '\'' +
                ", standard='" + standard + '\'' +
                ", model='" + model + '\'' +
                ", brandname='" + brandname + '\'' +
                ", packingsize='" + packingsize + '\'' +
                ", chargeunit='" + chargeunit + '\'' +
                ", inprice=" + inprice +
                ", outprice=" + outprice +
                ", count=" + count +
                ", sumprice=" + sumprice +
                ", remark='" + remark + '\'' +
                ", pickdate=" + pickdate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername == null ? null : suppliername.trim();
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

    public String getPackingsize() {
        return packingsize;
    }

    public void setPackingsize(String packingsize) {
        this.packingsize = packingsize == null ? null : packingsize.trim();
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

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSumprice() {
        return sumprice;
    }

    public void setSumprice(Double sumprice) {
        this.sumprice = sumprice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getPickdate() {
        return pickdate;
    }

    public void setPickdate(Date pickdate) {
        this.pickdate = pickdate;
    }
}