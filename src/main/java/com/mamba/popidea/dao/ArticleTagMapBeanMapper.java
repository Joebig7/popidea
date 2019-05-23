package com.mamba.popidea.dao;

import com.mamba.popidea.model.ArticleTagMapBean;
import org.springframework.stereotype.Repository;


public interface ArticleTagMapBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleTagMapBean record);

    int insertSelective(ArticleTagMapBean record);

    ArticleTagMapBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleTagMapBean record);

    int updateByPrimaryKey(ArticleTagMapBean record);
}