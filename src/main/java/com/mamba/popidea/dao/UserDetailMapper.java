package com.mamba.popidea.dao;

import com.mamba.popidea.model.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


public interface UserDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKeyWithBLOBs(UserDetail record);

    int updateByPrimaryKey(UserDetail record);

    //===========custom============
    UserDetail selectUserDetailByUserId(@Param("userId") Long userId);
}