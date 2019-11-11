package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.ThumbBeanMapper;
import com.mamba.popidea.model.ThumbBean;
import com.mamba.popidea.service.ThumbService;
import com.mamba.popidea.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/11 18:02
 * @description 点赞/踩业务
 */
@Service
public class ThumbServiceImpl implements ThumbService {

    private static final String THUMB_TO_ANSWER = "thumb_to_answer";
    private static final String THUMB_TO_ARTICLE = "thumb_to_article";
    private static final String THUMB_TO_COMMENT = "thumb_to_comment";


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
            thumbBean = new ThumbBean();
            thumbBean.setStatus(status);
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
     * 进行赞/踩 计数
     *
     * @param targetId
     * @param type
     * @param status
     */
    private void countThumb(Long targetId, Integer type, Integer status) {


    }
}