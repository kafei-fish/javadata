package com.lxl.mycircularqueue;

/**
 * 模拟队列改进版
 * 使得队列编程一个环形队列
 */
public class CircularQueue {

    private int maxSize;//队列大小
    private int front;
    private int rear;
    private int[] myQueue;

    public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        myQueue=new int[maxSize];
    }
    //判断队列是否满了
    public boolean isFull(){
        //如何判断队列是否已满，就要使用取模运算；得到个数
        return (rear+1)%maxSize==front;
    }
    //判断是否为空
    public boolean isEmpty(){
        return rear==front;
    }

    //添加队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满，不能添加数据");
            return;
        }
        myQueue[rear]=n;
        //将real后移这就会考虑到取模
        rear=(rear+1)%maxSize; //这个添加运算，是一个取模运算（0+1）%3=1
    }
    //出列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        //分析：
        /*
        1.先把font对应的值保存一个临时变量
        2.先将font后移，在考虑取模
        3.将临时变量返回
         */
        int value =myQueue[front];
        front=(front+1)%maxSize; //如果这个数组取到了最后一元素，时候，就会重新开始
        return value;
    }
    //显示所以数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，没有数据");
        }
        for (int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize, myQueue[i%maxSize]);
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public int headQueue(){
        if(isEmpty()){
            System.out.printf("队列为空，没有数据");
        }
        return myQueue[front+1];
    }
}
