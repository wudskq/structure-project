package cn.com.wudskq.datastructure.tree;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @title: TreeNode
 * @projectName structure-project
 * @description: TODO 节点对象
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


    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
