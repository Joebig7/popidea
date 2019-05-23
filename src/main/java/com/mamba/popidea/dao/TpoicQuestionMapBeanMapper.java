package com.mamba.popidea.dao;

import com.mamba.popidea.model.TpoicQuestionMapBean;
import org.springframework.stereotype.Repository;


public interface TpoicQuestionMapBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TpoicQuestionMapBean record);

    int insertSelective(TpoicQuestionMapBean record);

    TpoicQuestionMapBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TpoicQuestionMapBean record);

    int updateByPrimaryKey(TpoicQuestionMapBean record);
}