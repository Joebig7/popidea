package com.mamba.popidea.dao;

import com.mamba.popidea.model.ArticleBean;
import com.mamba.popidea.model.vo.ArticleVo;

import java.util.List;

public interface ArticleBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleBean record);

    int insertSelective(ArticleBean record);

    ArticleBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleBean record);

    int updateByPrimaryKeyWithBLOBs(ArticleBean record);

    int updateByPrimaryKey(ArticleBean record);

    //----------custom-------------
    void delete(Long id);

    List<ArticleBean> findArticleListByColumnId(Long columnId);

    ArticleVo getDetailInfo(Long id);

    List<ArticleBean> search(String keyword);
}