package com.abcool.limitsservice.beans;

public class Limits {
    private Integer minLimit;
    private Integer maxLimit;

    public Limits() {
    }

    public Limits(Integer minLimit, Integer maxLimit) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    public Integer getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Integer minLimit) {
        this.minLimit = minLimit;
    }

    public Integer getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Integer maxLimit) {
        this.maxLimit = maxLimit;
    }
}
