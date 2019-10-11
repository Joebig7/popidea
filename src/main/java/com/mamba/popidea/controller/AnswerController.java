package com.mamba.popidea.controller;

import com.mamba.popidea.model.QuestionAnswerBean;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.AnswerService;
import com.mamba.popidea.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/27 17:39
 */

@Api(value = "回答相关Api", tags = "回答")
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "发布回答", notes = "发布回答")
    @PostMapping("/release")
    public RestResp releaseAnswer(@Valid @RequestBody QuestionAnswerBean questionAnswerBean) {
        questionAnswerBean.setUserId(CommonUtil.getUserId());
        answerService.releaseOrUpdateAnswer(questionAnswerBean);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "发布回答", notes = "发布回答")
    @GetMapping("/list")
    public RestResp getAnswerList(@RequestParam("questionId") Long questionId, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        answerService.findAnswerList(questionId, pageNo, pageSize);
        return new RestResp();
    }

}