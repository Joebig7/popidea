package com.mamba.popidea.controller;

import com.mamba.popidea.model.TagBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/16 18:42
 * @description
 */
@Api(value = "问题相关Api", tags = "问题相关Api")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "创建标签", notes = "创建标签")
    @PostMapping("/create")
    public RestResp create(@ApiParam("标签信息") @Valid @RequestBody TagBean tagBean) {
        tagService.add(tagBean);
        return new RestResp();
    }


    @ApiOperation(value = "搜索标签", notes = "搜索标签")
    @PostMapping("/search")
    public RestResp search(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           @ApiParam("关键词") @RequestParam("keyword") String keyword) {
        RestData<TagBean> result = tagService.search(keyword, pageNo, pageSize);

        return new RestResp(result);
    }

}