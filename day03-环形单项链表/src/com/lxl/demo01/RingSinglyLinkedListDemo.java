package com.lxl.demo01;

/**
 * 环形单向链表
 */
public class RingSinglyLinkedListDemo {
    public static void main(String[] args) {
        RingSinglyLinkedList ringSinglyLinkedList=new RingSinglyLinkedList();
        ringSinglyLinkedList.addBoys(5);
        ringSinglyLinkedList.listBoys();

        ringSinglyLinkedList.countBoy(1,2,5);
    }
}

class RingSinglyLinkedList{
    private Boy fist=new Boy(-1);
    //添加链表
    public void addBoys(int nums){
        if(nums<1){
            System.out.println("nums的值不正确");
        }
        Boy curBoy=null;//辅助指针，帮助构建链表
        //使用for循环来构建环形链表
        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            //如果是第一个boy
            if(i==1){
                fist=boy;
                fist.setNext(fist);
                curBoy=fist;
            }else {
                curBoy.setNext(boy);
                boy.setNext(fist);
                curBoy=boy;
            }

        }
    }
    //遍历链表
    public void listBoys(){
        if(fist==null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy curBoy=fist;
        while (true){
            System.out.printf("小孩的编号为%d \n",curBoy.getNo());
            if(curBoy.getNext()==fist){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }

    /**
     *
     * @param starNo 第一个小孩
     * @param countNum 从第几人报数
     * @param nums 一共多少小孩
     */
    public void countBoy(int starNo,int countNum,int nums){
        if(fist==null||starNo<1||starNo>nums){
            System.out.println("您输入的参数不正确");
            return;
        }
        Boy helper=fist;
        while (true){
            if(helper.getNext()==fist){
                break;
            }
            helper=helper.getNext();
        }
        /**
         * 如果并不是从1开始的，我们就要用for循环，将指针位置重新指到
         *
         *
         *
         * **/

        for(int j=0;j<starNo-1;j++) {
            helper=helper.getNext();
            fist=fist.getNext();
        }
        /**
         * 当小孩报数是，让 fist和helper都有同时移动 m-1位
         */
        while (true){
            //说明只有一个节点
            if(helper==fist){
                break;
            }
            for (int j=0;j<countNum-1;j++){
                helper=helper.getNext();
                fist=fist.getNext();
            }
            System.out.printf("要出圈的小孩id是%d \n",fist.getNo());
            fist=fist.getNext();
            helper.setNext(fist);
        }
        System.out.printf("最后一个出圈的小孩的id是%d \n",helper.getNo());
    }
}
class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}