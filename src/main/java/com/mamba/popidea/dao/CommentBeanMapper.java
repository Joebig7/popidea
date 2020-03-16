package com.mamba.popidea.dao;

import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

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

    List<CommentVO> selectCommentByTargetIdAndType(@Param("commentTargetId") Long commentTargetId, @Param("commentType") Integer commentType);

}