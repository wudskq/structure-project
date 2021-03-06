package cn.com.wudskq.datastructure.tree;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: BinaryTree
 * @projectName structure-project
 * @description: TODO 二叉树实现
 * @date 2022/4/2 12:45 AM
 */
@Data
public class BinaryTree implements Serializable {

    private BinaryTreeNode root;


    public BinaryTree(){
        root = new BinaryTreeNode(1, "1");
        BinaryTreeNode node1 = new BinaryTreeNode(2, "2");
        BinaryTreeNode node2 = new BinaryTreeNode(3, "3");
        BinaryTreeNode node3 = new BinaryTreeNode(4, "4");
        BinaryTreeNode node4 = new BinaryTreeNode(5, "5");
        root.setLeftNode(node1); root.setRightNode(node2);
        node2.setLeftNode(node3);node2.setRightNode(node4);
        /**
         * 树结构内存图
         *        1
         *    2      3
         *        4    5
         */
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        //前序遍历
        binaryTree.preOrder(); //1,2,3,4,5
        System.out.println("前序遍历完成----");

        //中序遍历
        binaryTree.midOrder(); //2,1,4,3,5
        System.out.println("中序遍历完成----");

        //后序遍历
        binaryTree.postOrder();//2,4,3,5,1
        System.out.println("后序遍历完成----");

        //前序查找
        System.out.println(binaryTree.preQuery(0));
        System.out.println("前序查找完成----");

        //中序查找
        System.out.println(binaryTree.midQuery(1));
        System.out.println("中序查找完成----");

        //后序查找
        System.out.println(binaryTree.postQuery(3));
        System.out.println("后序查找完成----");

        //删除
        binaryTree.remove1(5);
        System.out.println("删除完成----");

        //前序遍历
        binaryTree.preOrder(); //1,2,3,4,5
        System.out.println("前序遍历完成----");

        //中序遍历
        binaryTree.midOrder(); //2,1,4,3,5
        System.out.println("中序遍历完成----");

        //后序遍历
        binaryTree.postOrder();//2,4,3,5,1
        System.out.println("后序遍历完成----");


    }



    //前序遍历
    public void preOrder(){
        if(null != root){
            root.preOrder();
        }else {
           throw new RuntimeException("root is empty!");
        }
    }

    //前序查找
    public BinaryTreeNode preQuery(int index){
        return root.preQuery(index);
    }

    //中序遍历
    public void midOrder(){
        if(null != root){
            root.midOrder();
        }else {
            throw new RuntimeException("root is empty!");
        }
    }

    //中序查找
    public BinaryTreeNode midQuery(int index){
        return root.midQuery(index);
    }

    //后序遍历
    public void postOrder(){
        if(null != root){
            root.postOrder();
        }else {
            throw new RuntimeException("root is empty!");
        }
    }

    //后序查找
    public BinaryTreeNode postQuery(int index){
        return root.postQuery(index);
    }


    //删除节点
    public void  remove(int index){
        //只有根节点情况
        if(null == root.getLeftNode() && null == root.getRightNode()){
            root = null;
        }else {
            root.remove(index);
        }
    }

    //删除节点
    public void  remove1(int index){
        //只有根节点情况
        if(null == root.getLeftNode() && null == root.getRightNode()){
            root = null;
        }else {
            root.remove1(index);
        }
    }

}
