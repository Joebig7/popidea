package com.mamba.popidea.dao;

import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.vo.CommentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CommentBeanMapper {
    int deleteByPrimaryKey(Long commentId);

    int insert(CommentBean record);

    int insertSelective(CommentBean record);

    CommentBean selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(CommentBean record);

    int updateByPrimaryKeyWithBLOBs(CommentBean record);

    int updateByPrimaryKey(CommentBean record);

    //-------------------custom-------------------

    List<CommentVo> selectCommentByTargetIdAndType(@Param("commentTargetId") Long commentTargetId, @Param("commentType") Integer commentType);

}