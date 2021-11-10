package com.lxl.MySortTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序的时间复杂度为O(n^2)
 * 运行时间为4秒
 */
public class SelectSort {
    public static void main(String[] args) {

//        int arr[]=new int[80000];
//        for(int i=0;i<80000;i++){
//            arr[i]=(int)(Math.random()*80000);
//        }
        int arr[]={9,4,3,1,5,6};
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("当前时间为"+format);
        sort(arr);
        Date date2=new Date();
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date2);
        System.out.println("当前时间为"+format1);

    }

    /**
     * 选择排序
     * 首先我们先假定数组的第一个元素就是最小的一个，并且设置两个变量将数组第一个元素的下表和数组第一个元素的值都存入到这个两个变量里
     * 从素组的第一个元素开始遍历比较，如果第一个元素大于第二元素就交换位置
     * @param arr 素组
     */
    public static void sort(int arr[]) {
        //循环遍历数组
        for(int i=0;i<arr.length;i++) {
            //将数组中的第一个元素取出下标和遍历存到这俩个变量里
            int minIndex = i;
            int min = arr[i];
            //从素组的第一个元素开始遍历比较，如果第一个元素大于第二元素就交换位置
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { //如果大，则就交换
                    //将最小值付给min
                    min = arr[j];
                    //将minIndex的最小值的坐标为 当前j的坐标
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                //找到这个对小值数组的位置赋值给当前最小的坐标
                arr[minIndex] = arr[i];
                //把这个位置
                arr[i] = min;
            }
//            System.out.println("第"+(i+1)+"轮之后");
//            System.out.println(Arrays.toString(arr));
        }
//
//        minIndex=1;
//        min=arr[1];
//        for(int j=1+1;j<arr.length;j++){
//            if(min>arr[j]){ //如果大，则就交换
//                min=arr[j];
//                minIndex=j;
//            }
//        }
//        if (minIndex!=1){
//        arr[minIndex]=arr[1];
//        arr[1]=min;
//        }
//        System.out.println("第二轮之后");
//        System.out.println(Arrays.toString(arr));
    }
    public static void sortTest(int []arr){
        //循环遍历数字
        for(int i=0;i<arr.length;i++){
            //先设定最小值为就为当前数组第一个元素
            int minIndex=i;
            int min=arr[i];
            for(int j=i+1;i<arr.length;i++){
                if(min>arr[j]){
                    minIndex=j;
                    min=arr[j];
                }
            }
            if(minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
        }
    }
}
