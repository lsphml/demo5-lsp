package com.lsp.demo5lsp.practise.algorithms;

public class BubbleSort extends BaseAlgorithms{

    /**
     * 冒泡排序：
     *          1、n个元素需要n-1趟排序
     *          2、每趟排序依次比较相邻的两个元素，将较大或者较小的元素“冒泡”到数组的最后一个位置
     *          3、每趟冒泡需要比较的元素为（n-i）个
     * @param array
     */
    public static void sort(int[] array){
        for (int i=0; i<array.length-1; i++) {
            for(int j=0; j<array.length-1-i; j++){
                int temp = 0;
                if (less(array[j] , array[j+1])) {
                    exch(array,j,j+1);
                }
            }
        }
    }


    public static void main(String[] args){
        int[] array = new int[]{3,12,5,56,78,9};
        sort(array);
        System.out.print(array);

    }

}
