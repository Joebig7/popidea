package com.mamba.popidea.controller;

import com.mamba.popidea.model.*;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.model.vo.*;
import com.mamba.popidea.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/20 16:08
 * @description 用户相关引导层
 */

@Api(value = "用户相关Api", tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户注册", notes = "用户注册 ")
    @PostMapping("/register")
    public RestResp register(@ApiParam("用户参数") @Valid @RequestBody UserBean userBean) {
        System.out.println(userBean.getNickName());
        userService.register(userBean);
        return new RestResp();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public RestResp<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return new RestResp<>(userService.login(username, password));
    }

    @ApiOperation(value = "用户注销", notes = "用户注销")
    @PostMapping("/loginOut")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp<Boolean> login(HttpServletRequest request) {
        return new RestResp<>(userService.loginOut(getToken(request)));
    }

    private String getToken(HttpServletRequest request) {
        return request.getHeader("authorization");
    }

    @ApiOperation(value = "用户详细信息添加/编辑", notes = "用户详细信息添加/编辑")
    @PostMapping("/detail/edit")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp detailEdit(@ApiParam("用户详细信息") @Valid @RequestBody UserDetail userDetail) {
        userService.detailInfoEdit(userDetail);
        return new RestResp<>();
    }

    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @GetMapping("/info")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp getWholeUserInfo() {
        UserVO userVO = userService.geWholeUserInfo();
        return new RestResp<>(userVO);
    }

    @ApiOperation(value = "查询我提的问题列表", notes = "查询我提的问题列表")
    @GetMapping("/creation/question")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp getCreatedQuestionList(@ApiParam("当前页数") @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                           @ApiParam("每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<QuestionBean> createdQuestionList = userService.getCreatedQuestionList(pageNo, pageSize);
        return new RestResp<>(createdQuestionList);
    }


    @ApiOperation(value = "查询我的专栏列表", notes = "查询我的专栏列表")
    @GetMapping("/creation/column")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp getCreatedColumnList(@ApiParam("当前页数") @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                         @ApiParam("每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<SpecialColumnBean> createdColumnList = userService.getCreatedColumnList(pageNo, pageSize);
        return new RestResp<>(createdColumnList);
    }

    @ApiOperation(value = "查询我的回答列表", notes = "查询我的回答列表")
    @GetMapping("/creation/answer")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp getCreatedAnswerList(@ApiParam("当前页数") @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                         @ApiParam("每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<OwnAnswerVO> createdAnswerList = userService.getCreatedAnswerList(pageNo, pageSize);
        return new RestResp<>(createdAnswerList);
    }


    //=========================收藏===========================

    @ApiOperation(value = "查询我的收藏夹", notes = "查询我的收藏夹")
    @GetMapping("/fav/column")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp getUserFavColumnList(@ApiParam("当前页数") @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                         @ApiParam("每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<FavColumnBean> userFavColumnList = userService.getUserFavColumnList(pageNo, pageSize);
        return new RestResp<>(userFavColumnList);
    }

    @ApiOperation(value = "查询我的收藏内容", notes = "查询我的收藏内容")
    @GetMapping("/fav/content")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp getUserFavList(@ApiParam("收藏参数") @RequestParam("columnId") Long columnId,
                                   @ApiParam("当前页数") @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                   @ApiParam("每页条数") @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<FavBeanVO> favBeanVoRestData = userService.getUserFavList(columnId, pageNo, pageSize);
        return new RestResp<>(favBeanVoRestData);
    }

    //=========================关注==========================

    @ApiOperation(value = "查询我关注的人接口", notes = "查询我关注的人接口")
    @GetMapping("/attention/person")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp person(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<AttentionPersonVO> attentionPersonList = userService.getMyAttentionPersonList(pageNo, pageSize);
        return new RestResp(attentionPersonList);
    }

    @ApiOperation(value = "查询我关注的问题接口", notes = "查询我关注的问题接口")
    @GetMapping("/attention/question")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp question(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<AttentionQuestionVO> attentionQuestionList = userService.getMyAttentionQuestionList(pageNo, pageSize);
        return new RestResp(attentionQuestionList);
    }

    @ApiOperation(value = "查询我关注的专栏接口", notes = "查询我关注的专栏接口")
    @GetMapping("/attention/column")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp column(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<AttentionColumnVO> attentionColumnList = userService.getMyAttentionColumnList(pageNo, pageSize);
        return new RestResp(attentionColumnList);
    }
}