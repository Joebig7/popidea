package com.mamba.popidea.dao;

import com.mamba.popidea.model.ArticleBean;


public interface ArticleBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleBean record);

    int insertSelective(ArticleBean record);

    ArticleBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleBean record);

    int updateByPrimaryKeyWithBLOBs(ArticleBean record);

    int updateByPrimaryKey(ArticleBean record);
}