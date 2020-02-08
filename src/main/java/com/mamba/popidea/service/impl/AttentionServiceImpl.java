package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.UserAttentionBeanMapper;
import com.mamba.popidea.model.UserAttentionBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.AttentionQuestionVO;
import com.mamba.popidea.model.vo.AttentionColumnVO;
import com.mamba.popidea.model.vo.AttentionPersonVO;
import com.mamba.popidea.service.AnswerService;
import com.mamba.popidea.service.AttentionService;
import com.mamba.popidea.service.QuestionService;
import com.mamba.popidea.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mamba.popidea.constant.ServiceTypeEnum.AttentionStatus;
import static com.mamba.popidea.constant.ServiceTypeEnum.AttentionType;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/15 18:07
 * @description 关注功能相关逻辑
 */
@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private UserAttentionBeanMapper userAttentionBeanMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AnswerService answerService;

    /**
     * 关注/取消关注
     *
     * @param userAttentionBean
     */
    @Transactional
    @Override
    public void toggle(UserAttentionBean userAttentionBean) {
        Long userAttentionId = userAttentionBean.getUserAttentionId();
        if (userAttentionId == null) {
            userAttentionBeanMapper.insertSelective(userAttentionBean);
        } else {
            userAttentionBeanMapper.updateByPrimaryKeySelective(userAttentionBean);
        }

        countAttention(userAttentionBean.getUserAttentionId(), userAttentionBean.getType(), userAttentionBean.getStatus());
    }

    private void countAttention(Long targetId, Integer type, Integer status) {
        String key = AttentionType.getKey(type);
        if (status.equals(AttentionStatus.FOLLOWER.getStatus())) {
            redisUtil.incrementForHash(key, targetId);
        } else if (status.equals(AttentionStatus.CANCLE_FOLLOW.getStatus())) {
            redisUtil.decrementForHash(key, targetId);
        }
    }


    /**
     * 查询用户关注的人
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<AttentionPersonVO> getAttentionPersonList(Long userId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<AttentionPersonVO> attentionPersonList = userAttentionBeanMapper.findAttentionPersonList(userId);
        PageInfo<AttentionPersonVO> pageInfo = new PageInfo<>(attentionPersonList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 查询用户关注的问题
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<AttentionQuestionVO> getAttentionQuestionList(Long userId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<AttentionQuestionVO> attentionQuestionList = userAttentionBeanMapper.findAttentionQuestionList(userId);
        PageInfo<AttentionQuestionVO> pageInfo = new PageInfo<>(attentionQuestionList);
        //完善问题的关注数量和回答数量
        List<AttentionQuestionVO> result = pageInfo.getList();
        if (!result.isEmpty()) {
            result.parallelStream().forEach(attentionQuestionVO -> {
                Long answerId = attentionQuestionVO.getId();
                Long userAttentionId = attentionQuestionVO.getUserAttentionId();
                //获取回答总数
                Long answerCount = answerService.getAnswerCount(answerId);
                //获取关注总数
                Long attentionCount = redisUtil.getCountForHash(AttentionType.ATTENTION_TO_ANSWER.getKey(), userAttentionId);
                attentionQuestionVO.setAnswerCount(answerCount);
                attentionQuestionVO.setAttentionCount(attentionCount);
            });
        }
        return new RestData<>(result, pageInfo.getTotal());
    }

    /**
     * 查询用户关注的专栏
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<AttentionColumnVO> getAttentionColumnList(Long userId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<AttentionColumnVO> attentionColumnVOList = userAttentionBeanMapper.findAttentionColumnList(userId);
        PageInfo<AttentionColumnVO> pageInfo = new PageInfo<>(attentionColumnVOList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }
}