package com.mamba.popidea.article;

import com.mamba.popidea.model.ArticleBean;
import com.mamba.popidea.model.TagBean;
import com.mamba.popidea.model.bo.ArticleBeanBo;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.ArticleVo;
import com.mamba.popidea.service.ArticleService;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/1 15:54
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void releaseArticle() {

        ArticleBeanBo articleBean = new ArticleBeanBo();
        articleBean.setUserId(10001L);
        articleBean.setTitle("article 1");
        articleBean.setContent("this is the article's content ...");
        articleBean.setColumnId(1L);
        List<Long> tags = Lists.newArrayList(1L, 2L, 3L);
        articleBean.setTags(tags);
        articleService.release(articleBean);

    }

    @Test
    public void updateArticle() {

        ArticleBeanBo articleBean = new ArticleBeanBo();
        articleBean.setId(2L);
        articleBean.setUserId(10001L);
        articleBean.setTitle("article 1 update");
        articleBean.setContent("this is the article's content ... update");
        articleBean.setColumnId(1L);
        List<Long> tags = Lists.newArrayList(1L, 2L, 3L);
        articleBean.setTags(tags);
        articleService.release(articleBean);

    }

    @Test
    public void deleteArticle() {
        articleService.delete(2L);
    }


    @Test
    public void getArticleList() {
        RestData<ArticleBean> list = articleService.list(1L, 1, 2);

        System.out.println(list.getRsData());
    }

    @Test
    public void getArticleInfo() {
        ArticleVo articleVo = articleService.get(2L);

        System.out.println(articleVo.getTitle());
    }

    @Test
    public void search() {
        RestData<ArticleBean> articleBeanRestData = articleService.search("tes", 1, 2);

        System.out.println(articleBeanRestData.getRsData().get(0).getTitle());
    }

}