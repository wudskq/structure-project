package cn.com.wudskq.datastructure.stack;

import java.text.MessageFormat;
import java.util.*;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName InfixToSuffix.java
 * @Description TODO 中缀表达式转后缀表达式(逆波兰表达式)
 * @createTime 2022年03月11日 09:55:00
 */

public class InfixToSuffix {

    //运算符优先级
    private HashMap<String, Integer> hashMap;

    //运算符栈
    private Stack<String> operatorStack;


    public InfixToSuffix() {
        //初始化优先级
        this.hashMap = new HashMap<>();
        //初始化栈
        this.operatorStack = new Stack<String>();
        hashMap.put("+", 0);
        hashMap.put("-", 0);
        hashMap.put("*", 1);
        hashMap.put("/", 1);
        hashMap.put("(", 2);
        hashMap.put(")", 3);
    }


    public static void main(String[] args) {
        //eg:
        //中缀表达式： 1+2*3+(4*5+6)*7 对应的后缀表示式 a b c * + d e * f  + g * +
        String infixData = "1+2*3+(4*5+6)*7";
        InfixToSuffix infixToSuffix = new InfixToSuffix();
        System.out.println(infixToSuffix.convert(infixData));
    }

    public String convert(String infixData) {
        String data = "";
        List<String> list = concvter(infixData);
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            //利用正则判断该值是否为整数
            boolean matches = item.matches("\\d+");
            if (matches) {
                data = MessageFormat.format("{0}{1}", data, item);
            } else {
                int currentLevel = getOperatorLevel(item);
                if (operatorStack.isEmpty()) {
                    operatorStack.push(item);
                } else {
                    Integer stackTopLevel = getOperatorLevel(operatorStack.peek());
                    //如果当前操作符优先级小于等于栈顶元素优先级或者当前操作符级别等于右括号级别时
                    if (currentLevel <= stackTopLevel || currentLevel == 3) {
                        //获取栈顶操作符优先级
                        stackTopLevel = getOperatorLevel(operatorStack.peek());
                        //弹出操作符直到栈数据为空
                        while (!operatorStack.isEmpty()) {
                            //获取栈顶操作符优先级
                            stackTopLevel = getOperatorLevel(operatorStack.peek());
                            //判断栈顶是否为左括号 直接退出循环
                            if (2 == stackTopLevel) {break;}
                            //栈判空
                            if (operatorStack.isEmpty()) {break;}
                            else {
                                //不为空则进行出栈
                                String pop = operatorStack.pop();
                                //进行数据链接
                                data = data + pop;
                            }
                        }
                        //右括号不入栈,待数据弹出完成后,当前操作符push进入操作符栈
                        if (currentLevel != 3) {operatorStack.push(item);}}
                    //如果当前操作符级别大于栈顶操作符级别 或者 栈顶操作符等于左括号时 操作符直接入栈
                    if (currentLevel > stackTopLevel || currentLevel == 2) {
                        //右括号不入栈,待数据弹出完成后,当前操作符push进入操作符栈
                        if (currentLevel != 3) {operatorStack.push(item);}
                    }
                }}}
        //最后顺序弹出所有运算符
        while (!operatorStack.isEmpty()) {
            //顺序弹出栈中数据
            String pop = operatorStack.pop();
            //排除括号
            if (getOperatorLevel(pop) != 2) {
                data = MessageFormat.format("{0}{1}", data, pop);
            }
        }
        return data;
    }


    //表达式转换为list
    private List<String> concvter(String infixData) {
        char[] chars = infixData.toCharArray();
        //转为数据
        List<String> list = new ArrayList<>(chars.length);
        for (char s : chars) {
            list.add(String.valueOf(s));
        }
        return list;
    }

    //获取优先级
    private int getOperatorLevel(String key) {
        Integer level = hashMap.get(key);
        return level;
    }
}
