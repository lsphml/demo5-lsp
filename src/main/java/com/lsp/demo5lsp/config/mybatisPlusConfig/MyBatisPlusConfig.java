package com.lsp.demo5lsp.config.mybatisPlusConfig;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liushaopeng
 * @version 1.0
 * @className MyBatisPlusConfig
 * @description
 * @date 2018/12/26 14:37
 */
@Configuration
public class MyBatisPlusConfig {


    /**
     *
     * @param
     *@return : com.baomidou.mybatisplus.core.injector.ISqlInjector
     *@description : 逻辑删除
     *@author : liushaopeng
     *@date : 2018/12/26 14:40
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     *
     * @param
     *@return : com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     *@description : 分页插件
     *@author : liushaopeng
     *@date : 2018/12/26 14:43
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
