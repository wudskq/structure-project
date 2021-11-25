package cn.com.wudskq.queue;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2021年11月25日 23:58:00
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(6);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(3);
        int queue = arrayQueue.getQueue();
        int queue1 = arrayQueue.getQueue();
        arrayQueue.peek();

    }
}
