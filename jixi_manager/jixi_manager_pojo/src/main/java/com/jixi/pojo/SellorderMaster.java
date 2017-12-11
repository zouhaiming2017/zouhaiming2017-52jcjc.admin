package com.jixi.pojo;

import java.util.Date;

public class SellorderMaster {
    private Integer id;

    private String sellordercode;

    private String itemcode;

    private String itemname;

    private String standard;

    private String model;

    private String brandname;

    private String packingsize;

    private String chargeunit;

    private Double outprice;

    private Long count;

    private Double sum;

    private String company;

    private String linkman;

    private Date selldate;

    private String selladdress;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSellordercode() {
        return sellordercode;
    }

    public void setSellordercode(String sellordercode) {
        this.sellordercode = sellordercode == null ? null : sellordercode.trim();
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

    public Double getOutprice() {
        return outprice;
    }

    public void setOutprice(Double outprice) {
        this.outprice = outprice;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public Date getSelldate() {
        return selldate;
    }

    public void setSelldate(Date selldate) {
        this.selldate = selldate;
    }

    public String getSelladdress() {
        return selladdress;
    }

    public void setSelladdress(String selladdress) {
        this.selladdress = selladdress == null ? null : selladdress.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}