package com.lsp.demo5lsp.bean;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args)  {
        System.out.println("this is a test of ApplicationRunner ......");
        System.out.println("order:"+1);
        System.out.println("原始参数："+ Arrays.asList(args.getSourceArgs()));
        Set<String> para =args.getOptionNames();
        para.stream().forEach(s -> System.out.println("key:"+s+"#####value:"+args.getOptionValues(s)));
    }
}
