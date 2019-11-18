package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.UserAttentionBeanMapper;
import com.mamba.popidea.model.UserAttentionBean;
import com.mamba.popidea.service.AttentionService;
import com.mamba.popidea.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static com.mamba.popidea.constant.ServiceTypeEnum.*;

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

}