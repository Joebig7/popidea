package com.mamba.popidea.service;

import com.mamba.popidea.model.TopicBean;
import com.mamba.popidea.model.common.result.RestData;

public interface TopicService {

    RestData<TopicBean> findTopicList(String key, Integer pageNo, Integer pageSize);
}
