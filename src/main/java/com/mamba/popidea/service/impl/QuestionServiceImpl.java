package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mamba.popidea.dao.QuestionBeanMapper;
import com.mamba.popidea.dao.TopicBeanMapper;
import com.mamba.popidea.dao.TopicQuestionMapBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.ServiceException;
import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.TopicQuestionMapBean;
import com.mamba.popidea.model.bo.QuestionBeanBo;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.QuestionVo;
import com.mamba.popidea.service.QuestionService;
import com.mamba.popidea.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TopicBeanMapper topicBeanMapper;

    /**
     * 发布或者修改问题
     *
     * @param questionBeanBo
     */
    @Transactional
    @Override
    public void releaseOrUpdateQuestion(QuestionBeanBo questionBeanBo) {
        QuestionBean questionBean = new QuestionBean();
        convert(questionBeanBo, questionBean);
        if (Objects.nonNull(questionBean.getId())) {
            questionBean.setQuestionContent(questionBean.getQuestionContent());
            questionBeanMapper.updateByPrimaryKeySelective(questionBean);
        } else {
            List<Long> topics = questionBeanBo.getTopics();
            questionBean.setStatus(Status.OK.code());
            questionBeanMapper.insertSelective(questionBean);
            //所属话题
            if (CollectionUtil.NotEmpty(topics)) {
                batchInsert(questionBean.getId(), topics);
            }
        }
    }

    private QuestionBean convert(QuestionBeanBo questionBeanBo, QuestionBean questionBean) {
        questionBean.setUserId(questionBeanBo.getUserId());
        questionBean.setStatus(questionBeanBo.getStatus());
        questionBean.setQuestionContent(questionBeanBo.getQuestionContent());
        questionBean.setQuestionTitle(questionBeanBo.getQuestionTitle());
        questionBean.setId(questionBeanBo.getId());
        return questionBean;
    }

    private void batchInsert(Long questionId, List<Long> topics) {
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

    /**
     * 获取问题详情信息
     *
     * @param id
     * @return
     */
    @Override
    public QuestionBean getQuestionInfo(Long id) {
        QuestionVo questionBeanVO = (QuestionVo) questionBeanMapper.selectByPrimaryKey(id);
        if (questionBeanVO == null) {
            throw ServiceException.newInstance(ErrorCodes.QUESTION_EXIST_ERROR);
        }
        questionBeanVO.setTopicBeans(topicBeanMapper.findTopicListWithQuesionId(id));

        //TODO 添加多少人关注这个问题
        //TODO 添加有多少人评论了该问题
        return questionBeanVO;
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
