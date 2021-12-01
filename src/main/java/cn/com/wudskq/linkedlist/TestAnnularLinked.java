package cn.com.wudskq.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2021年11月28日 21:23:00
 */
public class TestAnnularLinked {

    public static void main(String[] args) {
        /* 实例化环形链表 */
        AnnularLinkedList annularLinkedList = new AnnularLinkedList();
        /* 添加数据 */
        AnnularLinkedNode node1 = new AnnularLinkedNode(1, "第一个节点");
        AnnularLinkedNode node2 = new AnnularLinkedNode(2, "第二个节点");
        AnnularLinkedNode node3 = new AnnularLinkedNode(3, "第三个节点");
        AnnularLinkedNode node4 = new AnnularLinkedNode(4, "第四个节点");
        AnnularLinkedNode node5 = new AnnularLinkedNode(5, "第五个节点");
        AnnularLinkedNode node6 = new AnnularLinkedNode(6, "第六个节点");

        annularLinkedList.add(node1);
        annularLinkedList.add(node2);
        annularLinkedList.add(node3);
        annularLinkedList.add(node4);
        annularLinkedList.add(node5);

        annularLinkedList.list();

        /* 2-4-1-5-3 */
        annularLinkedList.joseph(1,2,5);

    }
}
