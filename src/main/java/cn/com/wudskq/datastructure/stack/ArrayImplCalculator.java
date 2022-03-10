package cn.com.wudskq.datastructure.stack;

import lombok.Data;
import java.util.HashMap;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName ArrayImplCalculator.java
 * @Description TODO 使用栈实现综合计算器(中缀表达式)
 * @createTime 2022年03月10日 10:15:00
 */
@Data
public class ArrayImplCalculator {

    //计算表达式
    private String cron;

    //指针
    private int index;

    //操作符
    private String operator = "+,-,*,/";

    //操作运算符优先级
    private HashMap<String, Integer> hashMap;

    //数据栈
    private ArrayImplStack numberStack;

    //符号栈
    private ArrayImplStack symbolStack;

    //初始化
    public ArrayImplCalculator() {
        this.index = 0;
        this.numberStack = new ArrayImplStack(100);
        this.symbolStack = new ArrayImplStack(100);
        this.hashMap = new HashMap<>(10);
        hashMap.put("+", 0);
        hashMap.put("-", 0);
        hashMap.put("*", 1);
        hashMap.put("/", 1);
    }


    public static void main(String[] args) {
        ArrayImplCalculator calculator = new ArrayImplCalculator();
        //16 4
        System.out.println(calculator.execCalculation("5*5-20/5+9+19-10"));

    }

    //执行表达式计算操作
    public int execCalculation(String cron) {
        char[] datas = cron.toCharArray();
        //遍历操作表达式
        for (int index = 0; index < datas.length; index++) {
            //当前数据
            String data = String.valueOf(datas[index]);
            //判断是否为运算符号,运算符号入符号栈
            if (operator.contains(data)) {
                //先判断符号栈是否为空,为空直接入栈
                if (symbolStack.isEmpty()) {
                    symbolStack.push(data);
                } else {
                    //栈顶运算符
                    String topOperator = String.valueOf(symbolStack.pop());
                    //计算栈顶运算符优先级
                    Integer topOperatorLevel = hashMap.get(topOperator);
                    //计算当前的运算符优先级
                    Integer operatorLevel = hashMap.get(data);

                    //判断当前运算符与栈顶运算符优先级
                    //如果当前运算符级别小于等于栈顶运算符级别
                    if (operatorLevel <= topOperatorLevel) {
                        Integer number1 = Integer.valueOf(String.valueOf(numberStack.pop()));
                        Integer number2 = Integer.valueOf(String.valueOf(numberStack.pop()));
                        Integer result = handleData(number1, topOperator, number2);
                        //计算的结果入数据栈
                        numberStack.push(result);
                        //当前运算符入符号栈
                        symbolStack.push(data);
                    } else {
                        //如果当前运算符优先级大于栈顶运算符优先级,则当前运算符直接入符号栈
                        symbolStack.push(data);
                    }
                }
            } else {
                //反之直接入数据栈
                numberStack.push(data);
            }
        }
        //遍历完成之后,获取符号栈最后一个操作符,弹出数据栈中的两个数,
        String operator = String.valueOf(symbolStack.pop());
        Integer number1 = Integer.valueOf(String.valueOf(numberStack.pop()));
        Integer number2 = Integer.valueOf(String.valueOf(numberStack.pop()));
        Integer result = handleData(number1, operator, number2);
        Integer number3 = Integer.valueOf(String.valueOf(numberStack.pop()));
        int res = handleData(result, operator, number3);
        return res;
    };

    //判断运算符,进行数据处理
    public Integer handleData(Integer number1, String operator, Integer number2) {
        Integer result = null;
        if ("+".equals(operator)) {
            result = number2 + number1;
        }
        if ("-".equals(operator)) {
            result = number2 - number1;
        }
        if ("*".equals(operator)) {
            result = number2 * number1;
        }
        if ("/".equals(operator)) {
            result = number2 / number1;
        }
        return result;
    }
}
