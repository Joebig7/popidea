package com.mamba.popidea.service;

import com.mamba.popidea.model.IndustryBean;
import com.mamba.popidea.model.common.result.RestData;

public interface IndustryService {

    RestData<IndustryBean> getAllIndustryList(Integer pageNo, Integer pageSize);
}
