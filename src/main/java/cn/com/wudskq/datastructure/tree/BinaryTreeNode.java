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
public class BinaryTreeNode implements Serializable {

    private Integer id;

    private Object value;

    //左指针
    private BinaryTreeNode leftNode;

    //右指针
    private BinaryTreeNode rightNode;

    //左指针类型 0为左子树 1为前驱节点
    private int leftNodeType;

    //右指针类型 0为右子树 1为后继节点
    private int rightNodeType;


    public BinaryTreeNode(Integer id, Object value){
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
    public BinaryTreeNode preQuery(int index){
        BinaryTreeNode res = null;
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
    public BinaryTreeNode midQuery(int index){
        BinaryTreeNode res = null;
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
    public BinaryTreeNode postQuery(int index){
        BinaryTreeNode res = null;
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

    //约定: 如果是叶子节点直接删除 如果是非叶子节点直接删除该非叶子节点的子树(包含该节点本身)
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

    //约定: 如果是叶子节点直接删除
    //如果是非叶子节点不能删除该非叶子节点的子树,只单独删除该节点,并且左叶子节点上一到删除节点位置,
    //删除
    public void remove1(int index){
        //左子节点不为空
        if(null != this.leftNode && this.leftNode.id == index){
            //该节点左子节点或者右子节点不为空
            if(this.leftNode.leftNode != null){
                //获取右叶子节点
                BinaryTreeNode rightNode = this.rightNode.rightNode;
                this.leftNode = this.leftNode.leftNode;
                //重新链接右叶子节点
                this.leftNode.rightNode = rightNode;
                return;
            }else if(this.leftNode.rightNode != null) {
                //获取左叶子节点
                BinaryTreeNode leftNode = this.rightNode.leftNode;
                this.leftNode = this.leftNode.rightNode;
                //重新链接左叶子节点
                this.rightNode.leftNode = leftNode;
                return;
            }
        }
        //右子节点不为空
        if(null != this.rightNode && this.rightNode.id == index){
            //该节点左子节点或者右子节点不为空
            if(this.rightNode.leftNode != null){
                //获取右叶子节点
                BinaryTreeNode rightNode = this.rightNode.rightNode;
                this.rightNode = this.rightNode.leftNode;
                //重新链接右叶子节点
                this.rightNode.rightNode = rightNode;
                return;
            }else if(this.rightNode.rightNode != null) {
                //获取左叶子节点
                BinaryTreeNode leftNode = this.rightNode.leftNode;
                this.rightNode = this.rightNode.rightNode;
                //重新链接左叶子节点
                this.rightNode.leftNode = leftNode;
                return;
            }
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
