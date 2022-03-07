package cn.com.wudskq.structure1.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName DoubleLinkedList.java
 * @Description TODO 双向链表
 * @createTime 2021年12月01日 00:59:00
 */

public class DoubleLinkedList {

    /* 头部节点 */
    private DoubleLinkedNode headNode = new DoubleLinkedNode(0, "");


    /* 添加 */
    public void add(DoubleLinkedNode node) {
        /* 辅助指针 */
        DoubleLinkedNode temp = headNode;
        while (true) {
            /* 证明已经找到最后一个节点 */
            if (null == temp.getNext()) {
                break;
            }
            temp = temp.getNext();
        }
        /* 最后一个节点添加next指针 */
        temp.setNext(node);
        /* 新节点添加pre指针 */
        node.setPre(temp);
    }

    /* 有排序功能的添加 */
    public void addByOrder(DoubleLinkedNode node) {
        DoubleLinkedNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (null == temp.getNext()) {
                break;
            }
            /* 说明找到前一个节点temp,后一个节点temp.getNext() */
            if (node.getId() < temp.getNext().getId()) {
                break;
            }
            if (node.getId() == temp.getNext().getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            throw new RuntimeException("node is exist!");
        } else {
            /* 新节点的next指针为前一个节点的next指针 */
            node.setNext(temp.getNext());
            /* 前一个节点的next指针为新节点 */
            temp.setNext(node);
            /* 新节点的pre指针为前一个节点 */
            node.setPre(temp);
        }
    }


    /* 更新 */
    public void update(DoubleLinkedNode node) {
        isEmpty();
        /* 辅助指针 */
        DoubleLinkedNode temp = headNode;
        boolean flag = false;
        while (true) {
            if (null == temp.getNext()) {
                break;
            }
            /* 证明已经找到 */
            if (node.getId() == temp.getNext().getId()) {
                flag = true;
                break;
            }
            /* 指针后移 */
            temp = temp.getNext();
        }
        if (flag) {
            temp.getNext().setName(node.getName());
        } else {
            throw new RuntimeException("update node is not exist!");
        }
    }

    /* 删除 */
    public void remove(int index) {
        isEmpty();
        /* 辅助指针 */
        DoubleLinkedNode temp = headNode.getNext();
        boolean flag = false;
        while (true) {
            if (null == temp) {
                break;
            }
            /* 证明已经找到 */
            if (temp.getId() == index) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            /* 删除节点的前一个节点的next指针指向要删除节点的next指针 */
            temp.getPre().setNext(temp.getNext());
            /* 避免删除节点为最后一个节点时 NEP 问题 */
            if (null != temp.getNext()) {
                /* 删除节点的后一个节点的pre指针指向要删除节点前一个节点 */
                temp.getNext().setPre(temp.getPre());
            }
        } else {
            throw new RuntimeException("delete node is not exist!");
        }
    }


    /* 遍历链表 从前往后遍历*/
    public void list() {
        isEmpty();
        /* 辅助指针 */
        DoubleLinkedNode temp = headNode;
        while (true) {
            if (null == temp.getNext()) {
                break;
            }
            System.out.println(temp.getNext());
            /* 输出后指针后移 */
            temp = temp.getNext();
        }
    }

    /* 判断是否为空 */
    public boolean isEmpty() {
        /* 辅助指针 */
        DoubleLinkedNode temp = headNode;
        /* 尾部指针为空 */
        if (null == temp.getNext()) {
            throw new RuntimeException("linkedList is empty!");
        } else {
            return false;
        }
    }

}
