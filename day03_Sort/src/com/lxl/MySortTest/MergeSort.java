package com.lxl.MySortTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序总结：
 * 使用分治策略，将数组，每次递归合并
 *
 */
public class MergeSort {
    public static void main(String[] args) {

        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];

        mergeSort(arr,0, arr.length-1,temp);

        System.out.println(Arrays.toString(arr));

    }



    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;//中间索引
            //左边递归递归
            mergeSort(arr,left,mid,temp);
            //右边递归
            mergeSort(arr,mid+1,right,temp);

            //进行合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 归并排序
     * 首先进行写合并地算法
     * (一) 如果左边下标数据大于右边下标数据就经那个小地数据存入到临时数组temp里，
     * 如果右边小，就将右边数据存储到临时下标temp里
     * (二）循环退出之后左右两边数据有一边为空地，则就将为空地一边依次添加到临时下标里
     * (三) 经临时数组里地数据拷贝到arr数组里。
     * @param arr 原始数组
     * @param left 左边左边初始化索引下标
     * @param mid  中间下边
     * @param right 右边索引下标
     * @param temp 临时数组，用来存储合并地数据
     */
    public static void merge(int []arr,int left,int mid,int right,int []temp){
        int i=left;
        int j=mid+1;
        int t=0;
        //先把作业两边按照规则填充到temp临时变量里
        while (i <= mid && j<=right ){
            //如果左边数据小于右边数据，就把左边数据放入临时变量里
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                t += 1;
                i += 1;
            }else { //如果右边的数据小于左边的数据，就把右边的数据放入临时变量里
                temp[t]=arr[j];
                t +=1;
                j +=1;
            }
        }
        //完成就退出循环进行第二步
        //将左边剩余数据地一边依次填充到临时数组里
        while (i<=mid){
            temp[t]=arr[i];
            t +=1;
            i +=1;
        }
        //将右边剩余地数据依次填充到临时数组里
        while (j<=right){
            temp[t]=arr[j];
            t +=1;
            j +=1;
        }
        //将temp数组里数据拷贝到arr数组里
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t +=1;
            tempLeft +=1;
        }

    }
}
