package com.mamba.popidea.dao;

import com.mamba.popidea.model.CommentBean;
import org.springframework.stereotype.Repository;


public interface CommentBeanMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(CommentBean record);

    int insertSelective(CommentBean record);

    CommentBean selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(CommentBean record);

    int updateByPrimaryKeyWithBLOBs(CommentBean record);

    int updateByPrimaryKey(CommentBean record);
}