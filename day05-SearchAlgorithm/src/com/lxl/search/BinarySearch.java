package com.lxl.search;

import java.util.ArrayList;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1000,1000,1000,1243};
//        int i = binarySearch(arr, 0,arr.length-1,90);
//        System.out.println("找到下标为"+i);
        ArrayList<Integer> integers = binarySearch02(arr, 0, arr.length - 1, -2);
        System.out.println("resIndexList"+integers);
        int a = 5, b = 5;
        System.out.println("a + b = " + a + b);

        System.out.println("a * b = " + a * b);
        System.out.println("a / i2 = " + a / b);
    }

    /**
     * 二分查找
     * @param arr 数组
     * @param left 最左边元素的下标
     * @param right 最右边元素的下标
     * @param findValue 要找的值
     * @return 如果找到就返回找到元素的下标，如果没找到就返回-1；
     */
    public static int binarySearch(int[] arr,int left,int right,int findValue){
        if(left>right){
            return -1;
        }
        int indexMin=(left+right)/2; //找到中间的下标
        int min=arr[indexMin]; //找到中间值

        //进行判断
        if(findValue>min){
            return binarySearch(arr,indexMin + 1,right,findValue);
        }else if(findValue<min){
            return binarySearch(arr,left,indexMin - 1,findValue);
        }else {
            return indexMin;
        }
    }

    /**
     * 查找元素的下标，如果是相同就全部查出，我们可以用list集合来存储
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static ArrayList<Integer> binarySearch02(int[] arr, int left, int right, int findValue){
        if(left>right){
            return new ArrayList<Integer>();
        }
        int indexMin=(left+right)/2; //找到中间的下标
        int min=arr[indexMin]; //找到中间值

        //进行判断
        if(findValue>min){
            return binarySearch02(arr,indexMin + 1,right,findValue);
        }else if(findValue<min){
            return binarySearch02(arr,left,indexMin - 1,findValue);
        }else {
            ArrayList<Integer> resIndexList=new ArrayList<>();
            //向indexMin左边扫描，将所以满足查找的元素全部加入到集合中
            int temp=indexMin-1;
            while (true){
                if(temp<0||arr[temp]!=findValue){
                    break;


                }
                resIndexList.add(temp);
                temp-=1;
            }
            resIndexList.add(indexMin);

            //右边
            temp=indexMin+1;
            while (true){
                if(temp>arr.length-1||arr[temp]!=findValue){
                    break;
                }
                resIndexList.add(temp);
                temp+=1;
            }
            return resIndexList;
        }
    }
    public static int MyBinarySearch(int[] arr,int left,int right,int findValue){
        if(left>right){
            return -1;
        }
        //找到中间的下标
        int middleIndex=(left+right)/2;
        //找到中间下标的值
        int middle=arr[middleIndex];
        if(findValue>middle){//右边查
            return  MyBinarySearch(arr,middleIndex-1,right,findValue);
        }else if(findValue<middle){//左边查
            return  MyBinarySearch(arr,left,middleIndex+1,findValue);
        }else {
            return middleIndex;
        }
    }
}
