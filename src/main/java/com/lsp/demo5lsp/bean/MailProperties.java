package com.lsp.demo5lsp.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lsp
 * @description 邮件发送配置信息实体
 * @date 2020/3/24 15:11
 **/
@Component
@ConfigurationProperties(prefix = "send")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailProperties {

    private String from;

    private String to;
}
