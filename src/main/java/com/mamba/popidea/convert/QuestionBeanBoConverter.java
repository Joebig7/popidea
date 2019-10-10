package com.mamba.popidea.convert;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.bo.QuestionBeanBo;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/10 14:58
 * @description
 */
@Component
public class QuestionBeanBoConverter implements Converter<QuestionBeanBo, QuestionBean> {

    @Nullable
    @Override
    public QuestionBean convert(QuestionBeanBo source) {
        QuestionBean questionBean = new QuestionBean();
        BeanUtils.copyProperties(source, questionBean);
        return questionBean;
    }
}