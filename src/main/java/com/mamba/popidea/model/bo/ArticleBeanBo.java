package com.mamba.popidea.model.bo;

import com.mamba.popidea.model.ArticleBean;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/17 14:16
 */
public class ArticleBeanBo extends ArticleBean {

    private List<Long> tags;

    public List<Long> getTags() {
        return tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }
}