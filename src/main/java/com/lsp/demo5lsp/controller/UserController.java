package com.lsp.demo5lsp.controller;

import com.lsp.demo5lsp.bean.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/24 16:01
 **/
@ApiOperation(value = "用户控制Api", tags = "用户控制Api")
@RestController
@Slf4j
public class UserController {

    @PutMapping("/user")
    public ResponseEntity<Object> changeUser(@RequestBody @Valid User user , BindingResult result){
        if (result.hasErrors()) {
            for(ObjectError error : result.getAllErrors()){
                log.info("错误信息："+error.getDefaultMessage());
            }
        }
        return ResponseEntity.ok().build();
    }
}
