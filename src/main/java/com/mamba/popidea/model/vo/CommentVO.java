package com.mamba.popidea.model.vo;

import com.mamba.popidea.model.CommentBean;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/11 16:08
 * @description
 */
public class CommentVO extends CommentBean {

    private String nickName;

    private String favicon;

    // 赞数量
    private Long likeCount;

    // 踩数量
    private Long disLikeCount;

    //子回复
    private List<CommentVO> childList;

    public List<CommentVO> getChildList() {
        return childList;
    }

    public void setChildList(List<CommentVO> childList) {
        this.childList = childList;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }
}