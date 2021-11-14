package com.lxl;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayTest {
    public static void main(String[] args)  {

        String[] a1={"a","b","c"};
        String[] a2={"e","f","g"};
        int[] a3={3,6,9};
        int index=0;
        boolean flag=false;
        String str="D:\\sparse3.txt";
        FileWriter fileWriter=null;
        while (true){

            try {
                File file=new File(str);
                if(!file.exists()){
                    file.createNewFile();
                }
                 fileWriter=new FileWriter(str,true);
                System.out.println("开始输出");
                fileWriter.write(a1[index]+"");
                fileWriter.write("\r\n");
                fileWriter.write(a2[index]+"");
                fileWriter.write("\r\n");
                fileWriter.write(a3[index]+"");
                fileWriter.write("\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(fileWriter!=null){
                        fileWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            index++;
            if(index>=a1.length||index>=a2.length){
                flag=true;
                break;
            }
        }

    }
    @Test
    public void Test01(){
        String[] aa = {"11","22","33","100"};
        String[] bb = {"44","55","66"};
        String[] cc = {"77","88","99"};
        String[] ee = new String[aa.length + bb.length + cc.length];
        System.arraycopy(aa, 0, ee, 0, aa.length);
        System.arraycopy(bb, 0, ee, aa.length, bb.length);
        System.arraycopy(cc, 0, ee, aa.length + bb.length, cc.length);
        System.out.println(Arrays.toString(ee));
        //拿到合并后的数组，就开始取数据
        fetchData(ee,aa,bb,cc);
    }
    public static void fetchData(String[] ee,String[] aa,String[] bb,String[] cc){
        //第一次取第一个
        //第二次取第一个数组长度+1个
        //第三次取第二个数组长度+1个
        int index=0;
        int indexTwo=0;
        List<String> list=new ArrayList<>();
        for(int i=0;i<ee.length;i++){
            System.out.println(ee[i]);
            list.add(ee[i]);
            System.out.println(ee[i+aa.length]);
            list.add(ee[i+aa.length]);
            System.out.println(ee[i+aa.length+bb.length]);
            list.add(ee[i+aa.length+bb.length]);

        }
    }
    public static void print(String ee){

        FileWriter fileWriter=null;
        try {
            File file=new File("D:\\sparse3.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            fileWriter=new FileWriter("D:\\sparse3.txt",true);
            System.out.println("开始输出");
            fileWriter.write(ee);
            fileWriter.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter!=null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
