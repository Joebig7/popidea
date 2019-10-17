package com.mamba.popidea.dao;

import com.mamba.popidea.model.TagBean;

import java.util.List;

public interface TagBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagBean record);

    int insertSelective(TagBean record);

    TagBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagBean record);

    int updateByPrimaryKey(TagBean record);

    //------------------Custom--------------------
    TagBean findByName(String name);

    List<TagBean> search(String keyword);

}