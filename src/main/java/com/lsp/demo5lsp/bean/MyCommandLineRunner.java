package com.lsp.demo5lsp.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author lsp
 * @Date 2020/3/23 17:21
 */
@Component
@Order(2)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args)  {
        System.out.println("this is a test of commandLineRunner.......");
        System.out.println("order:"+2);
        System.out.println("原始参数："+ Arrays.asList(args));
    }
}
