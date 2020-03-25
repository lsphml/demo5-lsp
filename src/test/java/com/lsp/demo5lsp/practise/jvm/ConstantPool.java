package com.lsp.demo5lsp.practise.jvm;

public class ConstantPool {

    public static void main(String[] args){
        String str1 = "morning";
        String str2 = new String("morning");
        String str3 = "morn" + "ing";
        String str4 = str2.intern();
        // ==:比较的是引用
        System.out.print("str1==str2:"+str1 == str2);
        System.out.print("str1==str3:"+str1 == str3);
        System.out.print("str2==str4:"+str2 == str4);
        // equals：比较的是对象
        System.out.print("str1==str2:"+str1.equals(str2));
        System.out.print("str1==str3:"+str1.equals(str3));
        System.out.print("str2==str4:"+str2.equals(str4));
    }
}
