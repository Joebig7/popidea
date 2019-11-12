package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.mamba.popidea.constant.ServiceTypeEnum;
import com.mamba.popidea.convert.ConverterUtil;
import com.mamba.popidea.dao.ArticleBeanMapper;
import com.mamba.popidea.dao.ArticleTagMapBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.model.ArticleBean;
import com.mamba.popidea.model.ArticleTagMapBean;
import com.mamba.popidea.model.bo.ArticleBeanBo;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.ArticleVo;
import com.mamba.popidea.model.vo.ThumbVo;
import com.mamba.popidea.service.ArticleService;
import com.mamba.popidea.service.CommentService;
import com.mamba.popidea.service.ThumbService;
import com.mamba.popidea.utils.CollectionUtil;
import com.mamba.popidea.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.mamba.popidea.constant.ServiceTypeEnum.ArticleStatus.DISABLE;
import static com.mamba.popidea.constant.ServiceTypeEnum.ArticleStatus.NORMAL;
import static com.mamba.popidea.constant.ServiceTypeEnum.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/16 17:12
 */
@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleBeanMapper articleBeanMapper;

    @Autowired
    private ArticleTagMapBeanMapper articleTagMapBeanMapper;

    @Autowired
    private ThumbService thumbService;

    @Autowired
    private CommentService commentService;

    /**
     * 发布或者修文章
     *
     * @param articleBeanBo
     */
    @Transactional
    @Override
    public void release(ArticleBeanBo articleBeanBo) {
        ArticleBean articleBean = ConverterUtil.convertBeanBo(new ArticleBean(), articleBeanBo);

        if (Objects.nonNull(articleBean.getId())) {
            articleBean.setUpdateTime(new Date());
            articleBeanMapper.updateByPrimaryKeySelective(articleBean);
        } else {
            List<Long> tags = articleBeanBo.getTags();
            articleBean.setStatus(NORMAL.getStatus());
            articleBeanMapper.insertSelective(articleBean);

            if (CollectionUtil.NotEmpty(tags)) {
                batchInsertTags(articleBean.getId(), tags);
            }
        }
    }

    /**
     * 删除文章
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        ArticleBean articleBean = articleBeanMapper.selectByPrimaryKey(id);
        CommonUtil.assertNull(articleBean, ErrorCodes.ARTICLE_EXIST_ERROR);
        articleBean.setStatus(DISABLE.status);
        articleBeanMapper.updateByPrimaryKeySelective(articleBean);
    }


    /**
     * 获取文章列表
     *
     * @param columnId 专栏id
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<ArticleBean> list(Long columnId, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);

        List<ArticleBean> articleList = articleBeanMapper.findArticleListByColumnId(columnId);

        PageInfo<ArticleBean> pageInfo = new PageInfo<>(articleList);

        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 获取文章详细信息
     *
     * @param id
     * @return
     */
    @Override
    public ArticleVo get(Long id) {
        ArticleVo articleVo = articleBeanMapper.getDetailInfo(id);
        CommonUtil.assertNull(articleVo, ErrorCodes.ARTICLE_EXIST_ERROR);
        //赞/踩的数量
        ThumbVo thumbData = thumbService.getThumbData(articleVo.getId(), ThumbType.TO_ANSWER.getStatus());
        articleVo.setLikeCount(thumbData.getUpCount());
        articleVo.setDisLikeCount(thumbData.getDownCount());
        //设置评论数
        long commentCount = commentService.getCommentCount(articleVo.getId(), CommentType.TO_ARTICLE.getStatus());
        articleVo.setCommentCount(commentCount);
        return articleVo;
    }


    /**
     * 关键词搜索
     *
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<ArticleBean> search(String keyword, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<ArticleBean> articleBeanList = articleBeanMapper.search(keyword);
        PageInfo<ArticleBean> pageInfo = new PageInfo<>(articleBeanList);
        return new RestData<>(pageInfo.getList(), pageInfo.getTotal());
    }

    private void batchInsertTags(Long articleId, List<Long> tags) {
        List<ArticleTagMapBean> articleTagMapBeanList = Lists.newArrayList();
        tags.forEach(id -> {
            ArticleTagMapBean articleTagMapBean = new ArticleTagMapBean();
            articleTagMapBean.setArticleId(articleId);
            articleTagMapBean.setTagId(id);
            articleTagMapBeanList.add(articleTagMapBean);
        });
        articleTagMapBeanMapper.batchInsert(articleTagMapBeanList);
    }


}