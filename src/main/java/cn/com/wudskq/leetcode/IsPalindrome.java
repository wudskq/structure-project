package cn.com.wudskq.leetcode;

import java.text.MessageFormat;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName isPalindrome.java
 * @Description TODO 回文数 leetcode 9. 回文数
 * @createTime 2022年03月14日 17:57:00
 */

public class IsPalindrome {


    public static void main(String[] args) {
        IsPalindrome obj = new IsPalindrome();
        boolean palindrome2 = obj.isPalindrome2(12344321);
        System.out.println(palindrome2);
    }


    public boolean isPalindrome(int x) {
        //如果该数为负数则不可反转(即无回文数)
        if(x<0 ){
            return false;
        }
        //若该大于0并且个位数为0则无回文数
        if(x>0 && x%10==0){
            return false;
        }

        return true;
    }


    //将该数转换为字符串并进行反转
    //反转后的字符串与原始数据做对比
    public boolean isPalindrome1(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    //数组倒叙输出
    //然后与原始数据尽心比较
    public boolean isPalindrome2(int x) {
        //负数与个位数为0并且大于0的数不是回文数
        if(x<0 || (x!=0&&x%10==0)){
            return false;
        }
        char[] arrays = new StringBuilder(x + "").toString().toCharArray();
        String data = "";
        for (int i = arrays.length-1; i >= 0 ; i--) {
            data = data + arrays[i];
        }
        return (x+"").equals(data);
    }
}
