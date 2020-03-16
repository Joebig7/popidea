package com.mamba.popidea.comment;

import com.mamba.popidea.constant.ServiceTypeEnum;
import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.CommentVO;
import com.mamba.popidea.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/11 17:04
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    /**
     * 发布
     */
    @Test
    public void release() {

        CommentBean commentBean = new CommentBean();
        commentBean.setUserId(10026L);
        commentBean.setCommentTargetId(1L);
        commentBean.setReplyCommentId(0L);
        commentBean.setType(ServiceTypeEnum.CommentType.TO_ANSWER.getStatus());
        commentBean.setContent("评论一下3");
        commentService.releaseComment(commentBean);


    }
    @Test
    public void delete() {
        commentService.deleteComment(1L);
    }


    @Test
    public void findCommentList() {
        RestData<CommentVO> commentList = commentService.findCommentList(1L, ServiceTypeEnum.CommentType.TO_ARTICLE.getStatus(), 1, 10);
        System.out.println(commentList.getRsData());
    }
}