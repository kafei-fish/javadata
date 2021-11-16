package com.lxl.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author MyLong
 */
public class Huffman {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node root = creatHuffMan(arr);
        perOrder(root);
    }
    public static void perOrder(Node root){
        if(root!=null){
            root.perOrder();
        }else {
            System.out.println("是空树，无需遍历");
        }
    }

    public static Node creatHuffMan(int[] arr){
        //创建一个数组
        ArrayList<Node> nodes = new ArrayList<>();
        //将数组存进list集合里
        for (int val : arr) {
            nodes.add(new Node(val));
        }
        int i=1;
        while (nodes.size()>1) {

            //进行排序
            Collections.sort(nodes);
            System.out.println("nodes=>" + nodes);
            //取出前两个数据
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            //让前两个Node的val相加构成新的父节点的权
            Node parent = new Node(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
            System.out.println("第"+(i++)+"次处理后" + nodes);
        }
        return nodes.get(0);
    }

}
class Node implements Comparable<Node>{
     int val;
     Node left;
     Node right;

    public Node(int val) {
        this.val = val;
    }
    public void perOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.perOrder();
        }
        if(this.right!=null){
            this.right.perOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val-o.val;
    }
}