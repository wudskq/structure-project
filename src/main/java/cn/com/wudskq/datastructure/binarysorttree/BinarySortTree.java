package cn.com.wudskq.datastructure.binarysorttree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenfangchao
 * @title: BinaySortTree
 * @projectName structure-project
 * @description: TODO 二叉排序树
 * @date 2022/4/10 9:27 PM
 */
public class BinarySortTree {

    Logger logger = LoggerFactory.getLogger(getClass());

    private BinarySortTreeNode root;

    static int[] array = {7,2,2,10,12,5,1,9};
    //内存结构图
    /**
     *        7
     *    2      10
     * 1    5  9    12
     *
     */

    public static void main(String[] args) {
        BinarySortTree binarySortTree = new BinarySortTree();
        //添加数据
        for (int a = 0; a < array.length; a++) {
            BinarySortTreeNode node = new BinarySortTreeNode(array[a]);
            binarySortTree.add(node);
        }
        //中序遍历
        binarySortTree.midOrder();
    }



    //添加节点
    public void  add(BinarySortTreeNode node){
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

