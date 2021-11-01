package com.lxl.demo01;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        Stack stack=new Stack(5);
        Scanner scanner=new Scanner(System.in);
        char key=' ';
        boolean loop=true;
        while (loop){
            System.out.println("s(show)：显示栈");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到栈");
            System.out.println("g(get)：取栈数据");
            key=scanner.next().charAt(0);
            switch (key){
                case 'a':
                    System.out.println("请输入要添加的数据");
                    int i = scanner.nextInt();
                    stack.push(i);
                    break;
                case 'g':
                    try {
                        int pop = stack.pop();
                        System.out.printf("取出栈的数据位%d\n",pop);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    stack.list();
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                default:
                    break;
            }
        }
        System.out.println("程序以退出");
    }
}
class Stack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }
    //栈满
    public boolean isFull(){
      return top==maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void list(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
