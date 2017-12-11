package com.jixi.pojo;

/**
 * Created by zhm on 2017/9/20.
 */
public class PickorderSumExport {
    private String pickordercode;
    private String supplier;
    private String linkman;
    private String address;
    private Double sum;
    private Double freight;
    private Double allsum;

    public String getPickordercode() {
        return pickordercode;
    }

    public void setPickordercode(String pickordercode) {
        this.pickordercode = pickordercode;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
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
}
