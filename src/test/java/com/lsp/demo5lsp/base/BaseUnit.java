package com.lsp.demo5lsp.base;

import com.lsp.demo5lsp.Demo5LspApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/24 14:37
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo5LspApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseUnit  {

    @Autowired
    WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }




}
