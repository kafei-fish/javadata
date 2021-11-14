package com.Thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class MyThread01 extends Thread{
    private CountDownLatch c;
    private volatile int[] t1;
    private volatile int[] t2;
    String str;

    public MyThread01(int[] t1,int[] t2,CountDownLatch c,String str) {
        this.c=c;
        this.t1 = t1;
        this.t2=t2;
        this.str=str;
    }

    @Override
    public void run() {
       for (int i=0;i<t1.length;i++) {

               try {
                   File file = new File(str);
                   if (!file.exists()) {
                       file.createNewFile();
                   }
                   FileWriter fileWriter = new FileWriter(str, true);

                   System.out.println("开始输出");
                   fileWriter.write(t1[i] + "");
                   fileWriter.write("\r\n");
                   c.await();
                   fileWriter.write(t2[i] + "");
                   fileWriter.write("\r\n");
                   fileWriter.close();
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
    }

