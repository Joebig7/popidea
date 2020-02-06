package com.mamba.popidea.controller;

import com.mamba.popidea.model.UserAttentionBean;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.AttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "关注/取消关注", notes = "关注/取消关注")
    @PostMapping("/toggle")
    public RestResp toggle(@ApiParam("关注相关参数") @Valid @RequestBody UserAttentionBean userAttentionBean) {
        attentionService.toggle(userAttentionBean);
        return new RestResp();
    }

}