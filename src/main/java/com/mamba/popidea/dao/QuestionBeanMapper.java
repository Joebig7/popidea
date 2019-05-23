package com.mamba.popidea.dao;

import com.mamba.popidea.model.QuestionBean;
import org.springframework.stereotype.Repository;


public interface QuestionBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionBean record);

    int insertSelective(QuestionBean record);

    QuestionBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionBean record);

    int updateByPrimaryKeyWithBLOBs(QuestionBean record);

    int updateByPrimaryKey(QuestionBean record);

    QuestionBean getQuestionInfo(Long id);
}