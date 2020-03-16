package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mamba.popidea.convert.ConverterUtil;
import com.mamba.popidea.dao.QuestionBeanMapper;
import com.mamba.popidea.dao.TopicQuestionMapBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.ServiceException;
import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.TopicQuestionMapBean;
import com.mamba.popidea.model.bo.QuestionBeanBo;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.QuestionVO;
import com.mamba.popidea.service.QuestionService;
import com.mamba.popidea.utils.CollectionUtil;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.mamba.popidea.constant.ServiceTypeEnum.QuestionStatus;

/**
 * 问题 业务层
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionBeanMapper questionBeanMapper;

    @Autowired
    private TopicQuestionMapBeanMapper topicQuestionMapBeanMapper;

    /**
     * 发布或者修改问题
     *
     * @param questionBeanBo
     */
    @Transactional
    @Override
    public void releaseOrUpdateQuestion(QuestionBeanBo questionBeanBo) {
        QuestionBean questionBean = ConverterUtil.convertBeanBo(new QuestionBean(), questionBeanBo);

        if (Objects.nonNull(questionBean.getId())) {
            questionBean.setUpdateTime(new Date());
            questionBeanMapper.updateByPrimaryKeySelective(questionBean);
        } else {
            List<Long> topics = questionBeanBo.getTopics();
            questionBean.setStatus(QuestionStatus.NORMAL.getStatus());
            questionBeanMapper.insertSelective(questionBean);

            if (CollectionUtil.NotEmpty(topics)) {
                batchInsertTopics(questionBean.getId(), topics);
            }
        }
    }

    private void batchInsertTopics(Long questionId, List<Long> topics) {
        List<TopicQuestionMapBean> topicQuestionMapBeanList = Lists.newArrayList();
        topics.forEach(id -> {
            TopicQuestionMapBean topicQuestionMapBean = new TopicQuestionMapBean();
            topicQuestionMapBean.setQuestionId(questionId);
            topicQuestionMapBean.setTopicId(id);
            topicQuestionMapBeanList.add(topicQuestionMapBean);
        });
        topicQuestionMapBeanMapper.batchInsert(topicQuestionMapBeanList);
    }


    /**
     * 删除问题 逻辑删除
     *
     * @param id
     */
    @Override
    public void deleteQuestion(Long id) {
        QuestionBean questionBean = questionBeanMapper.selectByPrimaryKey(id);
        CommonUtil.assertNull(questionBean, ErrorCodes.QUESTION_EXIST_ERROR);
        questionBean.setStatus(QuestionStatus.DELETE.getStatus());
        questionBeanMapper.updateByPrimaryKeySelective(questionBean);
    }


    /**
     * 获取问题详情信息
     *
     * @param id
     * @return
     */
    @Override
    public QuestionVO getQuestionInfo(Long id) {
        QuestionVO questionDetailInfo = questionBeanMapper.getQuestionDetailInfo(id);
        CommonUtil.assertNull(questionDetailInfo, ErrorCodes.QUESTION_EXIST_ERROR);

        questionDetailInfo.setFocusCount(getQuestionFocusCount(id));
        questionDetailInfo.setAnswerCount(getQuestionAnswerCount(id));
        return questionDetailInfo;
    }

    private Long getQuestionFocusCount(Long questionId) {
        //TODO 多少人关注这个问题

        return null;
    }


    private Long getQuestionAnswerCount(Long questionId) {
        //TODO 多少人回答了该问题
        return null;
    }


    /**
     * 模糊搜索
     *
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    public RestData<QuestionBean> getQuestionListByKeyWord(String keyword, Integer pageNo, Integer pageSize) {
        if (StringUtils.isEmpty(keyword)) {
            throw ServiceException.newInstance(ErrorCodes.KEYWORD_EXIST_ERROR);
        }
        PageHelper.startPage(pageNo, pageSize);
        List<QuestionBean> questionBeanList = questionBeanMapper.findByKeyWord(keyword);
        PageInfo<QuestionBean> pageInfo = new PageInfo<>(questionBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 根据userId查询用户问题列表
     *
     * @param userId
     * @return
     */
    @Override
    public RestData<QuestionBean> getQuestionListByUserId(Long userId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<QuestionBean> questionBeanList = questionBeanMapper.findListByUserId(userId);
        PageInfo<QuestionBean> pageInfo = new PageInfo<>(questionBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }


    /**
     * 根据关键字查询问题
     *
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData getQuestionSearch(String keyword, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<QuestionBean> questionBeanList = questionBeanMapper.findQuestionByKeyword(keyword);
        PageInfo<QuestionBean> pageInfo = new PageInfo<>(questionBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 推荐问题
     *
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<QuestionBean> recommend(Long userId, Integer pageNo, Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        List<QuestionBean> questionBeanList = questionBeanMapper.findByRecommend(userId);
        PageInfo<QuestionBean> pageInfo = new PageInfo<>(questionBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());


    }
}
