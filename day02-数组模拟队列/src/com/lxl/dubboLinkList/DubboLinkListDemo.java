package com.lxl.dubboLinkList;




public class DubboLinkListDemo {
    public static void main(String[] args) {
        HeroNode03 heroNode1=new HeroNode03(1,"松江","及时雨");
        HeroNode03 heroNode2=new HeroNode03(2,"卢俊义","玉麒麟");
        HeroNode03 heroNode3=new HeroNode03(3,"吴用","智多星");
        HeroNode03 heroNode4=new HeroNode03(4,"林冲","包子头");
        HeroNode03 heroNode5=new HeroNode03(5,"李晓龙","3320070216");
        DubboLinkList dubboLinkList=new DubboLinkList();
        dubboLinkList.addOrderBy(heroNode1);
        dubboLinkList.addOrderBy(heroNode3);
        dubboLinkList.addOrderBy(heroNode4);
        dubboLinkList.addOrderBy(heroNode2);
        dubboLinkList.addOrderBy(heroNode5);
        dubboLinkList.list();

    }
}
class DubboLinkList{
    private HeroNode03 head=new HeroNode03(0,"","");

    public HeroNode03 getHead() {
        return head;
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
        HeroNode03 temp=head.next;
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
    //双向链表添加
    public void add(HeroNode03 heroNode){
        //设置一个临时变量
        HeroNode03 temp=head;
        //进行while循环，找到一个最后一个节点，
        while (true){
            if(temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //当退出while循环的时候就说明，链表走到了最后，最后将这个next节点指向新的节点
        temp.next=heroNode;
        heroNode.per=temp;
    }
    //双向链表修改
    //修改节点
    public void update(HeroNode03 newHeroNode){
        //判断链表是否为空
        if(head.next==null){
            return;
        }
        //设置一个临时变量
        HeroNode03 temp=head.next;
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
    //双向链表删除
    public void remove(HeroNode03 heroNode){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空无法删除");
            return;
        }
        //创建一个临时指针=head
        HeroNode03 temp=head.next ;
        boolean flag=false;
        while (true){
            if(temp==null){
                return;
            }
            if(heroNode.no==temp.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.per.next=temp.next;
            temp.next.per=temp.per;

        }
    }
    /**
     * 按照顺序添加
     *
     */
    //按照编号添加
    public void addOrderBy(HeroNode03 heroNode){
        //设置一个临时变量，把它当作一个指针
        HeroNode03 temp=head;
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
            //temp.net=新 节点
            temp.next=heroNode;
            temp.next.per=heroNode;
            heroNode.per=temp;
        }

    }
}
//单链表节点
class HeroNode03{
    public int no;
    public String name;
    public String neckName;
    public HeroNode03 next;//指向下一个节点
    public HeroNode03 per;

    public HeroNode03(int no, String name, String neckName) {
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