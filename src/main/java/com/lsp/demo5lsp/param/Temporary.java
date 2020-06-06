package com.lsp.demo5lsp.param;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @author lsp
 * @description TODO
 * @date 2020/4/8 17:14
 **/
public class Temporary {

    public static void main(String[] args) {
        List<TestBean> list = new ArrayList<>();
        list.add(new TestBean(1,"lsp"));
        list.add(new TestBean(2,"cx"));
        list.add(new TestBean(1,"zxm"));
        list.add(new TestBean(1,"zjp"));
        list.add(new TestBean(2,"xy"));
        list.add(new TestBean(1,"lxc"));
        list.add(new TestBean(1,"wwr"));
        list.add(new TestBean(2,"jzp"));
        list.add(new TestBean(1,"zyt"));
        list.add(new TestBean(3,"xxxxxxxx"));
        Map<Integer,List<TestBean>> map = list.stream().collect(Collectors.groupingBy(TestBean::getTagId));
        System.out.println(map);
        System.out.println("map.entrySet:"+ map.entrySet());
        map.entrySet().stream().forEach(entry->{
            System.out.println("entry.key:"+entry.getKey()+" ====== entry.value.num:"+entry.getValue().size());
        });
        Integer num = map.entrySet().stream().map(entry->{return entry.getValue().size();}).collect(Collectors.summingInt(value -> value));
        System.out.println("entry.value.num.sum:"+num);
    }


}
