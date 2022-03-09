package cn.com.wudskq.datastructure.stack;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName ArrayImplStack.java
 * @Description TODO 数组实现栈
 * @createTime 2022年03月10日 03:44:00
 */
@Data
public class ArrayImplStack {

    private Object[] array;

    //栈顶
    private int stackTop;

    //栈底
    private int stackBottom;

    //栈容量大小
    private int stackSize;


    public static void main(String[] args) {
        ArrayImplStack stack = new ArrayImplStack(6);
        System.out.println("是否为空"+stack.isEmpty());
        System.out.println("是否已满" + stack.isFull());

        //入栈操作
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        //模拟栈满
//        stack.push(7);

        //取出栈中所有数据
        List<Object> data = stack.getStackALl();

        //出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //模拟栈空
//        System.out.println(stack.pop());

    }


    //初始化栈
    public ArrayImplStack(int size){
        this.stackSize = size;
        array = new Object[stackSize];
        stackTop = -1;
        stackBottom = 0;
    }


    //判断栈中是否有数据
    public Boolean isEmpty(){
        if(stackTop == -1){
            return true;
        }
        return false;
    }

    //判断栈容量是否已满
    //此处若栈顶指针初始化时为0,栈底指针初始化时为0
    //则无法判断栈是否已满还是为空,此处栈顶初始化时设置为-1用来区分
    public Boolean isFull(){
        if(stackTop+1 == stackSize){
            return true;
        }
        return false;
    }

    //入栈
    //入栈时
    public void push(Object data){
        if(isFull()){
            throw new RuntimeException("stack is full!");
        }
        //栈顶上移
        stackTop = (stackTop+1)%stackSize;
        array[stackTop] = data;
    }


    //出栈
    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        Object data = array[stackTop];
        //栈顶下移
        stackTop = (stackTop-1)%stackSize;
        return data;
    }

    //获取栈中所有数据
    //此操作仅仅是获取数据,不能实际移动栈顶指针
    public List<Object> getStackALl(){
        //定义辅助指针,遍历完数据后,
        int pointer = stackTop;
        if(isEmpty()){
            throw new RuntimeException("stack is empty!");
        }
        ArrayList<Object> data = new ArrayList<>();
        for (int i = 0; i < stackSize ; i++) {
            Object temp = array[stackTop];
            //取出数据后,栈顶指针下移
            stackTop = (stackTop-1)%stackSize;
            data.add(temp);
        }
        //复原栈顶指针位置
        stackTop = pointer;
        return data;
    }


}
