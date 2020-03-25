package com.lsp.demo5lsp.practise.algorithms;

public class InsertSort extends  BaseAlgorithms{

    /**
     *插入排序：
     *          1、n个元素需要n-1趟排序
     *          2、第i趟排序结束后，第i+1个元素的左边都是有序的
     *          3、每趟排序时依次和该元素左边的有序数组比较，找到合适的位置插入
     * @param array
     */
    public static void insertSort(int[] array){
        int len = array.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--){
                if(less(array[j],array[j-1])){
                    exch(array,j,j-1);
                } else {
                    break;
                }

            }
        }
    }

    /**
     * 希尔排序： （增强版的插入排序）
     *          1、
     * @param array
     */
    public static void shellSort(int[] array){
        int len = array.length;
        int gap = 1;
        while(gap < len/3){
            gap = 3*gap +1;
        }
        while (gap >=1){
            // 将数组变为gap有序
            for (int i = gap; i < len ; i++) {
                // 将array[i] 插入到array[i-2*gap],array[i-3*gap]......之中
                for (int j = i; j >= gap && less(array[j],array[j-gap]); j-=gap){
                    exch(array,j,j-gap);
                }
                gap = gap/3;
            }
        }

    }

    public static void main(String[] args){
        int[] array = new int[]{3,12,5,56,78,9};
        //insertSort(array);
        shellSort(array);
        System.out.println(array);
    }
}
