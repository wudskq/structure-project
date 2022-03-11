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
        //2 3 6 * + 2 / 10 + 2-
        String infixData = "2+3*(6/2)+10-2";
        //2 3 6 2 / * + 10 + 2 -
        InfixToSuffix infixToSuffix = new InfixToSuffix();
        System.out.println(infixToSuffix.convert(infixData));
    }

    public String convert(String infixData) {
        String data = "";
        char[] chars = infixData.toCharArray();
        //转为数据
        List<String> list = new ArrayList<>(chars.length);
        for (char s : chars) {
            list.add(String.valueOf(s));
        }
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            //利用正则判断该值是否为整数
            boolean matches = item.matches("\\d+");
            if (matches) {
                data = MessageFormat.format("{0}{1}", data, item);
                //符号入符号栈
            } else {
                //获取当前操作符优先级
                int currentLevel = getOperatorLevel(item);
                //栈空时直接入栈
                if (operatorStack.isEmpty()) {
                    operatorStack.push(item);
                } else {
                    //获取栈顶操作符优先级
                    int stackTopLevel = getOperatorLevel(operatorStack.peek());
                    /**
                     * 如果当前操作符优先级小于等于栈顶元素优先级
                     * 并且栈顶元素不能为左括号(左括号只有遇见右括号才会弹出)
                     * 或者当前操作符级别等于右括号级别时
                     */
                    if ((currentLevel <= stackTopLevel && stackTopLevel != 2) || currentLevel ==3) {
                        //弹出操作符直到栈数据为空  或者当前操作符优先级大于栈顶元素优先级时
                        //则符号栈一直弹出操作符进行数据链接,直到操作符栈为空或者当前操作符优先级大于栈顶元素优先级
                        while (!operatorStack.isEmpty() || (currentLevel > stackTopLevel)) {
                            //栈判空
                            if(operatorStack.isEmpty()){
                                break;
                            }else {
                                //弹出栈顶元素
                                String pop = operatorStack.pop();
                                //即左括号只出栈不进行数据链接
                                if(getOperatorLevel(pop) != 2){
                                    data = data + pop;
                                }
                            }
                        }
                        //右括号不入栈
                        if(currentLevel !=3){
                            //弹出完成后,当前操作符push进入操作符栈
                            operatorStack.push(item);
                        }
                    }
                    //如果当前操作符级别大于栈顶操作符级别 或者 栈顶操作符等于左括号时
                    //操作符直接入栈
                    if (currentLevel > stackTopLevel || stackTopLevel == 2 ) {
                        //右括号不入栈
                        if(currentLevel !=3){
                            operatorStack.push(item);
                        }
                    }
                }
            }
        }
        //弹出栈中最后一个运算符
        String pop = operatorStack.pop();
        return data + pop;
    }

    //获取优先级
    private int getOperatorLevel(String key) {
        Integer level = hashMap.get(key);
        return level;
    }
}
