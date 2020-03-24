package com.lsp.demo5lsp;

import com.lsp.demo5lsp.base.BaseUnit;
import com.lsp.demo5lsp.base.modular.system.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

class Demo5LspApplicationTests extends BaseUnit {

    @Autowired
    MailService mailService;

    @Test
    public void mailSend() {

        mailService.send("测试springboot发送邮件","简单邮件发送.....");

    }

}
