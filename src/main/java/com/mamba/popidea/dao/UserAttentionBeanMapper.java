package com.mamba.popidea.dao;

import com.mamba.popidea.model.UserAttentionBean;

public interface UserAttentionBeanMapper {
    int deleteByPrimaryKey(Long userAttentionId);

    int insert(UserAttentionBean record);

    int insertSelective(UserAttentionBean record);

    UserAttentionBean selectByPrimaryKey(Long userAttentionId);

    int updateByPrimaryKeySelective(UserAttentionBean record);

    int updateByPrimaryKey(UserAttentionBean record);
}