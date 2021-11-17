package com.lxl.tree;

import org.junit.Test;

import java.nio.file.ClosedWatchServiceException;
import java.util.*;

/**
 * 赫夫曼压缩
 * @author MyLong
 */
public class HuffmanCompressionDemo {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length);
        byte[] zip = huffmanZip(contentBytes);
        System.out.println("huffmanZip=>"+Arrays.toString(zip)+"长度=>"+zip.length);
    }

    /**
     * 把所以的方法都合并成一个方法
     * @param contentBytes
     * @return
     */
    public static byte[] huffmanZip(byte[] contentBytes){
        List<NodeTwo> nodes = getNodes(contentBytes);
        NodeTwo nodeTwo = creatHuffmanTree(nodes);
        Map<Byte, String> code = getCode(nodeTwo);
        byte[] zip = zip(contentBytes, code );
        return zip;
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

    /**
     * 赫夫曼压缩
     * @param bytes 字节数组
     * @param huffmanCodes map集合
     * @return 返回一个已经处理完毕的字符数组
     */
    public static byte[] zip(byte[] bytes,Map<Byte,String > huffmanCodes){
        StringBuilder stringBuilder=new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));

        }
        //判断长度取模8是否为0
        int len;
        if(stringBuilder.length()%8==0){
            //如果为0就除8
            len=stringBuilder.length()/8;
        }else {
            //否则就除8之后+1；
            len=stringBuilder.length()/8+1;
        }
        //初始化字符数组的长度
        byte[] huffmanCodeBytes=new byte[len];
        //设置一个下标
        int index=0;
        //遍历StringBuufer，设置步长为8
        for(int i=0;i<stringBuilder.length();i+=8){
            //设置一个字符串用来接受拼接完成的字符字符串
            String strByte;
            //如果i+8大于字符包装流的长度，设置返回一个新的 String ，其中包含此字符序列中当前包含的字符的子序列。
            if(i+8>stringBuilder.length()){
                strByte=stringBuilder.substring(i);
            }else {
                //否则就返回字符串中的8ge
                strByte=stringBuilder.substring(i,i+8);
            }
            //然后将使用Interger.parseInt将二进制转换成十进制
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
            //index++ 每次+1
            index++;
        }
        return huffmanCodeBytes;
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