package com.mamba.popidea.dao;

import com.mamba.popidea.model.UserIntergralBean;
import org.springframework.stereotype.Repository;


public interface UserIntergralBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserIntergralBean record);

    int insertSelective(UserIntergralBean record);

    UserIntergralBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserIntergralBean record);

    int updateByPrimaryKey(UserIntergralBean record);
}