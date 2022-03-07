package cn.com.wudskq.datastructure.linkedlist;

import lombok.Data;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName DoubleNode.java
 * @Description TODO
 * @createTime 2022年03月06日 22:23:00
 */
@Data
public class DoubleNode {

    private int index;

    private Object data;

    private DoubleNode pre;

    private DoubleNode next;

    public DoubleNode(int index,Object data){
        this.index = index;
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "index=" + index +
                ", data=" + data +
                '}';
    }
}
