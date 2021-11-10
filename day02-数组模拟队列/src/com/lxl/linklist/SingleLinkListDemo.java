package com.lxl.linklist;

import java.util.Stack;

/**
 * 链表的数据结构：
 *  如何添加数据
 *  首先我们要复制一个指针：
 *  让指针一直循环往下走，当走到node.next节点为空的情况下，就跳出循环，在这个空的next添加数据
 *  遍历链表：
 *  首先判断链表是否为空：
 *  如果为空直接返回，因为头节点不能动所以我们要设置一个复制节点用来移动
 *  首先判断，节点是否到最后了，到最后就跳出
 *  没有到最后就输出链表的数据，然后在限一个节点的信息给temp，相当于往后移动一位
 */
public class SingleLinkListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"松江","及时雨");
        HeroNode heroNode2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(3,"吴用","智多星");
        HeroNode heroNode4=new HeroNode(4,"林冲","包子头");
        HeroNode heroNode5=new HeroNode(5,"李晓龙","3320070216");


        SingleLinkList singleLinkList=new SingleLinkList();
        SingleLinkList02 singleLinkList02=new SingleLinkList02();
        singleLinkList.add(heroNode1);
        singleLinkList02.add(heroNode2);
        singleLinkList.add(heroNode3);
        singleLinkList02.add(heroNode4);
        singleLinkList02.add(heroNode5);
        //开始合并链表
        HeroNode heroNode = singleLinkList.MergeLinkedList(singleLinkList.getHead(), singleLinkList02.getHead());


     singleLinkList.list();
//        System.out.println("开始反转");
//        singleLinkList.ReverseList(singleLinkList.getHead());
//        singleLinkList.list();
//
//        System.out.println("使用栈倒叙排列");
//        singleLinkList.reverseHead(singleLinkList.getHead());
//        singleLinkList.addOrderBy(heroNode1);
//        singleLinkList.addOrderBy(heroNode4);
//        singleLinkList.addOrderBy(heroNode3);
//        singleLinkList.addOrderBy(heroNode2);
//        singleLinkList.addOrderBy(heroNode2);
//        singleLinkList.list();
//
//        HeroNode heroNode=new HeroNode(2,"小义","麒麟");
//        singleLinkList.update(heroNode);
//        System.out.println("修改后的数据");
//        singleLinkList.list();
//        System.out.println("删除后数据");
//        singleLinkList.remove(heroNode1);
//        singleLinkList.remove(heroNode2);
//        singleLinkList.list();
//        System.out.println("链表中节点"+singleLinkList.listNodeSum());
//        System.out.println("查找倒数第1个节点");
//        System.out.println(singleLinkList.findKNode(singleLinkList.getHead(), 3));
    }
    //面试题
    //求链表中节点的个数

}

/**
 * 链表的增删改查
 *
 */
class SingleLinkList{
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }
    public HeroNode addTwoNumbers(HeroNode l1,HeroNode l2){

        return null;
    }
    //添加链表
    public void add(HeroNode heroNode){
        //设置一个临时变量
        HeroNode temp=head;
        //进行while循环，找到一个最后一个节点，
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //当退出while循环的时候就说明，链表走到了最后，最后将这个next节点指向新的节点
        temp.next=heroNode;
    }
    //按照编号添加
    public void addOrderBy(HeroNode heroNode){
        //设置一个临时变量，把它当作一个指针
        HeroNode temp=head;
        boolean flag=false;//设置一个标识，如果插入的节点和链表的节点相等的话，就为ture
        //开始进行死循环
        while (true){
            //首先进行判断，链表为空，就直接跳出
            if(temp.next==null){
                break;
            }
            //进行定位链表的位置
            if(temp.next.no>heroNode.no){
                break;
                //判断插入数据的no是否相等
            }else  if(temp.next.no==heroNode.no){
                flag=true;//就设置标识为ture
                break;
            }
            //最后就要移动到下一个位置
            temp=temp.next;
        }
        //最后循环结束，我们就可以进行插入
        if(flag){
            System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n",heroNode.no);
        }else {
            //新节点的.next=temp.next
            heroNode.next=temp.next;
            //temp.net=新节点
            temp.next=heroNode;
        }

    }

    //修改节点
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if(head.next==null){
            return;
        }
        //设置一个临时变量
        HeroNode temp=head.next;
        boolean flag=false;//设置标识，如果找到临时节点，就就为true
        //开始进行循环
        while (true){
            if(temp==null){
                break;
            }
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            //让指针移动
            temp=temp.next;
        }
        //如果flag为true,说明找到位置了
        if(flag){
            temp.name= newHeroNode.name;
            temp.neckName=newHeroNode.neckName;
        }else {
            System.out.printf("准备修改的英雄%d不存在\n",newHeroNode.name);
        }
    }
    //遍历链表
    public void list(){
        //判断链表是否为空
        //这head.next等于了null，就说明了链表为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以我们要设置一盒临时变量来辅助
        HeroNode temp=head.next;
        while (true){
            //判断这个链表是否到最后了，如果到了就返回
            if(temp==null){
                break;
            }
            //如何没有到最后就输出这个链表信息
            System.out.println(temp);
            //最后还要后移
            temp=temp.next;
        }
    }
    //删除节点
    //
    public void remove(HeroNode heroNode){
        //判断链表是否为空
        if(head.next==null){
            return;
        }
        //创建一个临时指针=head
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp==null){
                return;
            }
            if(heroNode.no==temp.next.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
           temp.next=temp.next.next;

        }
    }

    /**
     * 求单链表中节点的个数
     * @return
     */
    public  int listNodeSum(){
        if(head.next==null){
            return 0;
        }
        HeroNode cur=head.next;
        boolean flag=false;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
/**
 * 新浪面试题：
 *     查找单链表中的倒数第k个节点
 */
    public HeroNode findKNode(HeroNode head,int index){
        if (head.next==null){
            return null;
        }
        int size=listNodeSum();
        if (index<=0||index>size){
            return null;
        }
        HeroNode cur=head.next;
        for (int i=0;i<size-index;i++){
            cur=cur.next;
        }
        return cur;
    }
    //单链表的反转
    public void ReverseList(HeroNode head){
        //如果链表为空，或者链表只有一个节点，就无需反转
        if(head.next==null||head.next.next==null){
            return;
        }
        //定义一个辅助指针变量
        HeroNode cur=head.next;
        HeroNode next=null;//执行当前节点的cur的下一个节点
        HeroNode reverseHead =new HeroNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }
    //从尾到头打印链表
    public void reverseHead(HeroNode head){
        if(head.next==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop()+"&&");

        }
    }
    public HeroNode MergeLinkedList(HeroNode head1,HeroNode head2){
            HeroNode p1=head1.next;
            HeroNode p2=head2.next;
            HeroNode p3=head1;
            while (p1!=null&&p2!=null){
                if(p1.no<=p2.no){
                    p3.next=p1;
                    //p1向下移动
                    p1=p1.next;
                }else {
                    p3.next=p2;
                    p2=p2.next;
                }
                p3=p3.next;
            }
            p3.next=p1==null?p2:p1;

            return head1;
  }

}
//单链表节点
class HeroNode{
    public int no;
    public String name;
    public String neckName;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String neckName) {
        this.no = no;
        this.name = name;
        this.neckName = neckName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", neckName='" + neckName + '\'' +
                '}';
    }
}
//合并两个链表
//比较每个链表的大小，如果大就加入到后面
//单链表节点
class HeroNode02{
    public int no;
    public String name;
    public String neckName;
    public HeroNode02 next;//指向下一个节点

    public HeroNode02(int no, String name, String neckName) {
        this.no = no;
        this.name = name;
        this.neckName = neckName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", neckName='" + neckName + '\'' +
                '}';
    }
}
class SingleLinkList02{
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void setHead(HeroNode head) {
        this.head = head;
    }

    /**
     *  首先要找到链表的最后以为，
     *  所以我们要设置一个指针变量，让指针变量等于链表的头节点，然后就行判断，如果头节点的.next为空则就跳出循环，否则，让指针在往后移,接着循环，直到找到空的节点
     *  跳出循环后，证明我们已经知道了最后的空节点，所以，在最后节点的.next添加数据
     * @param heroNode 要先添加的节点
     */
    public void add(HeroNode heroNode){
        //设置一个临时变量
        HeroNode temp=head;
        //进行while循环，找到一个最后一个节点，
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //当退出while循环的时候就说明，链表走到了最后，最后将这个next节点指向新的节点
        temp.next=heroNode;
    }


    /**
     *  按顺序添加数据,还是准备一个指针，并且设置一个标识，进行死循环，如果链表为空，就直接跳出，
     *  如果不为空，就要定位链表的位置，如果，节点的。next.no>herNode.no就直接跳出，否之，判断是否相等，并且修改flag为true
     *  然后在移动指针走向下一位
     *
     *  跳出哦循环之后，进行判断，如果flag为true的话，说明添加的数据和链表节点数据相等。不能进行添加，
     *  否则，temp的下一个节点的数据赋值herrnode.next
     *  temp.next就等于herode空的节点。
     *
     * @param heroNode
     */
    public void addOrderBy(HeroNode heroNode){
        //设置一个临时变量，把它当作一个指针
        HeroNode temp=head;
        boolean flag=false;//设置一个标识，如果插入的节点和链表的节点相等的话，就为ture
        //开始进行死循环
        while (true){
            //首先进行判断，链表为空，就直接跳出
            if(temp.next==null){
                break;
            }
            //进行定位链表的位置
            if(temp.next.no>heroNode.no){
                break;
                //判断插入数据的no是否相等
            }else  if(temp.next.no==heroNode.no){
                flag=true;//就设置标识为ture
                break;
            }
            //最后就要移动到下一个位置
            temp=temp.next;
        }
        //最后循环结束，我们就可以进行插入
        if(flag){
            System.out.printf("准备插入的英雄编号%d已经存在了，不能加入\n",heroNode.no);
        }else {
            //新节点的.next=temp.next
            heroNode.next=temp.next;
            //temp.net=新节点
            temp.next=heroNode;
        }

    }

    /**
     * 通过id来修改节点，首先，我们要先知道如何定位节点
     * 设置一个临时指针，
     * 设置一个标识
     * 进行死循环
     * 如果temp.no==newHeroNode.no为true已经找到了位置，就跳出循环。
     * 如果不为空，指针网后移，继续循环，知道找到跳出
     * 判断flag为true就修改
     * 否则就输出id不存在
     * @param newHeroNode
     */
    //修改节点
    public void update(HeroNode newHeroNode){
        //判断链表是否为空
        if(head.next==null){
            return;
        }
        //设置一个临时变量
        HeroNode temp=head.next;
        boolean flag=false;//设置标识，如果找到临时节点，就就为true
        //开始进行循环
        while (true){
            if(temp==null){
                break;
            }
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            //让指针移动
            temp=temp.next;
        }
        //如果flag为true,说明找到位置了
        if(flag){
            temp.name= newHeroNode.name;
            temp.neckName=newHeroNode.neckName;
        }else {
            System.out.printf("准备修改的英雄%d不存在\n",newHeroNode.name);
        }
    }

    /**
     * 如何变量链表：设置一个临时变量，判断链表是否到最后了，到最后据跳出，否则就输出这个节点的信息
     * 然后在把指针后移
     */
    //遍历链表
    public void list(){
        //判断链表是否为空
        //这head.next等于了null，就说明了链表为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以我们要设置一盒临时变量来辅助
        HeroNode temp=head.next;
        while (true){
            //判断这个链表是否到最后了，如果到了就返回
            if(temp==null){
                break;
            }
            //如何没有到最后就输出这个链表信息
            System.out.println(temp);
            //最后还要后移
            temp=temp.next;
        }
    }
    //删除节点
    //
    public void remove(HeroNode heroNode){
        //判断链表是否为空
        if(head.next==null){
            return;
        }
        //创建一个临时指针=head
        HeroNode temp=head;
        boolean flag=false;
        while (true){
            if(temp==null){
                return;
            }
            if(heroNode.no==temp.next.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;

        }
    }

    /**
     * 求单链表中节点的个数
     * @return
     */
    public  int listNodeSum(){
        if(head.next==null){
            return 0;
        }
        HeroNode cur=head.next;
        boolean flag=false;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    /**
     * 新浪面试题：查找单链表中的倒数第k个节点
     *
     */
    public HeroNode findKNode(HeroNode head,int index){
        if (head.next==null){
            return null;
        }
        int size=listNodeSum();
        if (index<=0||index>size){
            return null;
        }
        HeroNode cur=head.next;
        for (int i=0;i<size-index;i++){
            cur=cur.next;
        }
        return cur;
    }
    //单链表的反转
    public void ReverseList(HeroNode head){
        //如果链表为空，或者链表只有一个节点，就无需反转
        if(head.next==null||head.next.next==null){
            return;
        }
        //定义一个辅助指针变量
        HeroNode cur=head.next;
        HeroNode next=null;//执行当前节点的cur的下一个节点
        HeroNode reverseHead =new HeroNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;
    }
    //从尾到头打印链表
    public void reverseHead(HeroNode head){
        if(head.next==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<>();
        HeroNode cur=head.next;
        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop()+"&&");

        }
    }

    /**
     * 合并链表
     * 创建两个变量指针： p1,和p2 ,分别指向头节点的下一个节点
     * 创建一个指针p3指向head1节点
     * @param head1 第一个第一个链表
     * @param head2 第二个链表
     * @return
     */
    public HeroNode MergeLinkedList(HeroNode head1,HeroNode head2){

        HeroNode p1=head1.next;
        HeroNode p2=head2.next;
        HeroNode p3=head1;
        //如果p1和p2的节点的不为空,则进入循环
        while (p1!=null&&p2!=null){
            //p1的no小于p2.no，则就将p1添加到p3节点的后面
            if(p1.no<=p2.no){
                p3.next=p1;
                //p1向下移动
                p1=p1.next;
            }else {
                //否则就添加p2
                p3.next=p2;
                //p2指针往后移
                p2=p2.next;
            }
            //一次循环之后p3的指针后移
            p3=p3.next;
        }
        //最后若有指针已经循环为空，就把p2的节点添加到p3.next的后面，反之也是
        p3.next=p1==null?p2:p1;

        return head1;
    }

}
