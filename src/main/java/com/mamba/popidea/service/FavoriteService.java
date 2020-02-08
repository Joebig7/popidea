package com.mamba.popidea.service;

import com.mamba.popidea.model.FavColumnBean;
import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.FavBeanVo;

import javax.validation.Valid;

public interface FavoriteService {

    void toggle(UserFavoriteBean userFavoriteBean);

    RestData<FavBeanVo> getFavList(Long columnId, Long userId, Integer pageNo, Integer pageSize);
}
