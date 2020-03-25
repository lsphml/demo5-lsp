package com.lsp.demo5lsp.practise.algorithms;

public class BaseAlgorithms {

    public static boolean less(Comparable v , Comparable w){
        return v.compareTo(w) < 0;
    }

    public static void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
