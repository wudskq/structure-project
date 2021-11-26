package cn.com.wudskq.queue;

import lombok.Data;
import lombok.ToString;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Queue.java
 * @Description TODO 数组实现队列 array implements queue
 * @createTime 2021年11月25日 23:53:00
 */
@Data
@ToString
public class ArrayQueue {
    /* 队列容量 */
    private int maxSize;
    /* 队列头部指针 */
    private int front;
    /* 队列尾部指针 */
    private int rear;
    /* 队列实例化对象 */
    private int[] array;

    /**
     * 初始化队列
     *
     * @param arrayMaxSize
     */
    public ArrayQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        front = -1;
        rear = -1;
        array = new int[maxSize];
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 是否已满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 添加数据
     *
     * @param i
     */
    public void addQueue(int i) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }
        rear++;
        array[rear] = i;
    }

    /**
     * 取出数据
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        front++;
        int i = array[front];
        System.out.println(i);
        return array[front];
    }

    /**
     * 查询头部数据
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        int i = array[front + 1];
        System.out.println(i);
        return array[front + 1];
    }

    /**
     * 展示队列所有数据
     */
    public void listQueue() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }


}
