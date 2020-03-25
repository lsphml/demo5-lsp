package com.lsp.demo5lsp.practise.algorithms;

public class SelectSort extends BaseAlgorithms{
    /**
     * 选择排序：（因为它不断选择剩余元素中的最小者）
     *          1、找到数组中最小的那个元素
     *          2、将其与数组中的读一个元素交换位置
     *          3、在剩下的元素中找到最小的元素，将其与数组的第二个元素交换位置
     *          4、如此往复，直到将整个数组排序
     * @param array
     */
    public static void selectSort(int[] array){
        int len = array.length;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(less(array[i],array[j])){
                    exch(array,i,j);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{3,12,5,56,78,9};
        selectSort(array);
        System.out.println(array);
    }

}
