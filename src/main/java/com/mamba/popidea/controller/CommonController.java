package com.mamba.popidea.controller;

import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.model.vo.CommentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 16:20
 */
@Api(value = "评论相关Api", tags = "评论")
@RestController
@RequestMapping("/common")
public class CommonController {
    @ApiOperation(value = "查询评论列表", notes = "查询评论列表")
    @GetMapping("/search")
    public RestResp search(@ApiParam("回答或者文章的id") @RequestParam("Id") Long id,
                                @ApiParam("指定评论的对象类型") @RequestParam(value = "type", defaultValue = "") Integer type,
                                @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        return new RestResp( );
    }

}