package com.lxl.demo02;

import java.util.Stack;

/**
 * 栈计算器
 */
public class CalculatorStackDemo {
    public static void main(String[] args) {
        //根据老师的思路来开始进行
        String expression="90+2*6-2";
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operStack = new CalculatorStack(10);
        Stack stack=new Stack();
        //初始化变量
        int index=0;//设置一个指针变量
        int num1=0;//
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';//将每次扫描的课char保存到ch
        String keepNums="";
        while (true){
            //依次得到expression的
            ch=expression.substring(index,index+1).charAt(0);
            //判断ch是什么，然后相应的处理
            if (operStack.isOper(ch)){//如果是运算符
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.calculate(num1,num2,oper);
                        numStack.push(res);
                        //将当前操作符写入符号域
                        operStack.push(ch);
                    }else {
                        //如果当前操作符的的优先级大于栈中的操作符，就直接写人符号栈
                        operStack.push(ch);
                    }
                }else {
                    //如果为空，直接添加
                    operStack.push(ch);
                }
            }else {
                //如果不是操作符，就添加数字
                //numStack.push(ch-48);
                //处理多位数
                keepNums+=ch;
                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNums));
                }else {
                    //进行判断我们往后读取一位
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNums));
                        keepNums="";
                    }

                }

            }
            //将指针++
            index++;
            //当指针指向字符的最后，就跳出循环
            if(index>=expression.length()){
                break;
            }
        }
        //如果入栈完毕，两个栈还有数据，就直接取出运算
        while (true){
            //如果操作符栈是否为空，则就跳出循环
            if (operStack.isEmpty()){
                break;
            }
            //否则就取出
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.calculate(num1,num2,oper);
            //将计算的结果放入数字栈内
            numStack.push(res);
        }
        //计算完毕，在数字栈内就会剩下一个，这个就是最后运算的结果。将其弹出即可
       int res2=numStack.pop();
        System.out.printf("表达式 %s=%d",expression,res2);
    }
}
class CalculatorStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }
    //栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    public int peek(){
        return stack[top];
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
    //判断操作符谁的优先级高
    public int priority(int oper){
            if(oper=='*'||oper=='/'){
                return 1;
            }else  if (oper=='+'||oper=='-'){
                return 0;
            }else {
                return -1;
            }
    }
    //判断是不是一个运算符
    public boolean isOper(int oper){
        return oper=='*'||oper=='/'||oper=='-'||oper=='+';
    }
    //计算器
    public int calculate(int n1,int n2,int oper){
        int res=0;
        switch (oper){
            case '*':
                res=n1+n2;
                break;
            case '/':
                res=n2/n1;
                break;
            case '+':
                res=n2+n1;
                break;
            case '-':
                res=n1+n2;
                break;
            default:
                break;
        }
        return res;
    }






}
