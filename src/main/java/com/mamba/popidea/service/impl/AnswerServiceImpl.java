package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.QuestionAnswerBeanMapper;
import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.AnswerVO;
import com.mamba.popidea.model.vo.OwnAnswerVO;
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
    public RestData<AnswerVO> findAnswerList(Long questionId, Integer pageNo, Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        List<AnswerVO> answerList = answerBeanMapper.getAnswerList(questionId);
        PageInfo<AnswerVO> pageInfo = new PageInfo<>(answerList);
        List<AnswerVO> result = pageInfo.getList();

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

    /**
     * 获取问题的回答数量
     *
     * @param questionId
     * @return
     */
    @Override
    public Long getAnswerCount(Long questionId) {
        return answerBeanMapper.findAnswerCount(questionId);
    }

    /**
     * 根据用户id查询回答列表
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<OwnAnswerVO> getAnswerListByUserId(Long userId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<OwnAnswerVO> answerVoList = answerBeanMapper.findAnswerListByUserId(userId);
        PageInfo<OwnAnswerVO> pageInfo = new PageInfo<>(answerVoList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }
}