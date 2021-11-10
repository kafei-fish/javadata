package com.lxl.MySortTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[]={9,4,3,1,5,6};
        long l = System.currentTimeMillis();

        sort(arr);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }

    /**
     * 插入排序
     * 插入排序，首先，我们从素组下标1开始遍历数组元素
     * 通过数组下标来拿到值，
     * 将数组下标减1
     * @param arr 数组
     *
     */
    public static void sort(int[] arr){
        for (int i=1;i<arr.length;i++){
            //通过数组下表来拿到值
            int insertVal=arr[i];
            //将下标-1，就找到数组下表前一个值
            int insertIndex=i-1;
            //进行while循环 如果前一个下表下表大于0当前的值小于前一个值 则我们就进行循环，否则就退出循环
            while (insertIndex>=0 && insertVal<arr[insertIndex]) {
                //将当前的值换成前一个值，
                arr[insertIndex + 1] = arr[insertIndex];
                //然后下表--
                insertIndex--;
            }
            //此时insertIndex为-1 则我们加1就为0,然后就添加到下标为0的位置
            arr[insertIndex+1]=insertVal;
        }
    }
    public static void sortTest(int []arr){
        //首先遍历循环数组
        for(int i=1;i<arr.length;i++){
            int insertVal=arr[i];
            int insertIndex=i-1;
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                //将当前的值换成一个值
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
        }
    }
}
