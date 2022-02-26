package queue;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2022年02月27日 00:01:00
 */

public class QueueTest1 {
    // 定义一个队列
    Queue<String> queue;

    @Before
    public void before() {
        // 实例化队列变量
        queue = new LinkedList<String>();
        // add方法向队列中添加元素,返回布尔值，add方法添加失败时会抛异常,不推荐使用
        // queue.add("1");
        // queue.add("2");
        // queue.add("3");
        // queue.add("4");
        // queue.add("5");

        // offer方法向队列中添加元素，返回布尔值
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
    }

    // poll方法移除队列首个元素并返回，若队列为空，返回null
    @Test
    public void test1() {
// 弹出元素
        String pollEle = queue.poll(); // 先进先出,弹出了a
        System.out.println(pollEle); // a
        System.out.println(queue); // [b, c, d, e]
    }

    // remove方法移除首个元素并返回,若队列为空,会抛出异常：NoSuchElementException，不推荐使用
    @Test
    public void test2() {
// 弹出元素
        String remove = queue.remove(); // 先进先出,弹出了a
        System.out.println(remove); // a
        System.out.println(queue); // [b, c, d, e]
    }

    // peek方法返回队列首个元素，但不移除，若队列为空，返回null
    @Test
    public void test3() {
// 查看首个元素
        String peek = queue.peek(); // 首个元素是a,最先加入
        System.out.println(peek); // a
        System.out.println(queue); // [a, b, c, d, e]
    }

    // element方法返回队列的头元素，但不移除，若队列为空，会抛出异常：NoSuchElementException，不推荐使用
    @Test
    public void test4() {
// 查看首个元素
        String element = queue.element();
        System.out.println(element); // a
        System.out.println(queue); // [a, b, c, d, e]
    }


}

