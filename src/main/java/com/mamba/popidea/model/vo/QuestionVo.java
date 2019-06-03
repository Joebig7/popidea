package com.mamba.popidea.model.vo;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.TopicBean;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/24 15:17
 */
public class QuestionVo extends QuestionBean {


    private String username;

    private String description;

    //关注数
    private Long focusCount;

    //回答数
    private Long answerCount;

    public Long getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(Long focusCount) {
        this.focusCount = focusCount;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }

    private List<TopicBean> topicBeans;

    public List<TopicBean> getTopicBeans() {
        return topicBeans;
    }

    public void setTopicBeans(List<TopicBean> topicBeans) {
        this.topicBeans = topicBeans;
    }
}