package cn.com.wudskq.structure1.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName LinkedNode.java
 * @Description TODO 链表节点 双向链表节点
 * @createTime 2021年11月28日 20:58:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoubleLinkedNode {
    private int id;
    private String name;
    private DoubleLinkedNode pre;
    private DoubleLinkedNode next;

    public DoubleLinkedNode(int id,String name){
        this.id = id;
        this.name = name;
        pre = null;
        next = null;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
