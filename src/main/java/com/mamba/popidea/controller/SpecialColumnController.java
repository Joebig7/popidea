package com.mamba.popidea.controller;

import com.mamba.popidea.model.SpecialColumnBean;
import com.mamba.popidea.model.common.result.RestData;
import com.mamba.popidea.model.common.result.RestResp;
import com.mamba.popidea.service.SpecialColumnService;
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
 * @date: 2019/10/16 17:34
 * @description
 */
@Api(value = "文章相关Api", tags = "文章")
@RestController
@RequestMapping("/column")
public class SpecialColumnController {


    @Autowired
    private SpecialColumnService specialColumnService;

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "创建/修改专栏", notes = "创建/修改专栏")
    @PostMapping("/create")
    public RestResp createOrUpdate(@ApiParam("专栏信息") @Valid @RequestBody SpecialColumnBean columnBean) {
        Long userId = CommonUtil.getUserId();
        columnBean.setUserId(userId);
        specialColumnService.createOrUpdate(columnBean);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "删除专栏", notes = "删除专栏")
    @PostMapping("/delete")
    public RestResp delete(@ApiParam("专栏信息") @RequestParam("id") Long id) {
        specialColumnService.delete(id);
        return new RestResp();
    }

    @ApiImplicitParam(paramType = "header", dataType = "string", name = "Authorization", required = true)
    @ApiOperation(value = "删除专栏", notes = "删除专栏")
    @GetMapping("/list")
    public RestResp getColumnByUserId(@ApiParam("专栏信息") @RequestParam("userId") Long userId,
                                      @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                      @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        RestData<SpecialColumnBean> result = specialColumnService.getColumnByUserId(userId, pageNo, pageSize);
        return new RestResp(result);
    }
}