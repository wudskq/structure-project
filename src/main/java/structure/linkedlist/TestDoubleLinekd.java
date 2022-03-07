package cn.com.wudskq.structure1.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName TestDoubleLinekd.java
 * @Description TODO 测试双向链表增删改查
 * @createTime 2021年12月01日 01:42:00
 */
public class TestDoubleLinekd {

    public static void main(String[] args) {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        DoubleLinkedNode node1 = new DoubleLinkedNode(1, "第一个节点");
        DoubleLinkedNode node2 = new DoubleLinkedNode(2, "第二个节点");
        DoubleLinkedNode node3 = new DoubleLinkedNode(3, "第三个节点");
        DoubleLinkedNode node4 = new DoubleLinkedNode(4, "第四个节点");

        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);
        doubleLinkedList.list();

        doubleLinkedList.update(new DoubleLinkedNode(2,"二二"));
        doubleLinkedList.list();

        doubleLinkedList.remove(2);
        doubleLinkedList.list();

    }
}
