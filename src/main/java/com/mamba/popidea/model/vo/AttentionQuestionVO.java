package com.mamba.popidea.model.vo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/8 16:27
 * @description
 */
public class AttentionQuestionVO {

    private Long id;
    private Long userAttentionId;
    private String questionTitle;
    private Long attentionCount;
    private Long answerCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Long getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(Long attentionCount) {
        this.attentionCount = attentionCount;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }

    public Long getUserAttentionId() {
        return userAttentionId;
    }

    public void setUserAttentionId(Long userAttentionId) {
        this.userAttentionId = userAttentionId;
    }
}