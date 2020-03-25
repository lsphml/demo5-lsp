package com.lsp.demo5lsp;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description TODO
 * @Author lsp
 * @Date 2020/3/24 16:41
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.lsp.demo5lsp.base.modular.*.dao")
public class Demo5LspApplication {

    private static final Logger logger = LoggerFactory.getLogger(Demo5LspApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Demo5LspApplication.class, args);
        logger.info("Demo5LspApplication starts successful!");
    }

}
