package com.lsp.demo5lsp.config.mybatisGenreatorConfig;

/**
 * @author lsp
 * @description TODO
 * @date 2020/3/19 9:50
 **/
public class CodeGenerator {
    /**
     * @Description   mybatis-Plus的代码生成器:可以生成实体,mapper,mapper对应的xml,service
      * @param args
     * @Return void
     * @Author lsp
     * @Date 2020/3/19 10:00
     */
    public static void main(String[] args) {
        GeneratorConfig generatorConfig  = new GeneratorConfig();
        generatorConfig.doMpGeneration();
    }
}
