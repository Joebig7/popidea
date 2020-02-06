package com.mamba.popidea.dao;

import com.mamba.popidea.model.FavColumnBean;

import java.util.List;

public interface FavColumnBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FavColumnBean record);

    int insertSelective(FavColumnBean record);

    FavColumnBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FavColumnBean record);

    int updateByPrimaryKey(FavColumnBean record);

    //=======================custom========================
    List<FavColumnBean> findOwnFavColumnListByUserId(Long userId);

    List<FavColumnBean> findCommonFavColumnListByUserId(Long userId);

    void delete(Long columnId);
}