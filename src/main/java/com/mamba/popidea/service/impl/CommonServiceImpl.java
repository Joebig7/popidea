package com.mamba.popidea.service.impl;

import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.*;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.mamba.popidea.constant.ServiceTypeEnum.SearchType;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2020/3/16 14:56
 * @description
 */
@Service
public class CommonServiceImpl implements CommonService {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @Autowired
    private SpecialColumnService specialColumnService;

    /**
     * 获取全局搜索结果
     *
     * @param keyword
     * @param type
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData search(String keyword, Integer type, Integer pageNo, Integer pageSize) {
        SearchType key = SearchType.getKey(type);

        switch (key) {
            case TO_ANSWER:
                return questionService.getQuestionSearch(keyword, pageNo, pageSize);
            case TO_TOPIC:
                return topicService.getTopicSearch(keyword, pageNo, pageSize);
            case TO_USER:
                return userService.getUserSearch(keyword, pageNo, pageSize);
            case TO_COLUMN:
                return specialColumnService.getSpecialColumnSearch(keyword, pageNo, pageSize);
            default:
                return null;
        }
    }

    /**
     * 向用户推荐问题
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData recommend(Integer pageNo, Integer pageSize) {
        Long userId = CommonUtil.getUserId();
        return questionService.recommend(userId, pageNo, pageSize);
    }
}