package com.mamba.popidea.dao;

import com.mamba.popidea.model.TopicQuestionMapBean;

import java.util.List;


public interface TopicQuestionMapBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicQuestionMapBean record);

    int insertSelective(TopicQuestionMapBean record);

    TopicQuestionMapBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicQuestionMapBean record);

    int updateByPrimaryKey(TopicQuestionMapBean record);

    //===================custom=================
    void batchInsert(List<TopicQuestionMapBean> topics);
}