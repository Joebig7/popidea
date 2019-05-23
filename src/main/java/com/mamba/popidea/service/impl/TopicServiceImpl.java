package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.TopicBeanMapper;
import com.mamba.popidea.model.TopicBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/23 18:11
 */
@Service
public class TopicServiceImpl implements TopicService {


    @Autowired
    private TopicBeanMapper topicBeanMapper;

    /**
     * 查询话题列表
     *
     * @param key
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<TopicBean> findTopicList(String key, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<TopicBean> topicBeanList = topicBeanMapper.findTopicListWithCondition(key);
        PageInfo<TopicBean> pageInfo = new PageInfo<>(topicBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());

    }
}