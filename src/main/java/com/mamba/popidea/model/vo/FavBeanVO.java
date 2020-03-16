package com.mamba.popidea.model.vo;

import java.util.Date;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/8 15:24
 * @description
 */
public class FavBeanVO extends CommonVO {
    //用户名称
    private String nickName;

    //用户图标
    private String favicon;

    //问题标题
    private String questionTitle;

    //问题内容
    private String questionContent;

    //回答的id
    private Long answerId;

    //回答的内容
    private String answerContent;

    //收藏的时间
    private Date createTime;

    //文章id
    private Long articleId;

    //文章标题
    private String articleTitle;

    //文章内容
    private String articleContent;

    //收藏类型
    private Integer type;

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

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}