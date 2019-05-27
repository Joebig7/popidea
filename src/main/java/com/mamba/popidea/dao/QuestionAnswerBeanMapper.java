package com.mamba.popidea.dao;


import com.mamba.popidea.model.QuestionAnswerBean;

public interface QuestionAnswerBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionAnswerBean record);

    int insertSelective(QuestionAnswerBean record);

    QuestionAnswerBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionAnswerBean record);

    int updateByPrimaryKeyWithBLOBs(QuestionAnswerBean record);

    int updateByPrimaryKey(QuestionAnswerBean record);
}