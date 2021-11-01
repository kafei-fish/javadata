package com.lxl.demo02;

public class Mytest01 {
    public static void main(String[] args) {
        //100以内数相加
        System.out.println(add(1000));
    }
    public static int add(int n){
        int sum=0;
        sum=(1+n)*n/2;
        return sum;
    }
}
