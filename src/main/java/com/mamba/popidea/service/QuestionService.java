package com.mamba.popidea.service;

import com.mamba.popidea.model.QuestionBean;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/23 18:36
 */
public interface QuestionService {

    void releaseOrUpdateQuestion(QuestionBean questionBean);

    void deleteQuestion(Long id);

    QuestionBean getQuestionInfo(Long id);
}