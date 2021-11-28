package cn.com.wudskq.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2021年11月28日 21:23:00
 */
public class Main {
    public static void main(String[] args) {
        /* 实例化单向链表 */
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        /* 添加数据 */
        LinkedNode node1 = new LinkedNode(1, "第一个节点", null);
        LinkedNode node2 = new LinkedNode(2, "第二个节点", null);
        LinkedNode node3 = new LinkedNode(3, "第三个节点", null);
//        singleLinkedList.addNode(node1);
//        singleLinkedList.addNode(node3);
//        singleLinkedList.addNode(node2);
        singleLinkedList.addNodeByOrder(node1);
        singleLinkedList.addNodeByOrder(node3);
        singleLinkedList.addNodeByOrder(node2);
        singleLinkedList.updateNode(new LinkedNode(2,"测试更新是否有效",null));
        singleLinkedList.listLinkedList();

        singleLinkedList.removeNode(1);
        singleLinkedList.removeNode(2);
        singleLinkedList.removeNode(3);
        singleLinkedList.listLinkedList();
    }
}
