package cn.com.wudskq.structure1.stack;

import lombok.Data;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName ArrayStack.java
 * @Description TODO 数组实现栈
 * @createTime 2021年12月03日 02:20:00
 */
@Data
public class ArrayStack {

    /* 定义成员变量 top 作为栈顶 */
    private int top;

    /* 栈的最大容量 */
    private int maxSize;

    /* 栈的实例容器 */
    private int[] array;

    public ArrayStack(int maxSize) {
        /* 初始化时 栈顶无数据 即在栈最底层 */
        this.top = -1;
        this.maxSize = maxSize;
        /* 初始化栈容量 */
        this.array = new int[maxSize];
    }

    /* 入栈 */
    public void push(int data) {
        isFull();
        /* 栈顶上移 */
        top++;
        array[top] = data;
    }

    /* 出栈 */
    public int pop() {
        isEmpty();
        /* 先从栈顶取出数据 */
        int data = array[top];
        /* 栈顶下移 */
        top--;
        System.out.println(data);
        return data;
    }

    /* 遍历栈中的数据 从栈顶开始弹出数据 */
    public void list() {
        isEmpty();
        while (true) {
            /* 说明栈中的数据已经pop完 */
            if (top == -1) {
                break;
            }
            int i = array[top];
            System.out.println(i);
            top--;
        }
    }

    /* 判断栈是否已满 */
    public boolean isFull() {
        /* 栈顶等于最大容量减一 */
        if (top == (maxSize - 1)) {
            throw new RuntimeException("stack is full!");
        }
        return false;
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        /* 栈顶为-1时 */
        if (-1 == top) {
            throw new RuntimeException("stack is empty!");
        }
        return false;
    }
}
