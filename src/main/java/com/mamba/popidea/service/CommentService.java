package com.mamba.popidea.service;

import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.CommentVo;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 15:35
 */
public interface CommentService {
    void releaseComment(CommentBean commentBean);

    void deleteComment(Long commentId);

    RestData<CommentVo> findCommentList(Long commentTargetId, Integer commentType, Integer pageNo, Integer pageSize);

    long getCommentCount(Long targetId, Integer type);
}
