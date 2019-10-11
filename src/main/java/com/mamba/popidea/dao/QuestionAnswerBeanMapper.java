package com.mamba.popidea.dao;


import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.vo.AnswerVo;
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

    List<AnswerVo> getAnswerList(@Param("id")Long id);
}