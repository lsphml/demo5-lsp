package com.lsp.demo5lsp.bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Order(2)
public class MyCommandLIneRunner implements CommandLineRunner {
    @Override
    public void run(String... args)  {
        System.out.println("this is a test of commandLineRunner.......");
        System.out.println("order:"+2);
        System.out.println("原始参数："+ Arrays.asList(args));
    }
}
