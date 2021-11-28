package cn.com.wudskq.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName LinkedNode.java
 * @Description TODO 链表节点
 * @createTime 2021年11月28日 20:58:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedNode {
    private int id;
    private String name;
    private LinkedNode next;

    @Override
    public String toString() {
        return "LinkedNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
