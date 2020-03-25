package com.lsp.demo5lsp.practise.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyArray {
    /**
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        for (int i = 0; i< nums.length; i++){
            Integer left = 0;
            Integer right = 0;
            for (int j = 0 ; j < i; j++ ) {
                left += nums[j];
            }
            for (int k = i+1 ; k < nums.length ; k++){
                right += nums[k];
            }
                if (left == right) {
                    return i;
                }

        }
        return -1;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i< nums.length; i++){
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        for (int j = 0 ; j< nums.length; j++) {
            if (nums[j] != max) {
                if (max < 2*nums[j]){
                    return -1;
                }
            }
        }
        return index;
    }

    /**
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i>= 0; i--) {
            if (digits[i] == 9){
                if (i == 0) {
                    int[] newDigits = new int[digits.length+1];
                    newDigits[0] = 1;
                    for (int j =1 ; j< newDigits.length; j++) {
                        newDigits[j] = 0;
                    }
                    return newDigits;
                }
                digits[i] = 0;
            }else {
                digits[i] = digits[i]+1;
                return digits;
            }
        }
        return digits;
    }

    /**
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int length1 = s.length;
        int length2 = s.length/2;
        for (int i = 0; i< length2 ; i++) {
            char temp = s[i];
            s[i] = s[length1-1-i];
            s[length1-1-i] = temp;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        char[] strArray = s.toCharArray();
        int index = 0;
        for (int i = 0; i< strArray.length; i++){
            int accountTimes = 0;
            int temp = strArray[i];
            for (int j = 0; j< strArray.length; j++){
                if (temp == strArray[j] ){
                    accountTimes+=1;
                    if (accountTimes ==2){
                        break;
                    }else{
                        continue;
                    }
                }
            }
            if (accountTimes == 1) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    /**
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (null == needle){
            return 0;
        } else {
            return haystack.indexOf(needle);
        }
    }

    /**
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        str = str.trim();
        String firstChar = str.substring(0,1);
        String regx = "[0-9]|\\+|-";
        Pattern pattern = Pattern.compile(regx);
        Matcher m = pattern.matcher(firstChar);
        boolean flag = m.find();
        if (str == null || !flag){
            return 0;
        }else {
            String regx2 = "[^0-9]";
            Pattern pattern2 = Pattern.compile(regx2);
            Matcher m2 = pattern.matcher(str);
            String finalStr = m2.group();
        }
        return 0;
    }
    public static void main(String[] args){
        String s = "+loveleetcode123";
        int index = myAtoi(s);
        System.out.print(index);
}
}
