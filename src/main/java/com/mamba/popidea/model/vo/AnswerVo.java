package com.mamba.popidea.model.vo;

import com.mamba.popidea.model.QuestionAnswerBean;

import java.util.Date;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/31 18:22
 */
public class AnswerVo extends QuestionAnswerBean {


    private String nickName;

    private String favicon;


    // 赞数量
    private Long likeCount;

    // 踩数量
    private Long disLikeCount;

    // 评论数
    private Long commentCount;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

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