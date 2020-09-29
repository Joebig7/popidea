package com.mamba.popidea.controller;

import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.CommonService;
import io.swagger.annotations.Api;
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
 * @date: 2019/5/27 16:20
 */
@Api(value = "common相关Api", tags = "common相关Api")
@RestController
@RequestMapping("/common")
public class  CommonController {

    @Autowired
    private CommonService commonService;

    @ApiOperation(value = "全局搜索", notes = "全局搜索")
    @GetMapping("/search")
    public RestResp search(@ApiParam("搜索关键字") @RequestParam("keyword") String keyword,
                           @ApiParam("搜索目标 1-问题 2-话题 3-用户 4-专栏") @RequestParam(value = "type", defaultValue = "1") Integer type,
                           @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        RestData restData = commonService.search(keyword, type, pageNo, pageSize);
        return new RestResp(restData);
    }


    @ApiOperation(value = "推荐功能", notes = "推荐功能")
    @GetMapping("/recommend")
    public RestResp recommend(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                              @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize) {
        RestData restData = commonService.recommend(pageNo, pageSize);
        return new RestResp(restData);
    }
}