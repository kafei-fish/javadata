package com.lxl.tree;

/**
 * @author MyLong
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        HerNode root=new HerNode(1,"宋江");
        HerNode node2=new HerNode(2,"吴用");
        HerNode node3=new HerNode(3,"卢俊义");
        HerNode node4=new HerNode(4,"林冲");
        HerNode node5=new HerNode(5,"关胜");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
//        System.out.println("前序查找");
//        HerNode h1 = binaryTree.perHerNodeSearch(5);
//        System.out.println(h1);
//        System.out.println("中序查找");
//        HerNode h2 = binaryTree.infixHerNodeSearch(5);
//        System.out.println(h2);
//        System.out.println("后序查找");
//        HerNode h3 = binaryTree.postHerNodeSearch(5);
//        System.out.println(h3);
        //删除节点
        System.out.println("删除前");
        binaryTree.preOrder();
        binaryTree.delNode(5);
        System.out.println("删除后");
        binaryTree.preOrder();
    }
}
class BinaryTree{
    private HerNode root;

    public void setRoot(HerNode root) {
        this.root = root;
    }
    /**
     * 前序遍历
     */
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    public HerNode perHerNodeSearch(int id){
        if(root!=null){
          return root.perHerNodeSearch(id);
        }else {
           return null;
        }
    }
    public HerNode infixHerNodeSearch(int id){
        if(root!=null){
            return root.infixHerNodeSearch(id);
        }else {
            return null;
        }
    }
    public HerNode postHerNodeSearch(int id){
        if(root!=null){
            return root.postHerNodeSearch(id);
        }else {
            return null;
        }
    }
    public void delNode(int id){
        if(root!=null){
            if(root.getId()==id){
                root=null;
            }else {
                root.delNode(id);
            }
        }else {
            System.out.println("二叉树为空，不能删除");
        }
    }
}
class HerNode{
    private int id;
    private String name;
    private HerNode left;
    private HerNode right;

    public HerNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HerNode getLeft() {
        return left;
    }

    public void setLeft(HerNode left) {
        this.left = left;
    }

    public HerNode getRight() {
        return right;
    }

    public void setRight(HerNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HerNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        //输出root节点
        System.out.println(this);
        if (this.left!=null) {
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序查找
     * @param id 查找的id
     * @return 返回查询出的对象
     */
    public HerNode perHerNodeSearch(int id){
        System.out.println("进入前序遍历");
        if(this.id==id){
            return this;
        }
        HerNode resNode=null;
        if(this.left!=null){
            resNode=this.left.perHerNodeSearch(id);
        }
        //如果不为空，说明我们在左子树找到了
        if(resNode!=null){
            return resNode;
        }
        //如果左子树没找到，我们就在右子树上找
        if(this.right!=null){
             resNode = this.right.perHerNodeSearch(id);
        }
        return resNode;
    }

    /**
     * 中序查找
     * @param id 查找的id
     * @return 返回查询对象
     */
    public HerNode infixHerNodeSearch(int id){

        HerNode resNode=null;
        if(this.left!=null){
            resNode=this.left.infixHerNodeSearch(id);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入中序遍历");
        if(this.id==id){
            return this;
        }
        if(this.right!=null){
            resNode=this.right.infixHerNodeSearch(id);
        }
        return resNode;
    }
    public HerNode postHerNodeSearch(int id){

        HerNode resNode=null;
        if(this.left!=null){
            resNode=this.left.postHerNodeSearch(id);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode=this.right.postHerNodeSearch(id);
        }
        if(resNode!=null){
            return resNode;
        }
        System.out.println("进入后序遍历");
        if(this.id==id){
            return this;
        }
        return resNode;
    }
    /**
     * 删除节点
     */
    public void delNode(int id){
        if(left != null && this.left.id==id){
            this.left=null;
            return;
        }
        if(right !=null && this.right.id==id){
            this.right=null;
            return;
        }
        //如果左右都没有查找到，那我们就要进行递归
        if(this.left!=null){
            this.left.delNode(id);
        }
        if(this.right !=null){
            this.right.delNode(id);
        }
    }
    /**
     * 删除节点
     *
     */
    public void delNodeTo(int id){
        if (this.left.left==null&&this.left.right==null&&this.left.id==id){
            this.left=null;
            return;
        }
        if (this.right.left==null&&this.right.right==null&&this.right.id==id){
            this.right=null;
            return;
        }
        HerNode temp;
        if(this.left.left!=null&&this.left.right!=null&&this.left.id==id){
            temp=this.left.left;
            this.left=temp;
            temp.right=this.left.right;

        }
    }
}