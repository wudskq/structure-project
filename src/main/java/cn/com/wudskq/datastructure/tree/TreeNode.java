package cn.com.wudskq.datastructure.tree;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: TreeNode
 * @projectName structure-project
 * @description: TODO 树节点对象
 * @date 2022/4/2 12:08 AM
 */
@Data
public class TreeNode implements Serializable {

    private Integer id;

    private Object value;

    private TreeNode leftNode;

    private TreeNode rightNode;


    public TreeNode(Integer id,Object value){
        super();
        this.id = id;
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        //先输出父节点
        System.out.println(this);
        //遍历左子树
        if(null != this.leftNode){
            this.leftNode.preOrder();
        }
        //遍历右子树
        if(null != this.rightNode){
            this.rightNode.preOrder();
        }
    }

    //前序查找
    public TreeNode preQuery(int index){
        TreeNode res = null;
        //根节点查找
        if(this.id == index){
            res = this;
        }
        //左子树递归查找
        if(null != this.leftNode && this.leftNode.id != index){
            this.leftNode.preQuery(index);
        }else {
            res = this.leftNode;
        }
        //右子树递归查找
        if(null != this.rightNode && this.rightNode.id != index){
            this.rightNode.preQuery(index);
        }else {
            res = this.rightNode;
        }
        return res;
    }

    //中序遍历
    public void midOrder(){
        //先遍历左子树
        if(null != this.leftNode){
            this.leftNode.midOrder();
        }
        //再输出根节点
        System.out.println(this);
        //再遍历右子树
        if(null != this.rightNode){
            this.rightNode.midOrder();
        }
    }

    //中序查找
    public TreeNode midQuery(int index){
        TreeNode res = null;
        //左子树递归查找
        if(null != this.leftNode && this.leftNode.id != index){
            this.leftNode.midQuery(index);
        }else {
            res = this.leftNode;
        }
        //根节点查找
        if(this.id == index){
            res = this;
        }
        //右子树递归查找
        if(null != this.rightNode && this.rightNode.id != index){
            this.rightNode.midQuery(index);
        }else {
            res = this.rightNode;
        }
        return res;
    }


    //后序遍历
    public void postOrder(){
        //先遍历左子树
        if(null != this.leftNode){
            this.leftNode.midOrder();
        }
        //再遍历右子树
        if(null != this.rightNode){
            this.rightNode.midOrder();
        }
        //再输出根节点
        System.out.println(this);
    }

    //后序查找
    public TreeNode postQuery(int index){
        TreeNode res = null;
        //左子树递归查找
        if(null != this.leftNode && this.leftNode.id != index){
            this.leftNode.postQuery(index);
        }else {
            res = this.leftNode;
        }
        //右子树递归查找
        if(null != this.rightNode && this.rightNode.id != index){
            this.rightNode.postQuery(index);
        }else {
            res = this.rightNode;
        }
        //根节点查找
        if(this.id == index){
            res = this;
        }
        return res;
    }

    //删除
    public void remove(int index){
        //左子节点不为空
        if(null != this.leftNode && this.leftNode.id == index){
            this.leftNode = null;
            return;
        }
        //右子节点不为空
        if(null != this.rightNode && this.rightNode.id == index){
            this.rightNode = null;
            return;
        }
        //左子树
        if(null != this.leftNode){
            this.leftNode.remove(index);

        }
        //右子树
        if(null != this.rightNode){
            this.rightNode.remove(index);
        }
    }



    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
