package com.lsp.demo5lsp.controller;

import com.lsp.demo5lsp.bean.Information;
import com.lsp.demo5lsp.bean.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class HelloController {

    @Resource
    private Information information;

    @Resource
    private SystemInfo systemInfo;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Springboot!";
    }

    @RequestMapping("/info")
    public Information info(){
        return information;
    }

    @RequestMapping("/sys")
    public SystemInfo sys(){
        return  systemInfo;
    }
}
