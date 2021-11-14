package com.lxl.search;

/**
 * 线性查找
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,20,56,97};
        int i = linearSearch(arr, -1);

        System.out.println(i==-1?"没查找到":"找到了下标为:"+i);
    }
    public static int linearSearch(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(value==arr[i]){
                return i;
            }
        }
        return -1;
    }
}
