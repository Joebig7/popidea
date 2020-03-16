package com.mamba.popidea.service;

import com.mamba.popidea.model.ArticleBean;
import com.mamba.popidea.model.bo.ArticleBeanBo;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.ArticleVO;

public interface ArticleService {

    void release(ArticleBeanBo articleBeanBo);

    void delete(Long id);

    RestData<ArticleBean> list(Long columnId, Integer pageNo, Integer pageSize);

    ArticleVO get(Long id);

    RestData<ArticleBean> search(String keyword, Integer pageNo, Integer pageSize);
}
