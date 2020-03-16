package com.mamba.popidea.service;

import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.FavBeanVO;

public interface FavoriteService {

    void toggle(UserFavoriteBean userFavoriteBean);

    RestData<FavBeanVO> getFavList(Long columnId, Long userId, Integer pageNo, Integer pageSize);
}
