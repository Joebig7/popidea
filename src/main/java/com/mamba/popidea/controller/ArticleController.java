package com.mamba.popidea.controller;

import com.mamba.popidea.model.ArticleBean;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.ArticleService;
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
 * @date: 2019/10/16 17:11
 * @description
 */
@Api(value = "文章相关Api", tags = "文章")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @ApiOperation(value = "发布文章", notes = "发布文章")
//    @PostMapping("/release")
//    public RestResp releaseArticle(@ApiParam("文章信息") @Valid @RequestBody ArticleBean articleBean) {
//
//    }

}