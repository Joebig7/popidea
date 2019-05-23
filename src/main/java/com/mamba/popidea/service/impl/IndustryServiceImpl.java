package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.IndustryBeanMapper;
import com.mamba.popidea.model.IndustryBean;
import com.mamba.popidea.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/23 12:25
 */
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryBeanMapper industryBeanMapper;

    @Override
    public List<IndustryBean> getAllIndustryList() {
        return industryBeanMapper.findAllIndustryList();
    }
}