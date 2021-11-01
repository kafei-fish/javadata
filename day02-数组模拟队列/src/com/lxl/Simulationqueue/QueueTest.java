package com.lxl.Simulationqueue;

import com.lxl.mycircularqueue.CircularQueue;

import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {
        CircularQueue queue=new CircularQueue(3);
        Scanner sc=new Scanner(System.in);
        char key=' ';
        boolean loop=true;
        while (loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：显示队列");
            key=sc.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请添加数据" +
                            "");
                    int sum=sc.nextInt();
                    queue.addQueue(sum);
                    break;
                case 'g':
                    try{
                        int queue1 = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",queue1);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int i = queue.headQueue();
                        System.out.printf("取出的头部数据是%d\n",i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop=false;
                default:
                    break;
            }
        }
        System.out.println("程序推出~~~");
    }
}
