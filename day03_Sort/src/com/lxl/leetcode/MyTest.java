package com.lxl.leetcode;

import java.io.File;
import java.io.FileWriter;

public class MyTest {
    public static void main(String[] args) throws Exception {
        int[] t1={1,2,3};
        int[] t2={4,5,6};
        int[] t3={7,8,9};
        boolean flag=false;
        String str="D:/sparse3.txt";
        while (true){
            for(int i=0;i< t1.length;i++){
                File file=new File(str);
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter=new FileWriter(str);
                System.out.println("开始输出");
                fileWriter.write(t1[i]);
                if(t1[i]==i){
                    break;
                }

            }
            for(int i=0;i< t2.length;i++){
                File file=new File(str);
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter=new FileWriter(str);
                System.out.println("开始输出");
                fileWriter.write(t1[i]+"\r\n");
                if(t1[i]==i){
                    break;
                }

            }
            for(int i=0;i< t3.length;i++){
                File file=new File(str);
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter=new FileWriter(str);
                System.out.println("开始输出");
                fileWriter.write(t1[i]+"\r\n");
                if(t1[i]==i){
                    break;
                }

            }
            for(int i=0;i<3;i++){
                if(t1[i]==0&&t2[i]==0&&t3[i]==0){
                    return;
                }
            }

        }
    }
}
