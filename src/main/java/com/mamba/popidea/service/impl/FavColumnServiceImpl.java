package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.FavColumnBeanMapper;
import com.mamba.popidea.model.FavColumnBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.FavColumnService;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/2/6 13:26
 * @description
 */
@Service
public class FavColumnServiceImpl implements FavColumnService {

    @Autowired
    private FavColumnBeanMapper favColumnBeanMapper;

    @Override
    public void addOrUpdate(FavColumnBean favColumnBean) {
        Long userId = CommonUtil.getUserId();
        favColumnBean.setUserId(userId);
        Long id = favColumnBean.getId();
        if (Objects.nonNull(id)) {
            favColumnBeanMapper.updateByPrimaryKeySelective(favColumnBean);
        } else {
            favColumnBeanMapper.insertSelective(favColumnBean);
        }
    }

    @Override
    public RestData<FavColumnBean> getColumnList(Long userId, Integer pageNo, Integer pageSize) {
        Long ownId = CommonUtil.getUserId();
        //如果是自己的账号全部显示，如果是别人的只能显示未匿名的
        PageHelper.startPage(pageNo, pageSize);
        if (ownId.equals(userId)) {
            List<FavColumnBean> ownFavColumnList = favColumnBeanMapper.findOwnFavColumnListByUserId(userId);
            PageInfo<FavColumnBean> pageInfo = new PageInfo<>(ownFavColumnList);
            return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
        } else {
            List<FavColumnBean> commonFavColumnList = favColumnBeanMapper.findCommonFavColumnListByUserId(userId);
            PageInfo<FavColumnBean> pageInfo = new PageInfo<>(commonFavColumnList);
            return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
        }
    }

    /**
     * 删除收藏夹
     *
     * @param columnId
     */
    @Override
    public void delete(Long columnId) {
        favColumnBeanMapper.delete(columnId);
    }
}