package com.mamba.popidea.model.vo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/8 15:56
 * @description
 */
public class CommonVO {
    // 赞数量
    private Long likeCount;

    // 踩数量
    private Long disLikeCount;

    // 评论数
    private Long commentCount;

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getDisLikeCount() {
        return disLikeCount;
    }

    public void setDisLikeCount(Long disLikeCount) {
        this.disLikeCount = disLikeCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }
}