package com.mamba.popidea.question;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/24 14:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {


    @Autowired
    private QuestionService questionService;


    @Test
    public void releaseQuestion() {
        QuestionBean questionBean = new QuestionBean();
        questionBean.setUserId(10001L);
        questionBean.setQuestionTitle("测试一下问题发布");
        questionBean.setQuestionContent("这是内容。。。");
        questionBean.setStatus(1);
        questionService.releaseOrUpdateQuestion(questionBean);

    }

    @Test
    public void delete() {

        questionService.deleteQuestion(1L);

    }
}