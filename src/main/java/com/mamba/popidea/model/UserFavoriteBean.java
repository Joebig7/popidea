package com.mamba.popidea.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UserFavoriteBean {
    private Long userFavoriteId;

    @NotBlank(message = "被收藏对象id为空")
    private Long collectedId;

    @NotBlank(message = "收藏者用户id为空")
    private Long userId;

    private Integer status;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    public Long getUserFavoriteId() {
        return userFavoriteId;
    }

    public void setUserFavoriteId(Long userFavoriteId) {
        this.userFavoriteId = userFavoriteId;
    }

    public Long getCollectedId() {
        return collectedId;
    }

    public void setCollectedId(Long collectedId) {
        this.collectedId = collectedId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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