package cn.com.wudskq.datastructure.avlrtree;

import lombok.Data;

/**
 * @author chenfangchao
 * @title: BinarySortTreeNode
 * @projectName structure-project
 * @description: TODO AVL排序树节点
 * @date 2022/5/3 3:54 AM
 */
@Data
public class AVLTreeNode {

    private int value;

    private AVLTreeNode left;

    private AVLTreeNode right;

    public AVLTreeNode(int value) {
        this.value = value;
    }

    //递归添加节点(需要满足二叉排序树约定)
    public void  add(AVLTreeNode node){
        if(node == null){
            return;
        }
        //添加节点小于当前节点
        //指针往左边挂
        if(node.value < this.value){
            if(this.left == null){
                this.left = node;
            }else {
               this.left.add(node);
            }
        //节点大于当前节点 指针往右边挂
        }else{
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void midOrder(){
        if(this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.midOrder();
        }
    }


    @Override
    public String toString() {
        return "BinarySortTreeNode{" +
                "value=" + value +
                '}';
    }
}
