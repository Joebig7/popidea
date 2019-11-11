package com.mamba.popidea.dao;

import com.mamba.popidea.model.ThumbBean;
import org.apache.ibatis.annotations.Param;

public interface ThumbBeanMapper {
    int deleteByPrimaryKey(Long thumbId);

    int insert(ThumbBean record);

    int insertSelective(ThumbBean record);

    ThumbBean selectByPrimaryKey(Long thumbId);

    int updateByPrimaryKeySelective(ThumbBean record);

    int updateByPrimaryKey(ThumbBean record);

    //=====================custom==========================

    ThumbBean findThumbByTargetIdAndType(@Param("userId") Long userId, @Param("targetId") Long targetId, @Param("type") Integer type);
}