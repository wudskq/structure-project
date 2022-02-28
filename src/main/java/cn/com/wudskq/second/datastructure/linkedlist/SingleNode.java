package cn.com.wudskq.second.datastructure.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.soap.Node;
import java.io.Serializable;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SingleNode.java
 * @Description TODO
 * @createTime 2022年03月01日 02:26:00
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SingleNode implements Serializable {

    private Object data;

    private Node  next;
}
