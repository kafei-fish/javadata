package com.lxl.tree;

/**
 * @author MyLong
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrayBinary arrayBinary=new ArrayBinary(arr);
        //前序遍历
        System.out.println("前序遍历");
        arrayBinary.preOrder();
        //中序遍历
        System.out.println("中序遍历");
        arrayBinary.infixOrder(0);
        //后序遍历
        System.out.println("后序遍历");
        arrayBinary.postOrder(0);

    }
}
class ArrayBinary{
    public int[] arr;
    public ArrayBinary(int[] arr) {
        this.arr=arr;
    }
    public void preOrder(){
        preOrder(0);
    }

    /**
     * 前序遍历
     * @param index 开始索引
     */
    public void preOrder(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树进行前序遍历");
        }
        System.out.println(arr[index]);
        if((index*2+1)< arr.length){
            preOrder(index*2+1);
        }
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    /**
     * 中序遍历
     * @param index 开始遍历元素的数组下标
     */
    public void infixOrder(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树进行前序遍历");
        }
        if((index*2+1)<arr.length){
            infixOrder((index*2+1));
        }
        System.out.println(arr[index]);
        if((index*2+2)<arr.length){
            infixOrder((index*2+2));
        }
    }
    public void postOrder(int index){
        if(arr==null||arr.length==0){
            System.out.println("数组为空，不能按照二叉树进行前序遍历");
        }
        if((index*2+1)<arr.length){
            infixOrder((index*2+1));
        }
        if((index*2+2)<arr.length){
            infixOrder((index*2+2));
        }
        System.out.println(arr[index]);
    }
}
