package com.mamba.popidea.controller;

import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/23 16:55
 */

@Api(value = "话题相关api", tags = "话题相关api")
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "获取话题列表", notes = "获取话题列表")
    @RequestMapping("/get")
    public RestResp getTopicList(@RequestParam("key") String key, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return new RestResp<>(topicService.findTopicList(key, pageNo, pageSize));
    }

}