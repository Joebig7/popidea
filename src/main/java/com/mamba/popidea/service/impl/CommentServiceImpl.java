package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.CommentBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.CommentVo;
import com.mamba.popidea.service.CommentService;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mamba.popidea.constant.ServiceTypeEnum.CommentStatus.DISABLED;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 15:35
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentBeanMapper commentBeanMapper;

    /**
     * 发布评论
     */
    @Override
    public void releaseComment(CommentBean commentBean) {
        commentBeanMapper.insertSelective(commentBean);
    }

    /**
     * 删除评论
     *
     * @param commentId
     */
    @Override
    public void deleteComment(Long commentId) {
        CommentBean commentBean = commentBeanMapper.selectByPrimaryKey(commentId);
        CommonUtil.assertNull(commentBean, ErrorCodes.QUESTION_EXIST_ERROR);
        commentBean.setStatus(DISABLED.getStatus());
        commentBeanMapper.updateByPrimaryKeySelective(commentBean);
    }

    /**
     * 获取评论列表
     *
     * @param commentTargetId 评论目标id
     * @param commentType     评论类型 0-对问题的评论 1-对文章的评论
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<CommentVo> findCommentList(Long commentTargetId, Integer commentType, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<CommentVo> commentBeanList = commentBeanMapper.selectCommentByTargetIdAndType(commentTargetId, commentType);
        long count = commentBeanList.stream().filter(commentVo -> commentVo.getReplyCommentId() == 0).count();
        PageInfo<CommentVo> pageInfo = new PageInfo<>(commentBeanList);
        List<CommentVo> result = CommonUtil.getCommentTreeStructure(pageInfo.getList());
        return new RestData<>(result, count);
    }
}