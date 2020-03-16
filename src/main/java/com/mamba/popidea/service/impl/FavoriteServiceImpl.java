package com.mamba.popidea.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mamba.popidea.dao.UserFavoriteBeanMapper;
import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.vo.FavBeanVO;
import com.mamba.popidea.model.vo.ThumbVo;
import com.mamba.popidea.service.CommentService;
import com.mamba.popidea.service.FavoriteService;
import com.mamba.popidea.service.ThumbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.mamba.popidea.constant.ServiceTypeEnum.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/15 17:57
 * @description 收藏相关业务逻辑
 */
@Service
public class FavoriteServiceImpl implements FavoriteService {


    @Autowired
    private UserFavoriteBeanMapper userFavoriteBeanMapper;

    @Autowired
    private ThumbService thumbService;

    @Autowired
    private CommentService commentService;

    /**
     * 收藏功能
     *
     * @param userFavoriteBean
     */
    @Override
    public void toggle(UserFavoriteBean userFavoriteBean) {
        Long userFavoriteId = userFavoriteBean.getUserFavoriteId();
        if (Objects.isNull(userFavoriteId)) {
            userFavoriteBeanMapper.insertSelective(userFavoriteBean);
        } else {
            userFavoriteBeanMapper.updateByPrimaryKeySelective(userFavoriteBean);
        }
    }

    /**
     * 查询用户收藏列表
     *
     * @param columnId
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public RestData<FavBeanVO> getFavList(Long columnId, Long userId, Integer pageNo, Integer pageSize) {

        PageHelper.startPage(pageNo, pageSize);

        //查询收藏的回答和文章的相关信息
        List<FavBeanVO> result = userFavoriteBeanMapper.findFavList(columnId, userId);

        PageInfo<FavBeanVO> pageInfo = new PageInfo<>(result);

        //将回答或者文章的其他相关信息添加进去
        List<FavBeanVO> favBeanVoList = pageInfo.getList();
        if (!favBeanVoList.isEmpty()) {
            favBeanVoList.parallelStream().forEach(favBeanVo -> {
                if (FavType.FAV_ANSWER.getType().equals(favBeanVo.getType())) {
                    //赞、踩信息
                    ThumbVo thumbData = thumbService.getThumbData(favBeanVo.getAnswerId(), ThumbType.TO_ANSWER.getStatus());
                    favBeanVo.setLikeCount(thumbData.getUpCount());
                    favBeanVo.setDisLikeCount(thumbData.getDownCount());
                    //评论数量
                    long commentCount = commentService.getCommentCount(favBeanVo.getAnswerId(), CommentType.TO_ANSWER.getStatus());
                    favBeanVo.setCommentCount(commentCount);
                } else if (FavType.FAV_ARTICLE.getType().equals(favBeanVo.getType())) {
                    //赞、踩信息
                    ThumbVo thumbData = thumbService.getThumbData(favBeanVo.getArticleId(), ThumbType.TO_ARTICLE.getStatus());
                    favBeanVo.setLikeCount(thumbData.getUpCount());
                    favBeanVo.setDisLikeCount(thumbData.getDownCount());
                    //评论数量
                    long commentCount = commentService.getCommentCount(favBeanVo.getAnswerId(), CommentType.TO_ARTICLE.getStatus());
                    favBeanVo.setCommentCount(commentCount);
                }
            });
        }

        return new RestData<>(favBeanVoList, pageInfo.getTotal());
    }
}