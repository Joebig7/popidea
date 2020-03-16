package com.mamba.popidea.service;

import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.AnswerVO;
import com.mamba.popidea.model.vo.OwnAnswerVO;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 17:18
 */
public interface AnswerService {

    void releaseOrUpdateAnswer(QuestionAnswerBean questionAnswerBean);

    RestData<AnswerVO> findAnswerList(Long questionId, Integer pageNo, Integer pageSize);

    Long getAnswerCount(Long questionId);

    RestData<OwnAnswerVO> getAnswerListByUserId(Long userId, Integer pageNo, Integer pageSize);
}