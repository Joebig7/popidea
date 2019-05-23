package com.mamba.popidea.dao;

import com.mamba.popidea.model.TopicBean;
import org.springframework.stereotype.Repository;


public interface TopicBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicBean record);

    int insertSelective(TopicBean record);

    TopicBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicBean record);

    int updateByPrimaryKeyWithBLOBs(TopicBean record);

    int updateByPrimaryKey(TopicBean record);
}