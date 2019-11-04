package com.mamba.popidea.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class CommentBean {
    private Long commentId;

    @NotBlank(message = "commentTargetId不能为空")
    private Long commentTargetId;

    private Long replyCommentId;
    @NotBlank(message = "userId不能为空")

    private Long userId;
    @NotBlank(message = "type不能为空")
    private Integer type;

    private Date createTime;

    private Date updateTime;

    private String content;

    private Integer status;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentTargetId() {
        return commentTargetId;
    }

    public void setCommentTargetId(Long commentTargetId) {
        this.commentTargetId = commentTargetId;
    }

    public Long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Long replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}