package com.lxl.MySortTest;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class HillSort {
    public static void main(String[] args) {
        int arr[]={9,4,3,1,5,6,10,-3,-256,895};
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("当前时间为"+format);
        sellInsertionSort(arr);
        Date date2=new Date();
        SimpleDateFormat simpleDateFormat2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date2);
        System.out.println("当前时间为"+format1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 希尔排序【交换排序】
     * 解决步骤：
     *  首先将数组/2：进行交换
     *
     * @param arr
     */
    public static void sort(int arr[]){
        int count=0;
        int temp=0;
        for(int gap=arr.length/2;gap>0;gap/=2){
            //循环数组长度的/2到素组长度的次数
            for(int i=gap;i<arr.length;i++){
                //首先让j=i-gap
                for(int j=i-gap;j>=0;j-=gap){
                    if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                    }
                }
            }

        }
    }
    //进行希尔插入排序

    /**
     * 使用希尔【插入】排序
     * @param arr
     */
    public static void sellInsertionSort(int arr[]){
        //还是使用跟上面一样的方式，将数组/2遍历，得到一个数，从这个数开始遍历到数组的长度
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                //设置两个变量，设定让当前下标为最小的
                int j=i;
                int temp=arr[j];
                //进行判断，这个坐标小于前面的下标的值，则就进行插入排序
                if(arr[j]<arr[j-gap]){
                    //进行while循环，如果j-gap》=和最小值小于前面的值，进行替换，将最小值换成后面的值，然j=j-gap,退出循环之后将找到找到插入位置，将最小值进行插入
                    while (j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j]=temp;
                }
            }
        }

    }

    /**
     *
     * @param arr
     */
    public static void sellInsertSortTest(int arr[]){
        for(int gap=arr.length/2;gap>0;gap/=2){
            for(int i=gap;i<arr.length;i++){
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j-gap]=temp;
                }
            }
        }

    }
}
