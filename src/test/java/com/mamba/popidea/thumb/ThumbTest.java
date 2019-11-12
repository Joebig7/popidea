package com.mamba.popidea.thumb;

import com.mamba.popidea.constant.ServiceTypeEnum;
import com.mamba.popidea.model.vo.ThumbVo;
import com.mamba.popidea.service.ThumbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/12 14:50
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThumbTest {

    @Autowired
    private ThumbService thumbService;


    @Test
    public void ThumbTest() {
        //赞
//      thumbService.thumb(10002L, 2L, ServiceTypeEnum.ThumbType.TO_ARTICLE.getStatus(), ServiceTypeEnum.ThumbStatus.UP.getStatus());

        //踩
//      thumbService.thumb(10003L,2L, ServiceTypeEnum.ThumbType.TO_ARTICLE.getStatus(),ServiceTypeEnum.ThumbStatus.DOWN.getStatus());

        //取消赞
//        thumbService.thumb(10002L, 2L, ServiceTypeEnum.ThumbType.TO_ARTICLE.getStatus(), ServiceTypeEnum.ThumbStatus.CANCLE_UP.getStatus());

        // 取消踩
        thumbService.thumb(10003L, 2L, ServiceTypeEnum.ThumbType.TO_ARTICLE.getStatus(), ServiceTypeEnum.ThumbStatus.CANCLE_DOWN.getStatus());
    }

    @Test
    public void getThumbDataTest() {
        ThumbVo thumbData = thumbService.getThumbData(2L, 1);
        System.out.println(thumbData.toString());
    }


}