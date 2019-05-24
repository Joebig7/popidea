package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mamba.popidea.dao.QuestionBeanMapper;
import com.mamba.popidea.dao.TopicQuestionMapBeanMapper;
import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.TopicQuestionMapBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.QuestionService;
import com.mamba.popidea.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
     * @param questionBean
     */
    @Override
    public void releaseOrUpdateQuestion(QuestionBean questionBean, List<Long> topics) {
        if (Objects.nonNull(questionBean.getId())) {
            questionBean.setUpdateTime(new Date());
            questionBean.setQuestionContent(questionBean.getQuestionContent());
            questionBeanMapper.updateByPrimaryKeySelective(questionBean);
        } else {
            //所属话题
            if (CollectionUtil.NotEmpty(topics)) {
                batchInsert(questionBean.getId(), topics);
            }
            questionBean.setStatus(Status.OK.code());
            questionBeanMapper.insert(questionBean);
        }
    }


    private void batchInsert(Long questionId, List<Long> topics) {
        List<TopicQuestionMapBean> topicQuestionMapBeanList = Lists.newArrayList();
        topics.forEach(id -> {
            TopicQuestionMapBean topicQuestionMapBean = new TopicQuestionMapBean();
            topicQuestionMapBean.setId(questionId);
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
        questionBean.setStatus(Status.DELETE.code());
        questionBeanMapper.updateByPrimaryKeySelective(questionBean);
    }

    /**
     * 模糊搜索
     *
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    public RestData<QuestionBean> findQuestionByKeyWord(String keyword, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<QuestionBean> pageInfo = new PageInfo<>(questionBeanMapper.findByKeyWord(keyword));
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());

    }


    @Override
    public QuestionBean getQuestionInfo(Long id) {
        return questionBeanMapper.getQuestionInfo(id);
    }

    enum Status {
        FALSE(0),
        OK(1),
        DELETE(2);

        Status(Integer status) {
            this.status = status;
        }

        private Integer status;

        Integer code() {
            return status;
        }
    }
}
