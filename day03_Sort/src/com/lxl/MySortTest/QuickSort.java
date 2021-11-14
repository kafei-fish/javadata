package com.lxl.MySortTest;

import java.util.Arrays;

/**
 * 快速排序
 * @author lxl
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[]={-9,78,0,23,-256,70};
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int arr[],int left,int right){
        int l=left;
        int r=right;
        int pivot=arr[(left+right)/2];
        int temp =0;//交换中使用
        //while循环的目的是让比pivot值放大左边,找到大于pivort的值放大右边
        while (l<r){
            //在pivort的左边一直到，值到找到比prvot大的就退出
            while (arr[l]<pivot){
                l+=1;
            }
            //在pivort的右边一直到，直到找到笔pivort小的就退出
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l>=r则就说明，pivort已经按照左右两边的值，已经按照左边小于pivot和右边大于pivot的值进行排序
            //说明是数组的下标，一直在+=1
            //r一直在-=1；所以才进行l>=r的判断
            if (l>=r){
                break;
            }
            //交换位置
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //在交换完后发现arr[l]==pivot这两个数相等 就让pivot
            if(arr[l]==pivot){
                r-=1;
            }
            if(arr[r]==pivot){
                l+=1;
            }
        }
        //防止栈溢出
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if (left<r){
            sort(arr,left,r);
        }
        //向有递归
        if (right>l){
            sort(arr,l,right);
        }
    }
}
