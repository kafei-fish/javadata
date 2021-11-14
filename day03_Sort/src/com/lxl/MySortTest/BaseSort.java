package com.lxl.MySortTest;

import java.util.Arrays;

/**
 * 基数排序
 * @author lxl
 */
public class BaseSort {
    public static void main(String[] args) {
        int[] arr={53,3,542,748,14,214};
        baseSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     */
    public static void baseSort(int []arr){
        //定义一个二维数组桶
        int[][] bucket=new int[10][arr.length];

        //定义一个数组来记录每个桶里存储的数据

        int[]  bucketElementCounts=new int[10];
        //得到最代数是几位数
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int maxLength=(max+"").length();
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //第一轮
            for(int j=0;j<arr.length;j++){
                //取出每个原始的个数
                int digitOfElement=arr[j]/n%10;
                //将数组中取出的数据存储到二维数组中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序依次取出
            int index=0;
            //变量每一个桶
            for(int k=0;k< bucketElementCounts.length;k++){
                if(bucketElementCounts[k]!=0){
                    for(int l=0;l<bucketElementCounts[k];l++){
                        //取出元素放到原数组中
                        arr[index++]=bucket[k][l];
                    }
                }
                bucketElementCounts[k]=0;
            }


        }
//        //第一轮
//        for(int j=0;j<arr.length;j++){
//            //取出每个原始的个数
//            int digitOfElement=arr[j]%10;
//            //将数组中取出的数据存储到二维数组中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序依次取出
//        int index=0;
//        //变量每一个桶
//        for(int k=0;k< bucketElementCounts.length;k++){
//                if(bucketElementCounts[k]!=0){
//                    for(int l=0;l<bucketElementCounts[k];l++){
//                        //取出元素放到原数组中
//                        arr[index++]=bucket[k][l];
//                    }
//                }
//            bucketElementCounts[k]=0;
//        }
//        System.out.println("第一轮，对个位数排序"+ Arrays.toString(arr));
//        //第二轮
//        for(int j=0;j<arr.length;j++){
//            //取出每个原始的个数
//            int digitOfElement=arr[j]/10%10;
//            //将数组中取出的数据存储到二维数组中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序依次取出
//        index=0;
//        //变量每一个桶
//        for(int k=0;k< bucketElementCounts.length;k++){
//            if(bucketElementCounts[k]!=0){
//                for(int l=0;l<bucketElementCounts[k];l++){
//                    //取出元素放到原数组中
//                    arr[index++]=bucket[k][l];
//                }
//            }
//            bucketElementCounts[k]=0;
//        }
//        System.out.println("第二轮，对十位数排序"+ Arrays.toString(arr));
//        //第三轮
//        for(int j=0;j<arr.length;j++){
//            //取出每个原始的个数
//            int digitOfElement=arr[j]/100%10;
//            //将数组中取出的数据存储到二维数组中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序依次取出
//        index=0;
//        //变量每一个桶
//        for(int k=0;k< bucketElementCounts.length;k++){
//            if(bucketElementCounts[k]!=0){
//                for(int l=0;l<bucketElementCounts[k];l++){
//                    //取出元素放到原数组中
//                    arr[index++]=bucket[k][l];
//                }
//            }
//            bucketElementCounts[k]=0;
//        }
//        System.out.println("第三轮，对白位数排序"+ Arrays.toString(arr));
    }
}
