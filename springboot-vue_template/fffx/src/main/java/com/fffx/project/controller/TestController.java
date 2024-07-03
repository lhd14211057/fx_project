package com.fffx.project.controller;

import java.util.List;

import javax.annotation.Resource;

import com.fffx.project.common.PagingResult;
import com.fffx.project.common.Response;
import com.fffx.project.service.UserService;
import com.fffx.project.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "test", protocols = "https")
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    UserService userService;

    @ApiOperation(value = "查询用户list", produces = "Content-Type: application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cn", value = "第几页", example = "1", required = false, defaultValue = "1"),
            @ApiImplicitParam(name = "sn", value = "每页条数", example = "20", required = false, defaultValue = "20")
    })
    @GetMapping(value = "/user/list")
    public Response<PagingResult<UserVo>> queryUser(@RequestParam(name = "cn", required = false, defaultValue = "1") int cn,
                                                       @RequestParam(name = "sn", required = false, defaultValue = "20") int sn) {

        Response<PagingResult<UserVo>> response = new Response<>(Response.ResponseStatus.SUCCESS);
        PagingResult<UserVo> pagingResult = new PagingResult<>(cn, sn);
        PagingResult<UserVo> result = userService.list(pagingResult);
        response.setData(result);
        return response;
    }
}

