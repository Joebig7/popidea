package com.mamba.popidea.dao;

import com.mamba.popidea.model.FollowerBean;
import org.springframework.stereotype.Repository;


public interface FollowerBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FollowerBean record);

    int insertSelective(FollowerBean record);

    FollowerBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FollowerBean record);

    int updateByPrimaryKey(FollowerBean record);
}