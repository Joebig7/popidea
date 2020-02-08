package com.mamba.popidea.controller;

import com.mamba.popidea.model.FavColumnBean;
import com.mamba.popidea.model.UserBean;
import com.mamba.popidea.model.UserDetail;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.model.vo.FavBeanVo;
import com.mamba.popidea.model.vo.UserVO;
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
        RestData<FavBeanVo> favBeanVoRestData = userService.getUserFavList(columnId, pageNo, pageSize);
        return new RestResp<>(favBeanVoRestData);
    }
}