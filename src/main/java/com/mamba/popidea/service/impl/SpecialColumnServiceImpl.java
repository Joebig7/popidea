package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.SpecialColumnBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.model.SpecialColumnBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.SpecialColumnService;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.mamba.popidea.constant.ServiceTypeEnum.ColumnStatus;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/16 17:35
 */
@Service
public class SpecialColumnServiceImpl implements SpecialColumnService {

    @Autowired
    private SpecialColumnBeanMapper specialColumnBeanMapper;

    /**
     * 创建专栏
     *
     * @param columnBean
     */
    @Override
    public void createOrUpdate(SpecialColumnBean columnBean) {
        if (Objects.isNull(columnBean.getId())) {
            columnBean.setStatus(ColumnStatus.NORMAL.status);
            specialColumnBeanMapper.insertSelective(columnBean);
        } else {
            columnBean.setUpdateTime(new Date());
            specialColumnBeanMapper.updateByPrimaryKeySelective(columnBean);
        }
    }

    /**
     * 删除专栏
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        SpecialColumnBean specialColumnBean = specialColumnBeanMapper.selectByPrimaryKey(id);
        CommonUtil.assertNull(specialColumnBean, ErrorCodes.COLUMN_EXIST_ERROR);
        specialColumnBean.setStatus(ColumnStatus.DELETE.status);
        specialColumnBeanMapper.updateByPrimaryKeySelective(specialColumnBean);
    }

    /**
     * 获取专栏列表
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<SpecialColumnBean> getColumnByUserId(Long userId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<SpecialColumnBean> specialColumnBeanList = specialColumnBeanMapper.findColumnListByUserId(userId);
        PageInfo<SpecialColumnBean> pageInfo = new PageInfo<>(specialColumnBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }
}