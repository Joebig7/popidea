package com.mamba.popidea.dao;

import com.mamba.popidea.model.UserAttentionBean;
import com.mamba.popidea.model.vo.AttentionColumnVO;
import com.mamba.popidea.model.vo.AttentionPersonVO;
import com.mamba.popidea.model.vo.AttentionQuestionVO;

import java.util.List;

public interface UserAttentionBeanMapper {
    int deleteByPrimaryKey(Long userAttentionId);

    int insert(UserAttentionBean record);

    int insertSelective(UserAttentionBean record);

    UserAttentionBean selectByPrimaryKey(Long userAttentionId);

    int updateByPrimaryKeySelective(UserAttentionBean record);

    int updateByPrimaryKey(UserAttentionBean record);

    //==========================custom=========================

    List<AttentionPersonVO> findAttentionPersonList(Long userId);

    List<AttentionColumnVO> findAttentionColumnList(Long userId);

    List<AttentionQuestionVO> findAttentionQuestionList(Long userId);
}