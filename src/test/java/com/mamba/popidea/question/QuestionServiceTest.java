package com.mamba.popidea.question;

import com.google.common.collect.Lists;
import com.mamba.popidea.dao.TopicQuestionMapBeanMapper;
import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.TopicQuestionMapBean;
import com.mamba.popidea.model.bo.QuestionBeanBo;
import com.mamba.popidea.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private TopicQuestionMapBeanMapper topicQuestionMapBeanMapper;

    @Test
    public void releaseQuestion() {
        QuestionBeanBo questionBean = new QuestionBeanBo();
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


    @Test
    public void test() {
        List<TopicQuestionMapBean> list = Lists.newArrayList();

        TopicQuestionMapBean topicQuestionMapBean = new TopicQuestionMapBean();
        topicQuestionMapBean.setQuestionId(12L);
        topicQuestionMapBean.setTopicId(13L);
        list.add(topicQuestionMapBean);
        topicQuestionMapBeanMapper.batchInsert(list);
    }
}