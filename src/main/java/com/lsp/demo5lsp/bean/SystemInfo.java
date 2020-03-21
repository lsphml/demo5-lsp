package com.lsp.demo5lsp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description 使用@PropertySource和@Value读取自定义配置文件的属性值（只适用于.properties文件，.yml文件不适用）
 * @Author lsp
 * @Date 2020/3/18 11:32
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
// 指定自定义的配置文件的位置
@PropertySource(value = "classpath:external.properties",encoding = "UTF-8")
public class SystemInfo {

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;
}
