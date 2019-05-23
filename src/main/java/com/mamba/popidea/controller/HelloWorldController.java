package com.mamba.popidea.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/10 10:42
 */

@Api(value = "HelloWorld相关Api",tags = "test相关接口")
@RestController
public class HelloWorldController {


    @ApiOperation(value = "测试", notes = "用户可以注册成会员")
    @GetMapping("/test")
    public String test() {
        return "Hello world";
    }


}