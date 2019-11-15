package com.mamba.popidea.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class UserAttentionBean {
    private Long userAttentionId;

    @NotBlank(message = "被关注对象id为空")
    private Long followeredId;
    @NotBlank(message = "关注者用户id为空")
    private Long userId;


    private Integer status;

    private Integer type;

    private Date createTime;

    private Date updateTime;

    public Long getUserAttentionId() {
        return userAttentionId;
    }

    public void setUserAttentionId(Long userAttentionId) {
        this.userAttentionId = userAttentionId;
    }

    public Long getFolloweredId() {
        return followeredId;
    }

    public void setFolloweredId(Long followeredId) {
        this.followeredId = followeredId;
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