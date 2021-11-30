package cn.com.wudskq.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName LinkedNode.java
 * @Description TODO 链表节点 单向链表节点
 * @createTime 2021年11月28日 20:58:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleLinkedNode {
    private int id;
    private String name;
    private SingleLinkedNode next;

    public SingleLinkedNode(int id,String name){
        this.id = id;
        this.name = name;
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
