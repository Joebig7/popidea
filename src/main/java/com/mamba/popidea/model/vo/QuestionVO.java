package com.mamba.popidea.model.vo;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.TopicBean;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/24 15:17
 */
public class QuestionVO extends QuestionBean {



    private String nickName;

    private String favicon;

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
}