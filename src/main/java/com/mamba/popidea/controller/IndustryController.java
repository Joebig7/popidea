package com.mamba.popidea.controller;

import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "行业相关api", tags = "行业")
@RequestMapping("/industry")
@RestController
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @ApiOperation(value = "查询行业信息", notes = "查询行业信息")
    @GetMapping("/all")
    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    public RestResp getAllIndustry(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return new RestResp<>(industryService.getAllIndustryList(pageNo, pageSize));
    }
}