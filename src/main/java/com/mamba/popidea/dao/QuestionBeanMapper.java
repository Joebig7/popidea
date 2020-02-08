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
    List<QuestionBean> findByKeyWord(@Param("keyword") String keyword);

    QuestionVo getQuestionDetailInfo(@Param("id") Long id);

    List<QuestionBean> findListByUserId(Long userId);
}