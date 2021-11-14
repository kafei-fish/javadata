package com.hash;

/**
 * @author MyLong
 */
public class HashDemo {
}
class HashTable{
    private EmpLinkList[] empLinkListsArray;
    private int size;

    public HashTable(EmpLinkList[] empLinkListsArray, int size) {
        this.size = size;
        empLinkListsArray=new EmpLinkList[size];
        for(int i=0;i<size;i++){
            empLinkListsArray=new EmpLinkList[i];
        }
    }
    public void add(Emp emp){
        empLinkListsArray[hashFun(emp.id)].add(emp);
    }
    public void list(){
        for (int i=0;i<size;i++){
            empLinkListsArray[i].list(i);
        }
    }
    public int hashFun(int id){
        return id%size;
    }
}
/**
 * 员工
 */
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 链表
 */
class EmpLinkList{

    private Emp head;

    /**
     * 添加链表
     * @param emp
     */
    public void add(Emp emp){
        if(head==null){
            head=emp;
        }
        Emp curEmp=head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp=emp;
    }
    public void list(int i){
        if(head==null){
            System.out.println("第"+(i+1)+"链表为空");
            return;
        }
        System.out.println("第"+(i+1)+"链表为");
        Emp curEmp=head;
        while (true){

            System.out.printf("==> id=%d name=%s",curEmp.id,curEmp.name);
            if(curEmp.next==null){
                return;
            }
            curEmp=curEmp.next;

        }
    }
    public Emp findByIdEmp(int id){
        if(head==null){
            System.out.println("当前链表为空");
            return null;
        }
        Emp curEmp=head;
       while (true){
           if(curEmp.id==id){
               break;
           }
           if(curEmp.next==null){
                return null;
           }
           curEmp=curEmp.next;
       }
       return curEmp;
    }

    /**
     * 按顺序插入
     *
     * 如果链表为空就直接插入，否则插入的数据与前一个数据进行比价，如果建一个数据大于要插入的数据则就交换位置，否在就直接插入在后面
     *
     * @param emp
     */
    public void sortAdd(Emp emp){
        if(head==null){
            head=emp;
        }
        Emp curEmp=head;

    }
}