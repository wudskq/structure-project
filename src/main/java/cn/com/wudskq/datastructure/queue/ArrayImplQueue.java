package cn.com.wudskq.datastructure.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName ArrayImplQueue.java
 * @Description TODO 数组实现队列
 * @createTime 2022年02月26日 19:49:00
 */
@Slf4j
public class ArrayImplQueue {
    //队列
    private static int[] array;
    //头指针
    private static int front;
    //尾指针
    private static int rear;
    //最大容量
    private static int maxSize;

    public static void main(String[] args) {
        ArrayImplQueue queue = new ArrayImplQueue(10);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        queue.addQueue(6);
        queue.addQueue(7);
        queue.addQueue(8);
        queue.addQueue(9);
        queue.addQueue(10);
        System.out.println(queue.getQueue());
        List<Integer> list = queue.listQueue();
        queue.addQueue(11);
    }


    //初始化队列
    public ArrayImplQueue(int arrayMaxSize){
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为空
    public void isEmpty(){
        //头部指针与尾部指针相等时,队列位空
        if(front == rear){
           throw new RuntimeException("queue is empty!");
        }
    }


    //判断队列是否已满
    public void isFull(){
        //尾部指针与最大容量减1相等时,队列已满
        if(rear == maxSize -1){
            throw new RuntimeException("queue is full!");
        }
    }

    //添加数据
    public void addQueue(int data){
        //添加数据时判断队列是否已满
        isFull();
        //尾指针后移
        rear++;
        array[rear] = data;
    }

    //取出数据
    public  int getQueue(){
        //取出数据时判断队列是否为空
        isEmpty();
        //头指针后移
        front++;
        int data = array[front];
        return data;
    }

    //取出队列所有数据
    public List<Integer> listQueue(){
        isEmpty();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int item = array[i];
            list.add(item);
        }
        return list;
    }

    //取出队列头部数据
    public int getQueueFront(){
        isEmpty();
        int data = array[0];
        return data;
    }

    //取出队列尾部数据
    private int getQueueRear(){
        isEmpty();
        int i = array[rear];
        return i;
    }

}
