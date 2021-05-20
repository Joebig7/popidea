package com.mamba.popidea.dao;

import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);


    //==============Custom Mapper===========
    UserBean selectUserByLoginName(@Param("username") String username);

    UserVO findWholeUserInfoById(@Param("userId") Long userId);

    int switchMode(@Param("userId") Long userId, @Param("status") Integer status);

    List<UserBean> findUserByKeyword(String keyword);

    List<UserBean> list(@Param("set")Set<Long> set);
}