package cn.com.wudskq.datastructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName ArrayImplAnnularQueue.java
 * @Description TODO 环形数组实现环形队列
 * @createTime 2022年02月28日 01:28:00
 */

public class ArrayImplAnnularQueue {

    private int[] array;

    private int front;

    private int rear;

    private int maxSize;


    public static void main(String[] args) {
        ArrayImplAnnularQueue queue = new ArrayImplAnnularQueue(10);

        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        queue.addQueue(5);
        queue.addQueue(6);
        queue.addQueue(7);
        queue.addQueue(8);
        queue.addQueue(9);
        queue.getQueue();
        queue.addQueue(10);
       queue.listQueue();


    }



    //初始化队列
    public ArrayImplAnnularQueue(int arrayMaxSize){
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否为空
    private Boolean isEmpty(){
        if(front == rear){
            throw new RuntimeException("queue is empty!");
        }
        return true;
    }


    //判断队列是否已满
    private Boolean isFull(){
        if((rear + 1) % maxSize == front){
            throw new RuntimeException("queue is full!");
        }
        return false;
    }

    //入队
    private void addQueue(int data){
        isFull();
        array[rear] = data;
        rear = (rear+1)%maxSize;
    }

    //出队
    private int getQueue(){
        isEmpty();
        int i = array[front];
        front = (front+1)%maxSize;
        return i;
    }

    //展示所有数据
    private List<Integer> listQueue(){
        ArrayList<Integer> list = new ArrayList<>();
        isEmpty();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

}

