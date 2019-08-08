package com.mamba.popidea.dao;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.vo.QuestionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface QuestionBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionBean record);

    int insertSelective(QuestionBean record);

    QuestionBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionBean record);

    int updateByPrimaryKeyWithBLOBs(QuestionBean record);

    int updateByPrimaryKey(QuestionBean record);

    //======================custom==========================
    List<QuestionVo> findByKeyWord(@Param("keyword") String keyword);

    List<QuestionBean> findByUserId(@Param("userId") Long userId);

    QuestionVo getQuestionDetailInfo(@Param("id") Long id);
}