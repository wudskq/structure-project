package cn.com.wudskq.datastructure.tree;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenfangchao
 * @title: ThreadedBinaryTree
 * @projectName structure-project
 * @description: TODO 线索化二叉树(中序线索二叉树)
 * @date 2022/4/8 2:13 AM
 */
@Data
public class ThreadedBinaryTree {

    static  final Logger logger = LoggerFactory.getLogger(ThreadedBinaryTree.class);

    private BinaryTreeNode root;

    //创建辅助指针 用来存储该节点的前驱节点
    private BinaryTreeNode preNode;

    static int[] array = {8,3,10,1,14,6};

    public ThreadedBinaryTree(){
        root = new BinaryTreeNode(1, "1");
        BinaryTreeNode node1 = new BinaryTreeNode(3, "3");
        BinaryTreeNode node2 = new BinaryTreeNode(6, "6");
        BinaryTreeNode node3 = new BinaryTreeNode(8, "8");
        BinaryTreeNode node4 = new BinaryTreeNode(10, "10");
        BinaryTreeNode node5 = new BinaryTreeNode(14, "14");
        root.setLeftNode(node1); root.setRightNode(node2);
        node1.setLeftNode(node3);node1.setRightNode(node4);
        node2.setLeftNode(node5);
        /**
         * 树结构内存图
         *        1
         *    3        6
         *  8  10   14
         */
    }

    public static void main(String[] args) {
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        BinaryTreeNode root = threadedBinaryTree.getRoot();
        logger.info("中序遍历");
        //中序遍历
        threadedBinaryTree.midOrder();
        logger.info("中序线索化");
        //中序线索化
        threadedBinaryTree.threadedNode(root);
        System.out.println();
        logger.info("中序线索化遍历");
        threadedBinaryTree.threadedList();

    }


    //中序线索化方法
    public void threadedNode(BinaryTreeNode node){
        if(null == node){
           return;
        }
        //线索化左子树
        threadedNode(node.getLeftNode());
        //线索化当前节点
        if(node.getLeftNode() == null){
            node.setLeftNode(preNode);
            //修改当前指针类型为前驱节点
            node.setLeftNodeType(1);
        }
        if(preNode != null && preNode.getRightNode() == null){
            //指向后继节点
            preNode.setRightNode(node);
            preNode.setRightNodeType(1);
        }
        //每处理一个节点后,使得当前节点node为上一个节点的前驱节点
        preNode = node;
        //线索化右子树
        threadedNode(node.getRightNode());
    }

    //中序线索化遍历
    public void threadedList(){
        //创建辅助变量 存储当前遍历的节点,从root开始
        BinaryTreeNode node = root;
        while (null != node){
            //循环找到leftType=1的节点
            //后面随着遍历而变化,当leftType=1时,说明该节点是线索化的
            while (node.getLeftNodeType() == 0){
                node = node.getLeftNode();
            }
            //等于1打印节点
            System.out.println(node);
            //如果当前节点的右指针指向后继节点,则一直输出
            while (node.getRightNodeType() ==1){
                //获取到当前节点的后继节点
                node = node.getRightNode();
                System.out.println(node);
            }
            //替换这个遍历的节点
            node = node.getRightNode();
        }
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
