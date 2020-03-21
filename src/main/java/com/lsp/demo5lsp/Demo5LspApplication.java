package com.lsp.demo5lsp;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Demo5LspApplication {

    private static final Logger logger = LoggerFactory.getLogger(Demo5LspApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Demo5LspApplication.class, args);
        logger.info("Demo5LspApplication starts successful!");
    }

}
