package com.jixi.pojo;

import java.util.Date;

public class PickorderMaster {
    private Integer id;

    private String pickordercode;

    private String itemcode;

    private String itemname;

    private String standard;

    private String model;

    private String brandname;

    private String packingsize;

    private String chargeunit;

    private Long count;

    private Double inprice;

    private Double sum;

    private Date pickdate;

    private String pickaddress;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPickordercode() {
        return pickordercode;
    }

    public void setPickordercode(String pickordercode) {
        this.pickordercode = pickordercode == null ? null : pickordercode.trim();
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getInprice() {
        return inprice;
    }

    public void setInprice(Double inprice) {
        this.inprice = inprice;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getPickdate() {
        return pickdate;
    }

    public void setPickdate(Date pickdate) {
        this.pickdate = pickdate;
    }

    public String getPickaddress() {
        return pickaddress;
    }

    public void setPickaddress(String pickaddress) {
        this.pickaddress = pickaddress == null ? null : pickaddress.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}