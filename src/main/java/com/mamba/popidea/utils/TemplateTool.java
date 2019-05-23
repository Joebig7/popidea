package com.mamba.popidea.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Map;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/21 16:55
 */
@Component
public class TemplateTool {
    @Autowired
    private SpringTemplateEngine templateEngine;

    public String render(String template, Map<String, Object> params) {
        Context context = new Context(LocaleContextHolder.getLocale());
        context.setVariables(params);
        return templateEngine.process(template, context);
    }
}