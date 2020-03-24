package com.lsp.demo5lsp.base.modular.system.service;


/**
 * @Description TODO
 * @param subject
 * @param context
 * @Return void
 * @Author lsp
 * @Date 2020/3/24 15:00
 */
public interface MailService {
    void send(String subject,String context);
}
