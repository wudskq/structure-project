package cn.com.wudskq.structure1.queue;

import lombok.Data;
import lombok.ToString;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName AnnularArrayQueue.java
 * @Description TODO array implements annular queue 数组实现环形队列
 * @createTime 2021年11月27日 04:11:00
 */
@Data
@ToString
public class AnnularArrayQueue {

    private int front;

    private int rear;

    private int maxSize;

    private int[] array;

    public AnnularArrayQueue(int maxSize) {
        this.front = 0;
        this.rear = 0;
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断是否已满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 新增
     */
    public void addQueue(int i) {
        if (isFull()) {
            throw new RuntimeException("queue is full!");
        }
        array[rear] = i;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("queue is empty!");
        }
        int i = array[this.front];
        front = (front+1)%maxSize;
        return i;
    }


    /**
     * 获取头部
     */
    public int peek(){
        return array[0];
    }

    /**
     * 获取有效值个数
     */
    public int getLength(){
        return (rear-front+maxSize)%maxSize;
    }

    /**
     * 遍历
     */
    public void listQueue(){
        if(isEmpty()){
            throw new RuntimeException("list is empty!");
        }
        for (int i = 0; i <getLength() ; i++) {
            int data = array[front + i];
            System.out.println(data);
        }
    }
}
