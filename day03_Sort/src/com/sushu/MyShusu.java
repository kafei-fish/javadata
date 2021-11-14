package com.sushu;

import org.junit.Test;

public class MyShusu {
    public static void main(String[] args) {
        int shusuNext = isShusuNext(13);
        System.out.println(shusuNext);
    }
    public static int shuSu(int n){
        int a=0;
        int num=n;
        int temp=n+1;
        boolean isShusu=true;
        while (true){
            if(num%temp==0){
                isShusu=false;
              break;
            }
            temp+=1;
            num+=1;
        }
        if(isShusu){
            return temp;
        }
        return 0;
    }
    @Test
    public void test(){

        for(int i=2;i<=100;i++){
            boolean flag=true;
            for (int j=2;j<i;j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(i+"素数");
            }else {
                System.out.println(i+"不是素数");
            }
        }
    }
    //判断这个数是不是素数
    public static boolean isShuSu(int n){
        int temp=n;
        boolean flag=true;
        for(int i=2;i<n;i++){
            if(n%i==0){
                flag=false;
                break;
            }
        }
        if(flag){
            return true;
        }
        return false;
    }
    public static int isShusuNext(int n){

        int temp=n+1;
       while (true){
           boolean flag=true;
           // 7 8
           for(int i=2;i<temp;i++){
               if(temp%i==0){
                   flag=false;
                   break;
               }
           }
           if(flag){
               return temp;
           }
           temp+=1;
       }
    }
}
