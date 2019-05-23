package com.mamba.popidea.dao;

import com.mamba.popidea.model.UserBean;
import org.apache.ibatis.annotations.Param;


public interface UserBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);


    //==============Custom Mapper===========
    UserBean selectUserByLoginName(@Param("username") String username);
}