package com.mamba.popidea.service.impl;

import com.mamba.popidea.dao.QuestionAnswerBeanMapper;
import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.AnswerService;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mamba.popidea.conf.constant.ServiceTypeEnum.AnswerStatus;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 17:18
 */

@Service
public class AnswerServiceImpl implements AnswerService {


    @Autowired
    private QuestionAnswerBeanMapper answerBeanMapper;

    /**
     * 发布回答
     *
     * @param questionAnswerBean
     */
    @Override
    public void releaseAnswer(QuestionAnswerBean questionAnswerBean) {
        questionAnswerBean.setUserId(CommonUtil.getUserId());
        questionAnswerBean.setStatus(AnswerStatus.NORMAL.getStatus());
        answerBeanMapper.insert(questionAnswerBean);
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
    public RestData<QuestionAnswerBean> findAnswerList(Long questionId, Integer pageNo, Integer pageSize) {
        return null;
    }
}