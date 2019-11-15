package com.mamba.popidea.service;

import com.mamba.popidea.model.UserFavoriteBean;

public interface FavoriteService {

    void toggle(UserFavoriteBean userFavoriteBean);
}
