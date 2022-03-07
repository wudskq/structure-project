package cn.com.wudskq.datastructure.linkedlist;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SingleNode.java
 * @Description TODO
 * @createTime 2022年03月01日 02:26:00
 */
@Data
public class SingleNode implements Serializable {

    private int index;

    private Object data;

    private SingleNode  next;

    public SingleNode(int index, Object data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public String toString() {
        return "SingleNode{" +
                "index=" + index +
                ", data=" + data +
                '}';
    }
}
