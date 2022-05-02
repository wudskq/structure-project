package cn.com.wudskq.datastructure.avlrtree;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenfangchao
 * @title: AVLTree
 * @projectName structure-project
 * @description: TODO AVL二叉平衡树
 * @date 2022/5/3 3:56 AM
 */
public class AVLTree {

    Logger logger = LoggerFactory.getLogger(getClass());

    private AVLTreeNode root;

    static int[] array = {7,2,10,12,5,1,9};
    //内存结构图
    /**
     *        7
     *    2      10
     * 1    5  9    12
     *
     */

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        //添加数据
        for (int a = 0; a < array.length; a++) {
            AVLTreeNode node = new AVLTreeNode(array[a]);
            avlTree.add(node);
        }
        //中序遍历
        avlTree.midOrder();
    }



    //添加节点
    public void  add(AVLTreeNode node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    //中序遍历
    public void  midOrder(){
        if(root != null){
            root.midOrder();
        }else {
            logger.info("current is empty!");
        }
    }
}
