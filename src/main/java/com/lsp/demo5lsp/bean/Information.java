package com.lsp.demo5lsp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Description 使用@ConfigurationProperties 读取Application.properties配置文件的参数值
 * @Author lsp
 * @Date 2020/3/18 11:30
 */
@Component
@ConfigurationProperties(prefix = "info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information implements Serializable {

    private String address;

    private String phone;

    private String gender;
}
