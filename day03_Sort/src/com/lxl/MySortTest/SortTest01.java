package com.lxl.MySortTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序的时间复杂的为O(n^2)
 * 运行时间为20秒
 */
public class SortTest01 {
    public static void main(String[] args) {
      //  int arr[]={1,2,3,4,5};
        int arr[]=new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*80000);
        }
        //long l = System.currentTimeMillis();
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("当前时间为"+format);
        sort(arr);
        Date date2=new Date();
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date2);
        System.out.println("当前时间为"+format1);
        //long l1 = System.currentTimeMillis();
        //System.out.println(l1-l);
        //System.out.println(Arrays.toString(arr));

    }

    /**
     * 冒泡排序
     * @param arr
     *
     */
    public static void sort(int[] arr){
        //设置一个临时变量
        int temp=0;
        //设置一个flag
        boolean flag=false;
        //从0开始，到最后一个-1；
        for(int i=0;i<arr.length-1;i++){

            for(int j=0;j< arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }

            }
            if(!flag){
                break;
            }else {
                flag=false;
            }
        }
    }
}
