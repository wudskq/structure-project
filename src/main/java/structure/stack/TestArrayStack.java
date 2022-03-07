package cn.com.wudskq.structure1.stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName TestArrayStack.java
 * @Description TODO
 * @createTime 2021年12月03日 02:50:00
 */
public class TestArrayStack {

    private final static Logger logger = LoggerFactory.getLogger(TestArrayStack.class);

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(6);
        logger.info("入栈");
        /* 入栈 */
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        logger.info("出栈");
        /* 出栈 */
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        logger.info("遍历栈数据");
//        arrayStack.list();
    }
}
