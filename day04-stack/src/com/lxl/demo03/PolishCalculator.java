package com.lxl.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后缀表达式
 *
 */
public class PolishCalculator {
    public static void main(String[] args) {
//        //创建一个表达式 (3+4)*5-6
//        String expression="3 4 + 5 * 6 -";
//        //首先要把这个数据放在ArrayList
//        List<String> listString = getListString(expression);
//        int calculate = calculate(listString);
//        System.out.println(calculate);
        //通过中缀表达式转换成后缀表达式
        String expression="1+((2+3)*4)-5";
        List<String> strings = toInfixExpressionList(expression);
        System.out.println(strings);
        List<String> strings1 = parseSuffixExpressionList(strings);
        System.out.println(strings1);
        //获得之后我们就可以开始进行将中缀表达式转换成后缀表达式
    }

    /**
     * 将中缀表达式分隔开，把每个字符都加入到list集合里
     * @param s 中缀表达式字符串
     * @return
     */
    public static   List<String> toInfixExpressionList(String s){
        List<String> ls=new ArrayList<>();
        int i=0;//指针,用于遍历中缀表达式的每一个字符
        String str;//多位数拼接
        char c;//遍历到每个字符都存入c
        do {
            //进行判断取出的字符不在这个范围，则就添加到list集合里
            if((c=s.charAt(i))<48||(c=s.charAt(i))>57){

                ls.add(""+c);//将字符添加到list集合里
                i++;//使得指针往后移
            }else {//否则是一个数，我们就要考虑多位数
                str="";
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }

    /**
     * 将中缀表达式转换成后缀表达式步骤：
     * 
     * @param ls
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //创建一个操作栈
        Stack<String> s1=new Stack<>();
        //创建一个list集合作为数字栈
        List<String> s2=new ArrayList<>();
        //遍历ls，如果时一个数就加入lsit集合中,如果是一个左括号时就就加入s1操作栈,如果是一个右括号时，就要依次弹出，只到位左括号，然后把左括号消除
        for (String item : ls) {
            //通过正则表达式来判断字符是否位数字
            if(item.matches("\\d+")){
                s2.add(item);
            }else if("(".equals(item)){
                s1.push(item);
            }else if(")".equals(item)){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//弹出左括号
            }else {
                //当item的优先级小于s2的栈顶的优先级，就先把s2的栈顶的字符弹出并加入到s2list集合中,然后在次进行比较
                while (s1.size() !=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1剩余依次弹出加入
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    public static List<String> getListString(String expression){
        String[] s = expression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : s) {
            list.add(ele);
        }
        return list;
    }
    public  static int calculate (List<String> ls){
        Stack<String> stack = new Stack<>();
        for (String item : ls) {
            if(item.matches("\\d+")){
                stack.push(item);
            }else {
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if("+".equals(item)){
                    res=num1+num2;
                }else if("-".equals(item)){
                    res=num1-num2;
                }else if("*".equals(item)){
                    res=num1*num2;
                }else if("/".equals(item)){
                    res=num1/num2;
                }else {
                    throw  new RuntimeException("运算符有错误");
                }
                stack.push(""+res);
            }

        }
        return Integer.parseInt(stack.pop());
    }
}
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    public static int getValue(String operation){
        int res=0;
        switch (operation){
            case "+":
                res=ADD;
                break;
            case "-":
                res=SUB;
                break;
            case "*":
                res=MUL;
                break;
            case "/":
                res=DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return res;
    }
}