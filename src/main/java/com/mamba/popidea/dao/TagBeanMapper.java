package com.mamba.popidea.dao;

import com.mamba.popidea.model.TagBean;

public interface TagBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagBean record);

    int insertSelective(TagBean record);

    TagBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagBean record);

    int updateByPrimaryKey(TagBean record);
}