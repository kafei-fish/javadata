package com.Thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class MyThread02 extends Thread{
    private CountDownLatch c;
    private volatile int[] t3;
    private String str;

    public MyThread02(CountDownLatch c, int[] t3,String str) {
        this.c = c;
        this.t3 = t3;
        this.str=str;
    }

    @Override
    public void run() {
        for (int i=0;i<t3.length;i++){

            try {
                File file=new File(str);
                if(!file.exists()){
                    file.createNewFile();
                }
                FileWriter fileWriter=new FileWriter(str,true);
                System.out.println("开始输出");
                fileWriter.write(t3[i]+"");
                fileWriter.write("\r\n");
                c.countDown();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }

