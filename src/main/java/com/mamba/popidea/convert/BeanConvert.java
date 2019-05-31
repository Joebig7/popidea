package com.mamba.popidea.convert;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.bo.QuestionBeanBo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/31 17:04
 */
@Component
public class BeanConvert extends Convert<QuestionBeanBo, QuestionBean> {

    @Override
    public QuestionBean convert(QuestionBeanBo questionBeanBo) {
        QuestionBean questionBean = new QuestionBean();
        BeanUtils.copyProperties(questionBeanBo, questionBean);
        return questionBean;
    }
}