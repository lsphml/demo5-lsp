package com.lsp.demo5lsp.practise.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liushaopeng
 * @version 1.0
 * @className StaticVariableTest
 * @description
 * @date 2019/8/23 16:00
 */
@Slf4j
public class StaticVariableTest {
    public static int j ;

    static{
        j = 2;
        log.info("enter into static block.......");
    }

    public static int test(){
        try{
            log.info("enter into static function test():");
            return  j++;
        }catch (Exception e){
           log.info("static function test() runs error :{}",e);
           throw  new RuntimeException();
        } finally {
            log.info("finally: j:"+j);
            return ++j;
        }
    }

    public static void main(String[] args){
        log.info("enter into main function........");
        int g = test();
        log.info("main:"+g);
    }
}
