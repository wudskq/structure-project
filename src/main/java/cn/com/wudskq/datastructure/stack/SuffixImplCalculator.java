package cn.com.wudskq.datastructure.stack;

import lombok.Data;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName SuffixImplCalculator.java
 * @Description TODO 后缀表达式实现计算表达式计算
 * @createTime 2022年03月11日 16:59:00
 */
@Data
public class SuffixImplCalculator {

    //数据栈
    private Stack<Integer> dataStack;


    public static void main(String[] args) {
        String data = "2-(3+3)*3+8";
        InfixToSuffix infixToSuffix = new InfixToSuffix();
        //转换为后缀表达式
        String convert = infixToSuffix.convert(data);
        System.out.println(convert);//233+-3*8+
        SuffixImplCalculator suffixImplCalculator = new SuffixImplCalculator();
        //进行计算
        int i = suffixImplCalculator.operatorData(convert);
        System.out.println(i);
    }



    //初始化
    public SuffixImplCalculator(){
        this.dataStack = new Stack<Integer>();
    }

    //计算数据
    private int operatorData(String data){
        char[] chars = data.toCharArray();
        //转为数据
        List<String> list = new ArrayList<>(chars.length);
        for (char item : chars) {
            list.add(String.valueOf(item));
        }
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            //利用正则判断该值是否为整数
            boolean matches = item.matches("\\d+");
            //如果是数组则入数据栈
            if (matches) {
                dataStack.push(Integer.valueOf(item));
                //反之数据栈弹出两个数据,利用当前运算符做运算
            }else {
                Integer number1 = dataStack.pop();
                Integer number2 = dataStack.pop();
                Integer result = handleData(number1, item, number2);
                //计算结果入栈
                dataStack.push(result);
            }
        }
        //最后数据栈中的栈顶元素出栈即为结果
        Integer result = dataStack.pop();
        return result;
    }

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
