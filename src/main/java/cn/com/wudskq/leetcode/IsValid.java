package cn.com.wudskq.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName IsValid.java
 * @Description TODO 判断字符串是否有效 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @createTime 2022年03月15日 19:34:00
 * TODO 解题思路: 借助栈，碰到左括号入栈，碰到右括号弹出栈顶元素进行匹配
 * 那么：什么情况下是非法序列：return false？
 * 栈为空，但仍有待匹配的右括号；
 * 栈不为空，字符序列空了，存在未匹配的左括号；
 * 栈顶括号和右括号不匹配
 */
public class IsValid {

    private HashMap<Character,Character> hashMap;
    //创建栈
    private Stack<Character> stack;


    public IsValid(){
        this.hashMap = new HashMap<Character,Character>();
        this.stack = new Stack<Character>();
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
    }


    public static void main(String[] args) {
        String data = "()";
        String s = "()[]{}";
        String s1 = "(]"; String s2 = "([)]";
        String s3 = "{[]}";
        IsValid isValid = new IsValid();
        boolean valid = isValid.isValid(s2);
        System.out.println(valid);
    }



    public boolean isValid(String s) {
        //获取字符长度
        int length = s.length();
        //字符为空也满足条件
        if (length == 0) return true;
        //奇数字符串不满足条件
        if(length %2==1) return false;
        //遍历字符
        for (int i = 0; i < length; i++) {
            //获取单个字符
            char charAt = s.charAt(i);
            //遇见右括号则弹出栈顶元素与之匹配
            //栈为空,存在未匹配的右括号
            //栈不为空,栈顶元素与右括号不匹配
            if(hashMap.containsKey(charAt)){
                if(stack.isEmpty() || !stack.peek().equals(hashMap.get(charAt))){
                    return false;
                }
                stack.pop();
                //左括号入栈
            }else { stack.push(charAt);}
        }
        return stack.isEmpty();
    };
}
