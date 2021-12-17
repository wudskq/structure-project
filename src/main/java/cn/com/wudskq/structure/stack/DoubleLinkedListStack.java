package cn.com.wudskq.structure.stack;

import cn.com.wudskq.structure.linkedlist.DoubleLinkedNode;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName LinkedListStack.java
 * @Description TODO 双向链表实现栈
 * @createTime 2021年12月03日 03:07:00
 */

public class DoubleLinkedListStack {

    /* 定义head节点 */
    private DoubleLinkedNode headNode = new DoubleLinkedNode(0, "");


    /* 入栈 操作 使用头插法 */
    public void push(DoubleLinkedNode node) {
        /* 辅助指针 */
        DoubleLinkedNode temp = headNode;
        /* 循环 查找最前一个节点 */
        while (true) {
            /* 找到最前一个节点 */
            if (null == temp.getPre()) {
                break;
            }
            /* 指针前移 */
            temp = temp.getPre();
        }
        /* 新节点next指针指向找到的最前节点 */
        node.setNext(temp);
        /* 最前节点的pre指针指向新节点 */
        temp.setPre(node);
    }


    /* 出栈 */
    public DoubleLinkedNode pop() {
        isEmpty();
        /* 获取到最前节点 即要出栈的数据 */
        DoubleLinkedNode preNode = getPreNode();
        /* 获取到最前节点到next指针引用 置空pre指针  */
        DoubleLinkedNode data = preNode.getNext();
        /* 数据出栈后 移除引用 */
        preNode.setNext(null);
        data.setPre(null);
        System.out.println(preNode);
        return data;
    }


    /* 遍历 */
    public void list() {
        isEmpty();
        /* 找到最前节点 */
        DoubleLinkedNode preNode = getPreNode();
        /* 正序遍历 */
        while (true) {
            /* 遍历完成 */
            if (null == preNode.getNext()) {
                break;
            }
            System.out.println(preNode);
            /* 最前一个节点 指针后移 */
            preNode = preNode.getNext();
        }
    }


    /* 获取到最前节点 */
    public DoubleLinkedNode getPreNode() {
        isEmpty();
        DoubleLinkedNode temp = headNode;
        while (true) {
            /* 找到最前节点 */
            if (null == temp.getPre()) {
                break;
            }
            temp = temp.getPre();
        }
        return temp;
    }


    /* 判断是否为空 */
    public boolean isEmpty() {
        if (null == headNode.getPre()) {
            throw new RuntimeException("stack is empty!");
        }
        return false;
    }
}
