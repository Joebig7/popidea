package com.mamba.popidea.dao;


import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.vo.AnswerVO;
import com.mamba.popidea.model.vo.OwnAnswerVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionAnswerBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionAnswerBean record);

    int insertSelective(QuestionAnswerBean record);

    QuestionAnswerBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionAnswerBean record);

    int updateByPrimaryKeyWithBLOBs(QuestionAnswerBean record);

    int updateByPrimaryKey(QuestionAnswerBean record);

    //========================custom=====================

    List<AnswerVO> getAnswerList(@Param("id") Long id);

    Long findAnswerCount(Long questionId);

    List<OwnAnswerVO> findAnswerListByUserId(Long userId);



}