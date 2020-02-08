package com.mamba.popidea.controller;

import com.mamba.popidea.model.FavColumnBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.FavColumnService;
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
 * @date: 2020/2/6 13:24
 */
@Api(value = "收藏夹相关api", tags = "收藏夹相关api")
@RestController
@RequestMapping("/fav/column")
public class FavColumnController {

    @Autowired
    private FavColumnService favColumnService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "创建收藏夹", notes = "创建收藏夹")
    @PostMapping("/addOrUpdate")
    public RestResp addOrUpdate(@ApiParam("收藏夹参数") @Valid @RequestBody FavColumnBean favColumnBean) {
        favColumnService.addOrUpdate(favColumnBean);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "查询收藏夹列表", notes = "查询收藏夹列表")
    @GetMapping("/list")
    public RestResp getColumnList(@ApiParam("收藏夹参数") @RequestParam("userId") Long userId,
                                  @ApiParam("当前页数") @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                  @ApiParam("每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<FavColumnBean> columnList = favColumnService.getColumnList(userId, pageNo, pageSize);
        return new RestResp(columnList);
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "删除收藏夹", notes = "删除收藏夹")
    @DeleteMapping("/delete")
    public RestResp delete(@ApiParam("收藏夹参数") @RequestParam("columnId") Long columnId) {
        favColumnService.delete(columnId);
        return new RestResp();
    }


}