package cn.com.wudskq.structure1.linkedlist;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName AnnularLinkedList.java
 * @Description TODO 环形链表
 * @createTime 2021年12月02日 01:59:00
 */
public class AnnularLinkedList {

    /* 头部指针 */
    private AnnularLinkedNode front = null;

    /* 尾部指针 */
    private AnnularLinkedNode rear = null;


    /* 添加时使头部指针与尾部指针指向第一个节点 */
    public void add(AnnularLinkedNode node) {
        /* 添加第一个数据时 自身形成 环状 */
        if (null == front && null == rear) {
            /* 头指针 */
            front = node;
            /* 自身形成环状 */
            front.setNext(node);
            /* 尾指针 */
            rear = node;
        }
        while (true) {
            /* 如果尾指针的next指针指向头指针 则为最后一个节点 */
            if (rear.getNext() == front) {
                /* 尾指针next 新添加的数据 */
                rear.setNext(node);
                /* 新添加的数据next指针指向头指针 */
                node.setNext(front);
                /* 尾指针后移 指向新添加的数据 */
                rear = node;
                break;
            }
            rear = rear.getNext();
        }
    }

    /* 遍历 */
    public void list() {
        /* 辅助指针 */
        AnnularLinkedNode temp = front;
        isEmpty();
        while (true) {
            System.out.println(temp);
            /* 临时指针的next指向头指针 则证明已经遍历完 */
            if (temp.getNext() == front) {
                break;
            } else {
                /* 否则后移 */
                temp = temp.getNext();
            }
        }
    }


    /* 判空 */
    public boolean isEmpty() {
        if (null == front) {
            throw new RuntimeException("linekList is empty!");
        }
        return false;
    }


    /**
     * 约瑟夫问题
     * 一个圈 从指定位置n开始数
     * 数m次 数到的那位出列
     * 并且继续数 直到圈里的数据全部出列
     *
     * @param startNum
     * @param countNum
     * @param size
     */
    public void joseph(int startNum, int countNum, int size) {
        isEmpty();
        if (startNum < 1 || startNum > size) {
            throw new RuntimeException("参数非法 请重新输入!");
        }
        /* 创建辅助指针 用于辅助节点出列 */
        AnnularLinkedNode temp = front.getNext();
        /* 找到该环形的最后一个节点 */
        while (true) {
            /* 等于头部指针 证明遍历完成 */
            if (temp.getNext() == front) {
                break;
            }
            /* 指针后移 */
            temp = temp.getNext();
        }
        /* 头尾节点同时移动(startNum-1)次 找到指定位置,而并不是从头节点开始 */
        for (int i = 0; i < startNum - 1; i++) {
            front = front.getNext();
            temp = temp.getNext();
        }
        /* 数据进行出圈 */
        while (true) {
            /* 说明圈中只剩一个数据 */
            if (temp == front) {
                break;
            }
            /* 头尾节点同时向后移动(startNum-1)次 找到出圈的位置*/
            for (int i = 0; i < countNum - 1; i++) {
                front = front.getNext();
                temp = temp.getNext();
            }
            System.out.println("出列的数据" + front);
            /* 头指针指向自己的下一个 */
            front = front.getNext();
            /* 尾指针指向头指针 */
            temp.setNext(front);
        }
        System.out.println("圈中的数据" + temp);
    }
}
