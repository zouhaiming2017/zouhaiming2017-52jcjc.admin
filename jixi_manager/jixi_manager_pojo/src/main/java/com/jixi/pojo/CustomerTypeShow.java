package com.jixi.pojo;

/**
 * Created by zhm on 2017/11/8.
 */
public class CustomerTypeShow {
    private String customerType;
    private Double sum;
    private Long count;

    @Override
    public String toString() {
        return "CustomerTypeShow{" +
                "customerType='" + customerType + '\'' +
                ", sum=" + sum +
                ", count=" + count +
                '}';
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
