package cn.com.wudskq.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SingleLinkedList.java
 * @Description TODO 单向链表
 * @createTime 2021年11月28日 20:33:00
 */

public class SingleLinkedList {


    /* 初始化一个头部节点 */
    private LinkedNode headNode = new LinkedNode(0, "头部节点", null);

    /* 单向链表添加节点 */
    public void addNode(LinkedNode node) {
        /* 因为头部节点不能动 就需要一个临时指针用来进行辅助操作 */
        LinkedNode temp = headNode;
        /* 遍历链表 找到最后一个节点 将最后一节点的next指针指向新添加的节点 */
        while (true) {
            /* 代表找到了最后 */
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        /* 当退出while循环时 证明找到了链表的最后 */
        temp.setNext(node);
    }

    /* 遍历单向链表 */
    public void listLinkedList() {
        LinkedNode temp = headNode.getNext();
        /* 判断是否为空 */
        if (!isEmpty()) {
            while (true) {
                /* 说明next指针已无数据 */
                if (null == temp) {
                    break;
                }
                System.out.println(temp);
                /* 将指针后移 输出下一个 */
                temp = temp.getNext();

            }
        }
    }

    /* 判断链表是否为空 */
    public boolean isEmpty() {
        LinkedNode next = headNode.getNext();
        if (null == next) {
            throw new RuntimeException("linkedList is empty!");
        } else {
            return false;
        }
    }


}
