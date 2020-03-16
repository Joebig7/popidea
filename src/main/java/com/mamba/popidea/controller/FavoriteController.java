package com.mamba.popidea.controller;

import com.mamba.popidea.model.UserFavoriteBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.model.vo.FavBeanVO;
import com.mamba.popidea.service.FavoriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/15 17:53
 */

@Api(value = "收藏相关api", tags = "收藏相关api")
@RestController
@RequestMapping("/common/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "收藏/取消收藏功能", notes = "收藏/取消收藏功能")
    @PostMapping("/toggle")
    public RestResp toggle(@ApiParam("收藏参数") @Valid @RequestBody UserFavoriteBean userFavoriteBean) {
        favoriteService.toggle(userFavoriteBean);
        return new RestResp();
    }

    @ApiOperation(value = "获取用户收藏夹下的内容", notes = "获取用户收藏夹下的内容")
    @GetMapping("/list")
    public RestResp list(@ApiParam("收藏参数") @RequestParam("columnId") Long columnId,
                         @ApiParam("用户id") @RequestParam("userId") Long userId,
                         @ApiParam("当前页数") @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                         @ApiParam("每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<FavBeanVO> favList = favoriteService.getFavList(columnId, userId, pageNo, pageSize);
        return new RestResp(favList);
    }

}