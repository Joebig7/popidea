package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.UserFavoriteBeanMapper;
import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/15 17:57
 * @description 收藏相关业务逻辑
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {


    @Autowired
    private UserFavoriteBeanMapper userFavoriteBeanMapper;

    /**
     * 收藏功能
     *
     * @param userFavoriteBean
     */
    @Override
    public void toggle(UserFavoriteBean userFavoriteBean) {
        Long userFavoriteId = userFavoriteBean.getUserFavoriteId();
        if (Objects.isNull(userFavoriteId)) {
            userFavoriteBeanMapper.insertSelective(userFavoriteBean);
        } else {
            userFavoriteBeanMapper.updateByPrimaryKeySelective(userFavoriteBean);
        }
    }
}