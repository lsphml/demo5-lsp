package com.lsp.demo5lsp.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author lsp
 * @description 用户信息实体
 * @date 2020/3/24 15:51
 **/
@Data
public class User {

    private Integer id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String phone;

    @Range(max = 120,min = 0,message = "年龄大于零小于120岁")
    private String age;
}
