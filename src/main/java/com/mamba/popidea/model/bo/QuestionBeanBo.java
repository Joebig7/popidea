package com.mamba.popidea.model.bo;

import com.mamba.popidea.model.QuestionBean;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/30 18:19
 */
public class QuestionBeanBo extends QuestionBean {

    private List<Long> topics;


    public List<Long> getTopics() {
        return topics;
    }

    public void setTopics(List<Long> topics) {
        this.topics = topics;
    }
}