package com.lxl.demo05;

/**
 * 什么是八皇后问题
 * 一共有八个皇后走在棋盘上，第一个皇后与第二个皇后不能在同一行，同一列，同一斜，请问有几种解法
 * 八皇后问题解决：
 *  print() 首先我们要设置一个输出方法，要吧八皇后拜访的位置给输出出来
 *  judge() 我们还要设置一个judge方法，拉来进行判断皇后拜访的位置是否冲突
 *  check() 接下来设置一个check的方法，判断放入的皇后是已经大于最大值，如果n=max就打印，然后就返回
 */
public class Demo05Test {
    int max=8;
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {
        Demo05Test demo05Test=new Demo05Test();
        demo05Test.check(0);
        System.out.printf("一共有%d解法",count);
    }

    /**
     *
     * @param n
     */
    public void check(int n){
        if(n ==max){
            print();
            return;
        }
        //依次放入皇后，看看是否冲突
        for(int i=0;i<max;i++){
            //先把当前这个皇后n，方法进行的第一例
            array[n]=i;
            if(judge(n)){
                check(n+1);
            }
            //如果冲突，继续指向arry[n]=i
        }
    }



    /**
     * //查看我们放置第n个皇后，就去检测皇后是否和前面已经拜访的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
       for (int i=0;i<n;i++){
           //进行比较前一个和后一个的位置
           if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
               return false;
           }
       }
       return true;
    }

    //写一个方法将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }




}
