package cn.com.wudskq.structure1.stack;

import cn.com.wudskq.structure1.linkedlist.DoubleLinkedNode;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName TestDoubleLinkedList.java
 * @Description TODO
 * @createTime 2021年12月03日 03:28:00
 */

public class TestDoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinkedListStack doubleLinkedListStack = new DoubleLinkedListStack();
        DoubleLinkedNode node1 = new DoubleLinkedNode(1, "第一个节点");
        DoubleLinkedNode node2 = new DoubleLinkedNode(2, "第二个节点");
        DoubleLinkedNode node3 = new DoubleLinkedNode(3, "第三个节点");
        DoubleLinkedNode node4 = new DoubleLinkedNode(4, "第四个节点");

        doubleLinkedListStack.push(node1);
        doubleLinkedListStack.push(node2);
        doubleLinkedListStack.push(node3);
        doubleLinkedListStack.push(node4);
        doubleLinkedListStack.pop();
        doubleLinkedListStack.pop();
        doubleLinkedListStack.pop();
        System.out.println("===");
        doubleLinkedListStack.list();
    }
}
