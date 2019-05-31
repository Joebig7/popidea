package com.mamba.popidea.controller;

import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 16:20
 */
@Api(value = "评论相关Api",tags = "评论")
@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization",required = true)
    @ApiOperation(value = "发布评论", notes = "发布评论")
    @PostMapping("/release")
    public RestResp releaseComment(@Valid @RequestBody CommentBean commentBean) {
        commentService.releaseComment(commentBean);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization",required = true)
    @ApiOperation(value = "查询评论详情", notes = "查询评论详情")
    @GetMapping("/find")
    public RestResp findComment(@Valid @RequestBody CommentBean commentBean) {
        commentService.releaseComment(commentBean);
        return new RestResp();
    }

}