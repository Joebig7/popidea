package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.QuestionAnswerBeanMapper;
import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.AnswerVo;
import com.mamba.popidea.model.vo.ThumbVo;
import com.mamba.popidea.service.AnswerService;
import com.mamba.popidea.service.CommentService;
import com.mamba.popidea.service.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.mamba.popidea.constant.ServiceTypeEnum.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 17:18
 */

@Service
public class AnswerServiceImpl implements AnswerService {


    @Autowired
    private QuestionAnswerBeanMapper answerBeanMapper;

    @Autowired
    private ThumbService thumbService;

    @Autowired
    private CommentService commentService;

    /**
     * 发布回答
     *
     * @param questionAnswerBean
     */
    @Override
    public void releaseOrUpdateAnswer(QuestionAnswerBean questionAnswerBean) {

        if (questionAnswerBean.getId() != null) {
            questionAnswerBean.setUpdateTime(new Date());
            answerBeanMapper.updateByPrimaryKeySelective(questionAnswerBean);
        } else {
            questionAnswerBean.setStatus(AnswerStatus.NORMAL.getStatus());
            answerBeanMapper.insert(questionAnswerBean);
        }

    }

    /**
     * 查询回答列表
     *
     * @param questionId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<AnswerVo> findAnswerList(Long questionId, Integer pageNo, Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        List<AnswerVo> answerList = answerBeanMapper.getAnswerList(questionId);
        PageInfo<AnswerVo> pageInfo = new PageInfo<>(answerList);
        List<AnswerVo> result = pageInfo.getList();

        result.parallelStream().forEach(answerVo -> {
            //赞、踩信息
            ThumbVo thumbData = thumbService.getThumbData(answerVo.getId(), ThumbType.TO_ANSWER.getStatus());
            answerVo.setLikeCount(thumbData.getUpCount());
            answerVo.setDisLikeCount(thumbData.getDownCount());
            //评论数量
            long commentCount = commentService.getCommentCount(answerVo.getId(), CommentType.TO_ANSWER.getStatus());
            answerVo.setCommentCount(commentCount);
        });


        return new RestData<>(result, pageInfo.getTotal());
    }
}