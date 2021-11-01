package com.lxl.Simulationqueue;

/**
 * 模拟队列
 */
public class Queue {
    private int maxSize;//队列大小
    private int front;
    private int rear;
    private int[] myQueue;

    public Queue(int maxSize) {
        this.maxSize =maxSize;
        this.front = -1;
        this.rear = -1;
        this.myQueue = new int[maxSize];
    }

    //队列是否已满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加队列
    public void addQueue(int sum){
        if(isFull()){
            System.out.println("队列已满，不能添加数据~~~");
            return;
        }
        rear++;//让rear后移
        myQueue[rear]=sum;
    }

    //出列
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，不能添加数据~~~");
        }
        front++;
        return myQueue[front];
    }
    //显示数组的数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的，没有数据~~~");
            return;
        }
        for(int i=0;i<myQueue.length;i++){
            System.out.printf("myQueue[%d]=%d\n",i,myQueue[i]);
        }
    }
    //显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空了，没有数据了~~~");
        }
        return myQueue[front+1];
    }
}
