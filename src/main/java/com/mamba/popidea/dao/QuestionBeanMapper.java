package com.mamba.popidea.dao;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.vo.QuestionVO;
import org.apache.ibatis.annotations.Param;

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

    QuestionVO getQuestionDetailInfo(@Param("id") Long id);

    List<QuestionBean> findListByUserId(Long userId);

    List<QuestionBean> findQuestionByKeyword(String keyword);

    List<QuestionBean> findByRecommend(Long userId);
}