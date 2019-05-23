package com.mamba.popidea.model.common.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;

import java.util.List;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RestData<T> {

    private List<T> rsData;
    private Long rsCount;

    public RestData() {

    }

    public RestData(T data) {
        List<T> rsData = Lists.newArrayList();
        rsData.add(data);
        this.rsData = rsData;
    }

    public RestData(List<T> rsData) {
        this.rsData = rsData;
    }

    public RestData(List<T> rsData, Integer count) {
        this(rsData);
        this.rsCount = Long.valueOf(count);
    }

    public RestData(List<T> rsData, Long count) {
        this(rsData);
        this.rsCount = count;
    }

    public List<T> getRsData() {
        return rsData;
    }

    public void setRsData(List<T> rsData) {
        this.rsData = rsData;
    }

    public Long getRsCount() {
        return rsCount;
    }

    public void setRsCount(Long rsCount) {
        this.rsCount = rsCount;
    }
}
