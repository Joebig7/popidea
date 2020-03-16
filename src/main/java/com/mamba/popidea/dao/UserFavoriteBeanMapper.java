package com.mamba.popidea.dao;

import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.model.vo.FavBeanVO;

import java.util.List;

public interface UserFavoriteBeanMapper {
    int deleteByPrimaryKey(Long userFavoriteId);

    int insert(UserFavoriteBean record);

    int insertSelective(UserFavoriteBean record);

    UserFavoriteBean selectByPrimaryKey(Long userFavoriteId);

    int updateByPrimaryKeySelective(UserFavoriteBean record);

    int updateByPrimaryKey(UserFavoriteBean record);

    //==========================custom=========================


    List<FavBeanVO> findFavList(Long columnId, Long userId);

}