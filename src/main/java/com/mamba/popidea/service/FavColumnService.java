package com.mamba.popidea.service;

import com.mamba.popidea.model.FavColumnBean;
import com.mamba.popidea.model.common.result.RestData;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/6 13:26
 * @description
 */
public interface FavColumnService {

    void addOrUpdate(FavColumnBean favColumnBean);

    RestData<FavColumnBean> getColumnList(Long userId, Integer pageNo, Integer pageSize);

    void delete(Long columnId);
}