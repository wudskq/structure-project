package cn.com.wudskq.structure1.linkedlist;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName AnnularLinkedList.java
 * @Description TODO 单向环形链表节点
 * @createTime 2021年12月02日 01:59:00
 */
@Data
public class AnnularLinkedNode implements Serializable {

    private int id;

    private String name;

    private AnnularLinkedNode next;

    public AnnularLinkedNode(int id, String name) {
        this.id = id;
        this.name = name;
        this.next = null;
    }

    @Override
    public String toString() {
        return "AnnularLinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
