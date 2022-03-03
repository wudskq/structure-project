package cn.com.wudskq.second.datastructure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
