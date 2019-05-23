package com.mamba.popidea.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.IndustryBeanMapper;
import com.mamba.popidea.model.IndustryBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/23 12:25
 */
@Service
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryBeanMapper industryBeanMapper;

    @Override
    public RestData<IndustryBean> getAllIndustryList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<IndustryBean> allIndustryList = industryBeanMapper.findAllIndustryList();
        PageInfo<IndustryBean> pageInfo = new PageInfo<>(allIndustryList);
        System.out.println(pageInfo.getPageNum()+"===="+pageInfo.getPageSize());
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }
}