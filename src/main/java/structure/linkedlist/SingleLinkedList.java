package cn.com.wudskq.structure1.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SingleLinkedList.java
 * @Description TODO 单向链表
 * @createTime 2021年11月28日 20:33:00
 */

public class SingleLinkedList {


    /* 初始化一个头部节点 */
    private SingleLinkedNode headNode = new SingleLinkedNode(0, "头部节点", null);

    /* 单向链表添加节点 */
    public void addNode(SingleLinkedNode node) {
        /* 因为头部节点不能动 就需要一个临时指针用来进行辅助操作 */
        SingleLinkedNode temp = headNode;
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

    /* 单向链表添加节点 有自动排序功能 */
    public void addNodeByOrder(SingleLinkedNode node) {
        /* 获取头部节点指针 */
        SingleLinkedNode temp = headNode;
        /* 标识位 添加的编号是否存在 默认为false */
        boolean flag = false;
        while (true) {
            /* 说明next指针已无数据 temp为最后节点 */
            if (null == temp.getNext()) {
                break;
            }
            /* 如果要插入的节点小于temp节点下一个指针的id 说明已找到temp */
            if (node.getId() < temp.getNext().getId()) {
                break;
            } else if (node.getId() == temp.getNext().getId()) {
                /* 说明该节点已存在 */
                flag = true;
                break;
            }
            /* 条件都不成立 temp指针后移 */
            temp = temp.getNext();
        }
        if (flag) {
            throw new RuntimeException(temp.getNext() + " node is exist!");
        } else {
            /* 新节点 next指向 temp.next及节点 */
            node.setNext(temp.getNext());
            /* temp next指向新节点 */
            temp.setNext(node);
        }

    }

    /**
     * 根据新节点的ID进行修改原有节点的数据
     *
     * @param node
     */
    public void updateNode(SingleLinkedNode node) {
        isEmpty();
        SingleLinkedNode temp = headNode;
        boolean flag = false;
        while (true) {
            /* 说明已经遍历完链表 */
            if (null == temp.getNext()) {
                break;
            }
            /* 如果temp的next指针的id等于新加node的id 说明找到了 */
            if (temp.getNext().getId() == node.getId()) {
                flag = true;
                break;
            }
            /* 条件不满足 指针后移 */
            temp = temp.getNext();
        }
        if (flag) {
            temp.getNext().setName(node.getName());
        } else {
            throw new RuntimeException("node is not exist!");
        }
    }


    /* 单向链表删除节点 */
    public void removeNode(int index) {
        isEmpty();
        SingleLinkedNode temp = headNode;
        boolean flag = false;
        while (true) {
            /* 该链表已经遍历完 */
            if (null == temp.getNext()) {
                break;
            }
            /* 表示已经找到需要删除的节点 */
            if (temp.getNext().getId() == index) {
                flag = true;
                break;
            }
            /* 条件都不满足 则节点指针后移 */
            temp = temp.getNext();
        }
        if (flag) {
            /* 要删除的节点的上一个节点的next指针指向要删除的节点的next指针 */
            temp.setNext(temp.getNext().getNext());
        } else {
            throw new RuntimeException("delete node is not exist!");
        }
    }

    /* 遍历单向链表 */
    public void listLinkedList() {
        /* 获取头部节点的next指针 */
        SingleLinkedNode temp = headNode.getNext();
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
        SingleLinkedNode next = headNode.getNext();
        if (null == next) {
            throw new RuntimeException("linkedList is empty!");
        } else {
            return false;
        }
    }


}
