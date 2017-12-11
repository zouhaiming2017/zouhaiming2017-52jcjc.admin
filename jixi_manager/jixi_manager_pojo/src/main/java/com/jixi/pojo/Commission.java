package com.jixi.pojo;

public class Commission {
    private Integer id;

    private Double t1;

    private Double t2;

    private Double t3;

    private Double t4;

    private Double t5;

    @Override
    public String toString() {
        return "Commission{" +
                "id=" + id +
                ", t1=" + t1 +
                ", t2=" + t2 +
                ", t3=" + t3 +
                ", t4=" + t4 +
                ", t5=" + t5 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getT1() {
        return t1;
    }

    public void setT1(Double t1) {
        this.t1 = t1;
    }

    public Double getT2() {
        return t2;
    }

    public void setT2(Double t2) {
        this.t2 = t2;
    }

    public Double getT3() {
        return t3;
    }

    public void setT3(Double t3) {
        this.t3 = t3;
    }

    public Double getT4() {
        return t4;
    }

    public void setT4(Double t4) {
        this.t4 = t4;
    }

    public Double getT5() {
        return t5;
    }

    public void setT5(Double t5) {
        this.t5 = t5;
    }
}