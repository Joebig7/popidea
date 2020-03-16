package com.mamba.popidea.service;

import com.mamba.popidea.model.SpecialColumnBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/16 17:35
 * @description
 */
public interface SpecialColumnService {

    void createOrUpdate(SpecialColumnBean columnBean);

    void delete(Long id);

    RestData<SpecialColumnBean> getColumnByUserId(Long userId, Integer pageNo, Integer pageSize);

    RestData getSpecialColumnSearch(String keyword, Integer pageNo, Integer pageSize);
}