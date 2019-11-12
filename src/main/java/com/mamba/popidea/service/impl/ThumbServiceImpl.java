package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.ThumbBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.model.ThumbBean;
import com.mamba.popidea.service.ThumbService;
import com.mamba.popidea.utils.CommonUtil;
import com.mamba.popidea.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.mamba.popidea.constant.ServiceTypeEnum.ThumbStatus;
import static com.mamba.popidea.constant.ServiceTypeEnum.ThumbType;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/11 18:02
 * @description 点赞/踩业务
 */
@Service
public class ThumbServiceImpl implements ThumbService {

    @Autowired
    private ThumbBeanMapper thumbBeanMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 点赞/踩功能
     *
     * @param targetId 点赞的目标id
     * @param type     点赞类型  0-回答 1-文章 2-评论
     * @param status
     */
    @Transactional
    @Override
    public void thumb(Long userId, Long targetId, Integer type, Integer status) {
        // 添加点赞记录
        saveThumbRecord(userId, targetId, type, status);
        // 计数
        countThumb(targetId, type, status);
    }


    /**
     * 保存点赞记录
     *
     * @param targetId
     * @param type
     * @param status
     */
    private void saveThumbRecord(Long userId, Long targetId, Integer type, Integer status) {
        ThumbBean thumbBean = thumbBeanMapper.findThumbByTargetIdAndType(userId, targetId, type);
        if (Objects.isNull(thumbBean)) {
            handleThumbCondition(thumbBean, status);
            thumbBean = new ThumbBean();
            if (ThumbStatus.CANCLE_UP.getStatus().equals(status) || ThumbStatus.CANCLE_DOWN.getStatus().equals(status)) {
                thumbBean.setStatus(0);
            } else {
                thumbBean.setStatus(status);
            }

            thumbBean.setTargetId(targetId);
            thumbBean.setType(type);
            thumbBean.setUserId(userId);
            thumbBeanMapper.insertSelective(thumbBean);
        } else {
            thumbBean.setStatus(status);
            thumbBeanMapper.updateByPrimaryKeySelective(thumbBean);
        }
    }

    /**
     * 处理已经点赞或者踩的情况
     *
     * @param thumbBean
     * @param status
     */
    private void handleThumbCondition(ThumbBean thumbBean, Integer status) {
        Integer source = thumbBean.getStatus();
        if (status.equals(ThumbStatus.UP.getStatus()) || status.equals(ThumbStatus.DOWN.getStatus())) {
            CommonUtil.assertEqual(source, status, ErrorCodes.THUMB_EXIST_ERROR);
        } else if (status.equals(ThumbStatus.CANCLE_UP.getStatus()) || status.equals(ThumbStatus.CANCLE_DOWN.getStatus())) {
            CommonUtil.assertEqual(source, 0, ErrorCodes.THUMB_CANCLE_EXIST_ERROR);
        }


    }

    /**
     * 进行赞/踩 计数
     *
     * @param targetId 目标id
     * @param type     目标类型
     * @param status   状态
     */
    private void countThumb(Long targetId, Integer type, Integer status) {
        String key = ThumbType.getKey(type);
        StringBuilder stringBuilder = new StringBuilder(key);
        if (ThumbStatus.UP.equals(status)) {
            redisUtil.incrementForHash(stringBuilder.append("_UP").toString(), targetId);
        } else if (ThumbStatus.DOWN.equals(status)) {
            redisUtil.incrementForHash(stringBuilder.append("_DOWN").toString(), targetId);
        } else if (ThumbStatus.CANCLE_UP.equals(status)) {
            redisUtil.decrementForHash(stringBuilder.append("_UP").toString(), targetId);
        } else if (ThumbStatus.CANCLE_DOWN.equals(status)) {
            redisUtil.decrementForHash(stringBuilder.append("_DOWN").toString(), targetId);
        }
    }
}