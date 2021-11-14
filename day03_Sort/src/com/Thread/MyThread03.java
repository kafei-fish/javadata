package com.Thread;

import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.CountDownLatch;

public class MyThread03 {
    public static void main(String[] args) throws Exception{


        int[] t1={1,2,3};
        int[] t2={4,5,6};
        int[] t3={7,8,9};
//        String str="D:\\sparse3.txt";
//        for(int i=0;i< t1.length;i++){
//            File file=new File(str);
//            if(!file.exists()){
//                file.createNewFile();
//            }
//            FileWriter fileWriter=new FileWriter(str,true);
//            System.out.println("开始输出");
//            fileWriter.write(t1[i]+"");
//            fileWriter.write("\r\n");
//            fileWriter.write(t2[i]+"");
//            fileWriter.write("\r\n");
//            fileWriter.write(t3[i]+"");
//            fileWriter.write("\r\n");
//            fileWriter.close();
        CountDownLatch c=new CountDownLatch(1);
        new MyThread01(t1,t2,c,"D:\\\\sparse3.txt").start();
        new MyThread02(c,t3,"D:\\\\sparse3.txt").start();
    }
    public static void Mytest(){
        int index=0;
        int[] temp=new int[1000];

    }
}
