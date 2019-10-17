package com.mamba.popidea.model.vo;

import com.mamba.popidea.model.ArticleBean;
import com.mamba.popidea.model.TagBean;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/17 15:32
 * @description
 */
public class ArticleVo extends ArticleBean {

    private String nickName;

    private String favicon;


    // 赞数量
    private Long likeCount;

    // 踩数量
    private Long disLikeCount;

    // 评论数
    private Long commentCount;

    private List<TagBean> tags;

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

    public List<TagBean> getTags() {
        return tags;
    }

    public void setTags(List<TagBean> tags) {
        this.tags = tags;
    }
}