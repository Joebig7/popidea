package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.CommentBeanMapper;
import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.service.CommentService;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 15:35
 */

@Service
public class CommentServiceImpl implements CommentService {

    private CommentBeanMapper commentBeanMapper;

    /**
     * 发布评论
     */
    @Override
    public void releaseComment(CommentBean commentBean) {
        commentBean.setUserId(CommonUtil.getUserId());
        commentBeanMapper.insertSelective(commentBean);
    }
}