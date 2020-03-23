package com.lsp.demo5lsp.controller;

import com.lsp.demo5lsp.bean.Information;
import com.lsp.demo5lsp.bean.SystemInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author lsp
 * @Date 2020/3/23 17:19
 */

@Api(value="测试swagger2",tags = "测试接口")
@RestController
public class HelloController {

    @Resource
    private Information information;

    @Resource
    private SystemInfo systemInfo;

    @ApiOperation(value = "hello!",notes = "hello!")
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Springboot!";
    }

    @ApiOperation(value = "用户信息查询",notes = "用户信息查询")
    @RequestMapping("/info")
    public Information info(){
        return information;
    }

    @ApiOperation(value = "系统信息查询",notes = "系统信息查询")
    @RequestMapping("/sys")
    public SystemInfo sys(){
        return  systemInfo;
    }
}
