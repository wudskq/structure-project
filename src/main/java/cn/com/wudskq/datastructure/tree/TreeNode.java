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

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
