package com.mamba.popidea.model.vo;

import java.util.Date;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/8 21:45
 * @description
 */
public class OwnAnswerVo {

    private Long id;
    private String content;
    private String questionTitle;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}