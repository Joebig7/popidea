package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.CommentBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.CommentVO;
import com.mamba.popidea.model.vo.ThumbVo;
import com.mamba.popidea.service.CommentService;
import com.mamba.popidea.service.ThumbService;
import com.mamba.popidea.utils.CommonUtil;
import com.mamba.popidea.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mamba.popidea.constant.ServiceTypeEnum.*;
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

    @Autowired
    private ThumbService thumbService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 发布评论
     */
    @Transactional
    @Override
    public void releaseComment(CommentBean commentBean) {
        commentBeanMapper.insertSelective(commentBean);
        countComment(commentBean.getCommentTargetId(), commentBean.getType(), CommentStatus.NORMAL.getStatus());
    }

    /**
     * 删除评论
     *
     * @param commentId
     */
    @Transactional
    @Override
    public void deleteComment(Long commentId) {
        CommentBean commentBean = commentBeanMapper.selectByPrimaryKey(commentId);
        CommonUtil.assertNull(commentBean, ErrorCodes.QUESTION_EXIST_ERROR);
        commentBean.setStatus(DISABLED.getStatus());
        commentBeanMapper.updateByPrimaryKeySelective(commentBean);

        countComment(commentBean.getCommentTargetId(), commentBean.getType(), CommentStatus.NORMAL.getStatus());
    }

    /**
     * 计数
     *
     * @param targetId
     * @param type
     */
    private void countComment(Long targetId, Integer type, Integer status) {
        String key = CommentType.getKey(type);
        if (status.equals(CommentStatus.NORMAL)) {
            redisUtil.incrementForHash(key, targetId);
        } else if (status.equals(CommentStatus.DISABLED)) {
            redisUtil.decrementForHash(key, targetId);
        }
    }

    @Override
    public long getCommentCount(Long targetId, Integer type) {
        String key = CommentType.getKey(type);
        return redisUtil.getCountForHash(key, targetId);
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
    public RestData<CommentVO> findCommentList(Long commentTargetId, Integer commentType, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<CommentVO> commentBeanList = commentBeanMapper.selectCommentByTargetIdAndType(commentTargetId, commentType);
        long count = commentBeanList.stream().filter(commentVo -> commentVo.getReplyCommentId() == 0).count();
        PageInfo<CommentVO> pageInfo = new PageInfo<>(commentBeanList);
        List<CommentVO> list = pageInfo.getList();
        list.parallelStream().forEach(commentVo -> {
            ThumbVo thumbData = thumbService.getThumbData(commentVo.getCommentId(), ThumbType.TO_COMMENT.getStatus());
            commentVo.setLikeCount(thumbData.getUpCount());
            commentVo.setDisLikeCount(thumbData.getDownCount());
        });

        List<CommentVO> result = CommonUtil.getCommentTreeStructure(list);
        return new RestData<>(result, count);
    }
}