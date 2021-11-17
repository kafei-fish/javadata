package com.lxl.tree;

import java.nio.file.ClosedWatchServiceException;
import java.util.*;

/**
 * @author MyLong
 */
public class HuffmanCompressionDemo {
    public static void main(String[] args) {
        String content="i like like like java do you like java";
        byte[] contentBytes = content.getBytes();
        List<NodeTwo> nodes = getNodes(contentBytes);
        System.out.println("nodes"+nodes);
        NodeTwo nodeTwo = creatHuffmanTree(nodes);
        perOrder(nodeTwo);

        getCode(nodeTwo,"",stringBuilder);
        System.out.println("生成的赫夫曼编码表"+huffmanCodes);

    }

    /**
     * 获取node结点的data和val
     * @param bytes 字符数组
     * @return 存储字符和其个数的list集合
     */
    public static List<NodeTwo> getNodes(byte[] bytes){
        List<NodeTwo> nodes=new ArrayList<>();
        Map<Byte,Integer> counts=new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if(count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new NodeTwo(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    /**
     * 创建一个赫夫曼编码树
     * @param nodes list集合
     * @return 根节点
     */
    public static NodeTwo creatHuffmanTree(List<NodeTwo> nodes){
       while (nodes.size()>1){
           Collections.sort(nodes);
           NodeTwo nodeLeft = nodes.get(0);
           NodeTwo nodeRight = nodes.get(1);
           NodeTwo parents = new NodeTwo(null, nodeLeft.weight + nodeRight.weight);
           parents.left=nodeLeft;
           parents.right=nodeRight;

           nodes.remove(nodeLeft);
           nodes.remove(nodeRight);

           nodes.add(parents);
       }
       return nodes.get(0);
    }

    /**
     * 前序遍历
     * @param nodeTwo 结点
     */
    public static void perOrder(NodeTwo nodeTwo){
        if(nodeTwo!=null){
           nodeTwo.perOrder();
        }else {
            System.out.println("树空");
        }
    }
    //首先创建一个map集合用来存储编码表
    static Map<Byte,String> huffmanCodes=new HashMap<>();
    static StringBuilder stringBuilder=new StringBuilder();

    /**
     * 重载规则：**必须具有不同的参数列表； 可以有不同的返回类型；可以有不同的访问修饰符；可以抛出不同的异常。
     * @param root 根节点
     * @return 返回存储的赫夫曼树编码表
     */
    public static Map<Byte,String > getCode(NodeTwo root){
        if(root==null){
            return null;
        }
        getCode(root.left,"0",stringBuilder);
        getCode(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    /**
     * 赫夫曼编码表
     * @param node 结点
     * @param code 字符串
     * @param stringBuilder 用于拼接字符串
     */
    public static void getCode(NodeTwo node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1=new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node!=null){
            //非叶子节点
            if(node.data==null){
                getCode(node.left,"0",stringBuilder1);
                getCode(node.right,"1",stringBuilder1);
            }else {
                huffmanCodes.put(node.data,stringBuilder1.toString());
            }
        }
    }
}
class NodeTwo implements Comparable<NodeTwo>{
    Byte data;
    int weight;
    NodeTwo left;
    NodeTwo right;

    public NodeTwo(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NodeTwo{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(NodeTwo o) {
        return this.weight-o.weight;
    }

    /**
     * 前序遍历方法
      */
    public void perOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.perOrder();
        }
        if(this.right!=null){
            this.right.perOrder();
        }
    }
}