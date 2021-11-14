package com.Thread;

public class MyTest {
    public static void main(String[] args) {
        PrintArray printArray=new PrintArray();
        new Thread(()->{
            printArray.print01();
        }).start();
        new Thread(()->{
            printArray.print02();
        }).start();
        new Thread(()->{
            printArray.print03();
        }).start();
    }
}
class PrintArray{
    private int flag = 1;
    public synchronized void print01(){

        int[] t1 = {1, 2, 3};
        while (flag!=1) {
            try {
                for (int i : t1) {
                    System.out.println(i);
                }
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag=2;
        this.notifyAll();
    }
    public synchronized void print02(){

        int[] t2 = {4, 5, 6};
        while (flag!=2) {
            try {
                for (int i : t2) {
                    System.out.println(i);
                }
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag=3;
        this.notifyAll();
    }
    public synchronized void print03(){

        int[] t3 = {7, 8, 9};
        while (flag!=3) {
            try {
                for (int i : t3) {
                    System.out.println(i);
                }
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag=1;
        this.notifyAll();
    }
}
