package com.mamba.popidea.answer;

import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.AnswerVo;
import com.mamba.popidea.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/11 17:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnswerServiceTest {

    @Autowired
    private AnswerService answerService;

    @Test
    public void testReleaseAnswer() {
        //add
        QuestionAnswerBean questionAnswerBean = new QuestionAnswerBean();
        questionAnswerBean.setQuestionId(20L);
        questionAnswerBean.setUserId(10001L);
        questionAnswerBean.setContent("这是回答的内容");

        answerService.releaseOrUpdateAnswer(questionAnswerBean);

        //update
        QuestionAnswerBean questionAnswerBean1 = new QuestionAnswerBean();
        questionAnswerBean1.setId(1L);
        questionAnswerBean1.setContent("这是更新的内容！");

        answerService.releaseOrUpdateAnswer(questionAnswerBean1);
    }

    @Test
    public void testGetAnswerList(){

        RestData<AnswerVo> answerList = answerService.findAnswerList(20L, 1, 10);
        System.out.println(answerList);
    }
}