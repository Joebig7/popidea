package com.mamba.popidea.controller;

import com.mamba.popidea.model.ArticleBean;
import com.mamba.popidea.model.bo.ArticleBeanBo;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.model.vo.ArticleVO;
import com.mamba.popidea.service.ArticleService;
import com.mamba.popidea.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "发布或者修改文章", notes = "发布或者修改文章")
    @PostMapping("/release")
    public RestResp releaseOrUpdateArticle(@ApiParam("文章信息") @Valid @RequestBody ArticleBeanBo articleBeanBo) {
        articleBeanBo.setUserId(CommonUtil.getUserId());
        articleService.release(articleBeanBo);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "删除文章", notes = "删除文章")
    @PostMapping("/delete")
    public RestResp delete(@ApiParam("删除文章") @RequestParam("id") Long id) {
        articleService.delete(id);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "获取文章列表", notes = "获取文章列表")
    @GetMapping("/list")
    public RestResp list(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                         @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
                         @ApiParam("获取文章列表") @RequestParam("columnId") Long columnId) {
        RestData<ArticleBean> result = articleService.list(columnId, pageNo, pageSize);
        return new RestResp(result);
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "获取文章详细信息", notes = "获取文章详细信息")
    @GetMapping("/get")
    public RestResp get(@ApiParam("获取文章列表") @RequestParam("id") Long id) {
        ArticleVO articleVo = articleService.get(id);
        return new RestResp(articleVo);
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "搜索文章", notes = "搜索文章")
    @GetMapping("/search")
    public RestResp search(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           @ApiParam("搜索文章") @RequestParam("keyword") String keyword) {
        RestData<ArticleBean> result = articleService.search(keyword, pageNo, pageSize);
        return new RestResp(result);
    }
}