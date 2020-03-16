package com.mamba.popidea.controller;

import com.mamba.popidea.model.CommentBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.model.vo.CommentVO;
import com.mamba.popidea.service.CommentService;
import com.mamba.popidea.utils.CommonUtil;
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
 * @date: 2019/5/27 16:20
 */
@Api(value = "评论相关Api", tags = "评论")
@RestController
@RequestMapping("/common/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "发布评论", notes = "发布评论")
    @PostMapping("/release")
    public RestResp releaseComment(@Valid @RequestBody CommentBean commentBean) {

        commentBean.setUserId(CommonUtil.getUserId());
        commentService.releaseComment(commentBean);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "删除评论", notes = "删除评论")
    @PostMapping("/delete")
    public RestResp deleteComment(@RequestParam("commentId") Long commentId) {
        commentService.deleteComment(commentId);
        return new RestResp();
    }


    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "查询评论列表", notes = "查询评论列表")
    @GetMapping("/list")
    public RestResp findComment(@ApiParam("回答或者文章的id") @RequestParam("Id") Long id,
                                @ApiParam("指定评论的对象类型") @RequestParam(value = "type", defaultValue = "") Integer type,
                                @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<CommentVO> result = commentService.findCommentList(id, type, pageNo, pageSize);
        return new RestResp(result);
    }

}