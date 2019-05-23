package com.mamba.popidea.dao;

import com.mamba.popidea.model.IndustryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IndustryBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(IndustryBean record);

    int insertSelective(IndustryBean record);

    IndustryBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(IndustryBean record);

    int updateByPrimaryKey(IndustryBean record);


    //==============custom=================
    List<IndustryBean> findAllIndustryList();
}