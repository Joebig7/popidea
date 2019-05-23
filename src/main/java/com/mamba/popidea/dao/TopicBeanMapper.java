package com.mamba.popidea.dao;

import com.mamba.popidea.model.TopicBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TopicBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicBean record);

    int insertSelective(TopicBean record);

    TopicBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicBean record);

    int updateByPrimaryKeyWithBLOBs(TopicBean record);

    int updateByPrimaryKey(TopicBean record);

    //=======================custom====================
    List<TopicBean> findTopicListWithCondition(@Param("keyword")String key);
}