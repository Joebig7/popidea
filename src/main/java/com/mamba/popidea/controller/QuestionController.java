package com.mamba.popidea.controller;

import com.mamba.popidea.model.QuestionBean;
import com.mamba.popidea.model.bo.QuestionBeanBo;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.QuestionService;
import com.mamba.popidea.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/23 16:53
 */
@Api(value = "问题相关Api", tags = "问题")
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "发布问题", notes = "发布问题")
    @PostMapping("/release")
    public RestResp releaseQuestion(@Valid @RequestBody QuestionBeanBo questionBeanBo) {
        questionBeanBo.setUserId(CommonUtil.getUserId());
        questionService.releaseOrUpdateQuestion(questionBeanBo);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "删除问题", notes = "删除问题")
    @PostMapping("/delete")
    public RestResp releaseQuestion(@RequestParam("id") Long id) {
        questionService.deleteQuestion(id);
        return new RestResp();
    }

    @ApiOperation(value = "查询问题详情", notes = "查询问题详情")
    @GetMapping("/detail")
    public RestResp getQuestionInfo(@RequestParam("id") Long id) {
        return new RestResp(questionService.getQuestionInfo(id));
    }


    @ApiOperation(value = "模糊查询", notes = "模糊查询")
    @GetMapping("/get")
    public RestResp searchQuestion(@RequestParam("keyword") String keyword, @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return new RestResp(questionService.getQuestionListByKeyWord(keyword, pageNo, pageSize));
    }


}