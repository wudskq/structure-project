package cn.com.wudskq.datastructure.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenfangchao
 * @title: OrderBinaryTree
 * @projectName structure-project
 * @description: TODO 顺序存储二叉树
 * @date 2022/4/4 3:00 AM
 */
public class ArrayBinaryTree {

    Logger logger = LoggerFactory.getLogger(getClass());

    private int[] array;


    public ArrayBinaryTree(int[] array){
        this.array = array;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        arrayBinaryTree.preOrder(0);
        System.out.println("前序遍历完成----");
        arrayBinaryTree.midOrder(0);
        System.out.println("中序遍历完成----");
        arrayBinaryTree.postOrder(0);
        System.out.println("后序遍历完成----");
    }



    //顺序存储二叉树-前序遍历
    public void preOrder(int index){
        if(null == array || array.length ==0){
            logger.error("array is empty!");
        }
        System.out.println(array[index]);
        //向左递归遍历
        if((2 * index + 1) < array.length){
            preOrder(2 * index +1);
        }
        //向右递归遍历
        if((2 * index +2) < array.length){
            preOrder(2 * index +2);
        }
    }


    //顺序存储二叉树-中序遍历
    public void midOrder(int index){
        if(null == array || array.length ==0){
            logger.error("array is empty!");
        }
        //向左递归遍历
        if((2 * index + 1) < array.length){
            preOrder(2 * index +1);
        }
        System.out.println(array[index]);
        //向右递归遍历
        if((2 * index +2) < array.length){
            preOrder(2 * index +2);
        }
    }

    //顺序存储二叉树-后序遍历
    public void postOrder(int index){
        if(null == array || array.length ==0){
            logger.error("array is empty!");
        }
        //向左递归遍历
        if((2 * index + 1) < array.length){
            preOrder(2 * index +1);
        }
        //向右递归遍历
        if((2 * index +2) < array.length){
            preOrder(2 * index +2);
        }
        System.out.println(array[index]);
    }

}
