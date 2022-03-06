package cn.com.wudskq.second.datastructure.linkedlist;

import lombok.Data;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName CircularNode.java
 * @Description TODO 单向环形链表
 * @createTime 2022年03月07日 00:40:00
 */
@Data
public class CircularNode {

    private int index;

    private Object data;

    private CircularNode next;

    public CircularNode(int index, Object data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CircularNode{" +
                "index=" + index +
                ", data=" + data +
                '}';
    }
}
