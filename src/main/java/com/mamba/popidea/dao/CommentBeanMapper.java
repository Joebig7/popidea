package com.mamba.popidea.dao;

import com.mamba.popidea.model.CommentBean;

public interface CommentBeanMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(CommentBean record);

    int insertSelective(CommentBean record);

    CommentBean selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(CommentBean record);

    int updateByPrimaryKeyWithBLOBs(CommentBean record);

    int updateByPrimaryKey(CommentBean record);

    //-------------------custom-------------------

}