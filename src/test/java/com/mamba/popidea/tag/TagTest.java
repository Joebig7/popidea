package com.mamba.popidea.tag;

import com.mamba.popidea.constant.ServiceTypeEnum;
import com.mamba.popidea.model.TagBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.service.TagService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/17 11:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagTest {

    @Autowired
    private TagService tagService;

    @Test
    public void testCreate() {
        TagBean tagBean = new TagBean();
        tagBean.setStatus(ServiceTypeEnum.TagStatus.NEW.status);
        tagBean.setName("tag2");
        tagService.add(tagBean);
    }

    @Test
    public void testSearch() {

        RestData<TagBean> tag = tagService.search("tag", 1, 10);
        System.out.println(tag.getRsData() + "   " + tag.getRsCount());
    }

}