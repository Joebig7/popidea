package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.QuestionBeanMapper;
import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.service.QuestionService;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * 问题 业务层
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionBeanMapper questionBeanMapper;

    /**
     * 发布或者修改问题
     *
     * @param questionBean
     */
    @Override
    public void releaseOrUpdateQuestion(QuestionBean questionBean) {
        Long userId = CommonUtil.getUserId();
        if (Objects.nonNull(questionBean.getId())) {
            questionBean.setUpdateTime(new Date());
            questionBean.setQuestionContent(questionBean.getQuestionContent());
            questionBeanMapper.updateByPrimaryKeySelective(questionBean);
        } else {
            questionBean.setUserId(userId);
            questionBean.setStatus(Status.OK.code());
            questionBeanMapper.insert(questionBean);
        }
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
