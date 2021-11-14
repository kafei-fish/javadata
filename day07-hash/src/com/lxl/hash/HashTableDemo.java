package com.lxl.hash;

import java.util.Scanner;

/**
 * @author MyLong
 * 如何创建hash表：
 * 首先：hash表是一个数组加链表
 * 我们需要 一个链表 ，一个员工 ，最后组成一个hash数组
 *
 *
 *
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable=new HashTable(7);
        String key="";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加成员");
            System.out.println("list:显示成员");
            System.out.println("find:查找成员");
            System.out.println("exit:退出成员");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入姓名");
                    String name=scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("输入要查找的id");
                    id=scanner.nextInt();
                    hashTable.findById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

/**
 * 创建HashTable 管理多条链表
 */
class HashTable{

    private EmpLinkedList[] empLinkedListsArray;
    private int size;

    public HashTable(int size){
        this.size=size;
        empLinkedListsArray=new EmpLinkedList[size];
        //留一个坑 ,这时候要分别初始每个链表
        for(int i=0;i<size;i++){
            empLinkedListsArray[i]=new EmpLinkedList();
        }
    }

    /**
     * 添加员工
     * @param emp 员工信息
     */
    public void add(Emp emp){
        int empLinedList = hashFun(emp.id);
        empLinkedListsArray[empLinedList].add(emp);
    }

    /**
     * 遍历
     */
    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListsArray[i].list(i);
        }
    }

    /**
     * 编写散列函数
     * @param id
     * @return
     */
    public int hashFun(int id){
        return id%size;
    }
    public void findById(int id){
        int empLinedListNo = hashFun(id);
        Emp emp = empLinkedListsArray[empLinedListNo].findByEmpId(id);
        if(emp!=null){
            System.out.printf("在第%d条链表中找到了 雇员 id=%d\n name="+emp.name+"",(empLinedListNo+1),id);
        }else {
            System.out.println("在hash表中,没有找到该雇员");
        }

    }

}
/**
 * 员工
 */
class Emp{
      public int id;
      public String name;
      public Emp next;
      public Emp(int id,String name){
            super();
            this.id=id;
            this.name=name;
      }
}

/**
 * 表示链表
 */
class EmpLinkedList{
    /**
     * 头指针，指向第一个Emp
     */
    private Emp head;

    /**
     * 添加员工到链表中
     * @param emp 员工
     */
    public void add(Emp emp){
        //首先找到链表中最后一个元素
        //如果添加的式第一个雇员
        if(head==null){
            head=emp;
            return;
        }
        //如果不为空，就设置一个临时指针开始进行循环遍历
        Emp curEmp=head;
        while (curEmp.next != null) {

            //说明链表在最后 后移
            curEmp = curEmp.next;
        }
        //退出时直接将链表加入其中
        curEmp.next=emp;
    }

    /**
     * 遍历列表
     */
    public void list(int id){
        if(head==null){
            System.out.println("第"+(id+1)+"条链表为空");
            return;
        }
        System.out.print("第"+(id+1)+"条链表信息为");
        //设置一个辅助指针
        Emp curEmp=head;
        while (true){
            System.out.printf("==> id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        //进行换行
        System.out.println();
    }
    public Emp findByEmpId(int id){
        //判断链表是否为空
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
        Emp curEep=head;
        while (true){
            if(curEep.id==id){
                break;
            }
            //说明遍历当前链表没有找到该成员
            if(curEep.next==null){
                curEep=null;
            }
            //进行后移
            curEep=curEep.next;
        }
        return curEep;
    }
    public void sortAdd(Emp emp){
        boolean flag=false;
        Emp curEmp=head;
        while (true){
            if(curEmp==null){
                break;
            }
            if(curEmp.id>emp.id){
                break;
            }else if(curEmp.id==emp.id){
                flag=true;
                break;
            }
            curEmp=curEmp.next;
        }
        if(flag){
            System.out.printf("您要插入的数据%d以重复",emp.id);
        }else {
          emp.next=head;
          head=emp;

        }
    }
}