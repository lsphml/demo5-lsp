package com.lsp.demo5lsp.param;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author lsp
 * @description TODO
 * @date 2020/4/8 17:14
 **/
public class tempory {

    public static void main(String[] args) {
        List<TestBean> list = Collections.emptyList();
        list.add(new TestBean(1,"lsp"));
        list.add(new TestBean(2,"cx"));
        list.add(new TestBean(1,"zxm"));
        list.add(new TestBean(1,"zjp"));
        list.add(new TestBean(2,"xy"));
        list.add(new TestBean(1,"lxc"));
        list.add(new TestBean(1,"wwr"));
        list.add(new TestBean(2,"jzp"));
        list.add(new TestBean(1,"zyt"));

        Map<Integer,List<TestBean>> map = list.stream().collect(Collectors.groupingBy(TestBean::getTagId));

        System.out.println(map);
    }
}
