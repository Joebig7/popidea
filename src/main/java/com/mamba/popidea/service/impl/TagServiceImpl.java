package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.TagBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.model.TagBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.TagService;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mamba.popidea.constant.ServiceTypeEnum.TagStatus.NEW;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/17 10:38
 */

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagBeanMapper tagBeanMapper;

    /**
     * 添加新标签
     *
     * @param tagBean
     */
    @Override
    public void add(TagBean tagBean) {
        TagBean bean = findByName(tagBean.getName());
        CommonUtil.assertNull(bean, ErrorCodes.TAG_EXIST_ERROR);
        tagBean.setStatus(NEW.status);
        tagBeanMapper.insertSelective(tagBean);
    }

    /**
     * 根据标签名查询标签
     *
     * @param name
     * @return
     */
    @Override
    public TagBean findByName(String name) {
        return tagBeanMapper.findByName(name);
    }

    /**
     * 查询标签列表
     *
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<TagBean> search(String keyword, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<TagBean> tagBeanList = tagBeanMapper.search(keyword);
        PageInfo<TagBean> pageInfo = new PageInfo<>(tagBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }
}