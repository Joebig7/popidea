package com.mamba.popidea.controller;

import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.ThumbService;
import com.mamba.popidea.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/11/11 17:58
 */
@Api(value = "点赞/踩功能", tags = "点赞/踩功能")
@RestController
@RequestMapping("/common/thumb")
public class ThumbController {

    @Autowired
    private ThumbService thumbService;

    @ApiOperation(value = "点赞", notes = "点赞")
    @PostMapping("/thumb")
    public RestResp like(@ApiParam(value = "点赞目标id") @RequestParam("targetId") Long targetId,
                         @ApiParam(value = "点赞类型") @RequestParam("type") Integer type,
                         @ApiParam(value = "踩/赞  1-赞 2-踩 3-取消点赞 4-取消踩") @RequestParam("status") Integer status) {
        Long userId = CommonUtil.getUserId();
        thumbService.thumb(userId, targetId, type, status);
        return new RestResp();
    }

}