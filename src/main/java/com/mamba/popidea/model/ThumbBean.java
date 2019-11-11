package com.mamba.popidea.model;

import java.util.Date;

public class ThumbBean {
    private Long thumbId;

    private Long userId;

    private Long targetId;

    private Integer status;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    public Long getThumbId() {
        return thumbId;
    }

    public void setThumbId(Long thumbId) {
        this.thumbId = thumbId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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