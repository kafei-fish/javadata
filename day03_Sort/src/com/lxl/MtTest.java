package com.lxl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MtTest {
    public static void main(String[] args) throws Exception {

        int[] t2={4,5,6};
        int[] t3={7,8,9};

        new Thread(()->{
            int[] t1={1,2,3};
            String str="D:\\sparse3.txt";
            for(int i=0;i<t1.length;i++){

                    try {
                        File file=new File(str);
                        if(!file.exists()){
                            file.createNewFile();
                        }
                        FileWriter fileWriter=new FileWriter(str,true);
                        System.out.println("开始输出");
                        fileWriter.write(t1[i]+"");
                        fileWriter.write("\r\n");
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {

                    }
                }

        }).start();
    }
}
