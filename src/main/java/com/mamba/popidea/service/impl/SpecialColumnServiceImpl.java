package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.SpecialColumnBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.ServiceException;
import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.SpecialColumnBean;
import com.mamba.popidea.service.SpecialColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.mamba.popidea.conf.constant.ServiceTypeEnum.ColumnStatus;

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
        assertNull(specialColumnBean);
        specialColumnBean.setStatus(ColumnStatus.DELETE.status);
        specialColumnBeanMapper.updateByPrimaryKeySelective(specialColumnBean);
    }


    /**
     * 判断question是否存在，如果不存在抛出异常
     *
     * @param columnBean
     */
    private void assertNull(SpecialColumnBean columnBean) {
        if (Objects.isNull(columnBean)) {
            throw new ServiceException(ErrorCodes.COLUMN_EXIST_ERROR);
        }
    }
}