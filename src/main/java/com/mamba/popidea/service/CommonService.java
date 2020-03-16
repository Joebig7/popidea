package com.mamba.popidea.service;

import com.mamba.popidea.model.common.result.RestData;

public interface CommonService {
    RestData search(String keyword, Integer type, Integer pageNo, Integer pageSize);

    RestData recommend(Integer pageNo, Integer pageSize);
}
