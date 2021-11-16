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
    }
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
    public static void perOrder(NodeTwo nodeTwo){
        if(nodeTwo!=null){
           nodeTwo.perOrder();
        }else {
            System.out.println("树空");
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