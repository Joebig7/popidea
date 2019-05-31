package com.mamba.popidea.controller;

import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/23 16:55
 */

@Api(value = "话题相关Api", tags = "话题")
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "获取话题列表", notes = "获取话题列表")
    @GetMapping("/get")
    public RestResp getTopicList(@ApiParam(required = false) @RequestParam(value = "key", required = false) String key, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return new RestResp<>(topicService.findTopicList(key, pageNo, pageSize));
    }

}