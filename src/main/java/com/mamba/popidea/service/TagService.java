package com.mamba.popidea.service;

import com.mamba.popidea.model.TagBean;
import com.mamba.popidea.model.common.result.RestData;

public interface TagService {

    void add(TagBean tagBean);

    TagBean findByName(String name);

    RestData<TagBean> search(String keyword, Integer pageNo, Integer pageSize);
}
