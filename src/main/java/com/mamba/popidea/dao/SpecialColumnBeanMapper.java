package com.mamba.popidea.dao;

import com.mamba.popidea.model.SpecialColumnBean;

import java.util.List;

public interface SpecialColumnBeanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecialColumnBean record);

    int insertSelective(SpecialColumnBean record);

    SpecialColumnBean selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecialColumnBean record);

    int updateByPrimaryKeyWithBLOBs(SpecialColumnBean record);

    int updateByPrimaryKey(SpecialColumnBean record);

    List<SpecialColumnBean> findColumnListByUserId(Long userId);
}