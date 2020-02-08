package com.mamba.popidea.controller;

import com.mamba.popidea.model.UserAttentionBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.model.vo.AttentionQuestionVO;
import com.mamba.popidea.model.vo.AttentionColumnVO;
import com.mamba.popidea.model.vo.AttentionPersonVO;
import com.mamba.popidea.service.AttentionService;
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
 * @date: 2019/11/15 18:03
 */
@Api(value = "关注相关api", tags = "关注相关api")
@RestController
@RequestMapping("/common/attention")
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "关注/取消关注", notes = "关注/取消关注")
    @PostMapping("/toggle")
    public RestResp toggle(@ApiParam("关注相关参数") @Valid @RequestBody UserAttentionBean userAttentionBean) {
        attentionService.toggle(userAttentionBean);
        return new RestResp();
    }

    @ApiOperation(value = "查询用户关注的人接口", notes = "查询用户关注的人的接口")
    @GetMapping("/person")
    public RestResp person(@RequestParam("userId") Long userId,
                           @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<AttentionPersonVO> attentionPersonList = attentionService.getAttentionPersonList(userId, pageNo, pageSize);
        return new RestResp(attentionPersonList);
    }

    @ApiOperation(value = "查询用户关注的问题接口", notes = "查询用户关注的问题接口")
    @GetMapping("/question")
    public RestResp question(@RequestParam("userId") Long userId,
                           @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<AttentionQuestionVO> attentionQuestionList = attentionService.getAttentionQuestionList(userId, pageNo, pageSize);
        return new RestResp(attentionQuestionList);
    }

    @ApiOperation(value = "查询用户关注的专栏接口", notes = "查询用户关注的专栏接口")
    @GetMapping("/column")
    public RestResp column(@RequestParam("userId") Long userId,
                           @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<AttentionColumnVO> attentionColumnList = attentionService.getAttentionColumnList(userId, pageNo, pageSize);
        return new RestResp(attentionColumnList);
    }
}