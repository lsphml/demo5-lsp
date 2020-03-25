package com.lsp.demo5lsp.practise.ThreadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyLockTest {

    public void lockTest (){
        Lock lock = new ReentrantLock();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    }

    public static int getDivision(int m){
        try{
            if(m/0 >= 0){
            m++;
        }else{
            m-=1;
        }}catch (Exception e){
            m++;
            // 程序异常捕获后，若没有处理的话（抛出/return），程序会继续执行下去直到结束
           // return m++;
        }
        m++;
        return m++;

    }

    public static void main(String[] args){
        int n = getDivision(10);
        System.out.println(n);
    }



}
