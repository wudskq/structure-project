package cn.com.wudskq.algorithm.serach;


import java.util.Arrays;

/**
 * @author chenfangchao
 * @title: BinarySearch
 * @projectName structure-project
 * @description: TODO 二分查找
 * @date 2022/3/29 5:15 PM
 */
public class BinarySearch {

    static int[] arrays = {1,2,4,6,8,5,9,10,23,43,554,65};

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch1(arrays, 0, arrays.length - 1, 10));

    }


    public int binarySearch(int[] arrays,int findValue){
        //进行排序
        Arrays.sort(arrays);
        int left = 0,right = arrays.length-1;
        int middle = (left + right)/2;
        int middleData = arrays[middle];
        return -1;
    }

    public int binarySearch1(int[] arrays, int left,int right,int findValue){
        //进行排序
        Arrays.sort(arrays);
        //递归结束条件
        //如果左下标大于了右下标||右下标小于左下标则证明找不到数据
        if(left > right){
            return -1;
        }
        int middle = (left + right) /2;
        int middleData = arrays[middle];
        //向右递归
        if(findValue > middleData){
           return binarySearch1(arrays,middle+1,right,findValue);
        }else if(findValue < middleData){ //向左递归
            return binarySearch1(arrays,left,middle-1,findValue);
        }else{ //直接返回
            return middle;
        }
    }
}

