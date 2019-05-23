package com.mamba.popidea.model;

import java.util.Date;

public class UserIntergralBean {
    private Long id;

    private Long userId;

    private Integer intergral = 100;

    private Date createTime;

    private Date updateTime;

    public UserIntergralBean(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getIntergral() {
        return intergral;
    }

    public void setIntergral(Integer intergral) {
        this.intergral = intergral;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}