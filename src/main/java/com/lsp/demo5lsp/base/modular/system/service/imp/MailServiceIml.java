package com.lsp.demo5lsp.base.modular.system.service.imp;

import com.lsp.demo5lsp.base.modular.system.service.MailService;
import com.lsp.demo5lsp.bean.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/24 15:01
 **/
@Component
public class MailServiceIml implements MailService {

    @Resource
    JavaMailSender javaMailSender;

    @Resource
    MailProperties mailProperties;

    @Override
    public void send(String subject, String context) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(context);
        simpleMailMessage.setFrom(mailProperties.getFrom());
        simpleMailMessage.setTo(mailProperties.getTo());
        javaMailSender.send(simpleMailMessage);
    }
}
