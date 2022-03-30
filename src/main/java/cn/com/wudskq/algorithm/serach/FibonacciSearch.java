package cn.com.wudskq.algorithm.serach;

import java.util.Arrays;

/**
 * @author chenfangchao
 * @title: FibonacciSerach
 * @projectName structure-project
 * @description: TODO 斐波那契查找
 * @date 2022/3/31 12:34 AM
 */
public class FibonacciSearch {

    static int[] arrays = {1,2,4,3,7,6,8,5,9,10,11,12,13,14};

    static int count = 0;

    static int maxSize = 20;

    public static void main(String[] args) {
        FibonacciSearch search = new FibonacciSearch();
        int[] arrays = search.generateFibonacciArrays(maxSize);
        System.out.println(Arrays.toString(arrays));
        System.out.println(search.fibonacciSearch(arrays, 0, arrays.length - 1, 144));
    }


    //斐波那契查找
    public int fibonacciSearch(int[] arrays,int left,int right,int findValue){
        if(left > right){
            return -1;
        }
        int middle = (int) (left + (right-left)*0.618);
        int middleData = arrays[middle];
        if(findValue > middleData){
            return fibonacciSearch(arrays,middle+1,right,findValue);
        }else if(findValue < middleData){
            return fibonacciSearch(arrays,left,middle-1,findValue);
        }else {
            return middle;
        }
    }

    //实例化斐波那契数组
    public int[] generateFibonacciArrays(int maxSize){
        int[] fibonacci = new int[maxSize];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci;
    }
}
