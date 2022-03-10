package cn.com.wudskq.datastructure.linkedlist.question;

import cn.com.wudskq.datastructure.linkedlist.CircularLinkedList;
import cn.com.wudskq.datastructure.linkedlist.CircularNode;
import cn.com.wudskq.datastructure.linkedlist.CircularHeadNodeLinkedList;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Josephus.java
 * @Description TODO 约瑟夫问题
 * @createTime 2022年03月07日 01:57:00
 */

public class Josephus {

    public static void main(String[] args) {
        CircularLinkedList circularHeadNodeLinkedList = new CircularLinkedList();

        CircularNode node1 = new CircularNode(0, "0");
        CircularNode node2 = new CircularNode(1, "1");
        CircularNode node3 = new CircularNode(2, "2");
        CircularNode node4 = new CircularNode(3, "3");
        CircularNode node5 = new CircularNode(4, "4");

        //添加数据
        circularHeadNodeLinkedList.addCircularNode(node1);
        circularHeadNodeLinkedList.addCircularNode(node2);
        circularHeadNodeLinkedList.addCircularNode(node3);
        circularHeadNodeLinkedList.addCircularNode(node4);
        circularHeadNodeLinkedList.addCircularNode(node5);


        circularHeadNodeLinkedList.josePhus(3, 2);

    }
}
