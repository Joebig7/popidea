package com.mamba.popidea.service;

import com.mamba.popidea.model.FavColumnBean;
import com.mamba.popidea.model.UserFavoriteBean;

import javax.validation.Valid;

public interface FavoriteService {

    void toggle(UserFavoriteBean userFavoriteBean);
}
