package cn.com.wudskq.datastructure.recursion;

/**
 * @author chenfangchao
 * @version 1.0.0
 * @ClassName Recursion.java
 * @Description TODO
 * @createTime 2022年03月12日 01:07:00
 */

public class Recursion {

    public static void main(String[] args) {
        // factorial(n-1)*n;
        recursion1(6);
        // 6 * 5 * 4 * 3 * 2 *1
        // 5
        // 4
        // 3
        // 2
        // 1
    }

    //打印问题
    public static void recursion(int n){
        if(n>1){
            recursion(n-1);
        }else {
            System.out.println(n);
        }
    }

    //打印问题
    public static void recursion1(int n){
        if(n>1){
            recursion1(n-1);
        }
        System.out.println(n);
    }

    //阶乘问题
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }else {
           return   factorial(n-1)*n;
        }
    }

}
