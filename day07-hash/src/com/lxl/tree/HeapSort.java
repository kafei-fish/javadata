package com.lxl.tree;

import java.util.Arrays;

/**
 * @author MyLong
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr={4,6,8,5,9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        System.out.println("堆排序");
        int temp=0;
        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //完成大顶堆之后，将头节点存入数组的最后一个，然后在进行大顶堆排序
        for(int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("排序" + Arrays.toString(arr));
    }
    /**
     * 将数组转换成一个大顶堆
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr,int i,int length){
        //先取出当前的值
        int temp=arr[i];
        //k=i*2+1 的是左子节点
        for(int k=i*2+1;k<length;k=k*2+1){
            //如果左子节点的值小于右子节点的值
            if(k+1<length && arr[k]<arr[k+1]){
                k++; //k指向右子节点
            }
            //如果左节点大于父节点，则我们就交换位置
            if(arr[k]> temp){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        //当for循环结束后，我们已将i为父节点的最大值放在最顶端
        //将temp放到调整后位置
        arr[i]=temp;
    }


}
