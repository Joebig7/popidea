package com.mamba.popidea.question;

import com.google.common.collect.Lists;
import com.mamba.popidea.dao.TopicQuestionMapBeanMapper;
import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.TopicBean;
import com.mamba.popidea.model.TopicQuestionMapBean;
import com.mamba.popidea.model.bo.QuestionBeanBo;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.QuestionVo;
import com.mamba.popidea.service.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.listener.Topic;
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
        //test insert
        QuestionBeanBo questionBean = new QuestionBeanBo();
        questionBean.setUserId(10001L);
        questionBean.setQuestionTitle("测试一下问题发布");
        questionBean.setQuestionContent("这是内容。。。");
        questionBean.setStatus(1);

        List<Long> topics = Lists.newArrayList();
        topics.add(1L);
        topics.add(2L);
        questionBean.setTopics(topics);
        questionService.releaseOrUpdateQuestion(questionBean);
        //test update
//        QuestionBeanBo questionBean = new QuestionBeanBo();
//        questionBean.setId(20L);
//        questionBean.setUserId(10001L);
//        questionBean.setQuestionTitle("测试一下问题发布-update");
//        questionBean.setQuestionContent("这是内容。。。(update)");
//        questionBean.setStatus(1);
//        questionService.releaseOrUpdateQuestion(questionBean);
    }

    @Test
    public void testDelete() {

        questionService.deleteQuestion(20L);

    }


    @Test
    public void testGetQuestionInfo() {
        QuestionVo questionInfo   = questionService.getQuestionInfo(20L);
        System.out.println(questionInfo);
    }

    @Test
    public void testFindQuestionByKeyWord() {
        RestData<QuestionBean> listByKeyWord = questionService.getQuestionListByKeyWord("测试", 1, 20);
        System.out.println(listByKeyWord);
    }
}